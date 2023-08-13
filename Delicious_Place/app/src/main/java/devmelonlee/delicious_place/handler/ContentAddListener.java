package devmelonlee.delicious_place.handler;

import java.util.List;
import devmelonlee.delicious_place.vo.Content;
import devmelonlee.util.BreadcrumbPrompt;

public class ContentAddListener extends AbstractContentListener {
  public ContentAddListener(List<Content> list) {
    super(list);
  }

  @Override
  public void service(BreadcrumbPrompt prompt) {
    Content content = new Content();

    content.setNo(Content.contentNo++);
    content.setId(prompt.inputString("아이디를 입력해주세요 : "));
    content.setPassword(prompt.inputString("암호를 입력해주세요 : "));
    content.setGender(inputGender((char) 0, prompt)); // 기본값 : 0, 명시적 형변환
    content.setIsReceipt(inputReceipt((char) 0, prompt)); // 기본값 : 0, 명시적 형변환
    content.setStoreName(prompt.inputString("리뷰할 가게 이름을 적어주세요 : "));
    content.setContents(prompt.inputString("리뷰 내용을 적어주세요 : "));
    content.setStarRating(inputStar((char) 0, prompt));

    this.list.add(content);
  }
}
