package com.truesize;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import com.truesize.shoegraph.AllShoeRepository;
import com.truesize.shoegraph.ShoeNode;


@RestController
public class UserController {

	private final AllUserRepository allUserRepository;
    private final AllShoeRepository allShoeRepository;

    @Autowired
    public AccountService ac;

    //@Autowired
	public UserController(AllUserRepository allUserRepository, AllShoeRepository allShoeRepository){
        this.allUserRepository = allUserRepository;
        this.allShoeRepository = allShoeRepository;
    }

    @GetMapping("/api/createAccount")
    void createAccount(@RequestParam String email, @RequestParam String password){
    	ac.createAccount(email, password, allUserRepository);
        ac.logIn(email, password, allUserRepository);
    }

    @GetMapping("/api/logIn")
    void logIn(@RequestParam String email, @RequestParam String password){
        ac.logIn(email, password, allUserRepository);
    }

    @GetMapping("/api/logOut")
    void logOut(){
        ac.logOut();
    }

    // hopefully this returns profile information in a usable JSON format
    @GetMapping(value = "/api/getUserInfo", produces = MediaType.APPLICATION_JSON_VALUE)
    StringResponse getUserInfo(){
        return new StringResponse(ac.profile.toString());
    }

    @GetMapping("/api/addShoe")
    void addShoe(@RequestParam String model, @RequestParam String brand, @RequestParam String sex, @RequestParam Double size){
        //create a new owned shoe
        OwnedShoe os = new OwnedShoe(model, brand, size, sex);
        
        ShoeNode sn = allShoeRepository.findByUniqueShoeCode(ShoeNode.generateUniqueCode(model, brand, sex));
        
        //if the shoenode already exists, add new shoe to list of owned shoes
        if (sn != null){
            sn.ownedShoes.add(os);    
        }
        
        //else, create new shoenode and add ownedshoe to list   
        else{
            sn = new ShoeNode(model, brand, sex);
            sn.ownedShoes.add(os);
            allShoeRepository.save(sn);
        }

        //go through all the shoes in the userProfile ownedshoe list and add new edges to the sn
        this.addEdges(sn, os, ac.profile);

        // add new owned shoe to list of ownded shoes in profile
        ac.profile.ownedShoes.add(os);

        // TODO: prevent user from adding the same shoe to their profile more than once?
        // this would be to prevent the creation of useless edges that start and end at the same shoenode
    
    }

    public void addEdges(ShoeNode sn, OwnedShoe os, UserProfile up){

        ShoeNode target = null;

        for (OwnedShoe shoe: up.ownedShoes){
            //this should never be null bc "shoe" should always be in the database
            target = allShoeRepository.findByUniqueShoeCode(ShoeNode.generateUniqueCode(shoe.model, shoe.brand, shoe.sex));
            sn.addEdge(target, shoe.size - os.size);
        }
    }


    // TODO: add something to return all the shoes for a the current user 

}