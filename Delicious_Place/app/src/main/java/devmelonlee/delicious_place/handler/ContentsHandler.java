package devmelonlee.delicious_place.handler;

import devmelonlee.util.Prompt;

public class ContentsHandler {
  
  static final int MAX_SIZE = 100;
  
  static int[] no = new int[MAX_SIZE];
  static String[] id = new String[MAX_SIZE];
  static String[] email = new String[MAX_SIZE];
  static String[] password = new String[MAX_SIZE];
  static char[] gender = new char[MAX_SIZE];
  
  static String[] content = new String[MAX_SIZE];
  static char[] isReceipt = new char[MAX_SIZE];
  static int[] starRaiting = new int[MAX_SIZE];
  
  static int userId = 1;
  static int length = 0;

  static final char MALE = 'M';
  static final char FEMALE = 'W';
  static final char NONSEX = 'X';

  static final char YES = 'Y';
  static final char NO = 'N';

  public static void inputContents() {

    id[length] = Prompt.inputString("아이디를 입력해주세요 : ");
    email[length] = Prompt.inputString("이메일을 입력해주세요 : ");
    password[length] = Prompt.inputString("암호를 입력해주세요 : ");

    loop: while (true) {
      System.out.print("> ");
      String menuNo = Prompt.inputString("성별을 입력해주세요 : \n" + "  1. 남자\n" +
      "  2. 여자\n" + "  3. 선택하지 않음\n" + "> ");

      switch (menuNo) {
        case "1":
          gender[length] = MALE;
          break loop;
        case "2":
          gender[length] = FEMALE;
          break loop;
        case "3":
          gender[length] = NONSEX;
          break loop;  
        default:
          System.out.println("유효한 번호로 입력해주세요!");
      }
    }

    content[length] = Prompt.inputString("리뷰 내용을 적어주세요 : ");

    loop: while (true) {
      int validReceipt = Prompt.inputInteger("영수증 있으신가요? 예: 1, 아니오 : 2): ");
      switch (validReceipt) {
        case 1:
          isReceipt[length] = YES;
          break loop;
        case 2:
          isReceipt[length] = NO;
          break loop;
        default:
          System.out.println("유효한 번호로 입력해주세요!");
      }
    }

    while (true) { 
      int validStarRaiting = Prompt.inputInteger("평점은요 (1, 2, 3, 4, 5)? : ");
      if (validStarRaiting >= 1 && validStarRaiting <= 5) {
        starRaiting[length] = validStarRaiting;
        break;
      }
      System.out.println("유효한 번호로 입력해주세요!");
    }

    Prompt.inputString(); // flush buffer

    no[length] = userId++;
    length++;
  }

  public static void printContents() {
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

  public static boolean available() {
    return length < MAX_SIZE;
  }

}