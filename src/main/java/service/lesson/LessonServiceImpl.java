package service.lesson;

import base.service.BaseServiceImpl;
import jakarta.persistence.NoResultException;
import model.Lesson;
import org.hibernate.SessionFactory;
import repository.lesson.LessonRepository;

import java.util.List;

public class LessonServiceImpl extends BaseServiceImpl<Lesson, Long, LessonRepository> implements LessonService {

    public LessonServiceImpl(LessonRepository repository, SessionFactory sessionFactory) {
        super(repository, sessionFactory);
    }

    @Override
    public Lesson findByName(String name) throws NoResultException {
        return repository.findByName(name);
    }

    @Override
    public List<Lesson> allLessons() throws NoResultException {
        return repository.allLessons();
    }


}
