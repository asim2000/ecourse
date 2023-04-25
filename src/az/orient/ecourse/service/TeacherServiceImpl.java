package az.orient.ecourse.service;

import az.orient.ecourse.dao.TeacherDao;
import az.orient.ecourse.dao.impl.TeacherDaoImpl;
import az.orient.ecourse.model.Teacher;
import az.orient.ecourse.model.TeacherLesson;

import java.util.List;

public class TeacherServiceImpl implements TeacherService {
    private TeacherDao teacherDao;

    public TeacherServiceImpl(TeacherDao teacherDao){
        this.teacherDao = teacherDao;
    }
    @Override
    public List<Teacher> getTeacherList() throws Exception {
        return teacherDao.getTeacherList();
    }

    @Override
    public List<TeacherLesson> getTeacherLesson() throws Exception {
        return teacherDao.getTeacherLesson();
    }
}
