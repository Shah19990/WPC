import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FitnessClub {
    private Map<String, List<Lesson>> lessonsByType;
    private Map<String, List<Lesson>> lessonsByDay;

    public FitnessClub() {
        this.lessonsByType = new HashMap<>();
        this.lessonsByDay = new HashMap<>();
    }

    public void addLesson(Lesson lesson) {
        List<Lesson> lessonsOfType = lessonsByType.getOrDefault(lesson.getType(), new ArrayList<>());
        List<Lesson> lessonsOfDay = lessonsByDay.getOrDefault(lesson.getDay(), new ArrayList<>());
        lessonsOfType.add(lesson);
        lessonsOfDay.add(lesson);
        lessonsByType.put(lesson.getType(), lessonsOfType);
        lessonsByDay.put(lesson.getDay(), lessonsOfDay);
    }

    public List<Lesson> getLessonsByType(String type) {
        return lessonsByType.getOrDefault(type, new ArrayList<>());
    }

    public List<Lesson> getLessonsByDay(String day) {
        return lessonsByDay.getOrDefault(day, new ArrayList<>());
    }
}