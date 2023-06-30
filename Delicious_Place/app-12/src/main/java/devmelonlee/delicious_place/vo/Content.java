package devmelonlee.delicious_place.vo;

public class Content {
  
  private static int contentId = 1;

  public static final char MALE = 'M';
  public static final char FEMALE = 'W';
  public static final char NONSEX = 'X';

  public static final char YES = 'O';
  public static final char NO = 'X';

  private int no; 
  private String id;
  private String email;
  private String password;
  private char gender;
  private String storeName;
  private String content;
  private char isReceipt;
  private int starRaiting;

  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
  }
  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }
  public String getPassword() {
    return email;
  }
  public void setPassword(String password) {
    this.password = password;
  }
  public char getIsReceipt() {
    return isReceipt;
  }
  public void setIsReceipt(char isReceipt) {
    this.isReceipt = isReceipt;
  }
  public String getStoreName() {
    return storeName;
  }
  public void setStoreName(String storeName) {
    this.storeName = storeName;
  }
  public String getContent() {
    return content;
  }
  public void setContent(String content) {
    this.content = content;
  }
  public char getGender() {
    return gender;
  }
  public void setGender(char gender) {
    this.gender = gender;
  }

  public int getStarRaiting() {
    return starRaiting;
  }
  public void setStarRaiting(int starRaiting) {
    this.starRaiting = starRaiting;
  }
  
}
