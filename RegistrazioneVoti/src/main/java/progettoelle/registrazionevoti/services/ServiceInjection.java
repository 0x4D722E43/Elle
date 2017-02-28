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
import progettoelle.registrazionevoti.services.managecourse.ConcreteCoursesService;
import progettoelle.registrazionevoti.services.managecourse.ConcreteEnrollmentsService;
import progettoelle.registrazionevoti.services.manageexam.BookingExamService;
import progettoelle.registrazionevoti.services.manageexam.ConcreteStudentExamsService;
import progettoelle.registrazionevoti.services.manageexam.CreateExamService;
import progettoelle.registrazionevoti.services.manageexam.GradeExamService;
import progettoelle.registrazionevoti.services.manageexam.LoadResultsHistoryService;
import progettoelle.registrazionevoti.services.manageexam.ManageExamBookingsService;
import progettoelle.registrazionevoti.services.registration.ConcreteRegisterService;
import progettoelle.registrazionevoti.services.registration.ResetPasswordService;
import progettoelle.registrazionevoti.services.manageexam.AcceptExamResultService;
import progettoelle.registrazionevoti.services.manageexam.ConcreteProfessorExamService;
import progettoelle.registrazionevoti.services.manageexam.OpenExamBookingsService;

public class ServiceInjection {

    public static UserAccountService provideUserAccountService() {
        return new UserAccountService(new UserRepositoryHibernate());
    }

    public static ChangePasswordService provideChangePasswordService() {
        return new ChangePasswordService(new UserRepositoryHibernate());
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
        return new ResetPasswordService(new UserRepositoryHibernate(), new MockEmailService());
    }

    public static ConcreteRegisterService provideRegisterService() {
        return new ConcreteRegisterService(new FacultyRepositoryHibernate(), new DegreeCourseRepositoryHibernate(), new UserRepositoryHibernate(), new MockEmailService());
    }

}
