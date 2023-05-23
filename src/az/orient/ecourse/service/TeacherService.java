package az.orient.ecourse.service;

import az.orient.ecourse.model.Teacher;
import az.orient.ecourse.model.TeacherLesson;

import java.util.List;

public interface TeacherService {
    List<Teacher> getTeacherList() throws Exception;

    List<TeacherLesson> getTeacherLesson() throws Exception;

    List<Teacher> getTeacherListByLessonId(Long lessonId) throws Exception;

    Teacher getTeacherByUserId(Long userId) throws Exception;


}
