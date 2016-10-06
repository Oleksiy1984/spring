package com.alex.controller;

import com.alex.data.entities.services.Project;
import com.alex.data.entities.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;


@Controller
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @RequestMapping(value="/{projectId}")
    public String findProject(Model model, @PathVariable("projectId") Long projectId){
        model.addAttribute("project", this.projectService.find(projectId));
        return "project";
    }

    @RequestMapping(value="/find")
    public String find(Model model){
        model.addAttribute("projects", this.projectService.findAll());
        return "projects";
    }

    @RequestMapping(value="/add",method=RequestMethod.GET)
    public String addProject(Model model){

        model.addAttribute("types", new ArrayList<String>(){{
            add("");
            add("Single Year");
            add("Multi Year");
        }});

        model.addAttribute("project", new Project());

        return "project_add";
    }

    @RequestMapping(value="/add", method=RequestMethod.POST)
    public String saveProject(@ModelAttribute Project project){
        System.out.println(project);
        System.out.println("invoking saveProject");
        return "redirect:/project/add";
    }
/*
    @RequestMapping(value="/add", method=RequestMethod.POST, params={"type=multi"})
    public String saveMultiYearProject(){
        System.out.println("invoking saveMultiYearProject");
        return "project_add";
    }

    @RequestMapping(value="/add", method= RequestMethod.POST, params={"type=multi","special"})
    public String saveSpecialProject(){
        System.out.println("invoking saveSpecialProject");
        return "project_add";
    }
    */
}
