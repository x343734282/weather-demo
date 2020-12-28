package com.weather.app.controller;

import com.weather.app.service.ICityService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class IndexController {
    private final ICityService cityService;

    public IndexController(ICityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping("/index.html")
    public String index(Model model) {
        model.addAttribute("cities", this.cityService.getCities());
        return "index";
    }
}
