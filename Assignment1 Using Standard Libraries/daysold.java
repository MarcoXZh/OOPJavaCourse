/**
 * Assignment 1: Using standard libraries <br />
 * Calculate age in days
 */
public class daysold {

    /**
     * Calculate how many days between today and the birthday
     * @param birthday      {@code String} The birthday
     */
    public static void days(String birthday) {
        // TODO: Assignment 1 -- write your code here.


    }

    /**
     * Main entry
     * @param args          {@code String[]} Command line arguments
     */
    public static void main(String[] args) {
        days("3000-01-01");             // Wrong birthday. Birthday after today
        days("2001-02-29");             // Invalid date. 2001 is not a leap year
        days("2000-01-01");
        days("2000-01-15");
    }

}
