package com.truesize;

import com.truesize.shoegraph.AllShoeRepository;
import com.truesize.shoegraph.ShoeNode;
import com.truesize.shoegraph.ShoeSearchFactory;

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
                   @RequestParam(name="brand", required = true) String brandName,
                   @RequestParam(name="sex", required = true) String sex){
        
        String shoeLookingFor = ShoeNode.generateUniqueCode(modelName, brandName, sex);
        return ShoeSearchFactory.createSearcher("ShoeSizeRecommendSearcherBFS").getSizeRecc(shoeLookingFor, allShoeRepository);
    }
}
