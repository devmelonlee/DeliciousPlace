package devmelonlee.delicious_place;

import java.util.Scanner;

public class App {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    final int MAX_SIZE = 100;
    int userId = 1;
    int length = 0;
    
    int[] no = new int[MAX_SIZE];
    String[] id = new String[MAX_SIZE];
    String[] email = new String[MAX_SIZE];
    String[] password = new String[MAX_SIZE];
    char[] gender = new char[MAX_SIZE];
    
    String[] content = new String[MAX_SIZE];
    int[] isReceipt = new int[MAX_SIZE];
    int[] starRaiting = new int[MAX_SIZE];
    
    printTitle();

    //리뷰 정보 등록
    for (int i = 0; i < MAX_SIZE; i++) {
      inputContents(sc, i, id, email, password, gender, content, isReceipt, starRaiting, no, userId);
      length++;

      if (!promptContinue(sc)) {
        break;
      }
    }

    printContents(length, no, id, email, gender, content, isReceipt, starRaiting);
    sc.close();
  }

  static void printTitle() {
    System.out.println("나의 맛집 리뷰 시스템");
    System.out.println("----------------------------------");
    
  }

  static void inputContents(Scanner sc, int i, String[] id, String[] email, String[] password, 
   char[] gender, String[] content, int[] isReceipt, int[] starRaiting, int[] no, int userId) {
    
    System.out.print("아이디를 입력해주세요 : ");
    id[i] = sc.next();

    System.out.print("이메일을 입력해주세요 : ");
    email[i] = sc.next();

    System.out.print("암호를 입력해주세요 : ");
    password[i] = sc.next();

    loop: while (true) {
      System.out.println("성별을 입력해주세요 : ");
      System.out.println("  1. 남자");
      System.out.println("  2. 여자");
      System.out.println("  3. 선택하지 않음");
      System.out.print("> ");
      String menuNo = sc.next();

      switch (menuNo) {
        case "1":
          gender[i] = 'M';
          break loop;
        case "2":
          gender[i] = 'W';
          break loop;
        case "3":
          gender[i] = 'N';
          break loop;  
        default:
          System.out.println("유효한 번호로 입력해주세요!");
      }
    }

    System.out.print("리뷰 내용을 적어주세요 : ");
    content[i] = sc.next();

    loop: while (true) {
      System.out.print("영수증 있으신가요? 예: 1, 아니오 : 2): ");
      int validReceipt = sc.nextInt();
      switch (validReceipt) {
        case 1:
          isReceipt[i] = 1;
          break loop;
        case 2:
          isReceipt[i] = 2;
          break loop;
        default:
          System.out.println("유효한 번호로 입력해주세요!");
      }
    }

    while (true) {
      System.out.print("평점은요 (1, 2, 3, 4, 5)? : ");
      int validStarRaiting = sc.nextInt();
      if (validStarRaiting >= 1 && validStarRaiting <= 5) {
        starRaiting[i] = validStarRaiting;
        break;
      }
      System.out.println("유효한 번호로 입력해주세요!");
    }

    no[i] = userId;
    
  }

  static boolean promptContinue(Scanner sc) {
    System.out.print("계속 입력하시겠습니까?(Y/n) ");
    sc.nextLine(); // 이전에 next()를 실행한 후 남아 있던 줄바꿈 코드를 제거한다.
    String response = sc.nextLine();
    if (!response.equals("") && !response.equalsIgnoreCase("Y")) {
      return false;
    }
    return true;
  }

  static void printContents(int length, int[] no, String[] id, String[] email, char[] gender, String[] content, int[] isReceipt, int[] starRaiting) {
    System.out.println("---------------------------------------");

    for (int i = 0; i < length; i++) {
      System.out.println("번호, 이름, 이메일, 성별");
      System.out.println("---------------------------------------");
      System.out.printf("%d, %s, %s, %c\n", no[i], id[i], email[i], gender[i]);
      System.out.println("리뷰 내용 : " + content[i]);
      System.out.println("영수증 여부 : "+ isReceipt[i] + " 별점 : " + starRaiting[i]);
      System.out.println("---------------------------------------");
    }
  }

}
