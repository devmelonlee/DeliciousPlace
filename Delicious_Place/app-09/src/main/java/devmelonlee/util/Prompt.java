package devmelonlee.util;

import java.util.Scanner;

public class Prompt {
  static Scanner sc = new Scanner(System.in);

  public static String inputString(String title) {
    System.out.print(title);
    return sc.nextLine();
  }
  
  public static String inputString() {
    return sc.nextLine();
  }
  
  public static Integer inputInteger(String title) {
    System.out.println(title);
    return sc.nextInt();
  }

  public static void close() {
    sc.close();
  }
  
}
