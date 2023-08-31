package com.mattmottle.dojosandninjas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.mattmottle.dojosandninjas.models.Dojo;
import com.mattmottle.dojosandninjas.models.Ninja;
import com.mattmottle.dojosandninjas.services.DojoService;
import com.mattmottle.dojosandninjas.services.NinjaService;

import jakarta.validation.Valid;

@Controller
public class MainController {
	@Autowired
	DojoService dojoService;
	@Autowired 
	NinjaService ninjaService;
	
	@GetMapping("/")
	public String home(Model model) {
	     model.addAttribute("dojos", dojoService.readAllDojos());
		return "index.jsp";
	}
	@GetMapping("/dojos/new")
	public String newDojo(@ModelAttribute Dojo dojo) {
		return "newDojo.jsp";
	}
			
	@PostMapping("dojos/new/process")
	public String createNewDojo(Model model, @Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		if (result.hasErrors()) { 
			return "newDojo.jsp"; 
		} 
		else {
			dojoService.createDojo(dojo);
			return "redirect:/";
		}
	}
	@GetMapping("/ninjas/new")
	public String newNinja(Model model, @ModelAttribute Ninja ninja) {
		List<Dojo> dojos = dojoService.readAllDojos();
		model.addAttribute("dojos", dojos);
		return "newNinja.jsp";
	}
			
	@PostMapping("ninjas/new/process")
	public String createNewNinja(Model model, @Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result) {
		if (result.hasErrors()) { 
			return "newNinja.jsp"; 
		} 
		else {
			ninjaService.createNinja(ninja);
			return "redirect:/";
		}
	}
	
	@GetMapping("dojos/{dojoId}")
	public String dojoPage(Model model, @PathVariable("dojoId") Long dojoId) {
		Dojo dojo = dojoService.findDojo(dojoId);
		model.addAttribute("dojo", dojo);
		return "dojo.jsp";
	}
}
