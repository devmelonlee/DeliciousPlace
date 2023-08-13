package devmelonlee.delicious_place.handler;

import java.util.List;
import devmelonlee.delicious_place.vo.Content;
import devmelonlee.util.BreadcrumbPrompt;

public class ContentDetailListener extends AbstractContentListener {
  public ContentDetailListener(List<Content> list) {
    super(list);
  }

  @Override
  public void service(BreadcrumbPrompt prompt) {
    int contentNo = prompt.inputInt("번호? ");

    Content content = this.findBy(contentNo);
    if (content == null) {
      System.out.println("해당 번호의 게시글이 없습니다!");
      return;
    }
    System.out.println("아이디      : " + content.getId());
    System.out.println("성별        : " + toGenderString(content.getGender()));
    System.out.println("가게 이름   : " + content.getStoreName());
    System.out.println("리뷰 내용   : " + content.getContents());
    System.out.println("영수증 인증 : " + content.getIsReceipt());
    System.out.print("별점        : ");
    for (int j = 1; j <= content.getStarRating(); j++) {
      System.out.print("⭐️");
    }
    System.out.println("");
  }

}
