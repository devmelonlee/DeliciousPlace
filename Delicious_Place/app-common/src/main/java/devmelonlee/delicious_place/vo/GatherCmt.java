package devmelonlee.delicious_place.vo;

import java.io.Serializable;
import java.sql.Timestamp;

public class GatherCmt implements Serializable {

  private static final long serialVersionUID = 1L;

  private int commentId;
  private int postId; // 외래 키
  private int userId; // 외래 키
  private String content;
  private Timestamp createdAt;
  private Timestamp updatedAt;
  private User author; // 참조
  private Gather post; // 참조

  public int getCommentId() {
    return commentId;
  }

  public void setCommentId(int commentId) {
    this.commentId = commentId;
  }

  public int getPostId() {
    return postId;
  }

  public void setPostId(int postId) {
    this.postId = postId;
  }

  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public Timestamp getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Timestamp createdAt) {
    this.createdAt = createdAt;
  }

  public Timestamp getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(Timestamp updatedAt) {
    this.updatedAt = updatedAt;
  }

  public User getAuthor() {
    return author;
  }

  public void setAuthor(User author) {
    this.author = author;
  }

  public Gather getPost() {
    return post;
  }

  public void setPost(Gather post) {
    this.post = post;
  }



}
