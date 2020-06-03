package com.truesize;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.truesize.shoegraph.AllShoeRepository;
import com.truesize.shoegraph.ShoeNode;
import com.truesize.shoegraph.ShoeSearchFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShoeSizeRecommendController {

    @Autowired
    private AllShoeRepository allShoeRepository;
    
    @Autowired
    public AccountService ac;

    //params are the model and brand of shoe the user is searching for
    @GetMapping(value = "/api/sizeRecommend", produces = MediaType.APPLICATION_JSON_VALUE)
    StringResponse getSize(@RequestParam(name="model", required = true) String modelName,
                   @RequestParam(name="brand", required = true) String brandName,
                   @RequestParam(name="sex", required = true) String sex){
        
        String shoeLookingFor = ShoeNode.generateUniqueCode(modelName, brandName, sex);
        return new StringResponse(ShoeSearchFactory.createSearcher("ShoeSizeRecommendSearcherSmartBFS").getSizeRecc(shoeLookingFor, allShoeRepository, ac));
    }

    @GetMapping(value = "/api/getAllShoes", produces = MediaType.APPLICATION_JSON_VALUE)
    List<List<String>> getAllShoes(){
        Iterator<ShoeNode> shoeIterator = allShoeRepository.findAll().iterator();
        List<List<String>> shoes = new ArrayList<>();

        while(shoeIterator.hasNext()) {
            ShoeNode shoe = shoeIterator.next();
            List<String> shoeInfo = new ArrayList<>();
            shoeInfo.add(shoe.getBrand());
            shoeInfo.add(shoe.getModel());
            shoeInfo.add(shoe.getSex());
            shoeInfo.add(shoe.getImgURL());
            shoes.add(shoeInfo);
        }
        return shoes;
    }

}
