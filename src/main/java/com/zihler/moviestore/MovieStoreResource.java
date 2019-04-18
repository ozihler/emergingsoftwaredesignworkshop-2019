package com.zihler.moviestore;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/moviestore")
public class MovieStoreResource {

    @GetMapping("/works")
    public String works(){
        return "works";
    }
}

