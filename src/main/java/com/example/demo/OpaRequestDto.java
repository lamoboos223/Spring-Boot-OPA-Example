package com.example.demo;

public class OpaRequestDto {
  OpaRequestBodyDto input;

  public OpaRequestDto(OpaRequestBodyDto input) {
    this.input = input;
  }

  public OpaRequestBodyDto getInput() {
    return input;
  }

  public void setInput(OpaRequestBodyDto input) {
    this.input = input;
  }
}
