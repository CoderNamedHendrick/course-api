package com.hendrick.courseapidata.lessons;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LessonService {

    @Autowired
    private LessonRepository lessonRepository;

    public List<Lesson> getAllLessons(String courseId) {
        return new ArrayList<>(lessonRepository.findByCourseId(courseId));
    }

    public Lesson getLesson(String id) {
        return lessonRepository.findById(id).orElseThrow();
    }

    public void addLesson(Lesson topic) {
        lessonRepository.save(topic);
    }

    public void updateLesson(Lesson lesson) {
        lessonRepository.save(lesson);
    }

    public void deleteLesson(String id) {
        lessonRepository.deleteById(id);
    }
}
