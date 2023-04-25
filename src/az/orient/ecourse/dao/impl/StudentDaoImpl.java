package az.orient.ecourse.dao.impl;

import az.orient.ecourse.dao.DbHelper;
import az.orient.ecourse.dao.StudentDao;
import az.orient.ecourse.model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {

    @Override
    public List<Student> getStudentList() throws Exception {
        List<Student> studentList = new ArrayList<>();
        String sql = "select * from qrup58db.student\n" +
                "where active = 1";
        try (Connection c = DbHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getLong("id"));
                student.setName(rs.getString("name"));
                student.setSurname(rs.getString("surname"));
                student.setDob(rs.getDate("dob"));
                student.setAddress(rs.getString("address"));
                student.setPhone(rs.getString("phone"));
                student.setPin(rs.getString("pin"));
                studentList.add(student);
            }
        }
        return studentList;
    }

    @Override
    public void addStudent(Student student) throws Exception {
        String sql = "insert into student(name,surname,dob,address,phone,pin)" +
                " values(?,?,?,?,?,?) ";
        try(Connection c = DbHelper.getConnection();PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1,student.getName());
            ps.setString(2,student.getSurname());
            ps.setDate(3,new java.sql.Date(student.getDob().getTime()));
            ps.setString(4,student.getAddress());
            ps.setString(5,student.getPhone());
            ps.setString(6,student.getPin());
            ps.execute();
        }
    }

    @Override
    public Student getStudentById(Long studentId) throws Exception {
        Student student = new Student();
        String sql = "select * from qrup58db.student\n" +
                "where active = 1 and id = ?";
        try (Connection c = DbHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setLong(1,studentId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                student.setId(rs.getLong("id"));
                student.setName(rs.getString("name"));
                student.setSurname(rs.getString("surname"));
                student.setDob(rs.getDate("dob"));
                student.setAddress(rs.getString("address"));
                student.setPhone(rs.getString("phone"));
                student.setPin(rs.getString("pin"));
            } else {
                student = null;
            }
        }
        return student;
    }

    @Override
    public void updateStudent(Student student) throws Exception {
        String sql = "update student set name = ?,surname = ?,dob = ?,address = ?,phone = ?,pin = ?" +
                " where id = ?";
        try(Connection c = DbHelper.getConnection();PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1,student.getName());
            ps.setString(2,student.getSurname());
            ps.setDate(3,new java.sql.Date(student.getDob().getTime()));
            ps.setString(4,student.getAddress());
            ps.setString(5,student.getPhone());
            ps.setString(6,student.getPin());
            ps.setLong(7,student.getId());
            ps.execute();
        }
    }

    @Override
    public void deleteStudent(Long studentId) throws Exception {
        String sql = "update student set active = 0 " +
                " where id = ?";
        try(Connection c = DbHelper.getConnection();PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setLong(1,studentId);
            ps.execute();
        }
    }

    @Override
    public List<Student> searchStudentData(String keyword) throws Exception {
        List<Student> studentList = new ArrayList<>();
        String sql = "select * from qrup58db.student\n" +
                "where active = 1 AND (LOWER(NAME) LIKE LOWER(?) OR LOWER(SURNAME) LIKE LOWER(?) OR LOWER(ADDRESS) LIKE LOWER(?))";
        try (Connection c = DbHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1,"%"+keyword+"%");
            ps.setString(2,"%"+keyword+"%");
            ps.setString(3,"%"+keyword+"%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getLong("id"));
                student.setName(rs.getString("name"));
                student.setSurname(rs.getString("surname"));
                student.setDob(rs.getDate("dob"));
                student.setAddress(rs.getString("address"));
                student.setPhone(rs.getString("phone"));
                student.setPin(rs.getString("pin"));
                studentList.add(student);
            }
        }
        return studentList;
    }
}