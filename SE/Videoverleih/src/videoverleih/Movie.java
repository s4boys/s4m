package videoverleih;

public class Movie {

    public static final int CHILDRENS = 2;
    public static final int NEW_RELEASE = 1;
    public static final int REGULAR = 0;

    private String title;
    private int priceCode;

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