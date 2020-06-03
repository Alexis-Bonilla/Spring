package com.example.demo.delegate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.TsscGame;
import com.example.demo.model.TsscTimecontrol;

@Component
public class TsscTimeControlDelegate {
	
	@Autowired
	private RestTemplate restTemplate;

	@Value("${resource.timecontrol}")
	private String resource;

	@Value("${resource.timecontrol}/{id}")
	private String resourceId;

	@Value("${resource.timecontrol}/{id}/game")
	 private String gameResource;
	
	 public List<TsscTimecontrol> findAll() {
			return Arrays.stream(restTemplate.getForObject(resource, TsscTimecontrol[].class)).collect(Collectors.toList());
		 }
		 
		 public TsscTimecontrol findById(long id) {
			return restTemplate.getForObject(resourceId, TsscTimecontrol.class, id);
		 }
		 
		 public TsscGame findGame(long id) {
			return restTemplate.getForObject(gameResource, TsscGame.class, id);
		 }
		 
		 public void save(TsscTimecontrol time) {
			restTemplate.postForObject(resource, time, TsscTimecontrol.class);
		 }
		 
		 public void update(long id, TsscTimecontrol time) {
			restTemplate.exchange(resourceId, HttpMethod.PUT, new HttpEntity<>(time), TsscTimecontrol.class, id).getBody();
		 }
		 
		 public void delete(long id) {
			restTemplate.delete(resourceId, id);
		 }
		 
			public String getIdResource() {
				return resourceId;
		}
	

}
