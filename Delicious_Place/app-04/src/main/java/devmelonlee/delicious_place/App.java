package devmelonlee.delicious_place;

import java.util.Scanner;

public class App {
  public static void main(String[] args) {
    System.out.println("나의 맛집 리뷰 시스템");
    System.out.println("----------------------------------");
    
    Scanner sc = new Scanner(System.in);

    System.out.print("번호? ");
    int no = sc.nextInt();

    System.out.print("아이디? ");
    String id = sc.next();

    System.out.print("나이? ");
    int age = sc.nextInt();

    System.out.print("성별(남자:M, 여자:W)? ");
    String str = sc.next();
    char gender = str.charAt(0);

    System.out.print("리뷰 내용을 적어주세요 : ");
    String content = sc.next();
    
    System.out.print("영수증 있으신가요? : ");
    boolean isReceipt = sc.nextBoolean();

    System.out.print("평점은요 (1, 2, 3, 4, 5)? : ");
    int starRaiting = sc.nextInt();

    System.out.println("---------------------------------------");

    System.out.printf("번호: %d\n", no);
    System.out.printf("아이디: %s\n", id);
    System.out.printf("나이: %d\n", age);
    System.out.printf("성별(남자(M), 여자(W)): %c\n", gender);
    
    System.out.printf("리뷰 내용: %s\n", content);
    System.out.printf("영수증: %b\n", isReceipt);
    System.out.printf("평점: %d\n", starRaiting);
  }
}
