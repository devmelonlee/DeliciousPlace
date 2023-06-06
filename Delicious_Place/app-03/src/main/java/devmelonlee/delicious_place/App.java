package devmelonlee.delicious_place;

public class App {
  public static void main(String[] args) {
    System.out.println("나의 맛집 리뷰 시스템");
    System.out.println("----------------------------------");
    
    int no = 100;
    String id = "devmelonlee";
    int age = 26;
    char gender = 'M';

    String content = "사장님이 친절하고 음식이 맛있었어요!";
    boolean isReceipt = true;
    int starRaiting = 5;


    System.out.printf("번호: %d\n", no);
    System.out.printf("아이디: %s\n", id);
    System.out.printf("나이: %d\n", age);
    System.out.printf("성별(남자(M), 여자(W)): %c\n", gender);
    
    System.out.printf("리뷰 내용: %s\n", content);
    System.out.printf("영수증: %b\n", isReceipt);
    System.out.printf("평점: %d", starRaiting);
  }
}
