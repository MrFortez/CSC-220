class Test {

    public static void main(String[] args) {
        int numA = 7;
        int numB = 4;
        System.out.println(numA + " + " + numB + " = " + (numA + numB));

        System.out.println(addNumberz(numA, numB));

        System.out.println("The larger of " + numA + " and " + numB + " is " + getMax(numA, numB));

        System.out.println("The larger of " + numA + " and " + numB + " is " + getMaxButNormal(numA, numB));

        int score = 89;
        System.out.println("With a score of " + score + ", your grade is " + getGrade(score));

        float pi = (float) 3.14;

        int[] array;
        array = new int[6];

        int[] array2 = {1, 2, 3, 6, 4, 6, 8, 2, 6};

        printArray(array2);
    }


    private static int addNumberz(int x, int y) {
        return x + y;
    }

    private static int getMax(int x, int y) {
        return x > y ? x : y; // I love being fancy :)
    }

    private static int getMaxButNormal(int x, int y) {
        if (x > y) {
            return x;
        }
        return y;
    }

    private static char getGrade(int score) {
        if (score >= 90) {
            return 'A';
        }
        else if (score >= 80) {
            return 'B';
        }
        else if (score >= 70) {
            return 'C';
        }
        else if (score >= 60) {
            return 'D';
        }
        return 'F';
    }

    private static void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + ", ");
        }
    }
}