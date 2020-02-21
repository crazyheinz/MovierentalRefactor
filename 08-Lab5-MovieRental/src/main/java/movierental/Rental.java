package movierental;

import static movierental.Movie.Type.NEW_RELEASE;

/**
 * The rental class represents a customer renting a movie.
 */
public class Rental {

    private final Movie movie;
    private final int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public int calculateFrequentRenterPoints() {
        boolean isNewRelease = movie.getType() == NEW_RELEASE ;
        int frequentRenterPoints = 1;
        if (isNewRelease && daysRented >= 2) {
            frequentRenterPoints++;
        }
        return frequentRenterPoints;
    }

    public double calculatePrice() {
        return movie.getPriceMovie(this);
    }

}
