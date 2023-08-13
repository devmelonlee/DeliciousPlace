package devmelonlee.delicious_place.handler;

import java.util.List;
import devmelonlee.delicious_place.vo.Content;
import devmelonlee.util.ActionListener;
import devmelonlee.util.BreadcrumbPrompt;

public abstract class AbstractContentListener implements ActionListener {

  protected List<Content> list;

  public AbstractContentListener(List<Content> list) {
    this.list = list;
  }

  protected Content findBy(int no) {
    for (int i = 0; i < this.list.size(); i++) {
      Content c = this.list.get(i);
      if (c.getNo() == no) {
        return c;
      }
    }
    return null;
  }

  protected static String toGenderString(char gender) {
    return gender == 'M' ? "남성" : "여성";
  }

  protected static String isReceiptString(char receipt) {
    return receipt == 'O' ? "있음" : "없음";
  }

  protected static String starRatingString(char star) {
    StringBuilder sb = new StringBuilder();
    for (int j = 1; j <= star; j++) {
      sb.append("⭐️");
    }
    return sb.toString();
  }

  protected char inputGender(char gender, BreadcrumbPrompt prompt) {
    String label;
    if (gender == 0) {
      label = "성별?\n";
    } else {
      label = String.format("성별(%s)?\n", toGenderString(gender));
    }

    while (true) {
      String menuNo = prompt.inputString(label + "  1. 남성\n" + "  2. 여성\n" + "> ");

      switch (menuNo) {
        case "1":
          return Content.MALE;
        case "2":
          return Content.FEMALE;
        default:
          System.out.println("무효한 번호입니다.");
      }
    }
  }

  protected char inputReceipt(char receipt, BreadcrumbPrompt prompt) {
    String label;
    if (receipt == 0) {
      label = "영수증 있나요??\n";
    } else {
      label = String.format("영수증 여부(%s)?\n", isReceiptString(receipt));
    }

    while (true) {
      String menuNo = prompt.inputString(label + "  1. 있음 \n" + "  2. 없음 \n" + "> ");

      switch (menuNo) {
        case "1":
          return Content.YES;
        case "2":
          return Content.NO;
        default:
          System.out.println("무효한 번호입니다.");
      }
    }
  }

  protected char inputStar(char star, BreadcrumbPrompt prompt) {
    String label;
    if (star == 0) {
      label = "별점은요?\n";
    } else {
      label = String.format("현재 별점 :(%s)?\n", starRatingString(star));
    }

    while (true) {
      String menuNo = prompt.inputString(label + "1, 2, 3, 4, 5" + "> ");

      switch (menuNo) {
        case "1":
          return 1;
        case "2":
          return 2;
        case "3":
          return 3;
        case "4":
          return 4;
        case "5":
          return 5;

        default:
          System.out.println("무효한 번호입니다.");
      }
    }
  }

}
