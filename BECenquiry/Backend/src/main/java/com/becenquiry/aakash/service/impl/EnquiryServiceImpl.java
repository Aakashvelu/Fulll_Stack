package com.becenquiry.aakash.service.impl;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.becenquiry.aakash.dto.request.EnquiryRequest;
import com.becenquiry.aakash.dto.response.BasicResponse;
import com.becenquiry.aakash.dto.response.EnquiryResponse;
import com.becenquiry.aakash.model.Enquiry;
import com.becenquiry.aakash.repository.EnquiryRepository;
import com.becenquiry.aakash.service.EnquiryService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EnquiryServiceImpl implements EnquiryService {

    private final EnquiryRepository enquiryRepository;

    @Override
    public BasicResponse<EnquiryResponse> getAllenquiry() {
        List<Enquiry> enquiries = enquiryRepository.findAll();
        List<EnquiryResponse> payResponses = enquiries.stream()
                .map(enquiry -> EnquiryResponse.builder()
                .enquiryId(enquiry.getEnquiryId())
                .email(enquiry.getEmail())
                .name(enquiry.getName())
                .title(enquiry.getTitle())
                .description(enquiry.getDescription())
                .user_id(enquiry.getUser_id())
                        .build())
                .collect(Collectors.toList());

        return BasicResponse.<EnquiryResponse>builder()
                .message("Payment Data fetched").data(payResponses).build();
    }

    @Override
    public EnquiryResponse register(EnquiryRequest request) {
       Enquiry enquiry = Enquiry.builder()
       .title(request.getTitle())
       .name(request.getName())
       .email(request.getEmail())
       .description(request.getDescription())
       .build();
        enquiryRepository.save(enquiry);
        return EnquiryResponse.builder()
                .message("Enquiry Registered Successfully")
                .build();
    }

    @Override
    public BasicResponse<EnquiryResponse> deleteEnquiry(String enquiryId) {
        if (enquiryRepository.existsById(enquiryId)) {
            enquiryRepository.deleteById(enquiryId);
            return BasicResponse.<EnquiryResponse>builder()
                    .message("Enquiry deleted successfully")
                    .build();
        } else {
            return BasicResponse.<EnquiryResponse>builder()
                    .message("Payment found with ID: " + enquiryId)
                    .build();
        }
    }


}