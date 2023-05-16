import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CS61B {
    // variables (part b)
    private final String university = "UC Berkeley";
    private String semester;
    private List<String> students;
    private HashMap<Integer, String> idToStudent;

    // constructor (parts a, c)
    public CS61B(int capacity, HashMap<Integer, String> ids, String semester) {
        students = (List<String>)ids.values();
        idToStudent = ids;
        this.semester = semester;
    }

    //methods (part d)

}
