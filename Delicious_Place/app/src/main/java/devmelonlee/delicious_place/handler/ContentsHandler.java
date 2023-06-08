package devmelonlee.delicious_place.handler;

import devmelonlee.util.Prompt;
import devmelonlee.delicious_place.vo.Content;

public class ContentsHandler {
  
  static final int MAX_SIZE = 100;
  static Content[] contents = new Content[MAX_SIZE];
  
  static int contentId = 1;
  static int length = 0;

  static final char MALE = 'M';
  static final char FEMALE = 'W';
  static final char NONSEX = 'X';

  static final char YES = 'O';
  static final char NO = 'X';

  public static void inputContents() { // 1. 리뷰 등록

    if (!available()) {
      System.out.println("더 이상 입력할 수 없습니다!");
      return;
    }

    Content c = new Content();
    c.id = Prompt.inputString("아이디를 입력해주세요 : ");
    c.email = Prompt.inputString("이메일을 입력해주세요 : ");
    c.password = Prompt.inputString("암호를 입력해주세요 : ");
    c.gender = inputGender((char)0); // 기본값 : 0, 명시적 형변환

    c.storeName = Prompt.inputString("리뷰할 가게 이름을 적어주세요 : ");
    c.content = Prompt.inputString("리뷰 내용을 적어주세요 : ");
    c.isReceipt = inputReceipt((char)0); // 기본값 : 0, 명시적 형변환

    while (true) { 
      int validStarRaiting = Prompt.inputInt("평점은요 (1, 2, 3, 4, 5)? : ");
      if (validStarRaiting >= 1 && validStarRaiting <= 5) {
        c.starRaiting = validStarRaiting;
        break;
      }
      System.out.println("유효한 번호로 입력해주세요!");
    }

    c.no = contentId++;
    contents[length++] = c;
    // Prompt.inputString(""); // flush buffer
  }

  public static void printContents() { // 2. 전체 리뷰 조회


    for (int i = 0; i < length; i++) {
      Content c = contents[i];
      System.out.println("---------------------------------------------");
      System.out.printf(" 글 번호 |   아이디   |   이메일  |   성별  \n");
      System.out.println("---------------------------------------------");
      System.out.printf("# %05d,  %s,  %s, %s \n", 
        c.no, c.id, c.email, toGenderString(c.gender));
      System.out.println("가게 이름   : " + c.storeName);
      System.out.println("리뷰 내용   : " + c.content);
      System.out.println("영수증 인증 : "+ c.isReceipt);
      System.out.print("별점        : ");
      for (int j = 1; j <= c.starRaiting; j++) {
        System.out.print("⭐️");
      }
      System.out.println("");
      System.out.println("---------------------------------------------");
    }
  }

  
  public static void viewContents() { // 3. 리뷰 글 번호 조회
    
    String contentNo = Prompt.inputString("보고 싶은 글 번호를 입력해주세요 : ");
    for (int i = 0; i < length; i++) {
      Content c = contents[i];
      
      if (c.no == Integer.parseInt(contentNo)) {
        System.out.println("---------------------------------------------");
        System.out.printf(" 글 번호 |   아이디   |   이메일  |   성별  \n");
        System.out.println("---------------------------------------------");
        System.out.printf("# %05d, %s, %s, %s \n", 
        c.no, c.id, c.email, toGenderString(c.gender));
        System.out.println("가게 이름   : " + c.storeName);
        System.out.println("리뷰 내용   : " + c.content);
        System.out.println("영수증 인증 : "+ c.isReceipt);
        System.out.print("별점        : ");
        for (int j = 1; j <= c.starRaiting; j++) {
          System.out.print("⭐️");
        }
        System.out.println("");
        System.out.println("---------------------------------------------");
        return;
      }
    }
    System.out.println("해당 번호의 글은 없습니다!");
  }
  
  public static void updateContents() { // 4. 리뷰 수정하기
    
    String contentNo = Prompt.inputString("수정할 글 번호를 입력해주세요 : ");
    for (int i = 0; i < length; i++) {
      Content c = contents[i];
      if (c.no == Integer.parseInt(contentNo)) {
        System.out.printf("가게 이름을 변경하시겠습니까?\n (현재 : %s) : ", c.storeName);
        c.storeName = Prompt.inputString("");
        System.out.printf("글 내용을 변경하시겠습니까?\n (현재 : %s) : ", c.content);
        c.content = Prompt.inputString("");
        System.out.printf("영수증 여부를 변경하시겠습니까?\n : ");
        c.isReceipt = inputReceipt(c.isReceipt);
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
      contents[i] = contents[i + 1];
    }
    
    contents[--length] = null;
    System.out.println("해당 글이 성공적으로 삭제되었습니다.");
  }
  
  private static int indexOf(int contentNo) {
    for (int i = 0; i < length; i++) {
      Content c = contents[i];
      if (c.no == contentNo) {
        return i;
      }
    }
    return -1;
  }
  
  private static boolean available() {
    return length < MAX_SIZE;
  }
  
  private static char inputGender(char gender) {
    String label;
    if (gender == 0) {
      label = "성별을 입력해주세요 : \n";
    } else {
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
  
  public static String toGenderString(char gender) {
    return gender == 'M' ? "남성" : "여성";
  }
  
  private static char inputReceipt(char isReceipt) {
  
    while (true) {
      int validReceipt = Prompt.inputInt("영수증 있으신가요? \n 예: 1, 아니오 : 2)\n > ");
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
}