package com.truesize;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShoeSizeRecommendController {

    @GetMapping("/api/sizeRecommend")
    String getSize(@RequestParam(name="model", required = true) String modelName){
        return modelName + Double.toString(123.456);

    }
}
