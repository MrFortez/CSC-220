import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class GroupTest {
    public static void main(String[] args) {

        // Generate the array of Students.
        Student[] students = generateStudentList();

        // Print out the preference scores, used for testing.
        for (Student student : students) {
            String result = "[";
            for (int i = 0; i < student.getPreferences().length; i++) {
                result += student.getPreferences()[i];
                result += (i == (student.getPreferences().length - 1)) ? "] " : ", ";
            }
            System.out.println(result);
        }

        // Create a Scanner for user input.
        Scanner inputScanner = new Scanner(System.in);

        // String input is used to store the user's input.
        String input = "";

        // boolean validSize is used to loop the input prompt until the user inputs a valid group size.
        boolean validSize = false;

        // Loop until the user inputs a valid group size.
        while (!validSize) {
            System.out.print("How many students will be in each group?  ");

            // Get the user's input
            input = inputScanner.nextLine();

            // The try is here incase the user inputs anything other than an integer.
            try {

                // This checks whether the user's inputed number is a valid size. 
                // This is defined as being between 2 Students and half the total number of students rounded up.
                // Any other group size is nonsensical in the context of a classroom.
                // We round up in case the number of students is odd and the teacher wants to split the group in half.
                if ((Integer.parseInt(input)) >= 2 && (Integer.parseInt(input) <= Math.ceilDiv(students.length, 2))) {
                    validSize = true;
                }
                else {
                    System.out.println("The group size must be between 2 and " + Math.ceilDiv(students.length, 2));
                }
            }
            catch (Exception e){
                System.err.println("The size has to be an integer.");
            }
        }
        Group.setSize(Integer.parseInt(input));





    }

    // Accesses the csv file and creates an array of students with the data from that file.
    public static Student[] generateStudentList() {
        try {
            FileReader fr = new FileReader("compatability_withnames.csv");
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            String name = "";
            String[] tempArray;
            int[] preferences;

            Student[] students = new Student[20];

            // Burn the first line of the csv because its just names and I dont care about
            // it.
            br.readLine();

            // Read and attached the first student's line (aka belle walters) to a String.
            line = br.readLine();

            // Loop through the rest of the csv file until the read line is null.
            // Also keeping track of what the line number is via i.
            for (int i = 0; line != null; i++) {

                // Parse the line into a String array by comma.
                tempArray = line.split(",");

                // Take the first element of the array, the name of the student, and attach it
                // to a String variable.
                name = tempArray[0];

                // Create a new array to put the preference rankings in for each student. 
                preferences = new int[20];

                // Iterate through the rest of the line. For each element, convert it into an int and put it into an int array.
                for (int j = 1; j < tempArray.length; j++) {
                    preferences[j - 1] = Integer.parseInt(tempArray[j]);
                }

                // For each line, create a new student object and put it into the student array
                students[i] = new Student(name, i, preferences);

                // Read the next line and attach it to a String variable
                line = br.readLine();
            }

            // Close the buffered reader because I no longer need its services.
            br.close();

            // Prints out each student's name, list number, and preference rankings. Used for testing purposes.
            for (Student student : students) {
                System.out.println(student);
            }

            return students;
        

        } catch (Exception e) {
            System.err.println(e);
        }

        return null;
    }

}
