package com.objis.spring.controller;


import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import com.objis.spring.demodomaine.Formation;
import com.objis.spring.service.FormationService;


@Transactional
@Controller
public class AppController {

	private static final String String = null;
	@Autowired
	private FormationService formationservice;
	
    @RequestMapping({"/", "/index"})
    public ModelAndView index (){
        ModelAndView MAV = new ModelAndView();
        MAV.setViewName("index");
        MAV.addObject("formationList", this.formationservice.getAll());
        return MAV;
    }
    
    @RequestMapping("/form")
    public ModelAndView showForm() {
    	ModelAndView MAV = new ModelAndView();
    	MAV.setViewName("form");
        return MAV;
    }
    
    @RequestMapping(path = "/form", method = RequestMethod.POST)
    public String validateForm(@RequestParam Integer id, @RequestParam(name = "theme") String theme) {
		// Sauvegarder formation en BDD.
		final Formation newform = new Formation(id, theme);
		this.formationservice.create(newform);
		// Renvoyer vers la page de liste des articles.
		//return this.index();
		return "redirect:/index.html";
    }
    
    @GetMapping("/delete")
	public String delete(Integer id) {
		// Supprimer formation.
    	this.formationservice.deletebyId(id);
		// Renvoyer vers la vue welcome.
    	return "redirect:/index.html";
	}
    
	@GetMapping("/edit")
	public ModelAndView displayEdit(Integer id) {
		ModelAndView mav = new ModelAndView("form");
		Formation result = this.formationservice.findById(id);
		Hibernate.initialize(result);
		if (result!= null) {
			mav.addObject("editFormation", result);
		}
		return mav;
	}
	
	@PostMapping("/edit")
	public String validateUpdate(Formation formation) {
		this.formationservice.validateUpdate(formation);
		return "redirect:/index.html";
	}
	
	@RequestMapping("/search")
	public ModelAndView displaySearch(String search) {
		ModelAndView mav = new ModelAndView("search");
		return mav;
	}
	
	@PostMapping("/search")
	public ModelAndView search(String search) {
		ModelAndView mav = new ModelAndView("search");
		mav.addObject("resultList", this.formationservice.findByThemeContaining(search));
		return mav;
	}
}
