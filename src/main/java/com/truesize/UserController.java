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

    @GetMapping(value = "/api/createAccount", produces = MediaType.APPLICATION_JSON_VALUE)
    StringResponse createAccount(@RequestParam String email, @RequestParam String password){
        if (!ac.createAccount(email, password, allUserRepository)){
            return new StringResponse("CREATEACCOUNT_FAILURE");
        }

        if (ac.logIn(email, password, allUserRepository)){
            return new StringResponse("LOGIN_SUCCESS");
        }

        else{
            return new StringResponse("LOGIN_FAILURE");
        }
    }

    @GetMapping(value = "/api/logIn", produces = MediaType.APPLICATION_JSON_VALUE)
    StringResponse logIn(@RequestParam String email, @RequestParam String password){
        if (ac.logIn(email, password, allUserRepository)){
            return new StringResponse("LOGIN_SUCCESS");
        }

        else{
            return new StringResponse("LOGIN_FAILURE");
        }
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

    @GetMapping(value = "/api/getUserShoes", produces = MediaType.APPLICATION_JSON_VALUE)
    StringResponse getUserShoes(){
        return new StringResponse(ac.profile.shoesToString());
    }

    @GetMapping("/api/addShoe")
    void addShoe(@RequestParam String model, @RequestParam String brand, @RequestParam String sex, @RequestParam Double size, @RequestParam String imgURL){
        //create a new owned shoe

        System.out.println("adding shoe");
        OwnedShoe os = new OwnedShoe(model, brand, size, sex, imgURL);
        
        ShoeNode sn = allShoeRepository.findByUniqueShoeCode(ShoeNode.generateUniqueCode(model, brand, sex));
        
        //if the shoenode does not exist, create new shoenode
        if (sn == null){
            sn = new ShoeNode(model, brand, sex, imgURL);
            //sn.ownedShoes.add(os);
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

            if (target == null){
                System.out.println("Add Edge error: shoe node not found: " + ShoeNode.generateUniqueCode(shoe.model, shoe.brand, shoe.sex));
            }
            else{
                sn.addEdge(target, os.size, shoe.size);
            }
        }
    }


    // TODO: add something to return all the shoes for a the current user 

}