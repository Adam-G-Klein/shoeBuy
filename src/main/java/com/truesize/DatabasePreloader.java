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
        ShoeNode testNode = new ShoeNode("KD8", "Nike", "m");
        ShoeNode testNode2 = new ShoeNode("KD9", "Nike", "m");
        testNode.addEdge(testNode2, 3.0);
        this.allShoeRepository.save(testNode);
        this.allShoeRepository.save(testNode2);

        this.allUserRepository.save(new UserProfile("testemail@test.com", "password"));
        this.allUserRepository.save(new UserProfile("testemail2@test.com", "totallysecurepassword"));
    }

}
