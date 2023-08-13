// package devmelonlee.delicious_place.handler;
//
// import java.util.List;
// import devmelonlee.delicious_place.vo.Gather;
// import devmelonlee.util.BreadcrumbPrompt;
//
// public class GatherUpdateListener extends AbstractGatherListener {
// public GatherUpdateListener(List<Gather> list) {
// super(list);
// }
//
// @Override
// public void service(BreadcrumbPrompt prompt) {
// int gatherNo = prompt.inputInt("번호? ");
//
// Gather gather = this.findBy(gatherNo);
// if (gather == null) {
// System.out.println("해당 번호의 게더가 없습니다!");
// return;
// }
//
// if (!prompt.inputString("수정하려면 암호를 입력하세요? ").equals(gather.getPassword())) {
// System.out.println("암호가 일치하지 않습니다!");
// return;
// }
//
// gather.setStoreName(prompt.inputString("가게이름수정하기(%s)? ", gather.getStoreName()));
// gather.setContents(prompt.inputString("내용수정하기(%s)? ", gather.getContents()));
// gather.setReply(prompt.inputString("댓글편집하기(%s)? ", gather.getReply()));
// }
// }
