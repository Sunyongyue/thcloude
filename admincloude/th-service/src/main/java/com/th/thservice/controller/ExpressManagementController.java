package com.th.thservice.controller;


import com.th.thservice.service.ExpressManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping
public class ExpressManagementController {
    @Autowired
    private ExpressManagementService expressManagementService;


}
