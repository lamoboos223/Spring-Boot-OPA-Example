package com.example.demo;

import java.util.List;

public class OpaRequestBodyDto {
  String user;
  List<String> path;
  String method;

  public OpaRequestBodyDto() {
  }

  public String getUser() {
    return user;
  }

  public void setUser(String user) {
    this.user = user;
  }

  public List<String> getPath() {
    return path;
  }

  public void setPath(List<String> path) {
    this.path = path;
  }

  public String getMethod() {
    return method;
  }

  public void setMethod(String method) {
    this.method = method;
  }
}
