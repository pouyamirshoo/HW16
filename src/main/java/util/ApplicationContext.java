package util;

import conncetion.SessionFactorySingleton;
import org.hibernate.SessionFactory;
import repository.currentTerm.CurrentTermRepository;
import repository.currentTerm.CurrentTermRepositoryImpl;
import repository.employee.EmployeeRepository;
import repository.employee.EmployeeRepositoryImpl;
import repository.lesson.LessonRepository;
import repository.lesson.LessonRepositoryImpl;
import repository.reportCard.ReportCardRepository;
import repository.reportCard.ReportCardRepositoryImpl;
import repository.student.StudentRepository;
import repository.student.StudentRepositoryImpl;
import repository.teacher.TeacherRepository;
import repository.teacher.TeacherRepositoryImpl;
import repository.term.TermRepository;
import repository.term.TermRepositoryImpl;
import service.currentTerm.CurrentTermService;
import service.currentTerm.CurrentTermServiceImpl;
import service.employee.EmployeeService;
import service.employee.EmployeeServiceImpl;
import service.lesson.LessonService;
import service.lesson.LessonServiceImpl;
import service.reportcard.ReportCardService;
import service.reportcard.ReportCardServiceImpl;
import service.student.StudentService;
import service.student.StudentServiceImpl;
import service.teacher.TeacherService;
import service.teacher.TeacherServiceImpl;
import service.term.TermService;
import service.term.TermServiceImpl;

public class ApplicationContext {

    static final SessionFactory SESSION_FACTORY;

    private static final LessonRepository LESSON_REPOSITORY;
    private static final LessonService LESSON_SERVICE;

    private static final TeacherRepository TEACHER_REPOSITORY;
    private static final TeacherService TEACHER_SERVICE;

    private static final StudentRepository STUDENT_REPOSITORY;
    private static final StudentService STUDENT_SERVICE;

    private static final ReportCardRepository REPORT_CARD_REPOSITORY;
    private static final ReportCardService REPORT_CARD_SERVICE;

    private static final CurrentTermRepository CURRENT_TERM_REPOSITORY;
    private static final CurrentTermService CURRENT_TERM_SERVICE;

    private static final EmployeeRepository EMPLOYEE_REPOSITORY;
    private static final EmployeeService EMPLOYEE_SERVICE;

    private static final TermRepository TERM_REPOSITORY;
    private static final TermService TERM_SERVICE;

    static {
        SESSION_FACTORY = SessionFactorySingleton.getInstance();

        LESSON_REPOSITORY = new LessonRepositoryImpl(SESSION_FACTORY);
        TEACHER_REPOSITORY = new TeacherRepositoryImpl(SESSION_FACTORY);
        STUDENT_REPOSITORY = new StudentRepositoryImpl(SESSION_FACTORY);
        REPORT_CARD_REPOSITORY = new ReportCardRepositoryImpl(SESSION_FACTORY);
        CURRENT_TERM_REPOSITORY = new CurrentTermRepositoryImpl(SESSION_FACTORY);
        EMPLOYEE_REPOSITORY = new EmployeeRepositoryImpl(SESSION_FACTORY);
        TERM_REPOSITORY = new TermRepositoryImpl(SESSION_FACTORY);

        LESSON_SERVICE = new LessonServiceImpl(LESSON_REPOSITORY, SESSION_FACTORY);
        TEACHER_SERVICE = new TeacherServiceImpl(TEACHER_REPOSITORY,SESSION_FACTORY);
        STUDENT_SERVICE = new StudentServiceImpl(STUDENT_REPOSITORY,SESSION_FACTORY);
        REPORT_CARD_SERVICE = new ReportCardServiceImpl(REPORT_CARD_REPOSITORY,SESSION_FACTORY);
        CURRENT_TERM_SERVICE = new CurrentTermServiceImpl(CURRENT_TERM_REPOSITORY,SESSION_FACTORY);
        EMPLOYEE_SERVICE = new EmployeeServiceImpl(EMPLOYEE_REPOSITORY,SESSION_FACTORY);
        TERM_SERVICE = new TermServiceImpl(TERM_REPOSITORY,SESSION_FACTORY);
    }

    public static LessonService getLessonService() {
        return LESSON_SERVICE;
    }public static TeacherService getTeacherService() {
        return TEACHER_SERVICE;
    }
    public static StudentService getStudentService() {
        return STUDENT_SERVICE;
    }
    public static ReportCardService getReportCardService(){
        return REPORT_CARD_SERVICE;
    }
    public static CurrentTermService getCurrentTermService(){
        return CURRENT_TERM_SERVICE;
    }
    public static EmployeeService getEmployeeService(){return EMPLOYEE_SERVICE;}
    public static TermService getTermService(){return TERM_SERVICE;}
}
