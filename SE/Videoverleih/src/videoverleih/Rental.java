package videoverleih;

public class Rental {

    private Movie movie;
    private int daysRented;

    public Rental(Movie pMovie, int pDaysRented) {
        if(pDaysRented < 1) {
            throw new IllegalRentalDuration("Must be at least one day");
        }
        movie = pMovie;
        daysRented = pDaysRented;
    }

    public int getDaysRented() {
        return daysRented;
    }
    public Movie getMovie() {
        return movie;
    }
}