package service.employee;

import base.service.BaseService;
import jakarta.persistence.NoResultException;
import model.person.Employee;

public interface EmployeeService extends BaseService<Employee, Long> {
    Employee findByUserAndPass(String username, String password) throws NoResultException;

    Employee findByFullName(String firstName, String lastName) throws NoResultException;
}
