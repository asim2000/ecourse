package az.orient.ecourse.service;

import az.orient.ecourse.model.Lesson;

import java.util.List;

public interface LessonService {

    List<Lesson> getLessonList() throws Exception;

}
