package videoverleih;

abstract public class Movie {


    private String title;
    private int priceCode;
    
    
    abstract double getPrice(double amount, int daysRented);

    public Movie(String pTitle, int pPriceCode) {
        title = pTitle;
        priceCode = pPriceCode;
    }

    public int getPriceCode() {
        return priceCode;
    }
    public String getTitle() {
        return title;
    }
    public void setPriceCode(int pPriceCode) {
        priceCode = pPriceCode;
    }
}