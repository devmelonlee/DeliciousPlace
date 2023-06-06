package devmelonlee.delicious_place;

import java.util.Scanner;

public class App {
  public static void main(String[] args) {
    System.out.println("나의 맛집 리뷰 시스템");
    System.out.println("----------------------------------");
    
    Scanner sc = new Scanner(System.in);

    final int SIZE = 100;

    int[] no = new int[SIZE];
    String[] id = new String[SIZE];
    int[] age = new int[SIZE];
    char[] gender = new char[SIZE];
    String[] content = new String[SIZE];
    boolean[] isReceipt = new boolean[SIZE];
    int[] starRaiting = new int[SIZE];

    for (int i = 0; i < SIZE; i++) {
      System.out.print("번호? ");
      no[i] = sc.nextInt();
  
      System.out.print("아이디? ");
      id[i] = sc.next();
  
      System.out.print("나이? ");
      age[i] = sc.nextInt();
  
      System.out.print("성별(남자:M, 여자:W)? ");
      String str = sc.next();
      gender[i] = str.charAt(0);
  
      System.out.print("리뷰 내용을 적어주세요 : ");
      content[i] = sc.next();
      
      System.out.print("영수증 있으신가요? : ");
      isReceipt[i] = sc.nextBoolean();
  
      System.out.print("평점은요 (1, 2, 3, 4, 5)? : ");
      starRaiting[i] = sc.nextInt();
    }

    System.out.println("---------------------------------------");

    for (int i = 0; i < SIZE; i++) {
    System.out.printf("번호: %d\n", no[i]);
    System.out.printf("아이디: %s\n", id[i]);
    System.out.printf("나이: %d\n", age[i]);
    System.out.printf("성별(남자(M), 여자(W)): %c\n", gender[i]);
    
    System.out.printf("리뷰 내용: %s\n", content[i]);
    System.out.printf("영수증: %b\n", isReceipt[i]);
    System.out.printf("평점: %d\n", starRaiting[i]);
    }

    sc.close();
  }
}
