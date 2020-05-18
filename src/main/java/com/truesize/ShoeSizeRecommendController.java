package com.truesize;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShoeSizeRecommendController {
    private final AllShoeRepository allShoeRepository;

    public ShoeSizeRecommendController(AllShoeRepository repo){
        this.allShoeRepository = repo;
    }
    //params are the model and brand of shoe the user is searching for
    @GetMapping("/api/sizeRecommend")
    String getSize(@RequestParam(name="model", required = true) String modelName,
                   @RequestParam(name="brand", required = true) String brandName){
        
        //the 
        double usersSize = 8.5;

        Shoe shoeLookingFor = new Shoe("KD9", "Nike", "m");
        Shoe currentShoe = new Shoe("KD8", "Nike", "m");

        return modelName + ", at size " + getSizeReccomendation(currentShoe, usersSize, shoeLookingFor);
    }

    private double getSizeReccomendation(Shoe usersShoe, double usersSize, Shoe desiredShoe) {
        return this.allShoeRepository.findByModel(usersShoe.model).tester();
    }

}
