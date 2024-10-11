

public class Group {
    private Student[] members;
    private static int size = 2;

    public Group() {
        members = new Student[size];
    }

    public static void setSize(int size) {
        Group.size = size;
    }

    public double getGroupScore() {
        int score = 0;
        for (int i = 0; i <)
                score += studentA.getCompat
            }
        }
        return 0;
    }

    public String toString() {
        String result = "Members: [";
        for (int i = 0; i < members.length; i++) {
            result += members[i].getName();
            result += (i == (members.length - 1)) ? "] " : ", ";
        }

        result += "Group Score: " + getGroupScore();

        return result;
    }
}
