package com.example.demo.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.delegate.TsscGameDelegate;
import com.example.demo.delegate.TsscTopicDelegate;
import com.example.demo.model.TsscTopic;
import com.example.demo.service.TsscTopicServiceImp;



@Controller
public class TsscTopicController {

	@Autowired
	TsscTopicDelegate  topicDelegate;
	
	@Autowired 
	TsscGameDelegate gameDelegate;
	
	
	
	@GetMapping("/topics/")
	public String indexUser(Model model) {
		model.addAttribute("tsscTopics",topicDelegate.findAll());
		return "topics/index";
	}
	
	@GetMapping("/topics/add")
	public String addTopic(Model model) {
		model.addAttribute("tsscTopic", new TsscTopic());
		return "/topics/add-topic";
	}
	
	@PostMapping("/topics/add")

	public String saveTopic( Model model, TsscTopic tsscTopic, BindingResult bindingResult,@RequestParam(value = "action", required = true) String action) {
		if (!action.equals("Cancel")) {
			if (bindingResult.hasErrors()) {
				
				model.addAttribute("nameTsscTopic", tsscTopic.getName());
				model.addAttribute("prefixTsscTopic", tsscTopic.getGroupPrefix());
				model.addAttribute("descriptionTsscTopic", tsscTopic.getDescription());
				model.addAttribute("DefaultGroupsTsscTopic", tsscTopic.getDefaultGroups());
				model.addAttribute("DefaultSprintsTsscTopic", tsscTopic.getDefaultSprints());

				return "topics/add-topic";
				
			} else {
				
				topicDelegate.save(tsscTopic);
				return "redirect:/topics/";
			}
		} else {
				model.addAttribute("topics", topicDelegate.findAll());
				return "topics/index";
		}

	}
	
	@GetMapping("/topics/edit/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
		
		TsscTopic tsscTopic = topicDelegate.findById(id);
			if(tsscTopic == null) {
				throw new IllegalArgumentException("Invalid Topic Id:" + id);
			}
			
			model.addAttribute("tsscTopic", tsscTopic);
			model.addAttribute("nameTsscTopic", tsscTopic.getName());
			model.addAttribute("prefixTsscTopic", tsscTopic.getGroupPrefix());
			model.addAttribute("descriptionTsscTopic", tsscTopic.getDescription());
			model.addAttribute("DefaultGroupsTsscTopic", tsscTopic.getDefaultGroups());
			model.addAttribute("DefaultSprintsTsscTopic", tsscTopic.getDefaultSprints());
			
			return "topics/update-topic";
			
	}
	

	@PostMapping("/topics/edit/{id}")
	public String updateTopic(Model model,@PathVariable("id") long id, @RequestParam(value="action", required = true) String action, TsscTopic tsscTopic, BindingResult bindingResult) {
		if(action != null && !action.equals("Cancelar")) {
			topicDelegate.update( id,tsscTopic);
		}
		
		if(bindingResult.hasErrors()) {
			model.addAttribute("nameTsscTopic", tsscTopic.getName());
			model.addAttribute("prefixTsscTopic", tsscTopic.getGroupPrefix());
			model.addAttribute("descriptionTsscTopic", tsscTopic.getDescription());
			model.addAttribute("DefaultGroupsTsscTopic", tsscTopic.getDefaultGroups());
			model.addAttribute("DefaultSprintsTsscTopic", tsscTopic.getDefaultSprints());
			return "topic/update-topic";
		}
		
		if (action.equals("Cancelar")) {
			return "redirect:/topics/";
		}
		return "redirect:/topics/";
	}
	
	
	@GetMapping("/topics/del/{id}")

	public String deleteTopic(@PathVariable("id") long id) {
		TsscTopic tsscTopic = topicDelegate.findById(id);
		topicDelegate.delete(tsscTopic.getId());
		
		return "redirect:/topics/";
	}
	
	
	
	
	

	
	
	
	
}
