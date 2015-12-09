/**
 * Assignment 9: Refactoring II <br />
 * The {@code Rental} class
 */
public class Rental {
    // TODO: Assignment 9 Checkpoint 2 -- Move Method to Movie

    private Movie movie;
    private int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

}
