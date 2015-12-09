/**
 * Assignment 9: Refactoring II <br />
 * The {@code Movie} class
 */
public class Movie {
    // TODO: Assignment 9 Checkpoint 3 -- Replace Conditional with Polymorphism

    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;
    public static final int CHILD = 2;

    private String title;
    private int priceCode;

    public Movie(String title, int priceCode) {
        this.title = title;
        this.priceCode = priceCode;
    }

    public static Movie createRegularMovie(String title) {
        return new Movie(title, REGULAR);
    }

    public static Movie createNewRelease(String title) {
        return new Movie(title, NEW_RELEASE);
    }

    public static Movie createChildMovie(String title) {
        return new Movie(title, CHILD);
    }

    public int getPriceCode() {
        return priceCode;
    }

    public void setPriceCode(int priceCode) {
        this.priceCode = priceCode;
    }

    public String getTitle () {
        return title;
    }

    // TODO: Assignment 9 Checkpoint 4 -- perform two further distinct refactors

}
