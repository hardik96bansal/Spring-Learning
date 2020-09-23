package com.hello.courses.lessons;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LessonService {

    @Autowired
    LessonRepository lessonRepository;
    
    List<Lesson> lessons = new ArrayList<>(Arrays.asList(
        new Lesson("L1", "Lesson 1", "Lesson 1 Desc"),
        new Lesson("L2", "Lesson 2", "Lesson 2 Desc"),
        new Lesson("L3", "Lesson 3", "Lesson 3 Desc")
    ));

    public List<Lesson> getAllLessons(String courseId){
        return lessonRepository.findByCourseId(courseId);
    }

    public Lesson getLesson(String id){
        return lessonRepository.findById(id).get();
    }
    
    public void addLesson(Lesson lesson){
        lessonRepository.save(lesson);
    }

    public void updateLesson(String id, Lesson lesson){
        lessonRepository.save(lesson);
    }

    public void deleteLesson(String id){
        lessonRepository.deleteById(id);
    }
    

}
