import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CS61B {
    // variables (part b)
    private static String university = "UC Berkeley";
    private String semester;
    private CS61BStudent[] students;
    private Map<Integer, CS61BStudent> idToStudent = new HashMap<>();

    // constructor (parts a, c)
    public CS61B(int capacity, List<Integer> ids, String semester) {
        students = new CS61BStudent[capacity];
        for (int i = 0; i < capacity; i++) {
            Integer newStudentId = ids.get(i);
            CS61BStudent newStudent = new CS61BStudent(newStudentId);
            students[i] = newStudent;
            idToStudent.put(newStudentId, newStudent);
        }
        this.semester = semester;
    }

    //methods (part d)
    public void makeAllStudentsWatchLecture() {
        for (CS61BStudent student : students) {
            student.watchLecture();
        }
    }

    public int updateGrade(Integer sid, int points) {
        CS61BStudent student = idToStudent.get(sid);
        student.grade += points;
        return student.grade;
    }

    public static void changeUniversity(String newUniversity) {
        university = newUniversity;
    }

}
