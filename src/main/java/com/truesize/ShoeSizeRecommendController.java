package com.truesize;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShoeSizeRecommendController {

    @GetMapping("/api/userInfo")
    String getSize(@RequestParam(name="uname", required = true) String modelName){
        return modelName + Double.toString(123.456);

    }

}
