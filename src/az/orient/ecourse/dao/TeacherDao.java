package az.orient.ecourse.dao;

import az.orient.ecourse.model.Teacher;
import az.orient.ecourse.model.TeacherLesson;

import java.util.List;

public interface TeacherDao {

    List<Teacher> getTeacherList() throws Exception;

    List<TeacherLesson> getTeacherLesson() throws Exception;
}
