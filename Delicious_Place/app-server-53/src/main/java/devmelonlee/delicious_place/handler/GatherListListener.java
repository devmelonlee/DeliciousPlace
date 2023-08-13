// package devmelonlee.delicious_place.handler;
//
// import java.util.Iterator;
// import java.util.List;
// import devmelonlee.delicious_place.vo.Gather;
// import devmelonlee.util.BreadcrumbPrompt;
//
// public class GatherListListener extends AbstractGatherListener {
// public GatherListListener(List<Gather> list) {
// super(list);
// }
//
// @Override
// public void service(BreadcrumbPrompt prompt) {
// // 목록에서 데이터를 대신 꺼내주는 객체를 얻는다.
// Iterator<Gather> iterator = list.iterator();
//
// while (iterator.hasNext()) {
// Gather gather = iterator.next();
// System.out.println("---------------------------------------------");
// System.out.printf(" 글 번호 | 아이디 | 성별 \n");
// System.out.println("---------------------------------------------");
// System.out.printf("# %d, %s, %s\n", gather.getNo(), gather.getId(),
// toGenderString(gather.getGender()));
// System.out.printf("가게 이름 : %s \n", gather.getStoreName());
// System.out.printf("내용 : %s \n", gather.getContents());
// System.out.printf("댓글 : %s \n", gather.getReply());
// System.out.println("---------------------------------------------");
// }
//
// }
// }
