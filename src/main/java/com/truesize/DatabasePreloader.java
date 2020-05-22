package com.truesize;

import com.truesize.shoegraph.AllShoeRepository;
import com.truesize.shoegraph.ShoeNode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabasePreloader implements CommandLineRunner {

    private final AllShoeRepository allShoeRepository;

    @Autowired
    public DatabasePreloader(AllShoeRepository allShoeRepository){
        this.allShoeRepository = allShoeRepository;
    }

    @Override
    public void run(String... strings) throws Exception{
        //---Test Group 1: 2 nodes directly connected---
        ShoeNode testNode = new ShoeNode("KD8", "Nike", "m");
        ShoeNode testNode2 = new ShoeNode("KD9", "Nike", "m");
        testNode.addEdge(testNode2, 3.0, false);
        this.allShoeRepository.save(testNode);
        this.allShoeRepository.save(testNode2);

        //---Test Group 2: 3 nodes, no cycles---
        ShoeNode t1a = new ShoeNode("T1A", "Adidas", "f");
        ShoeNode t2a = new ShoeNode("T2A", "Adidas", "f");
        ShoeNode t3a = new ShoeNode("T3A", "Adidas", "f");
        ShoeNode t4a = new ShoeNode("T4A", "Adidas", "f");

        t1a.addEdge(t2a, 1.0, false);
        t1a.addEdge(t4a, 1.2, false);

        t2a.addEdge(t3a, 2.0, false);

        this.allShoeRepository.save(t1a);
        this.allShoeRepository.save(t2a);
        this.allShoeRepository.save(t3a);
        this.allShoeRepository.save(t4a);

        //---Test Group 3: 7 nodes, several cycles, size differences may not be consistent bc for test purposes---
        ShoeNode t1b = new ShoeNode("T1b", "Adidas", "f");
        ShoeNode t2b = new ShoeNode("T2b", "Adidas", "f");
        ShoeNode t3b = new ShoeNode("T3b", "Adidas", "f");
        ShoeNode t4b = new ShoeNode("T4b", "Adidas", "f");
        ShoeNode t5b = new ShoeNode("T5b", "Adidas", "f");
        ShoeNode t6b = new ShoeNode("T6b", "Adidas", "f");
        ShoeNode t7b = new ShoeNode("T7b", "Adidas", "f");

        t1b.addEdge(t2b, 1.1, false);
        t1b.addEdge(t3b, 1.15, false);
        t1b.addEdge(t4b, 1.05, false);

        t2b.addEdge(t6b, 0.25, false);

        t3b.addEdge(t5b, 1.2, false);
        t3b.addEdge(t4b, 0.2, false);

        t5b.addEdge(t7b, 0.2, false);
        //t5b.addEdge(t1b, 0.5, false);

        t6b.addEdge(t5b, 0.3, false);

        this.allShoeRepository.save(t1b);
        this.allShoeRepository.save(t2b);
        this.allShoeRepository.save(t3b);
        this.allShoeRepository.save(t4b);
        this.allShoeRepository.save(t5b);
        this.allShoeRepository.save(t6b);
        this.allShoeRepository.save(t7b);
    }

}
