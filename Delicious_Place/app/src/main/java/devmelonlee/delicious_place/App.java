package devmelonlee.delicious_place;

import devmelonlee.delicious_place.handler.ContentsHandler;
import devmelonlee.util.Prompt;

public class App {

  public static void main(String[] args) {

    printTitle();

    while (ContentsHandler.available()) {
      ContentsHandler.inputContents();

      if (!promptContinue()) {
        break;
      }
    }

    ContentsHandler.printContents();

    Prompt.close();
  }

  static void printTitle() {
    System.out.println("나의 맛집 리뷰 시스템");
    System.out.println("----------------------------------");
  }

  

  static boolean promptContinue() {
    String response = Prompt.inputString("계속 입력하시겠습니까?(Y/n) ");
    
    if (!response.equals("") && !response.equalsIgnoreCase("Y")) {
      return false;
    }
    return true;
  }

}
