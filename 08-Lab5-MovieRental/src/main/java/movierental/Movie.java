package movierental;

public class Movie {

    protected enum Type {
        CHILDRENS, NEW_RELEASE, REGULAR
    }
    private final String title;
    private final Type priceCode;

    public Movie(String title, Type priceCode) {
        this.title = title;
        this.priceCode = priceCode;
    }

    public Type getPriceCode() {
        return priceCode;
    }

    public String getTitle() {
        return title;
    }


}
