package service.lesson;

import base.service.BaseService;
import jakarta.persistence.NoResultException;
import model.Lesson;

import java.util.List;

public interface LessonService extends BaseService<Lesson,Long> {
    Lesson findByName(String name) throws NoResultException;
    List<Lesson> allLessons() throws NoResultException;

}
