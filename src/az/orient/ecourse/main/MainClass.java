package az.orient.ecourse.main;


import az.orient.ecourse.dao.StudentDao;
import az.orient.ecourse.dao.TeacherDao;
import az.orient.ecourse.dao.impl.StudentDaoImpl;
import az.orient.ecourse.dao.impl.TeacherDaoImpl;
import az.orient.ecourse.model.Student;
import az.orient.ecourse.model.TeacherLesson;
import az.orient.ecourse.service.StudentService;
import az.orient.ecourse.service.StudentServiceImpl;
import az.orient.ecourse.service.TeacherService;
import az.orient.ecourse.service.TeacherServiceImpl;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class MainClass {

    public static void main(String[] args) {
        try {
            StudentDao studentDao = new StudentDaoImpl();
            StudentService studentService = new StudentServiceImpl(studentDao);
            TeacherDao teacherDao = new TeacherDaoImpl();
            TeacherService teacherService = new TeacherServiceImpl(teacherDao);
            Scanner scanner = new Scanner(System.in);
            System.out.println("ENTER OPTION");
            System.out.println("1.Get all\n" +
                    "2.Add 3. Get Teachers Lessons");
            int option = scanner.nextInt();
            scanner.nextLine();
            switch (option){
                case 1:
                    List<Student> studentList = studentService.getStudentList();
                    studentList.forEach(System.out::println);
                    break;
                case 2:
                    System.out.println("Enter student name");
                    String name = scanner.nextLine();

                    System.out.println("Enter student surname");
                    String surname = scanner.nextLine();

                    System.out.println("Enter date of birth");
                    String dateOfBirth = scanner.nextLine();

                    System.out.println("Enter address");
                    String address = scanner.nextLine();

                    System.out.println("Enter phone");
                    String phone = scanner.nextLine();

                    System.out.println("Enter pin");
                    String pin = scanner.nextLine();

                    Student student = new Student();
                    student.setName(name);
                    student.setSurname(surname);
                    student.setDob(Date.valueOf(dateOfBirth));
                    student.setAddress(address);
                    student.setPin(pin);
                    student.setPhone(phone);
                    studentService.addStudent(student);
                    System.out.println("Student added");
                    break;
                case 3:
                    List<TeacherLesson> teacherLessonList = teacherService.getTeacherLesson();
                    teacherLessonList.forEach(System.out::println);
                    break;
                default:
                    System.out.println("Invalid method!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
