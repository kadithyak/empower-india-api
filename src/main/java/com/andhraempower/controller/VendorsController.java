package com.andhraempower.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/Vendors")
@RequiredArgsConstructor
public class VendorsController {

    @GetMapping("/getVendors")
    public String getVendors(){
        return "This is Vendors page";
    }
}
