package com.hello.courses.topics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

    private List<Topic> topics = new ArrayList<>(Arrays.asList(
        new Topic("spring", "Spring", "Spring Desc"),
        new Topic("angular", "Angular", "Angular Desc"),
        new Topic("java", "Java", "Java Desc")
    ));

    public List<Topic> getTopics(){
        List<Topic> topics = new ArrayList<>();
        topicRepository.findAll().forEach(topics::add);
        return topics;
    }

    public Topic getTopic(String id){
        return topicRepository.findById(id).get();
    }

	public void addTopic(Topic topic) {
        topicRepository.save(topic);
	}

	public void updateTopic(String id, Topic topic) {
        topicRepository.save(topic);
    }
    
    public void deleteTopic(String id){
        topicRepository.deleteById(id);
    }
    
}
