package com.becenquiry.aakash.service;

import com.becenquiry.aakash.dto.request.EnquiryRequest;
import com.becenquiry.aakash.dto.response.BasicResponse;
import com.becenquiry.aakash.dto.response.EnquiryResponse;

public interface EnquiryService {

    BasicResponse<EnquiryResponse> getAllenquiry();

    EnquiryResponse register(EnquiryRequest request);

    BasicResponse<EnquiryResponse> deleteEnquiry(String enquiryId);

    
}
