import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
import java.util.Random;

class GroupTest {
    public static void main(String[] args) {

        // Generate the array of Students.
        Student[] students = generateStudentList();

        // Prints out each student's name, list number, and preference rankings. Used for testing purposes.
        //  for (Student student : students) {
        //     System.out.println(student);
        // }
        
        // Print out the preference scores, used for testing.
        // for (Student student : students) {
        //     String result = "[";
        //     for (int i = 0; i < student.getPreferences().length; i++) {
        //         result += student.getPreferences()[i];
        //         result += (i == (student.getPreferences().length - 1)) ? "] " : ", ";
        //     }
        //     System.out.println(result);
        // }

        // have the user input the group size
        userInputedGroupSize(students);

        // Generate random groups
        Group[] groups = generateRandomGroups(students);

        // Optimize the groups
        hillClimbingAlgorithm(groups, students.length);
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

            // Burn the first line of the csv because its just names and I dont care about it.
            br.readLine();

            // Read and attached the first student's line (aka Belle Walters in the example csv) to a String.
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

            return students;
        

        } catch (Exception e) {
            System.err.println(e);
        }

        return null;
    }

    // Sets the group size via the user's input.
    public static void userInputedGroupSize(Student[] students) {

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

        // Set the target group size. Note that this is not necessarily the number of students in each group. It is
        // instead the capacity of each group.
        Group.setTargetGroupSize(Integer.parseInt(input));

        // Close the scanner to prevent memory leaks.
        inputScanner.close();

    }

    // Generates N/s groups (where N is the number of students and s is the size of each group, with the remainder being its own group)
    // Each group will consist of a random assortment of students from the given list.
    public static Group[] generateRandomGroups(Student[] students) {

        // Randomize the order of students.
        Student[] randomStudents = shuffle(students);

        // Declare and Initialize an array of ceil(N/s) groups. 
        Group[] groups = new Group[Math.ceilDiv(students.length, Group.getTargetGroupSize())];

        // Used to keep track of our position in the randomStudents array.
        int index = 0;

        // Loop through and initialize each group in the groups list.
        for (int i = 0; i < groups.length; i++) {
            groups[i] = new Group();

            // For each group, we need to fill each of it's slots with the next 
            // student in the randomStudents list.
            for (int j = 0; j < Group.getTargetGroupSize(); j++, index++) {

                // breaking the loop when the final group has more slots but there
                // are no students remaining, so as to not cause a ListOutOfBounds exception.
                if (index >= randomStudents.length) {
                    break;
                }
                
                // Add the student into the group.
                groups[i].populateGroup(randomStudents[index]);
            }
        }

        return groups;
    }

    // Employs a hill climbing algorithm to optimize the groups. Essentially,
    // it randomly swaps two students, and if that swap improves the overall score,
    // the swap is kept, otherwise the swap is undone. This is repeated an arbitrary 
    // number of times relative to the number of students in the class to create 
    // a set of groups with high compatability scores.
    public static void hillClimbingAlgorithm(Group[] groups, int numOfStudents) {

        // create a variable to store the total group score (aka all of the group scores added together).
        double totalGroupScore = 0;
       
        // print out the starting group scores after the initial randomization, and add up their group scores.
        for (Group group : groups) {
            System.out.println(group);
            totalGroupScore += group.getGroupScore();
        }

        // print out the total group score prior to hill climbing
        System.out.println("Average Group Score: " + (totalGroupScore / (double) groups.length));

        // Perform numOfStudents * 1000 random swaps (so with the example csv file with 20 students, it'll do 20,000 random swaps)
        for (int i = 0; i < (numOfStudents * 1000); i++) {
            randomSwap(groups);
        }

        // New line for formating.
        System.out.println();

        // Reset the total group score.
        totalGroupScore = 0;

        // Print out each group after the hill climbing, and add up their group scores.
        for (Group group : groups) {
            System.out.println(group);
            totalGroupScore += group.getGroupScore();
        }

        // Print out the final average group score.
        System.out.println("Average Group Score: " + (totalGroupScore / (double) groups.length));
    }

    // randomly chooses a student from two different groups. If swapping the 
    // chosen students would increase the combined compatability score,
    // this function will swap them.
    public static void randomSwap(Group[] groups) {
        
        // Makes an object of the random class.
        Random random = new Random();

        // temp variables used to keep track of which two groups we are swapping between
        Group targetGroupA;
        Group targetGroupB;

        // The indexes of the students that we are swapping.
        int targetIndexA;
        int targetIndexB;

        double originalScore;
        double newScore;

        // Target a random group from the given groups array.
        targetGroupA = groups[random.nextInt(groups.length)];

        // Ensure that the target groups are different
        do {
            targetGroupB = groups[random.nextInt(groups.length)];
        }
        while (targetGroupB.equals(targetGroupA));
       
        // Randomly decide which student in each group will be swapped.
        targetIndexA = random.nextInt(targetGroupA.getNumberOfStudents());
        targetIndexB = random.nextInt(targetGroupB.getNumberOfStudents());

        // Store the original score prior to swapping.
        originalScore = targetGroupA.getGroupScore() + targetGroupB.getGroupScore();

        // Swap.
        swapBetweenGroups(targetGroupA, targetGroupB, targetIndexA, targetIndexB);

        // Store the new score post swapping.
        newScore = targetGroupA.getGroupScore() + targetGroupB.getGroupScore();

        // If the original score was higher, undo the swap.
        if (originalScore > newScore) {
            swapBetweenGroups(targetGroupA, targetGroupB, targetIndexA, targetIndexB);
        }


    }

    // Given two Groups, swap the student at indexA with the student at indexB
    public static void swapBetweenGroups(Group groupA, Group groupB, int indexA, int indexB) {
        Student temp = groupA.getStudent(indexA);
        groupA.replaceStudent(indexA, groupB.getStudent(indexB));
        groupB.replaceStudent(indexB, temp);
    }


    // Helper function, returns the given array with the order of its items randomized.
    public static <T> T[] shuffle(T[] array) {
        // Makes an object of the random class.
        Random random = new Random();

        // Loop through the array, such that each item will be swapped at least once.
        for (int i = 0; i < array.length; i++) {

            // Generate the position that the item at index i will be swapped with.
            int swapIndex = random.nextInt(array.length - 1);

            // Swap.
            T temp = array[i];
            array[i] = array[swapIndex];
            array[swapIndex] = temp;

        }

        return array;
    }

  
}




