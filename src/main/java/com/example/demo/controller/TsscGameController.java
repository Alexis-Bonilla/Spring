package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.delegate.TsscGameDelegate;
import com.example.demo.delegate.TsscStoryDelegate;
import com.example.demo.delegate.TsscTopicDelegate;
import com.example.demo.model.TsscGame;
import com.example.demo.model.TsscStory;
import com.example.demo.service.TsscGameService;
import com.example.demo.service.TsscGameServiceImp;
import com.example.demo.service.TsscStoryService;
import com.example.demo.service.TsscTopicServiceImp;

import lombok.extern.java.Log;

@Controller
@Log
public class TsscGameController {

	@Autowired
	TsscGameDelegate gameDelegate ;
	@Autowired
	private TsscTopicDelegate topicDelegate;

	
	@Autowired
	private TsscStoryDelegate storyDelegate;
	
	
	@GetMapping("/games/")
	public String indexGame(Model model) {
		model.addAttribute("tsscGames", gameDelegate.findAll());
		return "games/index";
	}
	
	
	@GetMapping("/games/add")
	public String addGame(Model model) {
		
		model.addAttribute("tsscGame", new TsscGame());
		model.addAttribute("tsscTopics", topicDelegate.findAll());
		
		
		
		
		return "games/add-game";
	}
	
	
	@PostMapping("/games/add")
	public String saveGame( TsscGame tsscGame, BindingResult bindingResult, @RequestParam(value = "action", required = true) String action, Model model) {

		if (!action.equals("Cancelar")) {
			if (bindingResult.hasErrors()) {

				model.addAttribute("nameTsscGame", tsscGame.getName());
				model.addAttribute("nGroupsTsscGame", tsscGame.getNGroups());
				model.addAttribute("nSprintsTsscGame", tsscGame.getNSprints());
				model.addAttribute("scheduledDateTsscGame", tsscGame.getScheduledDate());
				model.addAttribute("scheduledTimeTsscGame", tsscGame.getScheduledTime());
				model.addAttribute("adminPasswordTsscGame", tsscGame.getAdminPassword());
				model.addAttribute("userPasswordTsscGame", tsscGame.getUserPassword());
				model.addAttribute("guestPasswordTsscGame", tsscGame.getGuestPassword());
				model.addAttribute("tsscTopics", topicDelegate.findAll());

				return "games/add-game";
			} else {

			

					if (tsscGame.getTsscTopic() == null) {

						gameDelegate.save(tsscGame);

					} else {

						gameDelegate.save(tsscGame);
					}

				

				return "redirect:/games/";
			}
		} else {
			

			model.addAttribute("games", gameDelegate.findAll());
			return "redirect:/games/";
		}

	}
	
	
	@Autowired
	private TsscGameService gameService;
	
	@Autowired
	private TsscStoryService storyService;
	
	@GetMapping("/games/edit/{id}")
	public String showUpdateForm(@PathVariable("id") Long id, Model model) {
		TsscGame tsscGame = gameDelegate.findById(id);
		
		model.addAttribute("tsscGame", tsscGame);
		model.addAttribute("nameTsscGame", tsscGame.getName());
		model.addAttribute("nGroupsTsscGame", tsscGame.getNGroups());
		model.addAttribute("nSprintsTsscGame", tsscGame.getNSprints());
		model.addAttribute("scheduledDateTsscGame", tsscGame.getScheduledDate());
		model.addAttribute("scheduledTimeTsscGame", tsscGame.getScheduledTime());
		model.addAttribute("adminPasswordTsscGame", tsscGame.getAdminPassword());
		model.addAttribute("userPasswordTsscGame", tsscGame.getUserPassword());
		model.addAttribute("guestPasswordTsscGame", tsscGame.getGuestPassword());
		model.addAttribute("tsscTopics", topicDelegate.findAll());
		
		return "games/update-game";
		
		
	}
	
	@PostMapping("/games/edit/{id}")
	public String updateGame(Model model, @PathVariable("id") Long id, @RequestParam(value = "action", required = true) String action , TsscGame tsscGame ,BindingResult bindingResult) {
		if(action != null && !action.equals("Cancelar")) {
			
			if (tsscGame.getTsscTopic() == null) {
				gameDelegate.update(id,tsscGame);
			}else {
				gameDelegate.update(id,tsscGame);
				
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
			model.addAttribute("tsscTopics",topicDelegate.findAll());
			
			return "games/update-game";
		}
		
		
		if (action.equals("Cancel")) {

			return "redirect:/games/";
		}
		
		return "redirect:/games/";
	}
	
	

	@GetMapping("/games/del/{id}")
	public String deleteGame(@PathVariable("id") Long id) {
		TsscGame tsscGame = gameDelegate.findById(id);
		gameDelegate.delete(tsscGame.getId());
		
		return "redirect:/games/";
	}
	
	
	@GetMapping("/games/list/{id}")
	public String showListStories(@PathVariable("id") long id, Model model) {
		TsscGame tsscGame = gameService.findById(id);
		model.addAttribute("tsscGame", tsscGame);
		model.addAttribute("stories", tsscGame.getTsscStories());
		return "games/list-stories";
	}

	@GetMapping("/games/list/add/{id}")
	public String addStory(@PathVariable("id") long id, Model model) {
		List<TsscGame> games = new ArrayList<>();
		TsscGame game = gameDelegate.findById(id);
		TsscStory story =  new TsscStory();
		games.add(game);
		story.setTsscGame(game);
		model.addAttribute("tsscStory",story);
		model.addAttribute("games", games);
		return "stories/add-story";
	}
	
	

		
}
