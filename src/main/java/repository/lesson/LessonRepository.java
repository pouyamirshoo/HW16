package repository.lesson;

import base.repository.BaseRepository;
import jakarta.persistence.NoResultException;
import model.Lesson;

import java.util.List;

public interface LessonRepository extends BaseRepository<Lesson,Long> {

     Lesson findByName(String name) throws NoResultException;
     List<Lesson> allLessons() throws NoResultException;
}
