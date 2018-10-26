package videoverleih;

public class NewRelease extends Movie{
    public static final int PRICECODE = 1;
    
	public NewRelease(String pTitle) {
		super(pTitle, PRICECODE);
		// TODO Auto-generated constructor stub
	}

	@Override
	double getPrice(double amount, int daysRented) {
		amount += daysRented*3;
		return amount;
	}


	

}
