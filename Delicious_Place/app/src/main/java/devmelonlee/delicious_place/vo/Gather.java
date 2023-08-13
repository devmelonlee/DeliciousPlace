package devmelonlee.delicious_place.vo;

import java.io.Serializable;

public class Gather implements Serializable, CsvObject, AutoIncrement {

  private static final long serialVersionUID = 1L;
  public static int gatherNo = 1;

  public static final char MALE = 'M';
  public static final char FEMALE = 'W';
  public static final char NONSEX = 'X';

  private int no;
  private String id;
  private String password;
  private char gender;
  private String storeName;
  private String contents;
  private String reply;

  public Gather() {}

  public Gather(int no) {
    this.no = no;
  }

  public static Gather fromCsv(String csv) {
    String[] values = csv.split(",");

    Gather gather = new Gather(Integer.parseInt(values[0]));
    gather.setId(values[1]);
    gather.setPassword(values[2]);
    gather.setGender(values[3].charAt(0));
    gather.setStoreName(values[4]);
    gather.setContents(values[5]);
    gather.setReply(values[6]);

    if (Gather.gatherNo <= gather.getNo()) {
      Gather.gatherNo = gather.getNo() + 1;
    }

    return gather;
  }

  @Override
  public void updateKey() {
    if (Gather.gatherNo <= this.no) {
      Gather.gatherNo = this.no + 1;
    }
  }

  @Override
  public String toCsvString() {
    return String.format("%d,%s,%s,%c,%s,%s,%s", this.getNo(), this.getId(), this.getPassword(),
        this.getGender(), this.getStoreName(), this.getContents(), this.getReply());
  }

  public String getReply() {
    return reply;
  }

  public void setReply(String reply) {
    this.reply = reply;
  }

  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }

    if (this.getClass() != obj.getClass()) {
      return false;
    }

    Gather gather = (Gather) obj;

    if (this.getNo() != gather.getNo()) {
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

  public char getGender() {
    return gender;
  }

  public void setGender(char gender) {
    this.gender = gender;
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
}

