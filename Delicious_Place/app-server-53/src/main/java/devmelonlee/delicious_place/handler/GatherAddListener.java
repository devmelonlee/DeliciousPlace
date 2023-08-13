// package devmelonlee.delicious_place.handler;
//
// import java.util.List;
// import devmelonlee.delicious_place.vo.Gather;
// import devmelonlee.util.BreadcrumbPrompt;
//
// public class GatherAddListener extends AbstractGatherListener {
// public GatherAddListener(List<Gather> list) {
// super(list);
// }
//
// @Override
// public void service(BreadcrumbPrompt prompt) {
// Gather gather = new Gather();
//
// gather.setNo(Gather.gatherNo++);
// gather.setId(prompt.inputString("아이디를 입력해주세요 : "));
// gather.setPassword(prompt.inputString("암호를 입력해주세요 : "));
// gather.setGender(inputGender((char) 0, prompt)); // 기본값 : 0, 명시적 형변환
// gather.setStoreName(prompt.inputString("같이 먹을 맛집을 적어주세요 : "));
// gather.setContents(prompt.inputString("오늘 나오는 메뉴나 음식에대해서 적어주세요 : "));
//
// this.list.add(gather);
// }
// }
