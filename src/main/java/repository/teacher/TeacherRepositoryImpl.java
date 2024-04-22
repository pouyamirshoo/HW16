package repository.teacher;

import base.repository.BaseRepositoryImpl;
import conncetion.SessionFactorySingleton;
import jakarta.persistence.NoResultException;
import model.Term;
import model.person.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.hibernate.query.QueryParameter;

import java.util.List;

public class TeacherRepositoryImpl extends BaseRepositoryImpl<Teacher,Long> implements TeacherRepository{
    public TeacherRepositoryImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Class<Teacher> getEntityClass() {
        return Teacher.class;
    }

    @Override
    public Teacher findByUserAndPass(String username, String password) throws NoResultException {
        Session session = SessionFactorySingleton.getInstance().openSession();
        Query<Teacher> query = session.createQuery("FROM Teacher t WHERE t.username = :username AND t.password = :password", Teacher.class);
        query.setParameter("username", username);
        query.setParameter("password",password);
        Teacher teacher = query.uniqueResult();
        session.close();
        return teacher;
    }

    @Override
    public Teacher findByFullName(String firstName, String lastName) throws NoResultException {
        Session session = SessionFactorySingleton.getInstance().openSession();
        Query<Teacher> query = session.createQuery("FROM Teacher t WHERE t.firstName = :firstName AND t.lastName = :lastName",
                Teacher.class);
        query.setParameter("firstName", firstName);
        query.setParameter("lastName",lastName);
        Teacher teacher = query.uniqueResult();
        session.close();
        return teacher;
    }

    @Override
    public Term findByYearAndHalfYear(int yearOfTerm, int halfTerm) throws NoResultException {
        Session session = SessionFactorySingleton.getInstance().openSession();
        Query<Term> query = session.createQuery("FROM Term t WHERE t.yearOfTerm = :yearOfTerm AND t.halfTerm = :halfTerm",
              Term.class);
        query.setParameter("yearOfTerm", yearOfTerm);
        query.setParameter("halfTerm",halfTerm);
        Term term = query.uniqueResult();
        session.close();
        return term;
    }
}
