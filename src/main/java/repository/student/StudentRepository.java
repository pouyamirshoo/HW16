package repository.student;

import base.repository.BaseRepository;
import jakarta.persistence.NoResultException;
import model.person.Student;

public interface StudentRepository extends BaseRepository<Student,Long> {
    Student findByUserAndPass(String username,String password) throws NoResultException;
    Student findByFullName(String firstName, String lastName) throws NoResultException;

}
