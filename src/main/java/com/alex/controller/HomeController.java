package com.alex.controller;


import com.alex.data.entities.services.Project;
import com.alex.data.entities.services.Sponsor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;


/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
    @RequestMapping("/")
    public String goHome(Model model){

        Date date = new Date();


        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, new Locale("uk"));
        TimeZone estTime = TimeZone.getTimeZone("Europe/Kiev");
        dateFormat.setTimeZone(estTime);
        String formattedDate = dateFormat.format(date);

        model.addAttribute("serverTime", formattedDate );
        Project project = new Project();
        project.setName("First Project");
        project.setSponsor(new Sponsor("NASA", "555-555-5555", "nasa@nasa.com"));
        project.setDescription("This is a simple project sponsored by NASA");
        model.addAttribute("currentProject", project);

        return "home";
    }
/*
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Locale locale, Model model) {
        logger.info("Welcome home! The client locale is {}.", locale);

        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

        String formattedDate = dateFormat.format(date);

        model.addAttribute("serverTime", formattedDate );

        return "home";
    }
    */
/*
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        System.out.println("HomeController: Passing through...");
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
        formattedDate = dateFormat.format(date);
        model.addAttribute("date", formattedDate );
        return "home";
    }
*/

}