package com.example.demo.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.delegate.TsscGameDelegate;
import com.example.demo.delegate.TsscStoryDelegate;
import com.example.demo.model.TsscGame;
import com.example.demo.model.TsscStory;
import com.example.demo.service.TsscGameService;
import com.example.demo.service.TsscGameServiceImp;
import com.example.demo.service.TsscStoryServiceImp;

import lombok.extern.java.Log;


@Controller
@Log
public class TsscStoryController {
	
	
	@Autowired
	private TsscGameDelegate gameDelegate ;

	@Autowired
	private TsscStoryDelegate storyDelegate;
	

	
	
	
	
	@GetMapping("/stories")
	public String indexStory(Model model) {
		model.addAttribute("tsscStories", storyDelegate.findAll());
		return "stories/index";
	}
	
	
	
	
	
	@GetMapping("/stories/add")
	public String addStory(Model model) {
		model.addAttribute("tsscStory", new TsscStory());
		model.addAttribute("games", gameDelegate.findAll());
		return "stories/add-story";
	}
	
	
	@PostMapping("/stories/add")
	public String saveStory(  Model model,TsscStory tsscStory, BindingResult bindingResult,
			@RequestParam(value = "action", required = true) String action) {

		if (!action.equals("Cancelar")) {
			if (bindingResult.hasErrors()) {

				model.addAttribute("descriptionTsscStory", tsscStory.getDescription());
				model.addAttribute("businessValueTsscStory", tsscStory.getBusinessValue());
				model.addAttribute("initialSprintTsscStory", tsscStory.getInitialSprint());
				model.addAttribute("priorityTsscStory", tsscStory.getPriority());
				model.addAttribute("tsscGames",tsscStory.getTsscGame());

				return "stories/add-stories";
			} else {
				
	
				TsscGame g = gameDelegate.findById(tsscStory.getTsscGame().getId());
				
				gameDelegate.findById(tsscStory.getTsscGame().getId()).getTsscStories().add(tsscStory);		
				storyDelegate.save(tsscStory);
				
			
			
				return "redirect:/stories/";
			}
		} else {
			
			return "redirect:/stories/";
		}

	}
	

	
	@GetMapping("/stories/edit/{id}")
	public String showUpdateForm(Model model,@PathVariable("id") long id) {
		TsscStory tsscStory = storyDelegate.findById(id);

		if (tsscStory == null)
			throw new IllegalArgumentException("Invalid story Id:" + id);
		model.addAttribute("tsscStory", tsscStory);
		model.addAttribute("descriptionTsscStory", tsscStory.getDescription());
		model.addAttribute("businessValueTsscStory", tsscStory.getBusinessValue());
		model.addAttribute("initialSprintTsscStory", tsscStory.getInitialSprint());
		model.addAttribute("priorityTsscStory", tsscStory.getPriority());
		model.addAttribute("tsscGames",gameDelegate.findAll());
		return "stories/update-story";
	}
	
	
	@PostMapping("stories/edit/{id}")
	public String updateStory(@PathVariable("id") long id,
			@RequestParam(value = "action", required = true) String action,
			 TsscStory tsscStory, BindingResult bindingResult, Model model) {

		if (action.equals("Cancelar")) {

			return "redirect:/stories/";
		}

		if (bindingResult.hasErrors()) {

			model.addAttribute("descriptionTsscStory", tsscStory.getDescription());
			model.addAttribute("businessValueTsscStory", tsscStory.getBusinessValue());
			model.addAttribute("initialSprintTsscStory", tsscStory.getInitialSprint());
			model.addAttribute("priorityTsscStory", tsscStory.getPriority());
			model.addAttribute("tsscGames", gameDelegate.findAll());
			
			return "stories/update-story";
		}

		if (action != null && !action.equals("Cancelar")) {

			try {
				storyDelegate.update(tsscStory.getId(),tsscStory);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		return "redirect:/stories/";
	}
	
	@GetMapping("/stories/del/{id}")
	public String deleteGame(@PathVariable("id") long id) {
		storyDelegate.delete(id);
		return "redirect:/stories/";
	}
	
	

	
	
	
	
	
	
	
	
}
