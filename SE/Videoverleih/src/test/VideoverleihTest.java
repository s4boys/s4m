package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import videoverleih.Customer;
import videoverleih.IllegalRentalDuration;
import videoverleih.Movie;
import videoverleih.Rental;

public class VideoverleihTest {
	
	Customer customer;
	Movie movie;
	Rental rental;
	
	
	@BeforeEach
	public void createObjects() {
		customer = new Customer("Gerhard Wanner");
		movie = new Movie("Matrix 2", 1);
		rental = new Rental(movie, 2);
		customer.addRental(rental);
		
	}

	@Test
	void testStatement() {
		String expected = "Rental Record for Gerhard Wanner\n" +
						  "\tMatrix 2\t6.0\n" +
						  "Amount owed is 6.0 Euros\n" +
						  "You earned 2 frequent renter points";
		assertEquals(expected, customer.statement());
	}
	
	@Test
	void testGetName() {
		String expected = "Gerhard Wanner";
		assertEquals(expected, customer.getName()); 
	}
	
	@Test
	void testMovie() {
		String expectedTitle = "Matrix 2";
		int expectedPriceCode = 1;
		assertEquals(expectedTitle, movie.getTitle());
		assertEquals(expectedPriceCode, movie.getPriceCode());
		
	}
	@Test
	void testDaysRented(){
		int expected = 2;
		assertEquals(expected, rental.getDaysRented());
	}
	
	@Test
	void testException() {
		Throwable exception = assertThrows(IllegalRentalDuration.class, () -> new Rental(movie, -1));
		assertEquals("Must be at least one day", exception.getMessage());
	}

}
