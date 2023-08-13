package devmelonlee.delicious_place.handler;

import java.util.List;
import devmelonlee.delicious_place.vo.Content;
import devmelonlee.util.BreadcrumbPrompt;

public class ContentDeleteListener extends AbstractContentListener {
  public ContentDeleteListener(List<Content> list) {
    super(list);
  }

  @Override
  public void service(BreadcrumbPrompt prompt) {
    if (!this.list.remove(new Content(prompt.inputInt("번호? ")))) {
      System.out.println("해당 번호의 게시글이 없습니다!");
    }
  }
}
