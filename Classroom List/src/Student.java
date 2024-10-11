

public class Student {
    // Student's name
    private String name;

    // The position in the csv table that the student is in, used for ease in accessing data
    private int listNumber;

    // The list of this student's prefrence rankings of the other students (aka the horizontal rows of numbers on the csv)
    private int[] preferences;

    public Student() {
        name = "";
        listNumber = 0;
    }

    public Student(String name, int listNumber, int[] preferences) {
        this.name = name;
        this.listNumber = listNumber;
        this.preferences = preferences;
    }

    public Student(String name, int listNumber) {
        this.name = name;
        this.listNumber = listNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setListNumber(int num) {
        listNumber = num;
    }

    public String getName() {
        return name;
    }

    public int getListNumber() {
        return listNumber;
    }

    public int[] getPreferences() {
        return preferences;
    }

    // Takes another Student object as a parameter, and returns *this* student's preference score for the given student.
    public int getPreferenceScore(Student other) {
        return preferences[other.getListNumber()];
    }

    // Takes another Student object as a parameter, and returns the sum of the students' preference for each other
    public int getCompatabilityScore(Student other) {
        return this.getPreferenceScore(other) + other.getPreferenceScore(this);
    }

    public String toString() {
        String result = "Name: " + name + "   List Number: " + listNumber + "   Preferences: [";
        for (int i = 0; i < preferences.length; i++) {
            result += preferences[i];
            result += (i == (preferences.length - 1)) ? "] " : ", ";
        }
        return result;
    }
}
