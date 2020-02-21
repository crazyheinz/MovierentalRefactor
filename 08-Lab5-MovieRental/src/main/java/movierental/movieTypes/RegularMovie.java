package movierental.movieTypes;

import movierental.Movie;
import movierental.Rental;

public class RegularMovie extends Movie {
    public RegularMovie(String title, Movie.Type priceCode) {
        super(title, priceCode);
    }

    @Override
    public double getPriceMovie(Rental rental) {

        double price = 2;
        if (rental.getDaysRented() > 2) {
            price += (rental.getDaysRented() - 2) * 1.5;
        }
        return price;
    }


}
