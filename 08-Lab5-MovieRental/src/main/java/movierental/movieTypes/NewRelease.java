package movierental.movieTypes;

import movierental.Movie;
import movierental.Rental;

public class NewRelease extends Movie {
    public NewRelease(String title, Movie.Type priceCode) {
        super(title, priceCode);
    }

    @Override
    public double getPriceMovie(Rental rental) {
        return rental.getDaysRented() * 3;
    }
}
