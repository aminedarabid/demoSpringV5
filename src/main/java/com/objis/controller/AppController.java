package com.objis.controller;


import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.objis.spring.demodao.IFormationDao;
import com.objis.spring.demodomaine.Formation;



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
    
    @RequestMapping("/form")
    public ModelAndView showForm() {
    	ModelAndView MAV = new ModelAndView();
    	MAV.setViewName("form");
        return MAV;
    }
    
    @RequestMapping(path = "/form", method = RequestMethod.POST)
	ModelAndView validateForm(@RequestParam int id, @RequestParam(name = "theme") String theme) {
		// Sauvegarder l'article en BDD.
		final Formation newform = new Formation(id, theme);
		this.repository.save(newform);
		// Renvoyer vers la page de liste des articles.
		return this.index();
}
}
