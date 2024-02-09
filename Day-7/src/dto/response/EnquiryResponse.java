package com.becenquiry.aakash.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EnquiryResponse {
    private String message;
    private String id;
    private String user_id;
    private String enquiry;
    private String course_id;
}
