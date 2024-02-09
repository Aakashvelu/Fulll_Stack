package com.becenquiry.aakash.service;

import com.becenquiry.aakash.dto.request.PaymentRequest;
import com.becenquiry.aakash.dto.response.BasicResponse;
import com.becenquiry.aakash.dto.response.PaymentResponse;

public interface PaymentService {

    BasicResponse<PaymentResponse> getAllUser();

    PaymentResponse register(PaymentRequest request);

    BasicResponse<PaymentResponse> deletepayment(String paymentId);

    BasicResponse<PaymentResponse> deletebooking(String paymentId);

    // BasicResponse<PaymentResponse> deletebooking(String paymentId);

    // BasicResponse<PaymentResponse> getUser();

}
