package com.becenquiry.aakash.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.becenquiry.aakash.dto.request.PaymentRequest;
import com.becenquiry.aakash.dto.response.BasicResponse;
import com.becenquiry.aakash.dto.response.PaymentResponse;
import com.becenquiry.aakash.service.PaymentService;
import com.becenquiry.aakash.util.MyConstant;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class PaymentController {
    
    private final PaymentService payService;
    @GetMapping(MyConstant.PAYMENTLIST)
    public ResponseEntity<BasicResponse<PaymentResponse>> getUser(){
        BasicResponse<PaymentResponse> response=new BasicResponse<>();
        try{
            response=payService.getAllUser();
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch(Exception exception){
            response.setMessage("Something Went Wrong");
            return new ResponseEntity<>(response,HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PostMapping(MyConstant.PAYMENT)
    public ResponseEntity<PaymentResponse> register(@RequestBody PaymentRequest request) {
        PaymentResponse response=new PaymentResponse();

        try{
            response=payService.register(request);
            return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
        }
        catch(Exception e){
            response.setMessage("Something Went Wrong!!!!");
            return new ResponseEntity<>(response, HttpStatus.EXPECTATION_FAILED);
        }
        
    }
    @DeleteMapping(MyConstant.PAYMENT + "/{paymentId}")
    public ResponseEntity<BasicResponse<PaymentResponse>> deleteBooking(@PathVariable String paymentId) {
        BasicResponse<PaymentResponse> response = new BasicResponse<>();
        try {
            BasicResponse<PaymentResponse> deletedBookingResponse = payService.deletebooking(paymentId);
            response.setMessage(deletedBookingResponse.getMessage());
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response.setMessage("Failed to delete booking: " + e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



}
