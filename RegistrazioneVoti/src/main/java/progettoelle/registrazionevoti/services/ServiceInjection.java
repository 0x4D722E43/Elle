package progettoelle.registrazionevoti.services;

import progettoelle.registrazionevoti.mail.MockEmailService;
import progettoelle.registrazionevoti.repositories.hibernate.CourseRepositoryHibernate;
import progettoelle.registrazionevoti.repositories.hibernate.DegreeCourseRepositoryHibernate;
import progettoelle.registrazionevoti.repositories.hibernate.EnrollmentRepositoryHibernate;
import progettoelle.registrazionevoti.repositories.hibernate.ExamRepositoryHibernate;
import progettoelle.registrazionevoti.repositories.hibernate.ExamResultRepositoryHibernate;
import progettoelle.registrazionevoti.repositories.hibernate.FacultyRepositoryHibernate;
import progettoelle.registrazionevoti.repositories.hibernate.UserRepositoryHibernate;
import progettoelle.registrazionevoti.services.account.ChangePasswordService;
import progettoelle.registrazionevoti.services.account.UserAccountService;
import progettoelle.registrazionevoti.services.courses.ConcreteCoursesService;
import progettoelle.registrazionevoti.services.courses.ConcreteEnrollmentsService;
import progettoelle.registrazionevoti.services.exams.BookingExamService;
import progettoelle.registrazionevoti.services.exams.ConcreteStudentExamsService;
import progettoelle.registrazionevoti.services.exams.CreateExamService;
import progettoelle.registrazionevoti.services.exams.GradeExamService;
import progettoelle.registrazionevoti.services.exams.LoadResultsHistoryService;
import progettoelle.registrazionevoti.services.exams.ManageExamBookingsService;
import progettoelle.registrazionevoti.services.account.ConcreteRegisterService;
import progettoelle.registrazionevoti.services.account.ConcretePasswordService;
import progettoelle.registrazionevoti.services.account.ResetPasswordService;
import progettoelle.registrazionevoti.services.exams.AcceptExamResultService;
import progettoelle.registrazionevoti.services.exams.ConcreteProfessorExamService;
import progettoelle.registrazionevoti.services.exams.OpenExamBookingsService;

public class ServiceInjection {

    public static UserAccountService provideUserAccountService() {
        return new UserAccountService(new UserRepositoryHibernate());
    }

    public static ChangePasswordService provideChangePasswordService() {        
        return new ConcretePasswordService(new UserRepositoryHibernate(), new MockEmailService());
    }

    public static ConcreteCoursesService provideCourseService() {
        return new ConcreteCoursesService(new DegreeCourseRepositoryHibernate(), new CourseRepositoryHibernate(), new EnrollmentRepositoryHibernate());
    }

    public static ConcreteEnrollmentsService provideEnrollmentService() {
        return new ConcreteEnrollmentsService(new CourseRepositoryHibernate(), new EnrollmentRepositoryHibernate());
    }

    public static AcceptExamResultService provideStudentExamService() {
        return new ConcreteStudentExamsService(new ExamResultRepositoryHibernate(),
                new EnrollmentRepositoryHibernate(), new ExamRepositoryHibernate());
    }

    public static BookingExamService provideBookExamService() {
        return new ConcreteStudentExamsService(new ExamResultRepositoryHibernate(),
                new EnrollmentRepositoryHibernate(), new ExamRepositoryHibernate());
    }

    public static CreateExamService provideCreateExamService() {
        return new ConcreteProfessorExamService(new CourseRepositoryHibernate(),
                new ExamRepositoryHibernate(), new ExamResultRepositoryHibernate());
    }

    public static GradeExamService provideGradeExamService() {
        return new ConcreteProfessorExamService(new CourseRepositoryHibernate(),
                new ExamRepositoryHibernate(), new ExamResultRepositoryHibernate());
    }

    public static LoadResultsHistoryService provideLoadExamResultHistoryService() {
        return new ConcreteStudentExamsService(new ExamResultRepositoryHibernate(),
                new EnrollmentRepositoryHibernate(), new ExamRepositoryHibernate());
    }

    public static ManageExamBookingsService provideManageExamBookingsService() {
        return new ConcreteProfessorExamService(new CourseRepositoryHibernate(),
                new ExamRepositoryHibernate(), new ExamResultRepositoryHibernate());
    }

    public static OpenExamBookingsService provideOpenExamBookingsService() {

        return new ConcreteProfessorExamService(new CourseRepositoryHibernate(),
                new ExamRepositoryHibernate(), new ExamResultRepositoryHibernate());
    }

    public static ResetPasswordService provideResetPasswordService() {
        return new ConcretePasswordService(new UserRepositoryHibernate(), new MockEmailService());
    }

    public static ConcreteRegisterService provideRegisterService() {
        return new ConcreteRegisterService(new FacultyRepositoryHibernate(), new DegreeCourseRepositoryHibernate(), new UserRepositoryHibernate(), new MockEmailService());
    }

}
