public class Main {
    public static void main(String[] args) {
        // create some customers
        Customer customer1 = new Customer("John");
        Customer customer2 = new Customer("Sarah");
        Customer customer3 = new Customer("Mike");

        // create some lessons
        Lesson lesson1 = new Lesson("Yoga", "Monday", 10, 5);
        Lesson lesson2 = new Lesson("Pilates", "Tuesday", 8, 4);
        Lesson lesson3 = new Lesson("Spinning", "Wednesday", 12, 6);

        // book some lessons
        customer1.bookLesson(lesson1);
        customer1.bookLesson(lesson2);
        customer2.bookLesson(lesson2);
        customer2.bookLesson(lesson3);
        customer3.bookLesson(lesson1);

        // print out the customers and their booked lessons
        System.out.println("Customers and their booked lessons:");
        for (Customer customer : new Customer[]{customer1, customer2, customer3}) {
            System.out.println(customer.getName() + ":");
            for (Lesson lesson : customer.getBookedLessons()) {
                System.out.println("  " + lesson.getType() + " on " + lesson.getDay() + " for $" + lesson.getPrice());
            }
        }

        // add some reviews
        lesson1.addReview(new Review("Great class!", 5, customer1));
        lesson1.addReview(new Review("Could be better", 3, customer2));
        lesson2.addReview(new Review("Amazing instructor", 4, customer3));

        // print out the average rating for each lesson
        System.out.println("Average ratings for each lesson:");
        for (Lesson lesson : new Lesson[]{lesson1, lesson2, lesson3}) {
            System.out.println(lesson.getType() + " on " + lesson.getDay() + ": " + lesson.getAverageRating() + " stars");
        }
    }
}