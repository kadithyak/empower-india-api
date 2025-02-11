package com.andhraempower.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/Sponsors")
@RequiredArgsConstructor
public class SponsorsController {

    @GetMapping("/getSponsors")
    public String getSponsors(){
        return "This is Sponsors page";
    }
}
