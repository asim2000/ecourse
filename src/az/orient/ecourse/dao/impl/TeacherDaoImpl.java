package az.orient.ecourse.dao.impl;

import az.orient.ecourse.dao.DbHelper;
import az.orient.ecourse.dao.TeacherDao;
import az.orient.ecourse.model.Lesson;
import az.orient.ecourse.model.Teacher;
import az.orient.ecourse.model.TeacherLesson;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TeacherDaoImpl implements TeacherDao {
    @Override
    public List<Teacher> getTeacherList() throws Exception {
        List<Teacher> teachers = new ArrayList<>();
        String sql = "select * from teacher where active=1";
        try(Connection connection = DbHelper.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery()) {
            while(resultSet.next()){
                Teacher teacher = new Teacher();
                teacher.setId(resultSet.getLong("id"));
                teacher.setName(resultSet.getString("name"));
                teacher.setSurname(resultSet.getString("surname"));
                teacher.setDob(resultSet.getDate("dob"));
                teacher.setAddress(resultSet.getString("address"));
                teacher.setPhone(resultSet.getString("phone"));
                teacher.setPin(resultSet.getString("pin"));
                teacher.setWorkExperience(resultSet.getInt("work_experience"));
                teachers.add(teacher);
            }
        }
        return teachers;
    }

    @Override
    public List<TeacherLesson> getTeacherLesson() throws Exception {
        List<TeacherLesson> teacherLessonList = new ArrayList<>();
        String sql = "select tl.id,t.id teacher_id,t.name teacher_name,t.surname teacher_surname,\n" +
                "l.id lesson_id,l.name lesson_name,(case when tl.price is null then l.price else tl.price end) price from teacher_lesson tl\n" +
                "inner join teacher t on tl.teacher_id = t.id\n" +
                "inner join lesson l on tl.lesson_id = l.id\n" +
                "where tl.active = 1";
        try(Connection c = DbHelper.getConnection();PreparedStatement ps = c.prepareStatement(sql);ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                TeacherLesson teacherLesson = new TeacherLesson();
                teacherLesson.setId(rs.getLong("id"));
                Teacher teacher = new Teacher();
                teacher.setId(rs.getLong("teacher_id"));
                teacher.setName(rs.getString("teacher_name"));
                teacher.setSurname(rs.getString("teacher_surname"));
                Lesson lesson = new Lesson();
                lesson.setId(rs.getLong("lesson_id"));
                lesson.setName(rs.getString("lesson_name"));
                teacherLesson.setTeacher(teacher);
                teacherLesson.setLesson(lesson);
                teacherLesson.setPrice(rs.getDouble("price"));
                teacherLessonList.add(teacherLesson);
            }
        }
        return teacherLessonList;
    }

    @Override
    public List<Teacher> getTeacherListByLessonId(Long lessonId) throws Exception {
        List<Teacher> teacherList = new ArrayList<>();
        String sql = "select t.id,t.name,t.surname from teacher_lesson tl\n" +
                "inner join teacher t on tl.teacher_id = t.id\n" +
                "inner join lesson l on tl.lesson_id = l.id\n" +
                "where tl.active = 1 and l.id = ?";
        try(Connection connection = DbHelper.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setLong(1,lessonId);
            ResultSet resultSet = ps.executeQuery();
            while(resultSet.next()){
                Teacher teacher = new Teacher();
                teacher.setId(resultSet.getLong("id"));
                teacher.setName(resultSet.getString("name"));
                teacher.setSurname(resultSet.getString("surname"));
                teacherList.add(teacher);
            }
        }
        return teacherList;
    }
}
