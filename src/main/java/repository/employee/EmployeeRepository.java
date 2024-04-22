package repository.employee;

import base.repository.BaseRepository;
import jakarta.persistence.NoResultException;
import model.person.Employee;

public interface EmployeeRepository extends BaseRepository<Employee, Long> {

    Employee findByUserAndPass(String username, String password) throws NoResultException;

    Employee findByFullName(String firstName, String lastName) throws NoResultException;

}
