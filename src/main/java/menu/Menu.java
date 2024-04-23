package menu;

import enums.Fields;
import enums.HireCondition;
import jakarta.persistence.NoResultException;
import model.Current;
import model.Lesson;
import model.ReportCard;
import model.Term;
import model.person.Employee;
import model.person.Student;
import model.person.Teacher;
import service.currentTerm.CurrentTermService;
import service.employee.EmployeeService;
import service.lesson.LessonService;
import service.reportcard.ReportCardService;
import service.student.StudentService;
import service.teacher.TeacherService;
import service.term.TermService;
import util.ApplicationContext;

import java.util.*;

public class Menu {

    private final Scanner sc = new Scanner(System.in);

    LessonService lessonService = ApplicationContext.getLessonService();
    EmployeeService employeeService = ApplicationContext.getEmployeeService();
    StudentService studentService = ApplicationContext.getStudentService();
    TeacherService teacherService = ApplicationContext.getTeacherService();
    TermService termService = ApplicationContext.getTermService();
    ReportCardService reportCardService = ApplicationContext.getReportCardService();
    CurrentTermService currentTermService = ApplicationContext.getCurrentTermService();

    public int getNumberFromUser() {
        int num = 0;
        try {
            num = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println(e.getMessage());
        } finally {
            sc.nextLine();
        }
        return num;
    }

    public String getStringFromUser() {
        String input = null;
        try {
            input = sc.nextLine();
        } catch (InputMismatchException e) {
            System.out.println(e.getMessage());
        }
        return input;
    }

    public String getUsername() {
        System.out.println("please enter username");
        return getStringFromUser();
    }

    public String getPassword() {
        System.out.println("please enter your password");
        System.out.println("Hint: password has to be between 8 to 10 and must contain at least 1 lower and upper case and 1 digit and 1 char");
        return getStringFromUser();
    }

    public String getFirstName() {
        System.out.println("please enter your first name");
        return getStringFromUser();
    }

    public String getLastName() {
        System.out.println("please enter your last name");
        return getStringFromUser();
    }

    public String getNationalCode() {
        System.out.println("please enter your National Code");
        return getStringFromUser();
    }

    public String getPhoneNumber() {
        System.out.println("please enter your Phone Number");
        return getStringFromUser();
    }

    public String getBirthDate() {
        System.out.println("please enter your Birth Date");
        return getStringFromUser();
    }

    public String getEmail() {
        System.out.println("please enter your email");
        return getStringFromUser();
    }

    public void startMenu() {
        System.out.println("*****************welcome to maktab university*****************");
        System.out.println("press 1 for employee menu");
        System.out.println("press 2 for student menu");
        System.out.println("press 3 for teacher menu");
        int choose = getNumberFromUser();

        switch (choose) {
            case 1 -> checkLogIn();
            case 2 -> checkLogInS();
            case 3 -> checkLogInT();
            default -> startMenu();
        }
    }

    public Employee logInEmployee() {
        String username = getUsername();
        String password = getPassword();
        return employeeService.findByUserAndPass(username, password);
    }

    public Student logInStudent() {
        String username = getUsername();
        String password = getPassword();
        return studentService.findByUserAndPass(username, password);
    }

    public Teacher logInTeacher() {
        String username = getUsername();
        String password = getPassword();
        return teacherService.findByUserAndPass(username, password);
    }

    public void checkLogIn() {
        Employee employee = logInEmployee();
        if (employee != null) {
            employeeMenu(employee);
        } else {
            System.out.println("wrong username or password");
            startMenu();
        }
    }

    public void checkLogInS() {
        Student student = logInStudent();
        if (student != null) {
            studentMenu(student);
        } else {
            System.out.println("wrong username or password");
            startMenu();
        }
    }

    public void checkLogInT() {
        Teacher teacher = logInTeacher();
        if (teacher != null) {
            teacherMenu(teacher);
        } else {
            System.out.println("wrong username or password");
            startMenu();
        }
    }

    public void employeeMenu(Employee employee) {
        System.out.println("welcome dear " + employee.getFirstName() + " " + employee.getLastName());
        System.out.println("press 1 for student process");
        System.out.println("press 2 for teacher process");
        System.out.println("press 3 for employee process");
        System.out.println("press 4 for lesson process");
        System.out.println("press 5 for see the salary bill");
        System.out.println("press 6 exit");

        int choose = getNumberFromUser();

        switch (choose) {
            case 1 -> employeeStudentProcess();
            case 2 -> employeeTeacherProcess();
            case 3 -> employeeProcess();
            case 4 -> employeeLessonProcess();
            case 5 -> showEmployeeSalary(employee);
            case 6 -> startMenu();
            default -> employeeMenu(employee);
        }
    }

    public void employeeStudentProcess() {
        System.out.println("press 1 for add a student");
        System.out.println("press 2 for update a student");
        System.out.println("press 3 for delete a student");
        System.out.println("press 4 exit");

        int choose = getNumberFromUser();
        switch (choose) {

            case 1 -> addStudent();
            case 2 -> updateStudent();
            case 3 -> deleteStudent();
            case 4 -> startMenu();
            default -> employeeStudentProcess();

        }
    }

    public void employeeTeacherProcess() {
        System.out.println("press 1 for add a teacher");
        System.out.println("press 2 for update a teacher");
        System.out.println("press 3 for delete a teacher");
        System.out.println("press 4 exit");

        int choose = getNumberFromUser();
        switch (choose) {

            case 1 -> addTeacher();
            case 2 -> updateTeacher();
            case 3 -> deleteTeacher();
            case 4 -> startMenu();
            default -> employeeTeacherProcess();

        }
    }

    public void employeeProcess() {
        System.out.println("press 1 for add a employee");
        System.out.println("press 2 for update a employee");
        System.out.println("press 3 for delete a employee");
        System.out.println("press 4 exit");

        int choose = getNumberFromUser();
        switch (choose) {

            case 1 -> addEmployee();
            case 2 -> updateEmployee();
            case 3 -> deleteEmployee();
            case 4 -> startMenu();
            default -> employeeProcess();

        }
    }

    public void employeeLessonProcess() {
        System.out.println("press 1 for add a lesson");
        System.out.println("press 2 for update a lesson");
        System.out.println("press 3 for delete a lesson");
        System.out.println("press 4 exit");

        int choose = getNumberFromUser();
        switch (choose) {

            case 1 -> addLesson();
            case 2 -> updateLesson();
            case 3 -> deleteLesson();
            case 4 -> startMenu();
            default -> employeeLessonProcess();

        }
    }

    public void teacherMenu(Teacher teacher) {
        System.out.println("welcome dear " + teacher.getFirstName() + " " + teacher.getLastName());
        System.out.println("press 1 for show teacher info");
        System.out.println("press 2 for enter grades");
        System.out.println("press 3 for see salary bill");
        System.out.println("press 4 exit");

        int choose = getNumberFromUser();

        switch (choose) {
            case 1 -> showTeacherInfo(teacher);
            case 2 -> enterReportCard();
            case 3 -> seeSalaryBill(teacher);
            case 4 -> startMenu();
            default -> teacherMenu(teacher);
        }
    }

    public void studentMenu(Student student) {
        System.out.println("welcome dear " + student.getFirstName() + " " + student.getLastName());
        System.out.println("press 1 for show student info");
        System.out.println("press 2 for show all lessons");
        System.out.println("press 3 for Select units");
        System.out.println("press 4 for show all grades");
        System.out.println("press 5 exit");

        int choose = getNumberFromUser();

        switch (choose) {
            case 1 -> showStudentInfo(student);
            case 2 -> showAllLessons(student);
            case 3 -> chooseLesson(student);
            case 4 -> showAllOfStudentReportCards(student);
            case 5 -> startMenu();
            default -> studentMenu(student);
        }
    }

    public void addStudent() {
        String firstName = getFirstName();
        String lastName = getLastName();
        String username = getUsername();
        String password = getPassword();
        String nationalCode = getNationalCode();
        String phoneNumber = getPhoneNumber();
        String birthDate = getBirthDate();
        String email = getEmail();
        System.out.println("please enter a student code");
        String studentCode = getStringFromUser();
        System.out.println("please enter student last term grade");
        int grade = getNumberFromUser();

        Student student = new Student(firstName, lastName, username, password,
                nationalCode, phoneNumber, birthDate, email, studentCode, grade);

        if (studentService.validate(student))
            try {
                studentService.saveOrUpdate(student);
            } catch (IllegalStateException e) {
                addStudent();
            }
        else
            addStudent();

    }

    public void addTeacher() {
        String firstName = getFirstName();
        String lastName = getLastName();
        String username = getUsername();
        String password = getPassword();
        String nationalCode = getNationalCode();
        String phoneNumber = getPhoneNumber();
        String birthDate = getBirthDate();
        String email = getEmail();

        HireCondition hireCondition = chooseCondition();

        System.out.println("please enter a teacher code");
        String teacherCode = getStringFromUser();
        List<Term> terms = creatTermList();
        Teacher teacher = new Teacher(firstName, lastName, username, password, nationalCode, phoneNumber,
                birthDate, email, hireCondition, teacherCode, terms);

        if (teacherService.validate(teacher)) {
            for (Term term : terms) {
                term.setTeacher(teacher);
            }
            teacherService.saveOrUpdate(teacher);
        } else
            addTeacher();
    }

    public HireCondition chooseCondition() {
        System.out.println("please enter hire condition press 1 CONTRACTUAL or 2 OFFICIAL");
        int enumChoose = getNumberFromUser();
        HireCondition hireCondition = null;
        switch (enumChoose) {
            case 1 -> hireCondition = HireCondition.CONTRACTUAL;
            case 2 -> hireCondition = HireCondition.OFFICIAL;
            default -> chooseCondition();
        }
        return hireCondition;
    }

    public Term creatTeacherTerm() {
        System.out.println("please enter the year of term between 1375-1402");
        int year = getNumberFromUser();
        System.out.println("please enter the half term");
        int half = getNumberFromUser();
        System.out.println("please enter the count of lessons between 12-29");
        int count = getNumberFromUser();
        Term term = new Term(year, half, count);
        if (termService.validate(term))
            return term;
        else
            creatTeacherTerm();
        return null;
    }

    public List<Term> creatTermList() {

        List<Term> terms = new ArrayList<>();
        System.out.println("please creat a term");
        Term termNew = creatTeacherTerm();
        terms.add(termNew);

        boolean flag = true;
        while (flag) {
            System.out.println("do you want to creat more terms?y/n");
            String creatChoose = getStringFromUser();
            if (creatChoose.equals("y")) {
                System.out.println("please creat a term");
                Term termTemp = creatTeacherTerm();
                if (checkExistTerm(terms, termTemp)) {
                    terms.add(termTemp);
                } else {
                    System.out.println("this term already exist");
                }
            } else
                flag = false;
        }
        return terms;
    }

    public boolean checkExistTerm(List<Term> terms, Term term) {
        boolean flag = true;
        for (Term temp : terms) {
            flag = temp.getYearOfTerm() != term.getYearOfTerm()
                    || temp.getHalfTerm() != term.getHalfTerm();
        }
        return flag;
    }

    public void addEmployee() {
        String firstName = getFirstName();
        String lastName = getLastName();
        String username = getUsername();
        String password = getPassword();
        String nationalCode = getNationalCode();
        String phoneNumber = getPhoneNumber();
        String birthDate = getBirthDate();
        String email = getEmail();
        System.out.println("please enter employee salary");
        int salary = getNumberFromUser();

        Employee employee = new Employee(firstName, lastName, username, password,
                nationalCode, phoneNumber, birthDate, email, salary);

        if (employeeService.validate(employee))
            try {
                employeeService.saveOrUpdate(employee);
            } catch (IllegalStateException e) {
                addEmployee();
            }
        else
            addEmployee();

    }

    public void addLesson() {
        System.out.println("please enter the lesson name");
        String name = getStringFromUser();
        System.out.println("please enter the count of lesson");
        int count = getNumberFromUser();
        Fields fields = chooseField();

        Lesson lesson = new Lesson(name, count, fields);
        if (lessonService.validate(lesson))
            try {
                lessonService.saveOrUpdate(lesson);
            } catch (IllegalStateException e) {
                addLesson();
            }
        else
            addLesson();
    }

    public Fields chooseField() {
        System.out.println("please enter the field of lesson press 1 for GENERAL and press 2 for PROFESSIONAL");
        int enumChoose = getNumberFromUser();
        Fields fields = null;
        switch (enumChoose) {
            case 1 -> fields = Fields.GENERAL;
            case 2 -> fields = Fields.PROFESSIONAL;
            default -> chooseField();
        }
        return fields;
    }

    public void updateStudent() {
        Student student = null;
        try {
            String firstName = getFirstName();
            String lastName = getLastName();
            student = studentService.findByFullName(firstName, lastName);
        } catch (NoResultException e) {
            System.out.println("this student is not exist");
            employeeStudentProcess();
        }
        if (student != null) {
            String firstName1 = getFirstName();
            student.setFirstName(firstName1);
            String lastName1 = getLastName();
            student.setLastName(lastName1);
            String username = getUsername();
            student.setUsername(username);
            String password = getPassword();
            student.setPassword(password);
            String nationalCode = getNationalCode();
            student.setNationalCode(nationalCode);
            String phoneNumber = getPhoneNumber();
            student.setPhoneNumber(phoneNumber);
            String birthDate = getBirthDate();
            student.setBirthDate(birthDate);
            String email = getEmail();
            student.setEmail(email);
            System.out.println("please enter a student code");
            String studentCode = getStringFromUser();
            student.setStudentCode(studentCode);
            System.out.println("please enter student last term grade");
            int grade = getNumberFromUser();
            student.setLastTermGrade(grade);

            if (studentService.validate(student))
                studentService.saveOrUpdate(student);
            else
                updateStudent();
        } else {
            System.out.println("this student is not exist");
            updateStudent();
        }


    }

    public void updateTeacher() {
        Teacher teacher = null;
        try {
            String firstName = getFirstName();
            String lastName = getLastName();
            teacher = teacherService.findByFullName(firstName, lastName);
        } catch (NoResultException e) {
            System.out.println("this teacher is not exist");
            updateTeacher();
        }
        if (teacher != null) {
            String firstName1 = getFirstName();
            teacher.setFirstName(firstName1);
            String lastName1 = getLastName();
            teacher.setLastName(lastName1);
            String username = getUsername();
            teacher.setUsername(username);
            String password = getPassword();
            teacher.setPassword(password);
            String nationalCode = getNationalCode();
            teacher.setNationalCode(nationalCode);
            String phoneNumber = getPhoneNumber();
            teacher.setPhoneNumber(phoneNumber);
            String birthDate = getBirthDate();
            teacher.setBirthDate(birthDate);
            String email = getEmail();
            teacher.setEmail(email);
            HireCondition hireCondition = chooseCondition();
            teacher.setHireCondition(hireCondition);
            System.out.println("please enter the teacher code");
            String teacherCode = getStringFromUser();
            teacher.setTeacherCode(teacherCode);
            List<Term> newTerms = editTeacherTerm(teacher);
            teacher.setTerms(newTerms);

            if (teacherService.validate(teacher)) {
                for (Term term : newTerms) {
                    term.setTeacher(teacher);
                }
                teacherService.saveOrUpdate(teacher);
            } else
                updateTeacher();
        } else {
            System.out.println("this teacher is not exist");
            updateTeacher();
        }
    }

    public void updateEmployee() {
        Employee employee = null;
        try {
            String firstName = getFirstName();
            String lastName = getLastName();
            employee = employeeService.findByFullName(firstName, lastName);
        } catch (NoResultException e) {
            System.out.println("this employee not exist");
            updateEmployee();
        }
        if (employee != null) {
            String firstName1 = getFirstName();
            employee.setFirstName(firstName1);
            String lastName1 = getLastName();
            employee.setLastName(lastName1);
            String username = getUsername();
            employee.setUsername(username);
            String password = getPassword();
            employee.setPassword(password);
            String nationalCode = getNationalCode();
            employee.setNationalCode(nationalCode);
            String phoneNumber = getPhoneNumber();
            employee.setPhoneNumber(phoneNumber);
            String birthDate = getBirthDate();
            employee.setBirthDate(birthDate);
            String email = getEmail();
            employee.setEmail(email);
            System.out.println("please enter salary");
            int salary = getNumberFromUser();
            employee.setSalary(salary);

            if (employeeService.validate(employee)) {
                employeeService.saveOrUpdate(employee);
            } else {
                updateEmployee();
            }
        } else {
            System.out.println("this employee not exist");
            updateEmployee();
        }
    }

    public void updateLesson() {
        Lesson lesson = null;
        try {
            System.out.println("please enter the lesson name");
            String name = getStringFromUser();
            lesson = lessonService.findByName(name);
        } catch (NoResultException e) {
            System.out.println("this lesson is not exist");
            updateLesson();
        }
        System.out.println("please enter the lesson name");
        String name1 = getStringFromUser();
        assert lesson != null;
        lesson.setName(name1);
        System.out.println("please enter the count of lesson");
        int count = getNumberFromUser();
        lesson.setCount(count);
        Fields fields = chooseField();
        lesson.setFields(fields);

        if (lessonService.validate(lesson))
            lessonService.saveOrUpdate(lesson);
        else
            updateLesson();
    }

    public List<Term> editTeacherTerm(Teacher teacher) {
        boolean flag = true;
        List<Term> terms = teacher.getTerms();
        while (flag) {
            System.out.println("do you want add or delete term?a/d/n");
            String choose = getStringFromUser();
            if (choose.equals("a")) {
                Term term = creatTeacherTerm();
                if (checkExistTerm(terms, term)) {
                    terms.add(term);
                } else {
                    System.out.println("this term already exist");
                }
            } else if (choose.equals("d")) {
                System.out.println("please enter the year of term");
                int year = getNumberFromUser();
                System.out.println("please enter the half term");
                int half = getNumberFromUser();
                terms.removeIf(term1 -> term1.getYearOfTerm() == year && term1.getHalfTerm() == half);
            } else
                flag = false;
        }
        return terms;
    }

    public void deleteStudent() {
        Student student;
        try {
            String firstName = getFirstName();
            String lastName = getLastName();
            student = studentService.findByFullName(firstName, lastName);
            studentService.delete(student);
        } catch (IllegalStateException e) {
            System.out.println("this student is not exist");
            deleteStudent();
        }
    }

    public void deleteTeacher() {
        Teacher teacher;
        try {
            String firstName = getFirstName();
            String lastName = getLastName();
            teacher = teacherService.findByFullName(firstName, lastName);
            if (teacher != null) {
                List<Term> terms = teacher.getTerms();
                terms.clear();
                teacherService.delete(teacher);
            } else {
                System.out.println("this teacher is not exist");
                deleteTeacher();
            }
        } catch (NoResultException e) {
            System.out.println("this teacher is not exist");
            deleteTeacher();
        }
        employeeTeacherProcess();
    }

    public void deleteEmployee() {
        Employee employee;
        try {
            String firstName = getFirstName();
            String lastName = getLastName();
            employee = employeeService.findByFullName(firstName, lastName);
            employeeService.delete(employee);
        } catch (IllegalStateException e) {
            System.out.println("this employee not exist");
            deleteEmployee();
        }
    }

    public void showEmployeeSalary(Employee employee) {
        System.out.println("dear " + employee.getFirstName() + " " + employee.getLastName() + " your salary is: " + employee.getSalary());
    }

    public void showStudentInfo(Student student) {
        System.out.println(student.toString());
        studentMenu(student);
    }

    public void showTeacherInfo(Teacher teacher) {
        System.out.println(teacher.toString());
        teacherMenu(teacher);
    }

    public void showAllLessons(Student student) {
        try {
            List<Lesson> lessons = lessonService.allLessons();
            for (Lesson lesson : lessons){
                System.out.println(lesson);
            }
        } catch (NullPointerException e) {
            System.out.println("there is no lesson");
        }
        studentMenu(student);
    }

    public void deleteLesson() {
        Lesson lesson;
        try {
            System.out.println("please enter the lesson name");
            String name = getStringFromUser();
            lesson = lessonService.findByName(name);
            lessonService.delete(lesson);
        } catch (NoResultException e) {
            System.out.println("this lesson is not exist");
            deleteLesson();
        }
    }

    public Long getLessonId() {
        Lesson lesson = null;
        try {
            System.out.println("please enter the lesson name");
            String name = getStringFromUser();
            lesson = lessonService.findByName(name);
        } catch (NoResultException e) {
            System.out.println("this lesson is not exist");
        }
        if (lesson != null) {
            return lesson.getId();
        }
        return null;
    }

    public Long getStudentId() {
        Student student = null;
        try {
            String firstName = getFirstName();
            String lastName = getLastName();
            student = studentService.findByFullName(firstName, lastName);
        } catch (NoResultException e) {
            System.out.println("this student is not exist");
            getStudentId();
        }
        if (student != null) {
            return student.getId();
        } else {
            System.out.println("wrong student info");
        }
        return null;
    }

    public void enterReportCard() {
        Long lessonId = getLessonId();
        int year = 0;
        int half = 0;
        if(lessonId != null) {
            System.out.println("please enter the year of term between 1375-1402");
            year = getNumberFromUser();
            System.out.println("please enter the half term");
            half = getNumberFromUser();
        }else {
            enterReportCard();
        }
        boolean flag = true;
        while (flag) {
            Long studentId = getStudentId();
            if (studentId != null && lessonId != null) {
                List<ReportCard> reportCards = reportCardService.reportCards(lessonId);
                int check = 0;
                for (ReportCard reportCard : reportCards) {
                    if (Objects.equals(reportCard.getStudentId(), studentId) && reportCard.getLessonGrade() > 12) {
                        System.out.println("this lesson is already passed");
                        check = 1;
                        break;
                    } else if (Objects.equals(reportCard.getStudentId(), studentId) && reportCard.getLessonGrade() < 12) {
                        reportCardService.delete(reportCard);
                    }
                }
                if (check == 0) {
                    System.out.println("please enter grade");
                    int grade = getNumberFromUser();
                    ReportCard reportCard = new ReportCard(year, half, grade, lessonId, studentId);
                    if (reportCardService.validate(reportCard)) {
                        reportCardService.saveOrUpdate(reportCard);
                    } else {
                        enterReportCard();
                    }
                    System.out.println("do you want to continue:y/n");
                    String choose = getStringFromUser();
                    if (choose.equals("n")) {
                        flag = false;
                        break;
                    }
                }
            }
        }
    }

    public void seeSalaryBill(Teacher teacher) {
        HireCondition hireCondition = teacher.getHireCondition();

        if (hireCondition.equals(HireCondition.OFFICIAL)) {
            System.out.println("please enter the year of term");
            int year = getNumberFromUser();
            System.out.println("please enter the half term");
            int halfTerm = getNumberFromUser();
            Term term = null;
            try {
                term = teacherService.findByYearAndHalfYear(year, halfTerm);
            } catch (NoResultException e) {
                System.out.println("this term is not exist");
            }
            if (term != null) {
                int count = term.getCountOfLessons();
                int salary = 8000000 + (count * 1000000);
                System.out.println("dear " + teacher.getFirstName() + teacher.getLastName() + " your salary is:");
                System.out.println("Fixed salary is: 8.000.000");
                System.out.println("you picked " + term.getCountOfLessons() + " lessons unit in " + term.getYearOfTerm() +
                        " half term " + term.getHalfTerm());
                System.out.println("your overall salary is: " + salary);
                teacherMenu(teacher);
            } else {
                System.out.println("wrong term info");
                seeSalaryBill(teacher);
            }
        } else {
            System.out.println("please enter the year of term");
            int year = getNumberFromUser();
            System.out.println("please enter the half term");
            int halfTerm = getNumberFromUser();
            Term term = null;
            try {
                term = teacherService.findByYearAndHalfYear(year, halfTerm);
            } catch (NoResultException e) {
                System.out.println("this term is not exist");
            }
            if (term != null) {
                int count = term.getCountOfLessons();
                int salary = (count * 1000000);
                System.out.println("dear " + teacher.getFirstName() + teacher.getLastName() + " your salary is:");
                System.out.println("you picked " + term.getCountOfLessons() + " lessons unit in " + term.getYearOfTerm() +
                        " half term " + term.getHalfTerm());
                System.out.println("your overall salary is: " + salary);
                teacherMenu(teacher);
            } else {
                System.out.println("wrong term info");
                seeSalaryBill(teacher);
            }
        }
    }

    public void chooseLesson(Student student) {
        if (checkCurrentTermExist(student)) {
            chooseLessonsMoreThan18(student);
            chooseLessonsLessThan18(student);
        } else {
            System.out.println("already picked a term");
        }
    }
    public boolean checkCurrentTermExist(Student student){
        List<Current> currents = currentTermService.findAllCurrentTerms();
        boolean flag = true;
        for(Current current : currents){
          if (Objects.equals(current.getStudent().getId(), student.getId())){
              flag = false;
              break;
          }
        }
        return flag;
    }

    public void chooseLessonsMoreThan18(Student student) {
        if (student.getLastTermGrade() > 18) {
            int term = 1402;
            int halfTerm = 2;
            Current current = new Current(term, halfTerm);
            List<Lesson> lessons = new ArrayList<>();

            int limit = 24;
            while (limit > 0) {
                int check = 0;
                Lesson lesson = null;
                try {
                    System.out.println("please enter the lesson name");
                    String name = getStringFromUser();
                    lesson = lessonService.findByName(name);
                } catch (NoResultException e) {
                    System.out.println("this lesson is not exist");
                    chooseLessonsMoreThan18(student);
                }
                assert lesson != null;
                List<ReportCard> reportCards;
                try {
                    reportCards = reportCardService.reportCardsStudent(student.getId());
                } catch (NoResultException e) {
                    continue;
                }
                if (lessons.size() > 0) {
                    for (Lesson lesson1 : lessons) {
                        if (lesson1.getName().equals(lesson.getName())) {
                            System.out.println("this lesson is already choose");
                            check = 1;
                        }
                    }
                }
                for (ReportCard reportCard : reportCards) {
                    if (Objects.equals(reportCard.getLessonId(), lesson.getId()) && reportCard.getLessonGrade() >= 12) {
                        System.out.println("this lesson is already passed");
                        check = 2;
                    }
                }
                if (check == 0 && limit - lesson.getCount() >= 0) {
                    limit -= lesson.getCount();
                    lessons.add(lesson);
                    System.out.println("remain " + limit + " units");
                } else if (check == 0 && limit - lesson.getCount() < 0) {
                    System.out.println("can not pick more than 24 units");
                }
            }
            current.setLessons(lessons);
            current.setStudent(student);
            currentTermService.saveOrUpdate(current);
            studentMenu(student);
        }
    }

    public void chooseLessonsLessThan18(Student student) {
        if (student.getLastTermGrade() < 18) {
            int term = 1402;
            int halfTerm = 2;
            Current current = new Current(term, halfTerm);
            List<Lesson> lessons = new ArrayList<>();

            int limit = 20;
            while (limit > 0) {
                int check = 0;
                Lesson lesson = null;
                try {
                    System.out.println("please enter the lesson name");
                    String name = getStringFromUser();
                    lesson = lessonService.findByName(name);
                } catch (NoResultException e) {
                    System.out.println("this lesson is not exist");
                    chooseLessonsMoreThan18(student);
                }
                assert lesson != null;
                List<ReportCard> reportCards;
                try {
                    reportCards = reportCardService.reportCardsStudent(student.getId());
                } catch (NoResultException e) {
                    continue;
                }
                if (lessons.size() > 0) {
                    for (Lesson lesson1 : lessons) {
                        if (lesson1.getName().equals(lesson.getName())) {
                            System.out.println("this lesson is already choose");
                            check = 1;
                        }
                    }
                }
                for (ReportCard reportCard : reportCards) {
                    if (Objects.equals(reportCard.getLessonId(), lesson.getId()) && reportCard.getLessonGrade() >= 12) {
                        System.out.println("this lesson is already passed");
                        check = 2;
                    }
                }
                if (check == 0 && limit - lesson.getCount() >= 0) {
                    limit -= lesson.getCount();
                    lessons.add(lesson);
                    System.out.println("remain " + limit + " units");
                } else if (check == 0 && limit - lesson.getCount() < 0) {
                    System.out.println("can not pick more than 20 units");
                }
            }
            current.setLessons(lessons);
            current.setStudent(student);
            currentTermService.saveOrUpdate(current);
            studentMenu(student);
        }
    }

    public void showAllOfStudentReportCards(Student student) {
        List<ReportCard> reportCards = reportCardService.reportCardsStudent(student.getId());
        for (ReportCard reportCard : reportCards) {
            Lesson lesson = lessonService.findById(reportCard.getLessonId());
            System.out.println("LESSON NAME: " + lesson.getName() + " " + reportCard);
        }
        studentMenu(student);
    }
}