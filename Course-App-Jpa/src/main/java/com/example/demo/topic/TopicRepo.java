package com.example.demo.topic;

import org.springframework.data.repository.CrudRepository;

// CrudRepository <Entity, Id>
public interface TopicRepo extends CrudRepository<Topic, String>{
	
}
