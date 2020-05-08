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
        ShoeNode testNode = new ShoeNode("KD8", "Nike", "m", 7.0);
        ShoeNode testNode2 = new ShoeNode("KD9", "Nike", "m", 10.0);
        testNode.addEdge(testNode2, 3.0, false);
        this.allShoeRepository.save(testNode);
        this.allShoeRepository.save(testNode2);
    }

}
