package com.andhraempower.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class SponsorsController {

    @GetMapping("/")
    public String getSponsors(){
        return "This is Sponsors page";
    }
}
