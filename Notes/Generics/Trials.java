package Notes.Generics;


public class Trials {

    public static void main(String[] args) {
        Integer[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        Double[] anotherArray = {4.56, 7.45, 5.4, 8.90, 0.543};
        Character[] yetAnotherArray = {'a', 'p', 'p', 'l', 'e', 's'};
        printArray(array);
        printArray(anotherArray);
    }

    // Type parameter: gaming
    // This is now used in place of the traditional types as a
    // placeholder. During excexution, gaming  will be replaced by the 
    // actual type e.g. int, char, double, as appropriate.
    public static <gaming> void printArray(gaming[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i] + " ");
        }
        System.out.println();
    }


}
