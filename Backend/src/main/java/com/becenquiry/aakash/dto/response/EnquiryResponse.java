package com.becenquiry.aakash.dto.response;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EnquiryResponse {
    private String enquiryId; 
    private String title;
    private String email;
    private String description;
    private String name;
    private String message;
    private String user_id;
}
