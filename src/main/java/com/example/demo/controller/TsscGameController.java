package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.TsscGame;
import com.example.demo.service.TsscGameServiceImp;

import com.example.demo.service.TsscTopicServiceImp;

@Controller
public class TsscGameController {

	@Autowired
	TsscGameServiceImp gameService ;
	@Autowired
	TsscTopicServiceImp topicService;
	
	
	@GetMapping("/games/")
	public String indexGame(Model model) {
		model.addAttribute("tsscGames", gameService.findAll());
		return "games/index";
	}
	
	
	@GetMapping("/games/add")
	public String addGame(Model model) {
		
		model.addAttribute("tsscGame", new TsscGame());
		model.addAttribute("tsscTopics", topicService.findAll());
		
		return "games/add-game";
	}
	
	
	@PostMapping("/games/add")
	public String saveGame( TsscGame tsscGame, BindingResult bindingResult, @RequestParam(value = "action", required = true) String action, Model model) {

		if (!action.equals("Cancel")) {
			if (bindingResult.hasErrors()) {

				model.addAttribute("nameTsscGame", tsscGame.getName());
				model.addAttribute("nGroupsTsscGame", tsscGame.getNGroups());
				model.addAttribute("nSprintsTsscGame", tsscGame.getNSprints());
				model.addAttribute("scheduledDateTsscGame", tsscGame.getScheduledDate());
				model.addAttribute("scheduledTimeTsscGame", tsscGame.getScheduledTime());
				model.addAttribute("adminPasswordTsscGame", tsscGame.getAdminPassword());
				model.addAttribute("userPasswordTsscGame", tsscGame.getUserPassword());
				model.addAttribute("guestPasswordTsscGame", tsscGame.getGuestPassword());
				model.addAttribute("tsscTopics", topicService.findAll());

				return "games/add-game";
			} else {

			

					if (tsscGame.getTsscTopic() == null) {

						gameService.save(tsscGame);

					} else {

						gameService.save(tsscGame);
					}

				

				return "redirect:/games/";
			}
		} else {

			model.addAttribute("games", gameService.findAll());
			return "games/index";
		}

	}
	
	
	
	@GetMapping("/games/edit/{id}")
	public String showUpdateForm(@PathVariable("id") Long id, Model model) {
		TsscGame tsscGame = gameService.findById(id);
		
		model.addAttribute("tsscGame", tsscGame);
		model.addAttribute("nameTsscGame", tsscGame.getName());
		model.addAttribute("nGroupsTsscGame", tsscGame.getNGroups());
		model.addAttribute("nSprintsTsscGame", tsscGame.getNSprints());
		model.addAttribute("scheduledDateTsscGame", tsscGame.getScheduledDate());
		model.addAttribute("scheduledTimeTsscGame", tsscGame.getScheduledTime());
		model.addAttribute("adminPasswordTsscGame", tsscGame.getAdminPassword());
		model.addAttribute("userPasswordTsscGame", tsscGame.getUserPassword());
		model.addAttribute("guestPasswordTsscGame", tsscGame.getGuestPassword());
		model.addAttribute("tsscTopics", topicService.findAll());
		
		return "games/update-game";
		
		
	}
	
	@PostMapping("/games/edit/{id}")
	public String updateGame(Model model, @PathVariable("id") Long id, @RequestParam(value = "action", required = true) String action , TsscGame tsscGame ,BindingResult bindingResult) {
		if(action != null && !action.equals(" ")) {
			
			if (tsscGame.getTsscTopic() == null) {
				gameService.save(tsscGame);
			}else {
				gameService.save(tsscGame);
				
			}
			
		}
		
		if(bindingResult.hasErrors()) {
			
			model.addAttribute("nameTsscGame", tsscGame.getName());
			model.addAttribute("nGroupsTsscGame", tsscGame.getNGroups());
			model.addAttribute("nSprintsTsscGame", tsscGame.getNSprints());
			model.addAttribute("scheduledDateTsscGame", tsscGame.getScheduledDate());
			model.addAttribute("scheduledTimeTsscGame", tsscGame.getScheduledTime());
			model.addAttribute("adminPasswordTsscGame", tsscGame.getAdminPassword());
			model.addAttribute("userPasswordTsscGame", tsscGame.getUserPassword());
			model.addAttribute("guestPasswordTsscGame", tsscGame.getGuestPassword());
			model.addAttribute("tsscTopics",topicService.findAll());
			
			return "games/update-game";
		}
		
		
		if (action.equals("Cancel")) {

			return "redirect:/games/";
		}
		
		return "redirect:/games/";
	}
	
	

	@GetMapping("/games/del/{id}")
	public String deleteGame(@PathVariable("id") Long id) {
		TsscGame tsscGame = gameService.findById(id);
		gameService.deleteTsscGame(tsscGame);
		
		return "redirect:/games/";
	}
	
	@GetMapping("/games/list/{id}")
	public String showListStories(@PathVariable("id") long id, Model model) {
		TsscGame tsscGame = gameService.findById(id);
		model.addAttribute("tsscGame", tsscGame);
		model.addAttribute("stories", tsscGame.getTsscStories());
		return "games/list-stories";
	}
	

	
	
	

	
}
