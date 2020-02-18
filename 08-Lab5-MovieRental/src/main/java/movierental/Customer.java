package movierental;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    private final String name;
    private final List<Rental> rentals = new ArrayList<Rental>();
    public Customer(String name) {
        this.name = name;
    }


    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public List<Rental> getRentals() {
        return rentals;
    }

    public String getName() {
        return name;
    }

}
