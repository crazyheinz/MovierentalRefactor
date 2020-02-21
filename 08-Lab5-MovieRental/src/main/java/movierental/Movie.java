package movierental;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public abstract class Movie {

    protected enum Type {
        CHILDRENS, NEW_RELEASE, REGULAR
    }
    private final String title;
    private final Type type;

    public Movie(String title, Type type) {
        this.title = title;
        this.type = type;
    }

    public double getPriceMovie(Rental rental) {
        return 5.0;
    }

    public Type getType() {
        return type;
    }

    public String getTitle() {
        return title;
    }


}
