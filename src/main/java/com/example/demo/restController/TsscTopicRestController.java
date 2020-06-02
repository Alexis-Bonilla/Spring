package com.example.demo.restController;

import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
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
import com.example.demo.service.TsscTopicService;


@RestController
public class TsscTopicRestController {

	@Autowired
	TsscTopicService topicService;

	@GetMapping("/api/topics")

	public Iterable<TsscTopic> getTopics() {
		return topicService.findAll();
	}
	
	@GetMapping("/api/topics/{id}")

	public TsscTopic getTopic(@PathVariable("id") long id) {
		TsscTopic t = topicService.findById(id);
		if(t==null) {
			throw new RuntimeException();
		} 
		return t;
	}
	
	@GetMapping("/api/topics/{id}/stories")

	public List<TsscStory> getTopicStories(@PathVariable("id") long id) {
		TsscTopic t = topicService.findById(id);
		if(t==null) {
			throw new RuntimeException();
		} 
		return t.getTsscStories();
	}
	                                  
	@GetMapping("/api/topics/{id}/games")

	public List<TsscGame> getTopicGames(@PathVariable("id") long id) {
		TsscTopic t = topicService.findById(id);
		if(t==null) {
			throw new RuntimeException();
		} 
		return t.getTsscGames();
	}
	
	
	@PostMapping("/api/topics")

	public ResponseEntity<Object> add(@RequestBody TsscTopic topic) {
		topicService.save(topic);
		TsscTopic savedTopic = topic;
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedTopic.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	

	@PutMapping("/api/topics/{id}")
	public ResponseEntity<Object> edit(@RequestBody TsscTopic topic, @PathVariable long id) {
		TsscTopic t = topicService.findById(id);
		if(t==null) {
			return ResponseEntity.notFound().build();
		} 
		topic.setId(id);
		topicService.update(topic);
		return ResponseEntity.ok().build();
	}
	
	
	@DeleteMapping("/api/topics/{id}")

	public ResponseEntity<Object> delete(@PathVariable long id) {
		topicService.deleteTsscTopic(topicService.findById(id));
		return ResponseEntity.ok().build();
	}
		
}
