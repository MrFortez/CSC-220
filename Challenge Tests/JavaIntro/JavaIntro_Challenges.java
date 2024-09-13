import java.util.Arrays;
import java.util.Random;

public class JavaIntro_Challenges {
  // main function used to test
  public static void main(String[] args) {
    // test challenge 0
    // System.out.println("\"" + c0(3.14f, 2, 1) + "\"");      // should print "003.140"
    // System.out.println("\"" + c0(12.34567f, 4, 1) + "\"");  // should print "000012.345670"
    // System.out.println("\"" + c0(486.57513f, 0, 7) + "\""); // should print "486.575130000000"
    // System.out.println("\"" + c0(1.7f, 0,0 ) + "\"");       // should print "1.7"
    // System.out.println();
    
    // test challenge 1
    // System.out.println("\"" + c1(1, 10) + "\""); // should print "abcdefghij"
    // System.out.println("\"" + c1(8, 15) + "\""); // should print "hijklmno"
    // System.out.println("\"" + c1(5,  6) + "\""); // should print "ef"
    // System.out.println("\"" + c1(14,14) + "\""); // should print "n"
    // System.out.println("\"" + c1(3,  1) + "\""); // should print ""
    // System.out.println();

    // test challenge 2
    // System.out.println("\"" + c2(1) + "\"");    // should print "Password123"
    // System.out.println("\"" + c2(67) + "\"");   // should print "lemonfish"
    // System.out.println("\"" + c2(1000) + "\""); // should print "12341234"
    // System.out.println("\"" + c2(10) + "\"");   // should print "123456"
    // System.out.println();
    
    // test challenge 3
    // System.out.println("\"" + c3( 5) + "\""); // should print "up up down down left"
    // System.out.println("\"" + c3(12) + "\""); // should print "up up down down left right left right b a select start"
    // System.out.println("\"" + c3( 1) + "\""); // should print "up"
    // System.out.println("\"" + c3( 0) + "\""); // should print ""
    // System.out.println();
    
    // test challenge 4
    // System.out.println(arrayToString(c4("48975165")));           // should print {5, 3}
    // System.out.println(arrayToString(c4("286644000")));          // should print {0, 9}
    // System.out.println(arrayToString(c4("5Hello78World00!!")));  // should print {2, 3}
    // System.out.println(arrayToString(c4("No-Digits_Are Here"))); // should print {0, 0}
    // System.out.println(arrayToString(c4("")));                   // should print {0, 0}
    // System.out.println();

    
    // test challenge 5
    // System.out.println("\"" + c5(150) + "\"");    // should print "Bulma"
    // System.out.println("\"" + c5(55000) + "\"");  // should print "Vegeta"
    // System.out.println("\"" + c5(50000) + "\"");  // should print "Piccolo"
    // System.out.println("\"" + c5(0) + "\"");      // should print "Bulma"
    // System.out.println("\"" + c5(900000) + "\""); // should print "Goku"
    // System.out.println();
    
    // test challenge 6
    // System.out.println("\"" + c6(10, 527) + "\""); // should print "5 6 10 11 17 43 47 52 60 66"
    // System.out.println("\"" + c6(5, 86) + "\"");   // should print "0 1 12 17 29"
    // System.out.println("\"" + c6(17, 65) + "\"");  // should print "6 15 20 24 26 27 27 27 28 35 43 48 54 60 61 65 68"
    // System.out.println();
    
    // test challenge 7
    System.out.println(c7( 5, 2.0f));
    System.out.println(c7(20, 3.2f));
    System.out.println(c7(25, 4.5f));
    System.out.println(c7(30, 5.0f));
    System.out.println(c7(35, 6.0f));
  }
  
  // helper functions
  private static String arrayToString(int[] array) {
    String result = "";
    for(int i = 0; i < array.length; i++) {
      if (i == array.length - 1) {
        result += array[i] + "";
      }
      else {
        result += array[i] + " ";
      }
    }
    result += "";
    return result;
  }
  
  
  // \/ challenge functions go here \/
  public static String c0(float number, int leadingZeros, int trailingZeros) {
    String text = String.valueOf(number);
    String dummyString1 = "";
    for (int i = 0; i < leadingZeros; i++) {
      text = "0" + text;
    }
    for (int i = 0; i < trailingZeros; i++) {
      text = text + "0";
    }
    return text;
  }

  public static String c1(int start, int stop) {
    char[] chars = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l',
 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    String text = "";
    for (int i = start - 1; i < stop; i++) {
      text += String.valueOf(chars[i]);
    }
    return text;
  }

  public static String c3(int end) {
    String[] code = {"up ", "up ", "down ", "down ", "left ", "right ", "left ", "right ", "b ", "a ", "select ", "start "};
    String text = "";
    for (int i = 0; i < end; i++) {
      text += code[i];
    }
    return text;
  }

  public static String c2(int seed) {
    String[] passwords = {"123456", "password", "Qwerty123","Abc123", "lemonfish", "sunshine", "Password123", "12341234", "1234567890"};
    Random random = new Random();
    random.setSeed(seed);
    return passwords[random.nextInt(9)];
  } 

  public static String c5(int power) {
    if (power > 87500) {
      return "Goku";
    }
    if (power > 50000) {
      return "Vegeta";
    }
    if (power > 20000) {
      return "Piccolo";
    }
    if (power > 8000) {
      return "Gohan";
    }
    if (power > 502) {
      return "Krillin";
    }
    return "Bulma";
  }

  public static int[] c4(String val)
  {
    int odd = 0;
    int even = 0;

    for (int i = 0; i < val.length(); i++) {
        if (Character.isDigit(val.charAt(i)) && (int)val.charAt(i) % 2 == 0) { 
          even++;
        }
        else if (Character.isDigit(val.charAt(i)) && (int)val.charAt(i) % 2 == 1) {
          odd++;
        }
    
    }

    int[] array = {odd, even};
    return array;
  }
  
  public static String c6(int size, int seed)
  {
    int[] array = new int[size];
    Random number = new Random();
    number.setSeed(seed);
    for (int i = 0; i<size; i++){


      int value = number.nextInt(75);
      array[i] = value;
  
    }
    Arrays.sort(array);
    return arrayToString(array);
  }

  public static String c7(int boxWidth, float personHeight) {
    String message = "";
  
    if (personHeight <= 3.0)
      message = "You are a child";
    else if (3.3 < personHeight && personHeight <= 4.5)
      message = "Still growing";
    else if (4.7 < personHeight && personHeight <= 5.3)
      message = "Short adult";
    else if (5.5 < personHeight && personHeight <= 10.0)
      message = "Normal height adult";
    else
      message = "Unknown";

    double padding = Math.max(0, boxWidth - (message.length() + 4));
    String textBefore = " ".repeat((int)padding/2);
    String textAfter = " ".repeat((int)(padding + 1) / 2);
    // for (int i = 0; i < (padding / 2); i++) {
    //   textBefore += " ";
    // }
    // for (int i = 0; i < ((padding + 1) / 2); i++) {
    //   textAfter += " ";
    // } 

    String result = "*".repeat(boxWidth) + "\n";
    // for (int i = 0; i < boxWidth; i++) {
    //   result += "*";
    // }
    // result += "\n";
    result += "* " + textBefore + message + textAfter + " *\n";
    // for (int i = 0; i < boxWidth; i++) {
    //   result += "*";
    // }
    result += "*".repeat(boxWidth) + "\n";
    return result;
  }

}



