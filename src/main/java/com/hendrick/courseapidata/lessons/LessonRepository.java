package com.hendrick.courseapidata.lessons;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LessonRepository extends  CrudRepository<Lesson, String>{

    List<Lesson> findByCourseId(String topicId);
}
