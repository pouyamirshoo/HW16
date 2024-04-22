package service.student;

import base.service.BaseService;
import jakarta.persistence.NoResultException;
import model.person.Student;

public interface StudentService extends BaseService<Student,Long> {
    Student findByUserAndPass(String username,String password) throws NoResultException;
    Student findByFullName(String firstName, String lastName) throws NoResultException;
}
