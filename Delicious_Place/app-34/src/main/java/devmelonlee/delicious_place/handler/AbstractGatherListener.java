package devmelonlee.delicious_place.handler;

import java.util.List;
import devmelonlee.delicious_place.vo.Content;
import devmelonlee.delicious_place.vo.Gather;
import devmelonlee.util.ActionListener;
import devmelonlee.util.BreadcrumbPrompt;

public abstract class AbstractGatherListener implements ActionListener {

  protected List<Gather> list;

  public AbstractGatherListener(List<Gather> list) {
    this.list = list;
  }

  protected Gather findBy(int no) {
    for (int i = 0; i < this.list.size(); i++) {
      Gather g = this.list.get(i);
      if (g.getNo() == no) {
        return g;
      }
    }
    return null;
  }

  protected static String toGenderString(char gender) {
    return gender == 'M' ? "남성" : "여성";
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

}
