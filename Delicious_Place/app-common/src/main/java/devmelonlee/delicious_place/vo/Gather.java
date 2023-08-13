package devmelonlee.delicious_place.vo;

import java.io.Serializable;
import java.sql.Timestamp;

public class Gather implements Serializable {

  private static final long serialVersionUID = 1L;

  private int postId;
  private String postName;
  private String storeName;
  private String content;
  private int desiredAttendees;
  private int currentAttendees;
  private Timestamp appointmentTime;
  private Timestamp createdAt;
  private int authorId;
  private User author;

  public int getPostId() {
    return postId;
  }

  public void setPostId(int postId) {
    this.postId = postId;
  }

  public String getPostName() {
    return postName;
  }

  public void setPostName(String postName) {
    this.postName = postName;
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

  public int getDesiredAttendees() {
    return desiredAttendees;
  }

  public void setDesiredAttendees(int desiredAttendees) {
    this.desiredAttendees = desiredAttendees;
  }

  public int getCurrentAttendees() {
    return currentAttendees;
  }

  public void setCurrentAttendees(int currentAttendees) {
    this.currentAttendees = currentAttendees;
  }

  public Timestamp getAppointmentTime() {
    return appointmentTime;
  }

  public void setAppointmentTime(Timestamp appointmentTime) {
    this.appointmentTime = appointmentTime;
  }

  public Timestamp getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Timestamp createdAt) {
    this.createdAt = createdAt;
  }

  public int getAuthorId() {
    return authorId;
  }

  public void setAuthorId(int authorId) {
    this.authorId = authorId;
  }

  public User getAuthor() {
    return author;
  }

  public void setAuthor(User author) {
    this.author = author;
  }

}

