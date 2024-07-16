package com.example.calculationservice;
import com.example.api.Calculate2Api;
import com.example.api.CalculateApi;
import com.example.model.CalculateRequest;
import com.example.model.CalculateResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculateApiControllerImpl implements CalculateApi, Calculate2Api {

    @Override
    public ResponseEntity<CalculateResponse> calculatePost(CalculateRequest calculateRequest) {
        int result = calculateRequest.getNumber1() + calculateRequest.getNumber2();
        CalculateResponse response = new CalculateResponse();
        response.setResult(result);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<CalculateResponse> calculate2Post(CalculateRequest calculateRequest) {
        int result = calculateRequest.getNumber1() + calculateRequest.getNumber2();
        CalculateResponse response = new CalculateResponse();
        response.setResult(result);
        return ResponseEntity.ok(response);
    }
}
