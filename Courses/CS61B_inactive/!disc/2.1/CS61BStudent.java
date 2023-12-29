public class CS61BStudent { // class declaration
    public int idNumber; // instance variables
    public int grade;
    public static String instructor = "Hug"; // class (static) variables

    public CS61BStudent(int id) { // constructor
        this.idNumber = id;
        this.grade = 100;
    }

    public void watchLecture() { // instance method
        ...
    }

    public static String getInstructor() { // static method
        ...
    }
}
