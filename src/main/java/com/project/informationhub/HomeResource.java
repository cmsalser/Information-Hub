package com.project.informationhub;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


// @RestController
public class HomeResource {

    @RequestMapping("/")
    public ModelAndView home() {
        // return ("<h1> hello </h1>");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("home");
        return modelAndView;
    }

    @GetMapping("/FAQ")
    public ModelAndView FAQ() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("FAQ");
        return modelAndView;
    }

    // @GetMapping("/FAQform")
    // public ModelAndView FAQform() {
    //     ModelAndView modelAndView = new ModelAndView();
    //     modelAndView.setViewName("FAQForm");
    //     return modelAndView;
    // }
}
