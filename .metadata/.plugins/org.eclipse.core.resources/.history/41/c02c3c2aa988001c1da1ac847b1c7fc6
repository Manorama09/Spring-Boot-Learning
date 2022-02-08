package com.example.demo.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//A business service - singleton
@Service
public class TopicService {

	List<Topic> topics = new ArrayList<>(Arrays.asList(
			new Topic("spring", "Spring Framework", "Spring Framework Description"),
			new Topic("java", "Java Core", "Core Java Description"),
			new Topic("javascript", "Javascript", "Javascript Description")
			));
	
	// GET - All topics		
	public List<Topic> getAllTopics(){
		return topics;
	}
	
	// GET - A particular topic's details
	public Topic getTopic(String id) {
		return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
	}
	
	// POST - Add a new topic
	public void addTopic(Topic topic) {
		topics.add(topic);
	}
	
	// PUT - Update an existing topic - given id
	public void updateTopic(Topic topic, String id) {
		for (int i = 0; i<topics.size(); i++) {
			Topic t = topics.get(i);
			if(t.getId().equals(id)) {
				topics.set(i, topic);
				return;
			}
		}
	}
	
	// DELETE - Remove an existing topic - given id
	public void deleteTopic(String id) {
		topics.removeIf(t -> t.getId().equals(id));
	}
}
