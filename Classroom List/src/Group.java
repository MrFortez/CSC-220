

public class Group {
    // The array storing the students in this group
    private Student[] members;

    // The number of students in the group. The same as doing members.length but not including null items.
    private int numOfStudents = 0;

    // A static variable storing the target size for groups. 
    // Note that if the total number of students isnt evenly divisable by
    // the size, then this progam will place the remaining students into their 
    // own group, with the empty slots of the group being set to null.
    // 2 is the default, but it can be changed by the user.
    private static int targetGroupSize = 2;

    public Group() {
        members = new Student[targetGroupSize];
    }

    public static void setTargetGroupSize(int size) {
        Group.targetGroupSize = size;
    }

    public static int getTargetGroupSize() {
        return targetGroupSize;
    }

    // Takes in any number of student objects, and takes those student
    // objects and adds them into any non occupied spots in this group.
    // If the group beoomes full, any remaining students will not be added.
    public void populateGroup(Student... students) {

        // i is the group index, and j is the index for the array of students passed into this function.
        // The loop will stop when either of these indexes surpass the limit of their respective array.
        for (int i = 0, j = 0; (i < members.length) && (j < students.length); i++) {
            if (members[i] == null) {
                members[i] = students[j];
                j++;

                numOfStudents++;
            }
        }
    }

    // Calculates the sum of the compatability between each student by the group, 
    // then divides it by the number of students in the group.
    public double getGroupScore() {
        int score = 0;
        
        // Loop through the members of this group.
        for (int i = 0; i < members.length; i++) {

            // Another loop that is offset by the outer loop by +1. The way these 
            // indexes are updated, these for loops will check the compatability of
            // every possible pair of the students in this group exactly once.
            for (int j = i + 1; j < getNumberOfStudents(); j++) {
                score += members[i].getCompatabilityScore(members[j]);
            }
        }
                
        return score / (double) getNumberOfStudents();
    }

    // Get the number of students in the group. This is different from
    // members.length in the case where the group is not full.
    // Note that the way students are added to groups, all null(empty) slots
    // will be at the back of the array. 
    public int getNumberOfStudents() {
        // int count = 0;
        // for (Student member : members) {
        //     if (member == null) {
        //         break;
        //     }
        //     count++;
        // }

        // return count;
        return numOfStudents;
    }

    // Returns the student object at the given index
    public Student getStudent(int index) {
        try {
            return members[index];
        }
        catch (Exception e) {
            System.err.println("Invalid Index; in getStudent()");
            return null;
        }
    }

    // Replaces the student at the given index with the given student.
    public void replaceStudent(int index, Student newStudent) {
        try {
            members[index] = newStudent;
        }
        catch (Exception e) {
            System.err.println("Invalid Index; in replaceStudent()");
        }
    }

    public String toString() {
        String result = "Members: [";
        for (int i = 0; i < getNumberOfStudents(); i++) {
            result += members[i].getName();
            result += (i == (getNumberOfStudents() - 1)) ? "] " : ", ";
        }

        result += "Group Score: " + getGroupScore();

        return result;
    }
}
