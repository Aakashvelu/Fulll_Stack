package com.becenquiry.aakash.service;

import com.becenquiry.aakash.dto.request.EnquiryRequest;
import com.becenquiry.aakash.dto.response.BasicResponse;
import com.becenquiry.aakash.dto.response.EnquiryResponse;

public interface EnquiryService {

    BasicResponse<EnquiryResponse> getEnUser();

    BasicResponse<EnquiryResponse> createEnquiry(String courseId);

    BasicResponse<EnquiryResponse> deleteEnquiry(String courseId);

    BasicResponse<EnquiryResponse> createEnquiry(EnquiryRequest courseRequest);

    BasicResponse<EnquiryResponse> updateCourse(String courseId, EnquiryRequest courseRequest);
}
