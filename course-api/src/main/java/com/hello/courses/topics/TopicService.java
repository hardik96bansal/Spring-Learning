package com.hello.courses.topics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicService {

    private List<Topic> topics = new ArrayList<>(Arrays.asList(
        new Topic("spring", "Spring", "Spring Desc"),
        new Topic("angular", "Angular", "Angular Desc"),
        new Topic("java", "Java", "Java Desc")
    ));

    public List<Topic> getTopics(){
        return topics;
    }

    public Topic getTopic(String id){
        return topics.stream().filter(x -> x.getId().equals(id)).findFirst().get();
    }

	public void addTopic(Topic topic) {
        topics.add(topic);
	}

	public void updateTopic(String id, Topic topic) {
        for(int i=0;i<topics.size();i++){
            if(topics.get(i).getId().equals(id)){
                topics.set(i, topic);
                return;
            }
        }
    }
    
    public void deleteTopic(String id){
        topics.removeIf(x -> x.getId().equals(id));
    }
    
}
