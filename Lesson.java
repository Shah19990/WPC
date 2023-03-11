import java.util.ArrayList;
import java.util.List;

public class Lesson {
    private String type;
    private String day;
    private int price;
    private int maxCapacity;
    private List<Customer> customers;
    private List<Review> reviews;

    public Lesson(String type, String day, int price, int maxCapacity) {
        this.type = type;
        this.day = day;
        this.price = price;
        this.maxCapacity = maxCapacity;
        this.customers = new ArrayList<>();
        this.reviews = new ArrayList<>();
    }

    public boolean addCustomer(Customer customer) {
        if (customers.size() < maxCapacity) {
            customers.add(customer);
            return true;
        }
        return false;
    }

    public void removeCustomer(Customer customer) {
        customers.remove(customer);
    }

    public int getPrice() {
        return price;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void addReview(Review review) {
        reviews.add(review);
    }

    public double getAverageRating() {
        if (reviews.isEmpty()) {
            return 0;
        }
        double sum = 0;
        for (Review review : reviews) {
            sum += review.getRating();
        }
        return sum / reviews.size();
    }

    public String getType() {
        return type;
    }

    public String getDay() {
        return day;
    }
}