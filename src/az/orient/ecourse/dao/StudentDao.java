package az.orient.ecourse.dao;

import az.orient.ecourse.model.Student;
import az.orient.ecourse.model.StudentTeacherLesson;

import java.util.List;

public interface StudentDao {

    List<Student> getStudentList() throws Exception;

    void addStudent(Student student) throws Exception;

    Student getStudentById(Long studentId) throws Exception;

    void updateStudent(Student student) throws Exception;

    void deleteStudent(Long studentId) throws Exception;

    List<Student> searchStudentData(String keyword) throws Exception;
    
    List<Student> getStudentListByLessonIdAndTeacherId(Long lessonId, Long teacherId) throws Exception;
    
    StudentTeacherLesson getStudentTeacherLessonBySIdAndTIdAndLId(Long studentId, Long teacherId, Long lessonId) throws Exception;


}
