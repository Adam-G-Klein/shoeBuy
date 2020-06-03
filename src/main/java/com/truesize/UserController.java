package com.truesize;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import com.truesize.shoegraph.AllShoeRepository;
import com.truesize.shoegraph.ShoeNode;
import org.slf4j.Logger;

import java.util.List;


@RestController
public class UserController {

    @Autowired
    private Logger logger;

    @Autowired
    private AllUserRepository allUserRepository;
    @Autowired
    private AllShoeRepository allShoeRepository;

    @Autowired
    public AccountService ac;

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
    UserProfile getUserInfo(){
        return ac.getProfile();
    }

    @GetMapping(value = "/api/getUserShoes", produces = MediaType.APPLICATION_JSON_VALUE)
    List<OwnedShoe> getUserShoes(){
        return ac.getProfile().getOwnedShoes();
    }

    @GetMapping("/api/addShoe")
    void addShoe(@RequestParam String model, @RequestParam String brand, @RequestParam String sex, @RequestParam Double size, @RequestParam String imgURL){
        //create a new owned shoe

        OwnedShoe os = new OwnedShoe(model, brand, size, sex, imgURL);
        
        ShoeNode sn = allShoeRepository.findByUniqueShoeCode(ShoeNode.generateUniqueCode(model, brand, sex));
        
        //if the shoenode does not exist, create new shoenode
        if (sn == null){
            sn = new ShoeNode(model, brand, sex, imgURL);

            allShoeRepository.save(sn);   
        }

        //go through all the shoes in the userProfile ownedshoe list and add new edges to the sn
        this.addEdges(sn, os, ac.getProfile());

        // add new owned shoe to list of ownded shoes in profile
        ac.getProfile().ownedShoes.add(os);

        allUserRepository.save(ac.getProfile());    
    }

    public void addEdges(ShoeNode sn, OwnedShoe os, UserProfile up){

        ShoeNode target = null;

        for (OwnedShoe shoe: up.ownedShoes){
            //this should never be null bc "shoe" should always be in the database
            target = allShoeRepository.findByUniqueShoeCode(ShoeNode.generateUniqueCode(shoe.getModel(), shoe.getBrand(), shoe.getSex()));

            if (target == null){
                logger.info("Add Edge error: shoe node not found: " + ShoeNode.generateUniqueCode(shoe.getModel(), shoe.getBrand(), shoe.getSex()));
            }
            else{
                sn.addEdge(target, os.getSize(), shoe.getSize());
            }
        }
    }

}