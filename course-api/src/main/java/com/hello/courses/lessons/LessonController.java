package com.hello.courses.lessons;

import java.util.List;

import com.hello.courses.course.Course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class LessonController {

    @Autowired
    private LessonService lessonService;
    
    @RequestMapping("/topics/{topicId}/courses/{courseId}/lessons")
    public List<Lesson> getAllLessons(@PathVariable String courseId){
        return lessonService.getAllLessons(courseId);
    }

    @RequestMapping("/topics/{topicId}/courses/{courseId}/lessons/{lessonId}")
    public Lesson getLesson(@PathVariable String lessonId){
        return lessonService.getLesson(lessonId);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/topics/{topicId}/courses/{courseId}/lessons")
    public void addLesson(@RequestBody Lesson lesson, @PathVariable String courseId){
        lesson.setCourse(new Course(courseId,"",""));
        lessonService.addLesson(lesson);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/topics/{topicId}/courses/{courseId}/lessons/{lessonId}")
    public void updateLesson(@PathVariable String lessonId, @RequestBody Lesson lesson, @PathVariable String courseId){
        lesson.setCourse(new Course(courseId, "", ""));
        lessonService.updateLesson(lessonId, lesson);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/topics/{topicId}/courses/{courseId}/lessons/{lessonId}")
    public void deleteLesson(@PathVariable String lessonId){
        lessonService.deleteLesson(lessonId);
    }

}
