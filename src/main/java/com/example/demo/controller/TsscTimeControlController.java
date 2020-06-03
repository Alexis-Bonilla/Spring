package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.delegate.TsscGameDelegate;
import com.example.demo.delegate.TsscTimeControlDelegate;
import com.example.demo.model.TsscGame;
import com.example.demo.model.TsscTimecontrol;
import com.example.demo.service.TsscTimeControlService;

@Controller
public class TsscTimeControlController {
	@Autowired
	private TsscTimeControlDelegate controlDelegate;
	@Autowired
	private TsscGameDelegate gameDelegate;

	
	@GetMapping("/timecontrol/")
	public String index(Model model) {
		model.addAttribute("timecontrols", controlDelegate.findAll());
		return "timecontrol/index";
	}
	
	@GetMapping("/timecontrol/add")
	public String add(Model model) {
		model.addAttribute("tsscTimecontrol", new TsscTimecontrol());
		model.addAttribute("games", gameDelegate.findAll());
		return "timecontrol/add";
	}
	
	@PostMapping("/timecontrol/add")
	public String add(@Validated TsscTimecontrol time, BindingResult bd, @RequestParam(value = "action", required = true) String action, Model model) {
			
		if(bd.hasErrors()&&!action.equalsIgnoreCase("Cancel")) {
			model.addAttribute("tsscTimecontrol", time);
			model.addAttribute("games", gameDelegate.findAll());
			return "timecontrol/add";
		}
		if(!action.equalsIgnoreCase("Cancel")) {
			controlDelegate.save(time);
		}
		return "redirect:/timecontrol/";
	}

	@Autowired
	private TsscTimeControlService tcs;
	
	@GetMapping("/timecontrol/edit/{id}")
	public String edit(@PathVariable("id") long id, Model model) {
		TsscTimecontrol time = controlDelegate.findById(id);
		model.addAttribute("tsscTimecontrol", time);
		model.addAttribute("name",time.getName());
		model.addAttribute("autostart", time.getAutostart());
		model.addAttribute("order", time.getOrder());
		model.addAttribute("timeInterval", time.getTimeInterval());
		model.addAttribute("state", time.getState());
		model.addAttribute("lastPlayTime", time.getLastPlayTime());
		model.addAttribute("type",time.getType());
		model.addAttribute("games", gameDelegate.findAll());
		return "timecontrol/edit";
	}
	
	@PostMapping("/timecontrol/edit/{id}")
	public String edit(@Validated TsscTimecontrol time, BindingResult bd, @RequestParam(value = "action", required = true) String action, @PathVariable("id") long id,  Model model) {
		if(bd.hasErrors()&&!action.equalsIgnoreCase("Cancel")) {
			model.addAttribute("tsscTimecontrol", time);
			model.addAttribute("name",time.getName());
			model.addAttribute("autostart", time.getAutostart());
			model.addAttribute("order", time.getOrder());
			model.addAttribute("timeInterval", time.getTimeInterval());
			model.addAttribute("state", time.getState());
			model.addAttribute("lastPlayTime", time.getLastPlayTime());
			model.addAttribute("type",time.getType());
			model.addAttribute("games", gameDelegate.findAll());
			return "timecontrol/edit";
		}
		if(!action.equalsIgnoreCase("Cancel")) {
			controlDelegate.update(id, time);
		}
		return "redirect:/timecontrol/";
	}
	
	@GetMapping("/timecontrol/showGame/{id}")
	public String showGame(Model model, @PathVariable("id") long id) {
		List<TsscGame> g = new ArrayList<>();
		g.add(controlDelegate.findGame(id));
		model.addAttribute("games", g);
		return "timecontrol/game-timecontrol";
	}
	
	@GetMapping("/timecontrol/del/{id}")
	public String remove(@PathVariable("id") long id) {
		controlDelegate.delete(id);
		return "redirect:/timecontrol/";
	}
	
	@GetMapping("/timecontrol/game/{id}")
	public String showListStories(@PathVariable("id") long id, Model model) {
		TsscTimecontrol tssctc = controlDelegate.findById(id);
		System.out.println("ID: "+tssctc.getTsscGame().getId());
		System.out.println("Nombre: "+gameDelegate.findById(tssctc.getTsscGame().getId()).getName());
		List<TsscGame> games = new ArrayList<>();
		games.add(gameDelegate.findById(tssctc.getTsscGame().getId()));
		model.addAttribute("tsscGames", games);
		return "games/index";
	}

}
