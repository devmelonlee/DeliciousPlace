package devmelonlee.delicious_place.vo;

import java.io.Serializable;
import java.sql.Timestamp;

public class User implements Serializable {

  private static final long serialVersionUID = 1L;

  private int id;
  private String role;
  private String email;
  private String password;
  private String gender;
  private Timestamp createdAt;
  private Timestamp updatedAt;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
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


  // 비밀번호 체크할 때
  // @Override
  // public int hashCode() {
  // return Objects.hash(no);
  // }

  // @Override
  // public boolean equals(Object obj) {
  // if (this == obj)
  // return true;
  // if (obj == null)
  // return false;
  // if (getClass() != obj.getClass())
  // return false;
  // Gather other = (Gather) obj;
  // return no == other.no;
  // }
  //



}
