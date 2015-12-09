import junit.framework.TestCase;

public class MovieTests extends TestCase {

    private Movie regular, newRelease, child;

    public MovieTests(String arg0) {
        super(arg0);
    }

    protected void setUp() throws Exception {
        super.setUp();
        regular = Movie.createRegularMovie("Regular");
        newRelease = Movie.createNewRelease("New Release");
        child = Movie.createChildMovie("Child");
    }

    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void testConstructor() {
        assertNotNull(regular);
        assertEquals("Regular", regular.getTitle());
        assertEquals(Movie.REGULAR, regular.getPriceCode());

        assertNotNull(newRelease);
        assertEquals("New Release", newRelease.getTitle());
        assertEquals(Movie.NEW_RELEASE, newRelease.getPriceCode());

        assertNotNull(child);
        assertEquals("Child", child.getTitle());
        assertEquals(Movie.CHILD, child.getPriceCode());
    }

    public void testSetPriceCode() {
        int newCode = Movie.NEW_RELEASE;
        regular.setPriceCode(newCode);
        assertEquals(newCode, regular.getPriceCode());
    }

}
