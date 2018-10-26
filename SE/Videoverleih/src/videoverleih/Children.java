package videoverleih;

public class Children extends Movie{
	
    public static final int PRICECODE = 2;

	public Children(String pTitle) {
		super(pTitle, PRICECODE);
		// TODO Auto-generated constructor stub
	}

	@Override
	double getPrice(double amount, int daysRented) {
		// TODO Auto-generated method stub
		amount += 1.5;
        if(daysRented>3)
            amount += (daysRented-3)*1.5;
        return amount;
	}
	
}
