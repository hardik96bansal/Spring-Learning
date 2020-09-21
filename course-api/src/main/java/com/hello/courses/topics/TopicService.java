package com.hello.courses.topics;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicService {

    private List<Topic> topics = Arrays.asList(
        new Topic("spring", "Spring", "Spring Desc"),
        new Topic("angular", "Angular", "Angular Desc"),
        new Topic("java", "Java", "Java Desc")
    );

    public List<Topic> getTopics(){
        return topics;
    }

    public Topic getTopic(String id){
        return topics.stream().filter(x -> x.getId().equals(id)).findFirst().get();
    }
    
}
