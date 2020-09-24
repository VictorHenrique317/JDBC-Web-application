package com.example.mvccontinuation.controller;

import com.example.mvccontinuation.constants.Mappings;
import com.example.mvccontinuation.constants.Views;
import com.example.mvccontinuation.services.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OrganizationController {
    private final OrganizationService organizationService;

    @Autowired
    public OrganizationController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @GetMapping(Mappings.LOCATION)
    public String location(){
        return Views.LOCATION;
    }

    @GetMapping(Mappings.SERVICE)
    public String listOrganizations(Model model){
        model.addAttribute("orgList", organizationService.getAllOrganizations());
        return Views.LIST_ORGANIZATIONS;
    }
}
