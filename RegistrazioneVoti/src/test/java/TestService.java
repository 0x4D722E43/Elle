


import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author mrc
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({services.Registration.class, services.UserAccount.class, services.Exams.class, services.Courses.class})
public class TestService {}
