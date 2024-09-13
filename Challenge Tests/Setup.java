public class Setup {
  // colors used
  public static final int CYAN   = 36;
  public static final int MAGENTA= 35;
  public static final int GREEN  = 32;

  public static void main(String[] args) {
    // used to ensure you are running on a linux-like terminal
    String hello = c(CYAN, "Java ");
    String world = c(MAGENTA, "Setup ");
    String bang = c(GREEN, "Finished");
    System.out.print(hello + world + bang);
    
    // used to ensure you are using the right version of Java
    String day = "SUNDAY";
    boolean isTodayHoliday = switch (day) {
      case "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY" -> false;
      case "SATURDAY", "SUNDAY" -> true;
      default -> throw new IllegalArgumentException("What's a " + day);
    };
  }
  
  // used to print colorful text
  public static String c(int num, String msg) {
    return "\033[" + num + "m" + msg + "\033[39m";
  }
}
