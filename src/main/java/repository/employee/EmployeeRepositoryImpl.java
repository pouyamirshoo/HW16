package repository.employee;

import base.repository.BaseRepositoryImpl;
import conncetion.SessionFactorySingleton;
import jakarta.persistence.NoResultException;
import model.person.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class EmployeeRepositoryImpl extends BaseRepositoryImpl<Employee, Long> implements EmployeeRepository {
    public EmployeeRepositoryImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Class<Employee> getEntityClass() {
        return Employee.class;
    }

    @Override
    public Employee findByUserAndPass(String username, String password) throws NoResultException {
        Session session = SessionFactorySingleton.getInstance().openSession();
        Query<Employee> query = session.createQuery("FROM Employee e WHERE e.username = :username AND e.password = :password",
                Employee.class);
        query.setParameter("username", username);
        query.setParameter("password", password);
        Employee employee = query.uniqueResult();
        session.close();
        return employee;
    }

    @Override
    public Employee findByFullName(String firstName, String lastName) throws NoResultException {
        Session session = SessionFactorySingleton.getInstance().openSession();
        Query<Employee> query = session.createQuery("FROM Employee e WHERE e.firstName = :firstName AND e.lastName = :lastName",
                Employee.class);
        query.setParameter("firstName", firstName);
        query.setParameter("lastName", lastName);
        Employee employee = query.uniqueResult();
        session.close();
        return employee;
    }


}
