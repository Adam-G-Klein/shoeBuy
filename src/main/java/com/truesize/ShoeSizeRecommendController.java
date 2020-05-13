package com.truesize;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShoeSizeRecommendController {

    //TODO use factory method to get a size recommendor, either using dfs or bfs
    @GetMapping("/api/sizeRecommend")
    String getSize(@RequestParam(name="model", required = true) String modelName){
        String usersShoeModelName = "Nike KD-8";
        double usersSize = 8.5;

        return modelName + ", at size " + getSizeReccomendation(usersShoeModelName, usersSize, modelName);
    }

    private double getSizeReccomendation(String usersShoeModel, double usersSize, String desiredModel) {
        return 9.0;
    }

}
