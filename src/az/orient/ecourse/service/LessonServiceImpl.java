package az.orient.ecourse.service;

import az.orient.ecourse.dao.LessonDao;
import az.orient.ecourse.model.Lesson;

import java.util.List;

public class LessonServiceImpl implements LessonService{

    private LessonDao lessonDao;

    @Override
    public List<Lesson> getLessonList() throws Exception {
        return lessonDao.getLessonList();
    }
}
