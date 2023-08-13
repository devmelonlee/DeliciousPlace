package devmelonlee.delicious_place;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import devmelonlee.delicious_place.handler.ContentAddListener;
import devmelonlee.delicious_place.handler.ContentDeleteListener;
import devmelonlee.delicious_place.handler.ContentDetailListener;
import devmelonlee.delicious_place.handler.ContentListListener;
import devmelonlee.delicious_place.handler.ContentUpdateListener;
import devmelonlee.delicious_place.handler.GatherAddListener;
import devmelonlee.delicious_place.handler.GatherDeleteListener;
import devmelonlee.delicious_place.handler.GatherListListener;
import devmelonlee.delicious_place.handler.GatherTogetherListener;
import devmelonlee.delicious_place.handler.GatherUpdateListener;
import devmelonlee.delicious_place.vo.Content;
import devmelonlee.delicious_place.vo.CsvObject;
import devmelonlee.delicious_place.vo.Gather;
import devmelonlee.util.BreadcrumbPrompt;
import devmelonlee.util.Menu;
import devmelonlee.util.MenuGroup;

public class App {

  ArrayList<Content> contentList = new ArrayList<>();
  LinkedList<Gather> gatherList = new LinkedList<>();

  BreadcrumbPrompt prompt = new BreadcrumbPrompt();

  MenuGroup mainMenu = new MenuGroup("메인");

  public App() {
    prepareMenu();
  }

  public static void main(String[] args) {
    new App().execute();
  }


  public void execute() {
    printTitle();

    loadData();
    mainMenu.execute(prompt);
    saveData();

    prompt.close();
  }

  static void printTitle() {
    System.out.println("나의 맛집 리뷰 추천 시스템");
    System.out.println("----------------------------------");
  }

  private void loadData() {
    loadCsv("content.csv", contentList, Content.class);
    loadCsv("gather.csv", gatherList, Gather.class);
  }

  private void saveData() {
    saveCsv("content.csv", contentList);
    saveCsv("gather.csv", gatherList);
  }

  private void prepareMenu() {
    MenuGroup contentMenu = new MenuGroup("맛집 리뷰");
    contentMenu.add(new Menu("맛집 리뷰등록하기", new ContentAddListener(contentList)));
    contentMenu.add(new Menu("맛집 리뷰목록보기(여러개)", new ContentListListener(contentList)));
    contentMenu.add(new Menu("맛집 리뷰조회하기(1개)", new ContentDetailListener(contentList)));
    contentMenu.add(new Menu("내 맛집 리뷰수정하기", new ContentUpdateListener(contentList)));
    contentMenu.add(new Menu("내 맛집 리뷰삭제하기", new ContentDeleteListener(contentList)));
    mainMenu.add(contentMenu);


    MenuGroup GatherMenu = new MenuGroup("오늘은 여기가요 - 게더");
    GatherMenu.add(new Menu("오늘 점심은 여기가자고 추가하기", new GatherAddListener(gatherList)));
    GatherMenu.add(new Menu("조회하기", new GatherListListener(gatherList)));
    GatherMenu.add(new Menu("댓글달기", new GatherTogetherListener(gatherList)));
    GatherMenu.add(new Menu("변경하기", new GatherUpdateListener(gatherList)));
    GatherMenu.add(new Menu("삭제하기", new GatherDeleteListener(gatherList)));
    mainMenu.add(GatherMenu);
  }

  @SuppressWarnings("unchecked")
  private <T extends CsvObject> void loadCsv(String filename, List<T> list, Class<T> clazz) {
    try {
      Method factoryMethod = clazz.getDeclaredMethod("fromCsv", String.class);

      FileReader in0 = new FileReader(filename);
      BufferedReader in = new BufferedReader(in0); // <== Decorator 역할을 수행!

      String line = null;

      while ((line = in.readLine()) != null) {
        list.add((T) factoryMethod.invoke(null, line)); // Reflection API를 사용하여 스태틱 메서드 호출
        // list.add(Member.fromCsv(line)); // 직접 스태틱 메서드 호출
      }

      in.close();

    } catch (Exception e) {
      System.out.println(filename + " 파일을 읽는 중 오류 발생!");
    }
  }

  private void saveCsv(String filename, List<? extends CsvObject> list) {
    try {
      FileWriter out0 = new FileWriter(filename);
      BufferedWriter out1 = new BufferedWriter(out0); // <== Decorator(장식품) 역할 수행!
      PrintWriter out = new PrintWriter(out1); // <== Decorator(장식품) 역할 수행!

      for (CsvObject obj : list) {
        out.println(obj.toCsvString());
        // Board나 Member 클래스에 필드가 추가/변경/삭제되더라도
        // 여기 코드를 변경할 필요가 없다.
        // 이것이 Information Expert 설계를 적용하는 이유다!
        // 설계를 어떻게 하느냐에 따라 유지보수가 쉬워질 수도 있고,
        // 어려워질 수도 있다.
      }
      out.close();

    } catch (Exception e) {
      System.out.println(filename + " 파일을 저장하는 중 오류 발생!");
    }
  }

  // static boolean promptContinue() { // 사용 안함
  // String response = Prompt.inputString("계속 입력하시겠습니까?(Y/n) ");
  //
  // if (!response.equals("") && !response.equalsIgnoreCase("Y")) {
  // return false;
  // }
  // return true;
  // }

}


