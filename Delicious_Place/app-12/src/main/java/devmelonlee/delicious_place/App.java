package devmelonlee.delicious_place;

import devmelonlee.delicious_place.handler.ContentsHandler;
import devmelonlee.util.Prompt;

public class App {

  public static void main(String[] args) {

    printTitle();
    printMenu();

    while (true) {
      String menuNo = Prompt.inputString("메인> ");
      if (menuNo.equals("6")) { // 6. 종료
        break;
      } else if (menuNo.equals("menu")) {
        printMenu();
      } else if (menuNo.equals("1")) { // 1. 리뷰 등록
        ContentsHandler.inputContents();
      } else if (menuNo.equals("2")) { // 2. 전체 리뷰 조회
        ContentsHandler.printContents();
      } else if (menuNo.equals("3")) { // 3. 리뷰 글 번호 조회
        ContentsHandler.viewContents();
      } else if (menuNo.equals("4")) { // 4. 리뷰 수정하기
        ContentsHandler.updateContents();
      } else if (menuNo.equals("5")) { // 5. 리뷰 삭제
        ContentsHandler.deleteContents();
      } else {
        System.out.println(menuNo);
      }
    }

    Prompt.close();
  }

  static void printMenu() {
    System.out.println("1. 리뷰 등록");
    System.out.println("2. 전체 리뷰 조회");
    System.out.println("3. 리뷰 글 번호 조회");
    System.out.println("4. 리뷰 수정하기");
    System.out.println("5. 리뷰 삭제하기");
    System.out.println("6. 종료");
  }

  static void printTitle() {
    System.out.println("나의 맛집 리뷰 시스템");
    System.out.println("----------------------------------");
  }

  static boolean promptContinue() { // 사용 안함
    String response = Prompt.inputString("계속 입력하시겠습니까?(Y/n) ");
    
    if (!response.equals("") && !response.equalsIgnoreCase("Y")) {
      return false;
    }
    return true;
  }

}
