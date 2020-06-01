package com.example.demo.delegate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.TsscGame;
import com.example.demo.model.TsscStory;



@Component
public class TsscStoryDelegate {
	
	 @Autowired
	 private RestTemplate template;
	 
	 @Value("${resource.stories}")
	 private String resource;
	 
	 @Value("${resource.stories}/{id}")
	 private String resourceId;
	 
	 @Value("${resource.stories}/{id}/game")
	 private String gameResource;
	 
	 
	 
	 public List<TsscStory> findAll() {
			return Arrays.stream(template.getForObject(resource, TsscStory[].class)).collect(Collectors.toList());
		 }
		 
		 public TsscStory findById(long id) {
			return template.getForObject(resourceId, TsscStory.class, id);
		 }
		 
		 public TsscGame findGame(long id) {
			return template.getForObject(gameResource, TsscGame.class, id);
		 }
		 
		 public void save(TsscStory story) {
			template.postForObject(resource, story, TsscStory.class);
		 }
		 
		 public void update(long id, TsscStory story) {
			template.exchange(resourceId, HttpMethod.PUT, new HttpEntity<>(story), TsscStory.class, id).getBody();
		 }
		 
		 public void delete(long id) {
			template.delete(resourceId, id);
		 }
		 
			public String getIdResource() {
				return resourceId;
			}
	

}
