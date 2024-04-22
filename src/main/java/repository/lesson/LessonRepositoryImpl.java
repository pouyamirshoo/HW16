package repository.lesson;

import base.repository.BaseRepositoryImpl;
import conncetion.SessionFactorySingleton;

import jakarta.persistence.NoResultException;
import model.Lesson;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class LessonRepositoryImpl extends BaseRepositoryImpl<Lesson,Long> implements LessonRepository {
    public LessonRepositoryImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Class<Lesson> getEntityClass() {
        return Lesson.class;
    }

    @Override
    public Lesson findByName(String name) throws NoResultException {
        Session session = SessionFactorySingleton.getInstance().openSession();
        Query<Lesson> query = session.createQuery("FROM Lesson l WHERE l.name =:name", Lesson.class);
        query.setParameter("name", name);
        Lesson lesson = query.getSingleResult();
        session.close();
        return lesson;
    }

    @Override
    public List<Lesson> allLessons  () throws NoResultException {
        String hql = "FROM Lesson ";
        Session session = SessionFactorySingleton.getInstance().openSession();
        Query<Lesson> query = session.createQuery(hql);
        List<Lesson> lessons = query.list();
        session.close();
        return lessons;
    }
}
