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
import progettoelle.registrazionevoti.services.managecourse.CreateCourseService;
import progettoelle.registrazionevoti.services.managecourse.EnrollOnCourseService;
import progettoelle.registrazionevoti.services.managecourse.LoadEnrolledStudentsService;
import progettoelle.registrazionevoti.services.managecourse.LoadProfessorCoursesService;
import progettoelle.registrazionevoti.services.managecourse.LoadStudentEnrollmentsService;
import progettoelle.registrazionevoti.services.manageexam.AcceptExamResultService;
import progettoelle.registrazionevoti.services.manageexam.BookExamService;
import progettoelle.registrazionevoti.services.manageexam.CreateExamService;
import progettoelle.registrazionevoti.services.manageexam.GradeExamService;
import progettoelle.registrazionevoti.services.manageexam.LoadExamResultHistoryService;
import progettoelle.registrazionevoti.services.manageexam.ManageExamBookingsService;
import progettoelle.registrazionevoti.services.manageexam.OpenExamBookingsService;
import progettoelle.registrazionevoti.services.registration.RegisterProfessorService;
import progettoelle.registrazionevoti.services.registration.RegisterService;
import progettoelle.registrazionevoti.services.registration.RegisterStudentService;
import progettoelle.registrazionevoti.services.registration.ResetPasswordService;

public class ServiceInjection {

    public static UserAccountService provideUserAccountService() {
        return new UserAccountService(new UserRepositoryHibernate());
    }

    public static ChangePasswordService provideChangePasswordService() {
        return new ChangePasswordService(new UserRepositoryHibernate());
    }

    public static CreateCourseService provideCreateCourseService() {
        return new CreateCourseService(new DegreeCourseRepositoryHibernate(), new CourseRepositoryHibernate());
    }

    public static EnrollOnCourseService provideEnrollOnCourseService() {
        return new EnrollOnCourseService(new CourseRepositoryHibernate(), new EnrollmentRepositoryHibernate());
    }

    public static LoadEnrolledStudentsService provideLoadEnrolledStudentsService() {
        return new LoadEnrolledStudentsService(new EnrollmentRepositoryHibernate());
    }

    public static LoadProfessorCoursesService provideLoadProfessorCoursesService() {
        return new LoadProfessorCoursesService(new CourseRepositoryHibernate());
    }

    public static LoadStudentEnrollmentsService provideLoadStudentEnrollmentsService() {
        return new LoadStudentEnrollmentsService(new EnrollmentRepositoryHibernate());
    }

    public static AcceptExamResultService provideAcceptExamResultService() {
        return new AcceptExamResultService(new ExamResultRepositoryHibernate(), new EnrollmentRepositoryHibernate());
    }

    public static BookExamService provideBookExamService() {
        return new BookExamService(new ExamRepositoryHibernate(), new ExamResultRepositoryHibernate());
    }

    public static CreateExamService provideCreateExamService() {
        return new CreateExamService(new CourseRepositoryHibernate(), new ExamRepositoryHibernate());
    }

    public static GradeExamService provideGradeExamService() {
        return new GradeExamService(new ExamResultRepositoryHibernate());
    }

    public static LoadExamResultHistoryService provideLoadExamResultHistoryService() {
        return new LoadExamResultHistoryService(new ExamResultRepositoryHibernate());
    }

    public static ManageExamBookingsService provideManageExamBookingsService() {
        return new ManageExamBookingsService(new ExamResultRepositoryHibernate());
    }

    public static OpenExamBookingsService provideOpenExamBookingsService() {
        return new OpenExamBookingsService(new ExamRepositoryHibernate());
    }

    public static ResetPasswordService provideResetPasswordService() {
        return new ResetPasswordService(new UserRepositoryHibernate(), new MockEmailService());
    }

    public static RegisterService provideRegisterService() {
        return new RegisterService(new FacultyRepositoryHibernate(), new DegreeCourseRepositoryHibernate(), new UserRepositoryHibernate(), new MockEmailService());
    }

}
