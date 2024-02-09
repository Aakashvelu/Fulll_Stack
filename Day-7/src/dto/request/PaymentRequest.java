package com.becenquiry.aakash.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentRequest {
    private String id;
    private String amount;
    private String status;
    private double amountPaid;
    private String message;
    private String modeOfPayment;

    
}
