package devmelonlee.delicious_place.handler;

import java.util.List;
import devmelonlee.delicious_place.vo.Gather;
import devmelonlee.util.BreadcrumbPrompt;

public class GatherTogetherListener extends AbstractGatherListener {
  public GatherTogetherListener(List<Gather> list) {
    super(list);
  }

  @Override
  public void service(BreadcrumbPrompt prompt) {
    int gatherNo = prompt.inputInt("같이 가려고 하는 음식점 글 번호를 입력해주세요 : ");

    Gather gather = this.findBy(gatherNo);
    if (gather == null) {
      System.out.println("해당 번호의 게더가 없습니다!");
      return;
    }

    System.out.println("가게 이름   : " + gather.getStoreName());
    System.out.println("내용        : " + gather.getContents());

    gather.setReply(prompt.inputString("댓글 남기기 : " + gather.getReply()));
  }
}
