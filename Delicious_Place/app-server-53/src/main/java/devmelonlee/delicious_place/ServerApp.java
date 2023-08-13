package devmelonlee.delicious_place;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import devmelonlee.delicious_place.dao.ContentDao;
import devmelonlee.delicious_place.dao.GatherDao;
import devmelonlee.util.MenuGroup;

public class ServerApp {
  ExecutorService threadPool = Executors.newFixedThreadPool(2);

  DataSource ds = new DataSource("jdbc:mysql://localhost:3306/dpdb", "std", "1111");
  ContentDao contentDao;
  GatherDao gatherDao;

  MenuGroup mainMenu = new MenuGroup("메인");

  int port;

  public ServerApp(int port) throws Exception {

    // this.port = port;
    //
    // this.contentDao = new MySQLContentDao(ds);
    // this.gatherDao = new MySQLGatherDao(ds);
    //
    // prepareMenu();
  }


  // public ServerApp() {
  // prepareMenu();
  // }
  //
  // public void close() throws Exception {
  //
  // }

  public static void main(String[] args) throws Exception {
    // ServerApp app = new ServerApp(8888);
    // app.execute();
    // app.close();
  }


  // public void execute() {
  // try (ServerSocket serverSocket = new ServerSocket(this.port)) {
  // System.out.println("서버 실행 중...");
  //
  // while (true) {
  // Socket socket = serverSocket.accept();
  // threadPool.execute(() -> processRequest(socket));
  // }
  // } catch (Exception e) {
  // System.out.println("서버 실행 오류!");
  // e.printStackTrace();
  // }
  // }
  //
  // private void processRequest(Socket Socket) {
  // try (Socket s = socket;
  // DataInputStream in = new DataInputStream(socket.getInputStream());
  // DataOutputStream out = new DataOutputStream(socket.getOutputStream())) {
  //
  // BreadcrumbPrompt prompt = new BreadcrumbPrompt(in, out);
  //
  // InetSocketAddress clientAddress = (InetSocketAddress) socket.getRemoteSocketAddress();
  // System.out.printf("%s 클라이언트 접속함!\n", clientAddress.getHostString());
  //
  // out.writeUTF(
  // "🍕Delicious Place - 같이 먹으러가요🍣\n" + "-----------------------------------------");
  //
  // new LoginListener(memberDao).service(prompt);
  //
  // mainMenu.execute(prompt);
  // out.writeUTF(NetProtocol.NET_END);
  //
  // } catch (Exception e) {
  // System.out.println("클라이언트 통신 오류!");
  // e.printStackTrace();
  //
  // } finally {
  // ds.clean(); // 현재 스레드에 보관된 Connection 객체를 닫고, 스레드에서 제거한다.
  // }
  // }
  //
  // private void prepareMenu() {
  // MenuGroup contentMenu = new MenuGroup("맛집 리뷰");
  // contentMenu.add(new Menu("맛집 리뷰등록하기", new ContentAddListener(contentList)));
  // contentMenu.add(new Menu("맛집 리뷰목록보기(여러개)", new ContentListListener(contentList)));
  // contentMenu.add(new Menu("맛집 리뷰조회하기(1개)", new ContentDetailListener(contentList)));
  // contentMenu.add(new Menu("내 맛집 리뷰수정하기", new ContentUpdateListener(contentList)));
  // contentMenu.add(new Menu("내 맛집 리뷰삭제하기", new ContentDeleteListener(contentList)));
  // mainMenu.add(contentMenu);
  //
  //
  // MenuGroup GatherMenu = new MenuGroup("오늘은 여기가요 - 게더");
  // GatherMenu.add(new Menu("오늘 점심은 여기가자고 추가하기", new GatherAddListener(gatherList)));
  // GatherMenu.add(new Menu("조회하기", new GatherListListener(gatherList)));
  // GatherMenu.add(new Menu("댓글달기", new GatherTogetherListener(gatherList)));
  // GatherMenu.add(new Menu("변경하기", new GatherUpdateListener(gatherList)));
  // GatherMenu.add(new Menu("삭제하기", new GatherDeleteListener(gatherList)));
  // mainMenu.add(GatherMenu);
  // }

}


