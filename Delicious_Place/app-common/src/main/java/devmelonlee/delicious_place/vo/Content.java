package devmelonlee.delicious_place.vo;

import java.io.Serializable;
import java.sql.Timestamp;

public class Content implements Serializable {

  private static final long serialVersionUID = 1L;

  private int contentId;
  private String storeName;
  private String contents;
  private String eatMenu;
  private int hasReceipt;
  private int starRating;
  private int likeButton;
  private int viewCount;
  private Timestamp createdAt;
  private int authorId;// 지운다.
  private String authorEmail; // 지운다.
  private String gender; // 지운다. 회원에서 가져옵니다.
  private User author; // 얘로 참조한다.



  public int getContentId() {
    return contentId;
  }

  public void setContentId(int contentId) {
    this.contentId = contentId;
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

  public String getEatMenu() {
    return eatMenu;
  }

  public void setEatMenu(String eatMenu) {
    this.eatMenu = eatMenu;
  }

  public int getHasReceipt() {
    return hasReceipt;
  }

  public void setHasReceipt(int hasReceipt) {
    this.hasReceipt = hasReceipt;
  }

  public int getStarRating() {
    return starRating;
  }

  public void setStarRating(int starRating) {
    this.starRating = starRating;
  }

  public int getLikeButton() {
    return likeButton;
  }

  public void setLikeButton(int likeButton) {
    this.likeButton = likeButton;
  }

  public int getViewCount() {
    return viewCount;
  }

  public void setViewCount(int viewCount) {
    this.viewCount = viewCount;
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

  public String getAuthorEmail() {
    return authorEmail;
  }

  public void setAuthorEmail(String authorEmail) {
    this.authorEmail = authorEmail;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public User getAuthor() {
    return author;
  }

  public void setAuthor(User author) {
    this.author = author;
  }



}
