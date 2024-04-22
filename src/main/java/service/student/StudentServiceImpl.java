package service.student;

import base.service.BaseServiceImpl;
import jakarta.persistence.NoResultException;
import model.person.Student;
import org.hibernate.SessionFactory;
import repository.student.StudentRepository;

public class StudentServiceImpl extends BaseServiceImpl<Student,Long, StudentRepository> implements StudentService {
    public StudentServiceImpl(StudentRepository repository, SessionFactory sessionFactory) {
        super(repository, sessionFactory);
    }

    @Override
    public Student findByUserAndPass(String username, String password) throws NoResultException {
        return repository.findByUserAndPass(username,password);
    }

    @Override
    public Student findByFullName(String firstName, String lastName) throws NoResultException {
        return repository.findByFullName(firstName,lastName);
    }
}
