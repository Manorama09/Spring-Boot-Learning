package com.example.demo.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//A business service - singleton
@Service
public class TopicService {
	
	@Autowired
	private TopicRepo repo;

	List<Topic> topics = new ArrayList<>(Arrays.asList(
			new Topic("spring", "Spring Framework", "Spring Framework Description"),
			new Topic("java", "Java Core", "Core Java Description"),
			new Topic("javascript", "Javascript", "Javascript Description")
			));
	
	// GET - All topics		
	public List<Topic> getAllTopics(){
		return (List<Topic>) repo.findAll();
	}
	
	// GET - A particular topic's details
	public Optional<Topic> getTopic(String id) {
		return repo.findById(id);
	}
	
	// POST - Add a new topic
	public void addTopic(Topic topic) {
		repo.save(topic);
	}
	
	// PUT - Update an existing topic - given id
	public void updateTopic(Topic topic, String id) {
		repo.save(topic);
	}
	
	// DELETE - Remove an existing topic - given id
	public void deleteTopic(String id) {
		repo.deleteById(id);
	}
}
