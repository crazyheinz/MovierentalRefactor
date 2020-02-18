package movierental;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static movierental.Movie.Type.REGULAR;
import static movierental.Movie.Type.CHILDRENS;
import static movierental.Movie.Type.NEW_RELEASE;

public class CustomerTest {

    @Test
    public void testCustomer() {
        Customer c = new CustomerBuilder().build();
        assertNotNull(c);
    }
;
    @Test
    public void testAddRental() {
        Customer customer2 = new CustomerBuilder().withName("Sallie").build();
        Movie movie1 = new Movie("Gone with the Wind", REGULAR);
        Rental rental1 = new Rental(movie1, 3); // 3 day rental
        customer2.addRental(rental1);
    }

    @Test
    public void testGetName() {
        Customer c = new Customer("David");
        assertEquals("David", c.getName());
    }

    @Test
    public void statementForRegularMovie() {
        Movie movie1 = new Movie("Gone with the Wind", REGULAR);
        Rental rental1 = new Rental(movie1, 3); // 3 day rental
        Customer customer2 =
            new CustomerBuilder()
                .withName("Sallie")
                .withRentals(rental1)
                .build();
        String expected = "Rental Record for Sallie\n" +
            "\tGone with the Wind\t3.5\n" +
            "Amount owed is 3.5\n" +
            "You earned 1 frequent renter points";
        String statement = new StatementFormatter()
                .formatStatement(customer2.getName(), customer2.getRentals());;
        assertEquals(expected, statement);
    }

    @Test
    public void statementForNewReleaseMovie() {
        Movie movie1 = new Movie("Star Wars", NEW_RELEASE);
        Rental rental1 = new Rental(movie1, 3); // 3 day rental
        Customer customer2 =
            new CustomerBuilder()
                .withName("Sallie")
                .withRentals(rental1)
                .build();
        String expected = "Rental Record for Sallie\n" +
            "\tStar Wars\t9.0\n" +
            "Amount owed is 9.0\n" +
            "You earned 2 frequent renter points";
        String statement = new StatementFormatter()
                .formatStatement(customer2.getName(), customer2.getRentals());
        assertEquals(expected, statement);
    }

    @Test
    public void statementForChildrensMovie() {
        Movie movie1 = new Movie("Madagascar", CHILDRENS);
        Rental rental1 = new Rental(movie1, 3); // 3 day rental
        Customer customer2
            = new CustomerBuilder()
            .withName("Sallie")
            .withRentals(rental1)
            .build();
        String expected = "Rental Record for Sallie\n" +
            "\tMadagascar\t1.5\n" +
            "Amount owed is 1.5\n" +
            "You earned 1 frequent renter points";
        String statement = new StatementFormatter()
                .formatStatement(customer2.getName(), customer2.getRentals());
        assertEquals(expected, statement);
    }

    @Test
    public void statementForManyMovies() {
        Movie movie1 = new Movie("Madagascar", CHILDRENS);
        Rental rental1 = new Rental(movie1, 6); // 6 day rental
        Movie movie2 = new Movie("Star Wars", NEW_RELEASE);
        Rental rental2 = new Rental(movie2, 2); // 2 day rental
        Movie movie3 = new Movie("Gone with the Wind", REGULAR);
        Rental rental3 = new Rental(movie3, 8); // 8 day rental
        Customer customer1
            = new CustomerBuilder()
            .withName("David")
            .withRentals(rental1, rental2, rental3)
            .build();
        String expected = "Rental Record for David\n" +
            "\tMadagascar\t6.0\n" +
            "\tStar Wars\t6.0\n" +
            "\tGone with the Wind\t11.0\n" +
            "Amount owed is 23.0\n" +
            "You earned 4 frequent renter points";
        String statement = new StatementFormatter()
                .formatStatement(customer1.getName(), customer1.getRentals());
        assertEquals(expected, statement);
    }

    //TODO make test for price breaks in code.
}
