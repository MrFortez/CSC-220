public class Test {

    public static void main(String[] args) {
        F(9);
        System.out.println();
        F(170);
        System.out.println();
        F(48);
        System.out.println();
        F(482875);
        System.out.println();

    }

    public static void F(int n) {
        if (n < 0) {
            F(-n);
        }

        System.out.print(n % 10);
        
        if (n >= 10) {
            F(n / 10);
        }
        
        
  
          
        
        
    }
}
