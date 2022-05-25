package com.springboot.demo2.springbootdemo2.entities;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

// @Data
// @AllArgsConstructor
// @NoArgsConstructor
@Entity
@Table(name = "USER_TBL")
public class User {
  @Id
  private int id;
  private String username;
  private String password;
  private String email;
  private Timestamp createtime;

  User() {
  }

  User(int id, String username, String password, String emai, Timestamp createtime) {
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String password) {
    this.password = password;
  }

  public Timestamp getCreatetime() {
    return createtime;
  }

  public void setCreatetime(Timestamp createtime) {
    this.createtime = createtime;
  }
}