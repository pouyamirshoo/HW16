package service.employee;

import base.service.BaseServiceImpl;
import jakarta.persistence.NoResultException;
import model.person.Employee;
import org.hibernate.SessionFactory;
import repository.employee.EmployeeRepository;

public class EmployeeServiceImpl extends BaseServiceImpl<Employee, Long, EmployeeRepository> implements EmployeeService {
    public EmployeeServiceImpl(EmployeeRepository repository, SessionFactory sessionFactory) {
        super(repository, sessionFactory);
    }


    @Override
    public Employee findByUserAndPass(String username, String password) throws NoResultException {
        return repository.findByUserAndPass(username, password);
    }

    @Override
    public Employee findByFullName(String firstName, String lastName) throws NoResultException {
        return repository.findByFullName(firstName, lastName);
    }

}
