package service.teacher;

import base.service.BaseService;
import jakarta.persistence.NoResultException;
import model.Term;
import model.person.Teacher;

public interface TeacherService extends BaseService<Teacher,Long> {
    Teacher findByUserAndPass(String username,String password) throws NoResultException;
    Teacher findByFullName(String firstName, String lastName) throws NoResultException;
    Term findByYearAndHalfYear(int year, int halfYear) throws NoResultException;
}
