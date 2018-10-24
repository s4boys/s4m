package videoverleih;

import java.util.*;

public class Customer {

    private String name;
    private Vector<Rental> rentals = new Vector<Rental>();

    public Customer(String pName) {
        name = pName;
    }

    public void addRental(Rental pRental) {
        rentals.addElement(pRental);
    }
    
    public String getName() {
        return name;
    }

    public String statement()
    {
        double lTotalAmount = 0;
        int lFrequentRenterPoints = 0;
        Enumeration<Rental> lRentals = rentals.elements();
        String lResult = "Rental Record for "+getName()+"\n";
        while(lRentals.hasMoreElements())
        {
            double lThisAmount = 0;
            Rental lEachRental = lRentals.nextElement();

            //Betr�ge f�r jede Zeile berechnen
            switch(lEachRental.getMovie().getPriceCode())
            {
                case Movie.REGULAR:
                    lThisAmount +=2;
                    if(lEachRental.getDaysRented()>2)
                        lThisAmount += (lEachRental.getDaysRented()-2)*1.5;
                    break;
                case Movie.NEW_RELEASE:
                    lThisAmount +=lEachRental.getDaysRented()*3;
                    break;
                case Movie.CHILDRENS:
                    lThisAmount += 1.5;
                    if(lEachRental.getDaysRented()>3)
                        lThisAmount += (lEachRental.getDaysRented()-3)*1.5;
                    break;
            }
            //Frequent Renter Points
            lFrequentRenterPoints++;
            //Bonus Frequent Renter Points
            if((lEachRental.getMovie().getPriceCode()==Movie.NEW_RELEASE) &&
                lEachRental.getDaysRented()>1)
                lFrequentRenterPoints++;
            //Berechnungen ausgeben
            lResult += "\t"+lEachRental.getMovie().getTitle()+"\t"+String.valueOf(lThisAmount)+"\n";
            lTotalAmount += lThisAmount;
        }
        //Fusszeile
        lResult += "Amount owed is "+String.valueOf(lTotalAmount)+" Euros\n";
        lResult += "You earned "+String.valueOf(lFrequentRenterPoints)+" frequent renter points";
        return lResult;
    }

    public static void main(String args[])
    {
        Customer lCustomer = new Customer("Peter Sauer");
        Movie lMovie1 = new Movie("Avatar", Movie.NEW_RELEASE);
        Movie lMovie2 = new Movie("Dschungelbuch", Movie.CHILDRENS);
        Movie lMovie3 = new Movie("Matrix", Movie.REGULAR);

        Rental lRental1 = new Rental(lMovie1, 12);
        lCustomer.addRental(lRental1);
        Rental lRental2 = new Rental(lMovie2, 2);
        lCustomer.addRental(lRental2);
        Rental lRental3 = new Rental(lMovie3, 7);
        lCustomer.addRental(lRental3);

        System.out.println(lCustomer.statement());
    }
}