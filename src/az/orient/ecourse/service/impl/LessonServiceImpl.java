package az.orient.ecourse.service.impl;

import az.orient.ecourse.dao.LessonDao;
import az.orient.ecourse.model.Lesson;
import az.orient.ecourse.service.LessonService;

import java.util.List;

public class LessonServiceImpl implements LessonService {

    private LessonDao lessonDao;

    public LessonServiceImpl(LessonDao lessonDao) {
        this.lessonDao = lessonDao;
    }
  

    @Override
    public List<Lesson> getLessonList() throws Exception {
        return lessonDao.getLessonList();
    }
}
