import junit.framework.TestCase;

public class RentalTests extends TestCase {

    private Movie movie;
    private Rental rental;
    private int numDays;

    public RentalTests(String arg0) {
        super(arg0);
    }

    protected void setUp() throws Exception {
        super.setUp();

        movie = Movie.createRegularMovie("Regular");
        numDays = 5;
        rental = new Rental(movie, numDays);
    }

    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void testConstructor() {
        assertNotNull(rental);
        assertEquals(movie, rental.getMovie());
        assertEquals(numDays, rental.getDaysRented());
    }

}
