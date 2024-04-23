package service.teacher;

import base.service.BaseServiceImpl;
import jakarta.persistence.NoResultException;
import model.Term;
import model.person.Teacher;
import org.hibernate.SessionFactory;
import repository.teacher.TeacherRepository;


public class TeacherServiceImpl extends BaseServiceImpl<Teacher, Long, TeacherRepository> implements TeacherService {


    public TeacherServiceImpl(TeacherRepository repository, SessionFactory sessionFactory) {
        super(repository, sessionFactory);
    }

    @Override
    public Teacher findByUserAndPass(String username, String password) throws NoResultException {
        return repository.findByUserAndPass(username, password);
    }

    @Override
    public Teacher findByFullName(String firstName, String lastName) throws NoResultException {
        return repository.findByFullName(firstName, lastName);
    }

    @Override
    public Term findByYearAndHalfYear(int year, int halfYear) throws NoResultException {
        return repository.findByYearAndHalfYear(year, halfYear);
    }
}
