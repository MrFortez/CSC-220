public class JavaMiniSet_Challenges {
    // main function used to test
    public static void main(String[] args) {
        // test challenge 0
        // System.out.println(c0(3, 2));  // should print false
        // System.out.println(c0(4, 2));  // should print true
        // System.out.println(c0(5, 3));  // should print false
        // System.out.println(c0(6, 3));  // should print true
        // System.out.println();
        
        // test challenge 1
        // System.out.println("\"" + c1("x", 3) + "\"");     // should print "xxx"
        // System.out.println("\"" + c1("hello", 2) + "\""); // should print "hellohello"
        // System.out.println("\"" + c1("abc", 5) + "\"");   // should print "abcabcabcabcabc"
        // System.out.println();
    }
    
    // challenge functions go here
    public static boolean c0(int dividend, int divisor) {
        return dividend % divisor == 0 ? true : false;
    }

    public static String c1(String text, int repeatAmount) {
        String epicString = "";
        for (int i = 0; i < repeatAmount; i++) {
            epicString += text;
        }
        return epicString;
    }

}
