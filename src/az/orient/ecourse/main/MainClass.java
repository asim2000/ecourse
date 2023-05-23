package az.orient.ecourse.main;

import az.orient.ecourse.dao.LessonDao;
import az.orient.ecourse.dao.PaymentDao;
import az.orient.ecourse.dao.StudentDao;
import az.orient.ecourse.dao.TeacherDao;
import az.orient.ecourse.dao.impl.LessonDaoImpl;
import az.orient.ecourse.dao.impl.PaymentDaoImpl;
import az.orient.ecourse.dao.impl.StudentDaoImpl;
import az.orient.ecourse.dao.impl.TeacherDaoImpl;
import az.orient.ecourse.gui.LoginFrame;
import az.orient.ecourse.gui.MainFrame;
import az.orient.ecourse.service.LessonService;
import az.orient.ecourse.service.PaymentService;
import az.orient.ecourse.service.impl.LessonServiceImpl;
import az.orient.ecourse.service.StudentService;
import az.orient.ecourse.service.impl.StudentServiceImpl;
import az.orient.ecourse.service.TeacherService;
import az.orient.ecourse.service.impl.PaymentServiceImpl;
import az.orient.ecourse.service.impl.TeacherServiceImpl;

public class MainClass {

    public static void main(String[] args) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }      
            StudentDao studentDao = new StudentDaoImpl();
            StudentService studentService = new StudentServiceImpl(studentDao);
            TeacherDao teacherDao = new TeacherDaoImpl();
            TeacherService teacherService = new TeacherServiceImpl(teacherDao);
            LessonDao lessonDao = new LessonDaoImpl();
            LessonService lessonService = new LessonServiceImpl(lessonDao);
            PaymentDao paymentDao = new PaymentDaoImpl();
            PaymentService paymentService = new PaymentServiceImpl(paymentDao);
            LoginFrame mainFrame = new LoginFrame(studentService,teacherService,lessonService,paymentService);
            mainFrame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
