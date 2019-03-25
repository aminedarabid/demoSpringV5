package com.objis.controller;


import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.objis.spring.demodao.IFormationDao;



@Controller
public class AppController {

	@Autowired
	private IFormationDao repository ;
	
    @RequestMapping("/")
    public ModelAndView index (){
        ModelAndView MAV = new ModelAndView();
        MAV.setViewName("index");
        MAV.addObject("formationList", this.repository.findAll());
        return MAV;
    }
}
