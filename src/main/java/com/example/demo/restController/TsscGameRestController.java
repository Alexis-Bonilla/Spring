package com.example.demo.restController;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.model.TsscGame;
import com.example.demo.model.TsscStory;
import com.example.demo.model.TsscTopic;
import com.example.demo.service.TsscGameService;

@RestController
public class TsscGameRestController {
	
	@Autowired
	TsscGameService gameService;

	@GetMapping("/api/games")
	public Iterable<TsscGame> getTopics() {
		return gameService.findAll();
	}
	
	@GetMapping("/api/games/{id}")
	public TsscGame getTopic(@PathVariable("id") long id) {
		TsscGame t = gameService.findById(id);
		if(t==null) {
			throw new RuntimeException();
		} 
		return t;
	}
	
	@GetMapping("/api/games/{id}/topic")
	public TsscTopic getGameTopic(@PathVariable("id") long id) {
		TsscGame t = gameService.findById(id);
		if(t==null) {
			throw new RuntimeException();
		} 
		return t.getTsscTopic();
	}
	
	@GetMapping("/api/games/{id}/stories")
	public List<TsscStory> getGameStories(@PathVariable("id") long id) {
		TsscGame t = gameService.findById(id);
		if(t==null) {
			throw new RuntimeException();
		} 
		return t.getTsscStories();
	}
			
	@PostMapping("/api/games")
	public ResponseEntity<Object> add(@RequestBody TsscGame game) {
		gameService.save(game);
		TsscGame saveGame =game;
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(saveGame.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	

	@PutMapping("/api/games/{id}")
	public ResponseEntity<Object> edit(@RequestBody TsscGame game, @PathVariable long id) {
		TsscGame t = gameService.findById(id);
		if(t==null) {
			return ResponseEntity.notFound().build();
		} 
		game.setId(id);
		gameService.update(game);
		return ResponseEntity.ok().build();
	}
	
	
	@DeleteMapping("/api/games/{id}")
	public ResponseEntity<Object> delete(@PathVariable long id) {
		gameService.delete(gameService.findById(id));
		return ResponseEntity.ok().build();
	}
		

}
