/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az.orient.ecourse.gui;

import az.orient.ecourse.model.Lesson;
import az.orient.ecourse.model.Payment;
import az.orient.ecourse.model.Student;
import az.orient.ecourse.model.StudentTeacherLesson;
import az.orient.ecourse.model.Teacher;
import az.orient.ecourse.service.LessonService;
import az.orient.ecourse.service.PaymentService;
import az.orient.ecourse.service.StudentService;
import az.orient.ecourse.service.TeacherService;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Asim Babayev
 */
public class EditPaymentFrame extends javax.swing.JFrame {

    private StudentService studentService;
    private TeacherService teacherService;
    private LessonService lessonService;
    private PaymentService paymentService;
    private Long selectedRow;

    public EditPaymentFrame() {
        initComponents();
    }

    public EditPaymentFrame(Long selectedRow, StudentService studentService, TeacherService teacherService, LessonService lessonService, PaymentService paymentService) {
        initComponents();
        this.studentService = studentService;
        this.teacherService = teacherService;
        this.lessonService = lessonService;
        this.paymentService = paymentService;
        this.selectedRow = selectedRow;
        set(selectedRow);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        amountTxt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        updateBtn = new javax.swing.JButton();
        clearBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lessonCmb = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        teacherCmb = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        studentCmb = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel4.setText("Amount");

        jLabel5.setText("AZN");

        updateBtn.setText("Update");
        updateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtnActionPerformed(evt);
            }
        });

        clearBtn.setText("Clear");

        jLabel1.setText("Lesson");

        lessonCmb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select Lesson" }));
        lessonCmb.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                lessonCmbItemStateChanged(evt);
            }
        });

        jLabel2.setText("Teacher");

        teacherCmb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select Teacher" }));
        teacherCmb.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                teacherCmbItemStateChanged(evt);
            }
        });

        jLabel3.setText("Student");

        studentCmb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select Student" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4))
                        .addGap(58, 58, 58)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(amountTxt)
                            .addComponent(lessonCmb, 0, 176, Short.MAX_VALUE)
                            .addComponent(teacherCmb, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(studentCmb, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(updateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                        .addComponent(clearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addContainerGap(43, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lessonCmb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(teacherCmb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(studentCmb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(amountTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5))
                    .addComponent(jLabel4))
                .addGap(63, 63, 63)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(updateBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                    .addComponent(clearBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
        try {
            Student student = (Student) studentCmb.getSelectedItem();
            Teacher teacher = (Teacher) teacherCmb.getSelectedItem();
            Lesson lesson = (Lesson) lessonCmb.getSelectedItem();
            Payment payment = new Payment();
            StudentTeacherLesson studentTeacherLesson = studentService.getStudentTeacherLessonBySIdAndTIdAndLId(student.getId(), teacher.getId(), lesson.getId());
            payment.setStudentTeacherLesson(studentTeacherLesson);
            if (!amountTxt.getText().isEmpty() && amountTxt.getText() != null) {
                payment.setAmount(Double.valueOf(amountTxt.getText()));
            }
            paymentService.addPayment(payment);
            JOptionPane.showMessageDialog(null, "Payment has been successfully added!");
            this.dispose();
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Problem! Payment has not been successfully added!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_updateBtnActionPerformed

    private void lessonCmbItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_lessonCmbItemStateChanged
        try {
            Lesson lesson = (Lesson) lessonCmb.getSelectedItem();
            List<Teacher> teacherList = teacherService.getTeacherListByLessonId(lesson.getId());
           // Payment p = paymentService.getPaymentById(selectedRow);
            showTeacherCombo(teacherList);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_lessonCmbItemStateChanged

    private void teacherCmbItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_teacherCmbItemStateChanged
        try {
            Lesson lesson = (Lesson) lessonCmb.getSelectedItem();
            Teacher teacher = (Teacher) teacherCmb.getSelectedItem();
            List<Student> studentList = studentService.getStudentListByLessonIdAndTeacherId(lesson.getId(), teacher.getId());
           // Payment p = paymentService.getPaymentById(selectedRow);
            showStudentCombo(studentList);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_teacherCmbItemStateChanged
    private void showLessonCombo(Payment p) {
        try {
            DefaultComboBoxModel lessonCombo = (DefaultComboBoxModel) lessonCmb.getModel();
            List<Lesson> lessonList = lessonService.getLessonList();
            for (Lesson lesson : lessonList) {
                lessonCombo.addElement(lesson);
            }
            lessonCombo.setSelectedItem(p.getStudentTeacherLesson().getTeacherLesson().getLesson());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void showTeacherCombo(List<Teacher> teacherList) {
        DefaultComboBoxModel teacherCombo = new DefaultComboBoxModel();
        teacherCmb.setModel(teacherCombo);
        teacherCombo.addElement(new Teacher((long) 0, "Select", "Teacher"));
        for (Teacher teacher : teacherList) {
            teacherCombo.addElement(teacher);
        }
    }

    private void showStudentCombo(List<Student> studentList) {
        DefaultComboBoxModel studentCombo = new DefaultComboBoxModel();
        studentCmb.setModel(studentCombo);
        for (Student student : studentList) {
            studentCombo.addElement(student);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField amountTxt;
    private javax.swing.JButton clearBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JComboBox lessonCmb;
    private javax.swing.JComboBox studentCmb;
    private javax.swing.JComboBox teacherCmb;
    private javax.swing.JButton updateBtn;
    // End of variables declaration//GEN-END:variables

    private void set(Long selectedRow) {
        try {
            Payment p = paymentService.getPaymentById(selectedRow);
            amountTxt.setText(String.valueOf(p.getAmount()));
            //  System.out.println(p.getStudentTeacherLesson().getTeacherLesson().getLesson());
            showLessonCombo(p);
            showTeacherCombo(p);
            showStudentCombo(p);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void showTeacherCombo(Payment p) {
        try {
            DefaultComboBoxModel teacherCombo = new DefaultComboBoxModel();
            teacherCmb.setModel(teacherCombo);
            teacherCombo.addElement(new Teacher((long) 0, "Select", "Teacher"));
            List<Teacher> teacherList = teacherService.getTeacherList();
            for (Teacher teacher : teacherList) {
                teacherCombo.addElement(teacher);
            }
            teacherCombo.setSelectedItem(p.getStudentTeacherLesson().getTeacherLesson().getTeacher());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void showStudentCombo(Payment p) {
        try {
            DefaultComboBoxModel studentCombo = new DefaultComboBoxModel();
            studentCmb.setModel(studentCombo);
            List<Student> studentList = studentService.getStudentList();
            for (Student student : studentList) {
                studentCombo.addElement(student);
            }
            studentCombo.setSelectedItem(p.getStudentTeacherLesson().getStudent());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
