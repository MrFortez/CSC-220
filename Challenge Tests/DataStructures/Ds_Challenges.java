
import java.util.Random;

public class Ds_Challenges {
  // main function used to test
  public static void main(String[] args) {
    Random rand = new Random();
    
    /// test challenge 0
    // String str = "";
    // int size = rand.nextInt(4) + 2;
    // for(int i = 0; i < size; i++) {
    //   int charIndex = rand.nextInt(26);
    //   char ch = (char)((int)'a' + charIndex);
    //   str += ch;
    // }
    // List<Character> list = c0(str);
    // System.out.println("Original String: " + str);
    // System.out.println("As List: {" + list + "}");
    
    /// test challenge 1
    // List<Integer> numbers = new List<>();
    // int size = rand.nextInt(12) + 2;
    // for(int i = 0; i < size; i++) {
      // int number = rand.nextInt(99);
      // numbers.append(number);
    // }
    // Queue<Integer> queue = c1(numbers);
    // System.out.println("\nNumbers in a list: " + numbers + "\n");
    // System.out.println("Numbers in a queue: " + queue);
    
    /// test challenge 2
    // Queue<Float> queue = new Queue<>();
    // int size = rand.nextInt(8) + 2;
    // for(int i = 0; i < size; i++) {
      // float number = rand.nextFloat();
      // queue.enqueue(number);
    // }
    // System.out.println("Original Queue" + queue + "\n\n");
    // Queue<Float> revQueue= c2(queue);
    // System.out.println("Reversed Queue:" + revQueue);
    
    
    /// test challenge 3
    // int size = rand.nextInt(8) + 2;
    // char[] letters = new char[size];
    // int[] numbers = new int[size];
    // for(int i = 0; i < size; i++) {
      // int letterIndex = rand.nextInt(26);
      // char letter = (char)((int)'A' + letterIndex);
      // letters[i] = letter;
      // numbers[i] = rand.nextInt(9999);
    // }
    // System.out.print("\nLetters: ");
    // for(int i = 0; i < size; i++) {
      // System.out.print(letters[i] + " ");
    // }
    // System.out.println();
    // System.out.print("Numbers: ");
    // for(int i = 0; i < size; i++) {
      // System.out.print(numbers[i] + " ");
    // }
    // System.out.println();
    // Stack<String> result = c3(letters, numbers);
    // System.out.print(result);
    // System.out.println("  Stack");
    
    /// test challenge 4
    int rows = rand.nextInt(8) + 3;
    int cols = rand.nextInt(8) + 3;
    int[][] numbers = new int[rows][cols];
    for(int r = 0; r < rows; r++) {
      for(int c = 0; c < cols; c++) {
        numbers[r][c] = rand.nextInt(89) + 10;
      }
    }
    System.out.println("Matrix of numbers:");
    for(int r = 0; r < rows; r++) {
      for(int c = 0; c < cols; c++) {
        if (c == cols - 1)
          System.out.print(numbers[r][c]);
        else
          System.out.print(numbers[r][c] + ", ");
      }
      System.out.println();
    }
    System.out.println();
    List<List<Integer>> list = c4(numbers);
    System.out.println("List of List of numbers:");
    for(int r = 0; r < list.size(); r++) {
      System.out.println(list.getValueAt(r));
    }
  }
  

  // \/ challenge functions go below - c0 has been started for you \/
  
  public static List<Character> c0(String str) {
    // List list = new List();
    // for (int i = 0; i < str.length(); i++) {
    //   list.append(Character.valueOf(str.charAt(i)));
    // }

    // return list;
    List<Character> result = new List<Character>();
    // char[] charArray = str.toCharArray();
    // for (int i = 0; i < str.length(); i++)
    // {
    //   result.append(charArray[i]);
    // }
    return result;
  }

  public static Queue<Integer> c1(List<Integer> numbers) {
    Queue<Integer> queue = new Queue<Integer>();

    for (int i = 0; i < numbers.size(); i++) {
      if (numbers.getValueAt(i) % 3 == 0 || numbers.getValueAt(i) % 5 == 0) {
        queue.enqueue(numbers.getValueAt(i));
      }
    }

    return queue;
  }

  public static Queue<Float> c2(Queue<Float> nums) {
    Stack<Float> stack = new Stack<Float>();
    Queue<Float> result = new Queue<Float>();
    Float temp = null;
    while ((temp = nums.dequeue()) != null) {
      stack.push(temp);
    }

    while ((temp = stack.pop()) != null) {
      result.enqueue(temp);
    } 
    
    return result;
  }

  public static Stack<String> c3(char[] chars, int[] nums) {
    Stack<String> result = new Stack<String>();
    String temp = "";

    for (int i = 0; i < nums.length; i++) {
      temp = chars[i] + ":" + nums[i];
      result.push(temp);
    }

    return result;
  }

  public static List<List<Integer>> c4(int[][] numbers) {
    List<List<Integer>> result = new List<List<Integer>>();

    for (int i = 0; i < numbers.length; i++) {
      result.append(new List<Integer>());
    }


    for (int i = 0; i < numbers.length; i++) {
      for (int col : numbers[i]) {
        result.getValueAt(i).append(col);
      }
    }

    return result;
  }
}

