package videoverleih;

public class Regular extends Movie {
	
	public static final int PRICECODE = 0;
	
    public Regular(String pTitle) {
		super(pTitle, PRICECODE);
		// TODO Auto-generated constructor stub
	}

	@Override
	double getPrice(double amount, int daysRented) {
		amount += 2;
		if (daysRented >2)
            amount += (daysRented-2)*1.5;
		return amount;
	}

    


}
