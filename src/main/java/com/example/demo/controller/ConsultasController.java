package com.example.demo.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dao.TsscGameDao;
import com.example.demo.dao.TsscTopicDao;
import com.example.demo.model.TsscGame;
import com.example.demo.model.TsscTopic;

@Controller
public class ConsultasController {
	@Autowired
	private TsscGameDao game;
	@Autowired
	private TsscTopicDao topic;
	
	
	
	@GetMapping("/consultas/topic")
	public String indexT(Model model) {
		return "consultas/indexT";
	}
	
	@GetMapping("/consultas/game")
	public String indexG(Model model) {
		return "consultas/indexG";
	}
	
	@PostMapping("/consultas/game")
	public String filtrerGames(@RequestParam("initialDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate initialDate, @RequestParam("finishDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate finishDate, Model model) {
		List<TsscGame> filter = game.findByDateRange(initialDate, finishDate);
		System.out.println("Cantidad games en filter: "+filter.size());
		model.addAttribute("tsscGames", filter);
		return "games/index";
	}
	
	@PostMapping("/consultas/topic")
	public String topicsByDate(@RequestParam("date")@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date, Model model) {
		List<TsscTopic> filter = topic.findTopicsByGameDateOrderedByTime(date);
		model.addAttribute("tsscTopics",filter);
		return "topics/index";
	}

}
