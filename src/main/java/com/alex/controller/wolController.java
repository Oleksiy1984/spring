package com.alex.controller;

import com.alex.data.entities.Project;
import com.alex.data.entities.services.Resource;
import com.alex.data.entities.services.WakeUp;
import com.alex.data.entities.services.Waker;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
//import com.alex.data.entities.wol;



@Controller
public class wolController {

    @RequestMapping(value="/wok",method= RequestMethod.GET)
    public String wok1(Model model){

        List<String> checks = new LinkedList<>(Arrays.asList(new String[]{
                "D4-3D-7E-31-D0-7A", "Ds"
        }));

        model.addAttribute("typeOptions", checks);
        model.addAttribute("waker", new Waker());
        return "wok";
    }

    @RequestMapping(value="/wok", method=RequestMethod.POST)
    public String wok(@ModelAttribute Waker waker){
        System.out.println(waker);
        try {
            waker.doWakeOnLan();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "redirect:/wok";
    }

}

