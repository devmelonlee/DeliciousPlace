package devmelonlee.delicious_place.handler;

import java.util.List;
import devmelonlee.delicious_place.vo.Content;
import devmelonlee.util.BreadcrumbPrompt;

public class ContentUpdateListener extends AbstractContentListener {

  public ContentUpdateListener(List<Content> list) {
    super(list);
  }

  @Override
  public void service(BreadcrumbPrompt prompt) {
    int contentNo = prompt.inputInt("번호? ");

    Content content = this.findBy(contentNo);
    if (content == null) {
      System.out.println("해당 번호의 리뷰가 없습니다!");
      return;
    }

    if (!prompt.inputString("암호? ").equals(content.getPassword())) {
      System.out.println("암호가 일치하지 않습니다!");
      return;
    }

    content.setStoreName(prompt.inputString("가게이름(%s)? ", content.getStoreName()));
    content.setContents(prompt.inputString("내용(%s)? ", content.getContents()));
    content.setIsReceipt(inputReceipt(content.getIsReceipt(), prompt));
    content.setStarRating(inputStar((char) 0, prompt));
  }
}
