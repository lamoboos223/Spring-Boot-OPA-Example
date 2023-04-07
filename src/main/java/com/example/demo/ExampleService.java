package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@GrpcService
public class ExampleService extends ExampleServiceGrpc.ExampleServiceImplBase {

  private final RestTemplate restTemplate;

  @Value("${opa.url}")
  String opaUrl;

  @Value("${opa.path}")
  List<String> opaPath;

  @Value("${opa.method}")
  String opaMethod;

  public ExampleService(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  @Override
  public void isAllowedToCheckSalary(ExampleRequest request,
                                     StreamObserver<ExampleResponse> responseObserver) {
    List<String> path = new ArrayList<>(opaPath);
    path.add(request.getEmployee());

    OpaRequestBodyDto opaRequestBodyDto = new OpaRequestBodyDto();
    opaRequestBodyDto.setUser(request.getCurrentUser());
    opaRequestBodyDto.setPath(path);
    opaRequestBodyDto.setMethod(opaMethod);
    OpaRequestDto opaRequestDto = new OpaRequestDto(opaRequestBodyDto);
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    headers.add(HttpHeaders.CONTENT_TYPE, "application/json");

    HttpEntity<Object> httpEntity = new HttpEntity<>(opaRequestDto, headers);

    ResponseEntity<OpaResponseDto> responseEntity =
        restTemplate.exchange(opaUrl, HttpMethod.POST, httpEntity, OpaResponseDto.class);

    ExampleResponse response = ExampleResponse.newBuilder()
        .setIsAllowed(responseEntity.getBody().getResult().isAllow())
        .build();

    path.clear();

    responseObserver.onNext(response);
    responseObserver.onCompleted();
  }

}
