package devmelonlee.delicious_place.vo;

import java.io.Serializable;

public class Content implements Serializable, CsvObject {

  private static final long serialVersionUID = 1L;
  private static int contentNo = 1;

  public static final char MALE = 'M';
  public static final char FEMALE = 'W';
  public static final char NONSEX = 'X';

  public static final char YES = '✅';
  public static final char NO = '❎';


  private int no;
  private String id;
  private String password;
  private char gender;
  private String storeName;
  private String contents;
  private char isReceipt;
  private int starRating;

  public Content() {
    this.no = contentNo++;
  }

  public Content(int no) {
    this.no = no;
  }

  public static Content fromCsv(String csv) {
    String[] values = csv.split(",");

    Content content = new Content(Integer.parseInt(values[0]));
    content.setId(values[1]);
    content.setPassword(values[2]);
    content.setGender(values[3].charAt(0));
    content.setStoreName(values[4]);
    content.setContents(values[5]);
    content.setIsReceipt(values[6].charAt(0));
    content.setStarRating(Integer.parseInt(values[7]));

    if (Content.contentNo <= content.getNo()) {
      Content.contentNo = content.getNo() + 1;
    }

    return content;
  }

  @Override
  public String toCsvString() {
    return String.format("%d,%s,%s,%c,%s,%s,%c,%d", this.getNo(), this.getId(), this.getPassword(),
        this.getGender(), this.getStoreName(), this.getContents(), this.getIsReceipt(),
        this.getStarRating());
  }

  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }

    if (this.getClass() != obj.getClass()) {
      return false;
    }

    Content content = (Content) obj;

    if (this.getNo() != content.getNo()) {
      return false;
    }

    return true;
  }

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

  public String getPassword() {
    return password;
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

  public String getContents() {
    return contents;
  }

  public void setContents(String contents) {
    this.contents = contents;
  }

  public char getGender() {
    return gender;
  }

  public void setGender(char gender) {
    this.gender = gender;
  }

  public int getStarRating() {
    return starRating;
  }

  public void setStarRating(int starRating) {
    this.starRating = starRating;
  }

}
