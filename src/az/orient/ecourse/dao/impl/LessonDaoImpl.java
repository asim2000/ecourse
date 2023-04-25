package az.orient.ecourse.dao.impl;

import az.orient.ecourse.dao.DbHelper;
import az.orient.ecourse.dao.LessonDao;
import az.orient.ecourse.model.Lesson;
import az.orient.ecourse.model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class LessonDaoImpl implements LessonDao {


    @Override
    public List<Lesson> getLessonList() throws Exception {
        List<Lesson> lessonList = new ArrayList<>();
        String sql = "select * from qrup58db.lesson\n" +
                "where active = 1";
        try (Connection c = DbHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Lesson lesson = new Lesson();
                lesson.setId(rs.getLong("id"));
                lesson.setName(rs.getString("name"));
                lesson.setTime(rs.getInt("time"));
                lesson.setPrice(rs.getDouble("price"));
                lessonList.add(lesson);
            }
        }
        return lessonList;
    }
}
