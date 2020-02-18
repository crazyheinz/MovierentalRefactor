package movierental;

import java.util.List;
import java.util.stream.Collectors;

public class StatementFormatter {

    public String formatStatement(String customerName, List<Rental> rentals) {

        return formatHeader(customerName) + formatBody(rentals) + formatFooter(rentals);
    }

    private String formatBody(List<Rental> rentals) {
        return rentals.stream()
                .map(this::formatBodyLine)
                .collect(Collectors.joining());
    }

    private String formatFooter(List<Rental> rentals) {
        return "Amount owed is " + calculateTotalPrice(rentals) + "\n" + ("You earned " + calculateTotalRentalPoints(rentals) + " frequent renter points");
    }

    private int calculateTotalRentalPoints(List<Rental> rentals) {
        return rentals.stream()
                .mapToInt(Rental::calculateFrequentRenterPoints)
                .sum();
    }

    private double calculateTotalPrice(List<Rental> rentals) {
        return rentals.stream()
                .mapToDouble(Rental::calculatePrice)
                .sum();
    }

    private String formatBodyLine(Rental rental) {
        return "\t" + rental.getMovie().getTitle() + "\t" + rental.calculatePrice() + "\n";
    }

    private String formatHeader(String customerName) {
        return "Rental Record for " + customerName + "\n";
    }

}
