package com.redline.ecoredlinekgback.controller;

import com.redline.ecoredlinekgback.pojo.Instance;
import com.redline.ecoredlinekgback.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/home")
public class HomeController {

    @Autowired
    HomeService homeService;

    @GetMapping("/instance")
    public Instance[] homeDetails(@RequestParam(value="num", required=false) Integer num){
        return homeService.getInstanceArr(num);
    }

}
