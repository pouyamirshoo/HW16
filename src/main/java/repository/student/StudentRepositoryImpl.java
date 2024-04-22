package repository.student;

import base.repository.BaseRepositoryImpl;
import conncetion.SessionFactorySingleton;
import jakarta.persistence.NoResultException;
import model.person.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class StudentRepositoryImpl extends BaseRepositoryImpl<Student,Long> implements StudentRepository {
    public StudentRepositoryImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Class<Student> getEntityClass() {
        return Student.class;
    }

    @Override
    public Student findByUserAndPass(String username, String password) throws NoResultException {
        Session session = SessionFactorySingleton.getInstance().openSession();
        Query<Student> query = session.createQuery("FROM Student s WHERE s.username = :username " +
                "AND s.password = :password", Student.class);
        query.setParameter("username", username);
        query.setParameter("password",password);
        Student student = query.uniqueResult();
        session.close();
        return student;
    }

    @Override
    public Student findByFullName(String firstName, String lastName) throws NoResultException {
        Session session = SessionFactorySingleton.getInstance().openSession();
        Query<Student> query = session.createQuery("FROM Student s WHERE s.firstName = :firstName AND s.lastName = :lastName",
                Student.class);
        query.setParameter("firstName", firstName);
        query.setParameter("lastName",lastName);
        Student student = query.uniqueResult();
        session.close();
        return student;
    }
}
