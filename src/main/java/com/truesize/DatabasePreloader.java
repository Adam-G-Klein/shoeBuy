package com.truesize;

import com.truesize.shoegraph.AllShoeRepository;
import com.truesize.shoegraph.ShoeNode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabasePreloader implements CommandLineRunner {

    private final AllShoeRepository allShoeRepository;
    private final AllUserRepository allUserRepository;

    @Autowired
    public DatabasePreloader(AllShoeRepository allShoeRepository, AllUserRepository allUserRepository){
        this.allShoeRepository = allShoeRepository;
        this.allUserRepository = allUserRepository;
    }

    @Override
    public void run(String... strings) throws Exception{
        this.allUserRepository.save(new UserProfile("testemail@test.com", "password"));
        this.allUserRepository.save(new UserProfile("testemail2@test.com", "totallysecurepassword"));

        addTestGroup4();
        addTestGroup5();
    }

    private void addTestGroup1(){
        //---Test Group 1: 2 nodes directly connected---
        ShoeNode testNode = new ShoeNode("KD8", "Nike", "m");
        ShoeNode testNode2 = new ShoeNode("KD9", "Nike", "m");
        testNode.addEdge(testNode2, 10.0, 12.0);
        this.allShoeRepository.save(testNode);
        this.allShoeRepository.save(testNode2);
    }

    private void addTestGroup2(){
        //---Test Group 2: 3 nodes, no cycles---
        ShoeNode t1a = new ShoeNode("T1A", "Adidas", "f", "https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/zc5x1xceepbszkhwprvn/joyride-run-flyknit-mens-running-shoe-PjmR5M.jpg");
        ShoeNode t2a = new ShoeNode("T2A", "Adidas", "f");
        ShoeNode t3a = new ShoeNode("T3A", "Adidas", "f");
        ShoeNode t4a = new ShoeNode("T4A", "Adidas", "f");

        t1a.addEdge(t2a, 10, 11);
        t1a.addEdge(t4a, 10, 11.5);

        t2a.addEdge(t3a, 12.5, 11);

        this.allShoeRepository.save(t1a);
        this.allShoeRepository.save(t2a);
        this.allShoeRepository.save(t3a);
        this.allShoeRepository.save(t4a);
    }

    private void addTestGroup3(){
        //---Test Group 3: 7 nodes, several cycles, size differences may not be consistent bc for test purposes---
        ShoeNode t1b = new ShoeNode("T1b", "Adidas", "f");
        ShoeNode t2b = new ShoeNode("T2b", "Adidas", "f");
        ShoeNode t3b = new ShoeNode("T3b", "Adidas", "f");
        ShoeNode t4b = new ShoeNode("T4b", "Adidas", "f");
        ShoeNode t5b = new ShoeNode("T5b", "Adidas", "f");
        ShoeNode t6b = new ShoeNode("T6b", "Adidas", "f");
        ShoeNode t7b = new ShoeNode("T7b", "Adidas", "f");

        t1b.addEdge(t2b, 10, 11);
        t1b.addEdge(t3b, 10, 10);
        t1b.addEdge(t4b, 11, 11.5);

        t2b.addEdge(t6b, 8.5, 9);

        t3b.addEdge(t5b, 12, 13);
        t3b.addEdge(t4b, 13, 19);

        t5b.addEdge(t7b, 12.5, 13);
        //t5b.addEdge(t1b, 0.5, false);

        t6b.addEdge(t5b, 10, 9.5);

        this.allShoeRepository.save(t1b);
        this.allShoeRepository.save(t2b);
        this.allShoeRepository.save(t3b);
        this.allShoeRepository.save(t4b);
        this.allShoeRepository.save(t5b);
        this.allShoeRepository.save(t6b);
        this.allShoeRepository.save(t7b);
    }
    private void addTestGroup4(){
        //---Test Group 4: testing edge changes when add multiple shoe nodes that increase edge's multiplicity---
        ShoeNode t1c = new ShoeNode("T1c", "Adidas", "f");
        ShoeNode t2c = new ShoeNode("T2c", "Adidas", "f");
        ShoeNode t3c = new ShoeNode("T3c", "Adidas", "f");
        
        t1c.addEdge(t2c, 10.0, 9.0);
        t1c.addEdge(t2c, 10.0, 9.5);

        t2c.addEdge(t3c, 9.0, 8.5);
        this.allShoeRepository.save(t1c);
        this.allShoeRepository.save(t2c);
        this.allShoeRepository.save(t3c);
    }

    private void addTestGroup5(){
        ShoeNode t1c = new ShoeNode("KD9", "Nike", "u");
        ShoeNode t2c = new ShoeNode("KD3000", "Nike", "u");
        ShoeNode t3c = new ShoeNode("HotDog", "Nike", "u");

        this.allShoeRepository.save(t1c);
        this.allShoeRepository.save(t2c);
        this.allShoeRepository.save(t3c);
    }

}
