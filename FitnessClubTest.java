import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class FitnessClubTest {
    private FitnessClub fitnessClub;

    @BeforeEach
    public void setUp() {
        fitnessClub = new FitnessClub();
        Lesson lesson1 = new Lesson("Yoga", "Monday", 10, 5);
        Lesson lesson2 = new Lesson("Zumba", "Tuesday", 12, 7);
        Lesson lesson3 = new Lesson("Pilates", "Thursday", 15, 8);
        fitnessClub.addLesson(lesson1);
        fitnessClub.addLesson(lesson2);
        fitnessClub.addLesson(lesson3);
    }

    @Test
    public void testAddLesson() {
        Lesson lesson = new Lesson("Boxing", "Friday", 17, 6);
        fitnessClub.addLesson(lesson);
        List<Lesson> fridayLessons = fitnessClub.getLessonsByDay("Friday");
        Assertions.assertTrue(fridayLessons.contains(lesson));
    }

    @Test
    public void testGetLessonsByType() {
        List<Lesson> yogaLessons = fitnessClub.getLessonsByType("Yoga");
        Assertions.assertEquals(1, yogaLessons.size());
        Assertions.assertEquals("Yoga", yogaLessons.get(0).getType());
    }

    @Test
    public void testGetLessonsByDay() {
        List<Lesson> tuesdayLessons = fitnessClub.getLessonsByDay("Tuesday");
        Assertions.assertEquals(1, tuesdayLessons.size());
        Assertions.assertEquals("Zumba", tuesdayLessons.get(0).getType());
    }

    @Test
    public void testAddCustomerToLesson() {
        Lesson lesson1 = new Lesson("Yoga", "Monday", 10, 2);
        Customer customer1 = new Customer("John");
        Customer customer2 = new Customer("Jane");
        Assertions.assertTrue(lesson1.addCustomer(customer1));
        Assertions.assertTrue(lesson1.addCustomer(customer2));
        Assertions.assertFalse(lesson1.addCustomer(new Customer("Mike")));
    }

    @Test
    public void testRemoveCustomerFromLesson() {
        Lesson lesson1 = new Lesson("Yoga", "Monday", 10, 2);
        Customer customer1 = new Customer("John");
        Customer customer2 = new Customer("Jane");
        lesson1.addCustomer(customer1);
        lesson1.addCustomer(customer2);
        lesson1.removeCustomer(customer1);
        Assertions.assertEquals(1, lesson1.getCustomers().size());
        Assertions.assertFalse(lesson1.getCustomers().contains(customer1));
    }
}