package conncetion;

import model.Current;
import model.Lesson;
import model.ReportCard;
import model.Term;
import model.person.Employee;
import model.person.Student;
import model.person.Teacher;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class SessionFactorySingleton {
    private static class LazyHolder {
        static SessionFactory INSTANCE;

        static {
            var registry = new StandardServiceRegistryBuilder()
                    .configure()
                    .build();

            INSTANCE = new MetadataSources(registry)
                    .addAnnotatedClass(Employee.class)
                    .addAnnotatedClass(Teacher.class)
                    .addAnnotatedClass(Lesson.class)
                    .addAnnotatedClass(Term.class)
                    .addAnnotatedClass(Student.class)
                    .addAnnotatedClass(ReportCard.class)
                    .addAnnotatedClass(Current.class)
                    .addAnnotatedClass(Employee.class)
                    .buildMetadata()
                    .buildSessionFactory();
        }
    }

    public static SessionFactory getInstance() {
        return LazyHolder.INSTANCE;
    }
}
