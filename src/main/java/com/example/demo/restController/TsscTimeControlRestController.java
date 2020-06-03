package com.example.demo.restController;

import java.net.URI;

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
import com.example.demo.model.TsscTimecontrol;
import com.example.demo.model.TsscTopic;
import com.example.demo.service.TsscTimeControlService;
import com.example.demo.service.TsscTopicService;

@RestController
public class TsscTimeControlRestController {
	
	@Autowired
	TsscTimeControlService timeControlService;
	
	@GetMapping("/api/timecontrol")
	public Iterable<TsscTimecontrol> getTimecontrols() {
		return timeControlService.findAll();
	}
	
	@GetMapping("/api/timecontrol/{id}")
	public TsscTimecontrol getTimecontrol(@PathVariable("id") long id) {
		TsscTimecontrol t = timeControlService.findById(id);
		if(t==null) {
			throw new RuntimeException();
		} 
		return t;
	}
	
	@GetMapping("/api/timecontrol/{id}/game")
	public TsscGame getStoryGame(@PathVariable("id") long id) {
		TsscTimecontrol t = timeControlService.findById(id);
		if(t==null) {
			throw new RuntimeException();
		} 
		return t.getTsscGame();
	}
	
	@PostMapping("/api/timecontrol")
	public ResponseEntity<Object> add(@RequestBody TsscTimecontrol timecontrol) {
		timeControlService.save(timecontrol);
		TsscTimecontrol savedTimecontrol = timecontrol;
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedTimecontrol.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	

	@PutMapping("/api/timecontrol/{id}")
	public ResponseEntity<Object> edit(@RequestBody TsscTimecontrol topic, @PathVariable long id) {
		TsscTimecontrol t = timeControlService.findById(id);
		if(t==null) {
			System.out.println("Not found in restC TC");
			return ResponseEntity.notFound().build();
		} 
		topic.setId(id);
		timeControlService.update(topic);
		return ResponseEntity.ok().build();
	}
	
	
	@DeleteMapping("/api/timecontrol/{id}")

	public ResponseEntity<Object> delete(@PathVariable long id) {
		timeControlService.delete(timeControlService.findById(id));
		return ResponseEntity.ok().build();
	}
}
