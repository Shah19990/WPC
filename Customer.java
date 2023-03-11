import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private List<Lesson> bookedLessons;

    public Customer(String name) {
        this.name = name;
        this.bookedLessons = new ArrayList<>();
    }

    public boolean bookLesson(Lesson lesson) {
        if (lesson.addCustomer(this)) {
            bookedLessons.add(lesson);
            return true;
        }
        return false;
    }

    public boolean changeBooking(Lesson oldLesson, Lesson newLesson) {
        if (newLesson.addCustomer(this)) {
            bookedLessons.remove(oldLesson);
            bookedLessons.add(newLesson);
            oldLesson.removeCustomer(this);
            return true;
        }
        return false;
    }

    public void cancelBooking(Lesson lesson) {
        bookedLessons.remove(lesson);
        lesson.removeCustomer(this);
    }

    public String getName() {
        return name;
    }

    public List<Lesson> getBookedLessons() {
        return bookedLessons;
    }
}