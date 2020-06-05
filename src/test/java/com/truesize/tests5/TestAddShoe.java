package com.truesize.tests5;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.beans.factory.annotation.Autowired;
import com.truesize.shoegraph.ShoeNode;
import com.truesize.AccountService;
import com.truesize.AllUserRepository;
import com.truesize.OwnedShoe;
import com.truesize.UserController;
import com.truesize.UserProfile;
import com.truesize.shoegraph.AllShoeRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestAddShoe {

    @Autowired
    private AllShoeRepository asr;
    
    @Autowired
    private AllUserRepository aur;
    
    @Autowired
    public AccountService ac;

    @Autowired
    private UserController controller;

    @Test
    public void addEdges() {
    	asr.deleteAll();
    	aur.deleteAll();
        UserProfile profile = new UserProfile("6test@email.com", "123456");
        profile.ownedShoes.add(new OwnedShoe("testshoe1","adidas", 12.0, "f", "URL"));
        profile.ownedShoes.add(new OwnedShoe("testshoe2","nike", 13.0, "m", "URL"));
        aur.save(profile);
        asr.save(new ShoeNode("testshoe2","nike", "m"));
        asr.save(new ShoeNode("testshoe1","adidas", "f"));

        OwnedShoe os = new OwnedShoe("newshoe","gucci", 12.0, "f", "URL");
        ShoeNode sn = new ShoeNode("newshoe", "gucci", "f");
        
        asr.save(sn);
        
        controller.addEdges(sn, os, profile);
        asr.save(sn);

        //assert that the new sn is in the repository
        String uniqueShoeCode = ShoeNode.generateUniqueCode("newshoe", "gucci", "f");
        sn = asr.findByUniqueShoeCode(uniqueShoeCode);
        assert(sn != null);
        //assert that new sn has two edges

        assert(sn.getEdges().size() == 2);
        //assert that other sn has one edge
        uniqueShoeCode = ShoeNode.generateUniqueCode("testshoe1", "adidas", "f");
        sn = asr.findByUniqueShoeCode(uniqueShoeCode);
        assert(sn.getEdges().size() == 1);
    }

    @Test
    public void addShoe() {
    	asr.deleteAll();
    	aur.deleteAll();
        UserProfile profile = new UserProfile("6test@email.com", "123456");
        ac.setProfile(profile);
        ac.setLoggedIn(true);
        profile.ownedShoes.add(new OwnedShoe("testshoe1","adidas", 12.0, "f", "URL"));
        profile.ownedShoes.add(new OwnedShoe("testshoe2","nike", 13.0, "m", "URL"));
        asr.save(new ShoeNode("testshoe2","nike", "m"));
        asr.save(new ShoeNode("testshoe1","adidas", "f"));
    	  aur.save(profile);

        controller.addShoe("newshoe2","gucci","m",13.5, "imgURL");

        //assert that a new shoe node has been added to the repository
        String uniqueShoeCode = ShoeNode.generateUniqueCode("newshoe2", "gucci", "m");
        ShoeNode sn = asr.findByUniqueShoeCode(uniqueShoeCode);
        assert(sn != null);
        //assert that the new shoe node has 2 edges
        assert(sn.getEdges().size() == 2);

        //assert that the user profile now has 3 OwnedShoes
        assert(profile.ownedShoes.size() == 3);  
    }
}