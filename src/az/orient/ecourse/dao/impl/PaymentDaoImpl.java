package az.orient.ecourse.dao.impl;

import az.orient.ecourse.dao.DbHelper;
import az.orient.ecourse.dao.PaymentDao;
import az.orient.ecourse.model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PaymentDaoImpl implements PaymentDao {
    @Override
    public List<Payment> getPaymentList() throws Exception {
        List<Payment> paymentList = new ArrayList<>();
        String sql = "SELECT * FROM PAYMENT_VIEW";
        try(Connection c = DbHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Payment payment = new Payment();
                payment.setId(rs.getLong("id"));
                StudentTeacherLesson studentTeacherLesson = new StudentTeacherLesson();
                Student student = new Student();
                student.setId(rs.getLong("student_id"));
                student.setName(rs.getString("student_name"));
                student.setSurname(rs.getString("student_surname"));
                studentTeacherLesson.setStudent(student);
                TeacherLesson teacherLesson = new TeacherLesson();
                Teacher teacher = new Teacher();
                teacher.setId(rs.getLong("teacher_id"));
                teacher.setName(rs.getString("teacher_name"));
                teacher.setSurname(rs.getString("teacher_surname"));
                teacherLesson.setTeacher(teacher);
                Lesson lesson = new Lesson();
                lesson.setId(rs.getLong("lesson_id"));
                lesson.setName(rs.getString("lesson_name"));
                teacherLesson.setLesson(lesson);
                studentTeacherLesson.setTeacherLesson(teacherLesson);
                payment.setStudentTeacherLesson(studentTeacherLesson);
                payment.setAmount(rs.getDouble("amount"));
                payment.setDataDate(rs.getDate("pay_date"));
                paymentList.add(payment);
            }
        }
        return paymentList;
    }

    @Override
    public void addPayment(Payment payment) throws Exception {
        String sql = "insert into payment(student_teacher_lesson_id,amount) values(?,?)";
        try (Connection connection = DbHelper.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setLong(1,payment.getStudentTeacherLesson().getId());
            preparedStatement.setDouble(2,payment.getAmount());
            preparedStatement.execute();
        }
    }
}
