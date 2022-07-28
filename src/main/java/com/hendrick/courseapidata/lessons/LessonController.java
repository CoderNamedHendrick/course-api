package com.hendrick.courseapidata.lessons;

import com.hendrick.courseapidata.courses.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LessonController {

    @Autowired
    private LessonService lessonService;

    @RequestMapping("/topics/{topicId}/courses/{id}/lessons")
    public List<Lesson> getAllLessons(@PathVariable String id, @PathVariable String topicId) {
        return lessonService.getAllLessons(id);
    }

    @RequestMapping("/topics/{topicId}/courses/{courseId}/lessons{id}")
    public Lesson getLesson(@PathVariable String id, @PathVariable String topicId, @PathVariable String courseId) {
        return lessonService.getLesson(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/topics/{topicId}/courses/{courseId}/lessons")
    public void addLesson(@RequestBody Lesson lesson, @PathVariable String topicId, @PathVariable String courseId) {
        lesson.setCourse(new Course(courseId, "", "", ""));
        lessonService.addLesson(lesson);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/topics/{topicId}/courses/{courseId}/lessons/{id}")
    public void updateLesson(@RequestBody Lesson lesson, @PathVariable String topicId, @PathVariable String courseId, @PathVariable String id) {
        lesson.setCourse(new Course(courseId, "", "", ""));
        lessonService.updateLesson(lesson);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/topics/{topicId}/courses/{courseId}/lessons/{id}")
    public void deleteLesson(@PathVariable String id, @PathVariable String courseId, @PathVariable String topicId) {
        lessonService.deleteLesson(id);
    }
}
