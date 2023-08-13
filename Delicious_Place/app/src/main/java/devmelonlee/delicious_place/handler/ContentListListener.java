package devmelonlee.delicious_place.handler;

import java.util.Iterator;
import java.util.List;
import devmelonlee.delicious_place.vo.Content;
import devmelonlee.util.BreadcrumbPrompt;

public class ContentListListener extends AbstractContentListener {

  public ContentListListener(List<Content> list) {
    super(list);
  }

  @Override
  public void service(BreadcrumbPrompt prompt) {
    // 목록에서 데이터를 대신 꺼내주는 객체를 얻는다.
    Iterator<Content> iterator = list.iterator();

    while (iterator.hasNext()) {
      Content content = iterator.next();
      System.out.println("---------------------------------------------");
      System.out.printf(" 글 번호 |   아이디   |   성별   \n");
      System.out.println("---------------------------------------------");
      System.out.printf("# %d, %s, %s\n", content.getNo(), content.getId(),
          toGenderString(content.getGender()));
      System.out.printf("가게 이름   : %s \n", content.getStoreName());
      System.out.printf("리뷰 내용   : %s \n", content.getContents());
      System.out.printf("영수증 인증 : %c \n", content.getIsReceipt());
      System.out.printf("별점        : %s \n", starRatingString((char) content.getStarRating()));
      System.out.println("---------------------------------------------");
    }

  }
}
