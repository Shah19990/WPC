public class Review {
    private String text;
    private int rating;
    private Customer author;

    public Review(String text, int rating, Customer author) {
        this.text = text;
        this.rating = rating;
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public int getRating() {
        return rating;
    }

    public Customer getAuthor() {
        return author;
    }
}