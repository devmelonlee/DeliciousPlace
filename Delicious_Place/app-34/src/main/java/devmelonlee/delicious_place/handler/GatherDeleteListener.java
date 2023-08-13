package devmelonlee.delicious_place.handler;

import java.util.List;
import devmelonlee.delicious_place.vo.Gather;
import devmelonlee.util.BreadcrumbPrompt;

public class GatherDeleteListener extends AbstractGatherListener {
  public GatherDeleteListener(List<Gather> list) {
    super(list);
  }

  @Override
  public void service(BreadcrumbPrompt prompt) {
    if (!this.list.remove(new Gather(prompt.inputInt("번호? ")))) {
      System.out.println("해당 번호의 게시글이 없습니다!");
    }
  }

}
