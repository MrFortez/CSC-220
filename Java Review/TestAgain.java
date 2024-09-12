class TestAgain {
    public static void main(String[] args) {
        String a = "abcdefghijklmnopqrstuvwxyz";
        String b = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        String c = combineStrings(a, b);
        System.out.println(c);


        
    }
    
    private static int getMax(int x, int y) {
        return x > y ? x : y; // I love being fancy :)
    }


    private static String combineStrings(String a, String b) {
        String newString = "";

        if (getMax(a.length(), b.length()) == a.length()) {
            for (int i = 0; i < b.length(); i++) {
                // Both Work
                // newString += String.valueOf(a.charAt(i)) + String.valueOf(b.charAt(i));
                newString += a.charAt(i) + "" + b.charAt(i);
            }
            newString += a.substring(b.length());
        }
        else {
            for (int i = 0; i < a.length(); i++) {
                // Both Work
                // newString += String.valueOf(a.charAt(i)) + String.valueOf(b.charAt(i));
                newString += a.charAt(i) + "" + b.charAt(i);
            }
            newString += b.substring(a.length());
        }

        return newString;
    }
}
