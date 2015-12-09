import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {

    public static Test suite() {
        TestSuite suite = new TestSuite("Test for default package");
        //$JUnit-BEGIN$
        suite.addTestSuite(RentalTests.class);
        suite.addTestSuite(CustomerTests.class);
        suite.addTestSuite(MovieTests.class);
        //$JUnit-END$
        return suite;
    }

}
