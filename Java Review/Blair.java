public class Blair {
    
    public static void main(String[] args) {
        int[][] array = new int[5][10];
        printArray(array);
    }

    public static void printArray(int[][] x) {
        for (int[] y : x) {
            for (int num : y) {
                System.out.print(num + ", ");
            }
            System.out.println();
        }

    }
}
