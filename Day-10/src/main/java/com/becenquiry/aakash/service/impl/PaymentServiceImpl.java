package com.becenquiry.aakash.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.becenquiry.aakash.dto.request.PaymentRequest;
import com.becenquiry.aakash.dto.response.BasicResponse;
import com.becenquiry.aakash.dto.response.CourseResponse;
import com.becenquiry.aakash.dto.response.PaymentResponse;
import com.becenquiry.aakash.model.Courses;
import com.becenquiry.aakash.model.Payment;
import com.becenquiry.aakash.repository.PaymentRepository;
import com.becenquiry.aakash.service.PaymentService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository payRepository;

    @Override
    public BasicResponse<PaymentResponse> getAllUser() {
        List<Payment> courses = payRepository.findAll();
        List<PaymentResponse> payResponses = courses.stream().map(pay -> PaymentResponse.builder()
        .id(pay.getId())
        .amount(pay.getAmount())
        .amountPaid(pay.getAmountPaid())
        .status(pay.getStatus())
        .modeOfPayment(pay.getModeOfPayment())
        .build())
        .collect(Collectors.toList());

        return BasicResponse.<PaymentResponse>builder()
                .message("Payment Data fetched").data(payResponses).build();
    }

    // @Override
    // public PaymentResponse register(PaymentRequest request) {
    //     var payment = Payment.builder()
    //         .amount(request.getAmount())
    //         .amountPaid(request.getAmountPaid())
    //         .modeOfPayment(request.getModeOfPayment())
    //         .status(request.getStatus())
    //         .build();
    //     payRepository.save(payment);
    //     return BasicResponse.<PaymentResponse>builder().message("Success").build()
    //     // return BasicResponse.<PaymentResponse>builder()
    //     //     .message("Success")
    //     //     .build();

    //     }
    // }
    @Override
    public PaymentResponse register (PaymentRequest request) {
        Payment payment = Payment.builder()
        // .amount(request.getAmount())
        .id(request.getId())
        .status(request.getStatus())
        .amountPaid(request.getAmountPaid())
        .amount(request.getAmount())
                .modeOfPayment(request.getModeOfPayment())
                // .paymentDate(request.getPaymentDate())
                .build();
        payRepository.save(payment);
        return PaymentResponse.builder()
                .message("User Created Successfully")
                .build();
    }

    @Override
    public BasicResponse<PaymentResponse> deletebooking(String paymentId) {
        if (payRepository.existsById(paymentId)) {
            payRepository.deleteById(paymentId);
            return BasicResponse.<PaymentResponse>builder()
                    .message("Booking deleted successfully")
                    .build();
        } else {
            return BasicResponse.<PaymentResponse>builder()
                    .message("Booking not found with ID: " + paymentId)
                    .build();
        }
    }

    @Override
    public BasicResponse<PaymentResponse> deletepayment(String paymentId) {
        if (payRepository.existsById(paymentId)) {
            payRepository.deleteById(paymentId);
            return BasicResponse.<PaymentResponse>builder()
                    .message("Booking deleted successfully")
                    .build();
        } else {
            return BasicResponse.<PaymentResponse>builder()
                    .message("Booking not found with ID: " + paymentId)
                    .build();
        }
    }

    // @Override
    // public BasicResponse<PaymentResponse> getUser() {
    //     List<Payment> payments = payRepository.findAll();
    //     List<PaymentResponse> payResponses = payments.stream()
    //             .map(payment -> PaymentResponse.builder()
    //                     // .paymentId(payment.getPaymentId())
    //                     .amount(payment.getAmount())
    //                     .status(payment.getStatus())
    //                     .modeOfPayment(payment.getModeOfPayment())
    //                     .build())
    //             .collect(Collectors.toList());

    //     return BasicResponse.<PaymentResponse>builder()
    //             .message("Payment Data fetched").data(payResponses).build();
    // }
    
}
