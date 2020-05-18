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
                   @RequestParam(name="brand", required = true) String brandName,
                   @RequestParam(name="sex", required = true) String sex){
        
        //---- the users data, will need to pull this from Ted's database -----
        double usersSize = 8.5;
        String usersShoe = "kd9nikem";
        //---- ---------------------------------------------------------- -----

        String shoeLookingFor = modelName.toLowerCase() + brandName.toLowerCase() + sex.toLowerCase();
        
        return modelName + ", at size " + getSizeReccomendation(usersShoe, usersSize, shoeLookingFor);
    }

    //TODO create a factory method to actually give me the bfs or dfs options
    private String getSizeReccomendation(String usersShoe, double usersSize, String shoeLookingFor) {
        Double sizeRecc = this.allShoeRepository.findByUniqueShoeCode(usersShoe).getImmediateSizeDiff(shoeLookingFor);
        if(sizeRecc == null){
            return "Shoe Not Found";
        }
        else {
            return sizeRecc + "";
        }
    }



}
