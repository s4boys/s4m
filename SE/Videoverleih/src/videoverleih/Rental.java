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

	double getAmount(double lThisAmount) {
		//Betr�ge f�r jede Zeile berechnen
		lThisAmount = getMovie().getPrice(lThisAmount, getDaysRented());
		return lThisAmount;
	}

	int calcFrequentRenter(int lFrequentRenterPoints) {
		//Frequent Renter Points
		lFrequentRenterPoints++;
		//Bonus Frequent Renter Points
		if((getMovie().getPriceCode() == NewRelease.PRICECODE) &&
		    getDaysRented()>1)
		    lFrequentRenterPoints++;
		return lFrequentRenterPoints;
	}
}