package com.example.calculationservice;
import com.example.api.Calculate2Api;
import com.example.api.CalculateApi;
import com.example.api.CalculateTaxApi;
import com.example.model.CalculateRequest;
import com.example.model.CalculateResponse;
import com.example.model.CalculateTaxRequest;
import com.example.model.CalculateTaxResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CalculateApiControllerImpl implements CalculateTaxApi, CalculateApi, Calculate2Api {

    @Override
    public ResponseEntity<CalculateResponse> calculatePost(CalculateRequest calculateRequest) {
        int result = calculateRequest.getNumber1() + calculateRequest.getNumber2();
        System.out.println(result);
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


    @Override
    public ResponseEntity<CalculateTaxResponse> calculateTaxPost(CalculateTaxRequest calculateTaxRequest) {
        double tax = calculateTaxRequest.getSteuerbilanzgewinn().doubleValue() * 0.3;
        CalculateTaxResponse calculateTaxResponse = new CalculateTaxResponse();
        calculateTaxResponse.setResult(new BigDecimal(tax));
        return ResponseEntity.ok(calculateTaxResponse);
    }
}
