package com.makers.makersbnb.controller;

import com.makers.makersbnb.repository.SpaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class StaticPageController {

    @Autowired
    SpaceRepository spaceRepository;
    // Home page
    @GetMapping("/")
    public ModelAndView welcome() {
        ModelAndView modelAndView = new ModelAndView("/LandingPage");
        Long nSpaces = spaceRepository.count();
        // this next line makes nSpaces available in the template
        modelAndView.addObject("nSpaces", nSpaces);
        // imagine these reviews were stored in a database
        String[] reviews = new String[] {"Awesome", "Nice", "Perfect"};
        modelAndView.addObject("reviews", reviews);
        Integer nBookings = 123;
        modelAndView.addObject("nBookings", nBookings);
        return modelAndView;
    }

    @GetMapping("/contactus")
    public String contactPage() {
        return "info@makersbnb.com";
    }

    @GetMapping("/termsandconditions")
    public String termsConditionsPage() {
        return "Coming soon! In the meantime, please behave yourselves.";
    }

    @GetMapping("/signup")
    public ModelAndView signUp() {
        ModelAndView modelAndView = new ModelAndView("/SignupPage");
        // for now, imagine this value was generated by querying the database
        Integer nUsers = 57;
        // this next line makes nUsers available in the template
        modelAndView.addObject("nUsers", nUsers);
        return modelAndView;
    }
}
