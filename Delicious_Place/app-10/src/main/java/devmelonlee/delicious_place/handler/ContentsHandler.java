package devmelonlee.delicious_place.handler;

import devmelonlee.util.Prompt;

public class ContentsHandler {
  
  static final int MAX_SIZE = 100;
  
  static int[] no = new int[MAX_SIZE];
  static String[] id = new String[MAX_SIZE];
  static String[] email = new String[MAX_SIZE];
  static String[] password = new String[MAX_SIZE];
  static char[] gender = new char[MAX_SIZE];
  
  static String[] storeName = new String[MAX_SIZE];
  static String[] content = new String[MAX_SIZE];
  static char[] isReceipt = new char[MAX_SIZE];
  static int[] starRaiting = new int[MAX_SIZE];
  
  static int contentId = 1;
  static int length = 0;

  static final char MALE = 'M';
  static final char FEMALE = 'W';
  static final char NONSEX = 'X';

  static final char YES = 'Y';
  static final char NO = 'N';

  public static void inputContents() { // 1. 리뷰 등록

    if (!available()) {
      System.out.println("더 이상 입력할 수 없습니다!");
      return;
    }

    id[length] = Prompt.inputString("아이디를 입력해주세요 : ");
    email[length] = Prompt.inputString("이메일을 입력해주세요 : ");
    password[length] = Prompt.inputString("암호를 입력해주세요 : ");
    gender[length] = inputGender((char)0); // 기본값 : 0, 명시적 형변환

    storeName[length] = Prompt.inputString("리뷰할 가게 이름을 적어주세요 : ");
    content[length] = Prompt.inputString("리뷰 내용을 적어주세요 : ");
    isReceipt[length] = inputReceipt((char)0); // 기본값 : 0, 명시적 형변환

    while (true) { 
      int validStarRaiting = Prompt.inputInt("평점은요 (1, 2, 3, 4, 5)? : ");
      if (validStarRaiting >= 1 && validStarRaiting <= 5) {
        starRaiting[length] = validStarRaiting;
        break;
      }
      System.out.println("유효한 번호로 입력해주세요!");
    }

    Prompt.inputString(); // flush buffer

    no[length] = contentId++;
    length++;
  }

  public static void printContents() { // 2. 전체 리뷰 조회

    System.out.println("---------------------------------------");

    for (int i = 0; i < length; i++) {
      System.out.println("번호, 아이디, 이메일, 성별");
      System.out.println("---------------------------------------");
      System.out.printf("%d, %s, %s, %c\n", no[i], id[i], email[i], toGenderString(gender[i]));
      System.out.println("가게 이름 : " + storeName[i]);
      System.out.println("리뷰 내용 : " + content[i]);
      System.out.println("영수증 여부 : "+ isReceipt[i]);
      System.out.println("별점 : " + starRaiting[i]);
      System.out.println("---------------------------------------");
    }
  }

  public static String toGenderString(char gender) {
    return gender == 'M' ? "남성" : "여성";
  }

  private static char inputGender(char gender) {

    String label;
    if (gender == 0) {
      label = "성별을 입력해주세요 : \n";
    } else {
      // label = "성별(" + toGenderString(gender) + ")?\n";
      label = String.format("성별(%s)?\n", toGenderString(gender));
    }

    while (true) {
      String menuNo = Prompt.inputString(label + 
      "  남자 : 1, 여자 : 2 \n" + 
      "> ");

      switch (menuNo) {
        case "1":
          return MALE;
        case "2":
          return FEMALE;
        default:
          System.out.println("유효하지 않은 입력입니다. 다시 입력해주세요.");
      }
    }
  }

  private static char inputReceipt(char isReceipt) {

    while (true) {
      int validReceipt = Prompt.inputInt("영수증 있으신가요? \n 예: 1, 아니오 : 2) > ");
      switch (validReceipt) {
        case 1:
          return YES;
        case 2:
          return NO;
        default:
          System.out.println("유효하지 않은 입력입니다. 다시 입력해주세요.");
      }
    }
  }

  public static void viewContents() { // 3. 리뷰 글 번호 조회

    String contentNo = Prompt.inputString("보고 싶은 글 번호를 입력해주세요 : ");
    for (int i = 0; i < length; i++) {
      if (no[i] == Integer.parseInt(contentNo)) {
        System.out.println("번호, 아이디, 이메일, 성별");
        System.out.println("---------------------------------------");
        System.out.printf("%3d, %s, %s, %c\n", no[i], id[i], email[i], toGenderString(gender[i]));
        System.out.println("가게 이름 : " + storeName[i]);
        System.out.println("리뷰 내용 : " + content[i]);
        System.out.println("영수증 여부 : "+ isReceipt[i]);
        System.out.println("별점 : " + starRaiting[i]);
        return;
      }
    }
    System.out.println("해당 번호의 글은 없습니다!");
  }

  public static void updateContents() { // 4. 리뷰 수정하기

    String contentNo = Prompt.inputString("수정할 글 번호를 입력해주세요 : ");
    for (int i = 0; i < length; i++) {
      if (no[i] == Integer.parseInt(contentNo)) {
        System.out.printf("가게 이름을 변경하시겠습니까?\n (현재 : %s) : ", storeName[i]);
        storeName[i] = Prompt.inputString("");
        System.out.printf("글 내용을 변경하시겠습니까?\n (현재 : %s) : ", content[i]);
        content[i] = Prompt.inputString("");
        System.out.printf("영수증 여부를 변경하시겠습니까?\n : ");
        isReceipt[i] = inputReceipt(isReceipt[i]);
        return;
      }
    }
    System.out.println("해당 번호의 글은 없습니다!");
  }

  public static void deleteContents() { // 5. 리뷰 삭제

    int contentNo = Prompt.inputInt("삭제하고 싶은 글 번호를 입력해주세요 : ");

    int deletedIndex = indexOf(contentNo);
    if (deletedIndex == -1) {
      System.out.println("해당 번호의 글은 없습니다!");
      return;
    }
    for (int i = deletedIndex; i < length - 1; i++) { // 마지막 -1까지 삭제
      no[i] = no[i + 1];
      id[i] = id[i + 1];
      email[i] = email[i + 1];
      password[i] = password[i + 1];
      gender[i] = gender[i + 1];
      storeName[i] = storeName[i + 1];
      content[i] = content[i + 1];
      isReceipt[i] = isReceipt[i + 1];
      starRaiting[i] = starRaiting[i + 1];
    }

    no[length - 1] = 0; // 마지막 은 초기화
    id[length - 1] = null;
    email[length - 1] = null;
    password[length - 1] = null;
    gender[length - 1] = (char) 0;
    storeName[length - 1] = null;
    content[length - 1] = null;
    isReceipt[length - 1] = (char) 0;
    starRaiting[length - 1] = 0;

    length--;
    System.out.println("해당 글이 성공적으로 삭제되었습니다.");
  }

  private static int indexOf(int contentNo) {
    for (int i = 0; i < length; i++) {
      if (no[i] == contentNo) {
        return i;
      }
    }
    return -1;
  }

  private static boolean available() {
    return length < MAX_SIZE;
  }

}