import junit.framework.TestCase;

public class CustomerTests extends TestCase {

    private Customer customer;
    private Movie regular, newRelease, lateNewRelease, child, lateChild;

    public CustomerTests(String arg0) {
        super(arg0);
    }

    protected void setUp() throws Exception {
        super.setUp();

        customer = new Customer("Test Customer");

        regular = Movie.createRegularMovie("Regular");
        newRelease = Movie.createNewRelease("New Release");
        lateNewRelease = Movie.createNewRelease("Late New Release");
        child = Movie.createChildMovie("Child");
        lateChild = Movie.createChildMovie("Late Child");

        customer.addRental(new Rental(regular, 5));
        customer.addRental(new Rental(newRelease, 2));
        customer.addRental(new Rental(lateNewRelease, 3));
        customer.addRental(new Rental(child, 3));
        customer.addRental(new Rental(lateChild, 4));
    }

    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void testConstructor() {
        assertNotNull(customer);
        assertEquals("Test Customer", customer.getName());
    }

    public void testStatement() {

        /*
         * Rental Record for Test Customer
               Regular          6.5
               New Release      6.0
               Late New Release 9.0
               Child            1.5
               Late Child       3.0
           Amount owed is 26.0
           You earned 7 frequent renter points
         */
        String result = customer.statement();

        // Result contains 8 lines
        assertEquals(8, result.split("\n").length);

        // First line includes customer Name
        assertTrue(result.split("\n")[0].contains("Test Customer"));

        // Check for each rental in summary
        assertTrue(result.contains("\n\tRegular\t6.5\n"));
        assertTrue(result.contains("\n\tNew Release\t6.0\n"));
        assertTrue(result.contains("\n\tLate New Release\t9.0\n"));
        assertTrue(result.contains("\n\tChild\t1.5\n"));
        assertTrue(result.contains("\n\tLate Child\t3.0\n"));

        // check for amount owing
        assertTrue(result.contains("\nAmount owed is 26.0\n"));

        //check for frequent renter points
        assertTrue(result.contains("\nYou earned 7 frequent renter points"));
    }

}
