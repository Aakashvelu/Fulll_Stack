package com.becenquiry.aakash.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EnquiryRequest {
    private String id;
    private String user_id;
    private String enquiry;
    private String course_id;
    
    
}
