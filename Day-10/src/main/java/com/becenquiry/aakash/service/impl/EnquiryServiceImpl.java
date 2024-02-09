package com.becenquiry.aakash.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.becenquiry.aakash.dto.request.EnquiryRequest;
import com.becenquiry.aakash.dto.response.BasicResponse;
import com.becenquiry.aakash.dto.response.CourseResponse;
import com.becenquiry.aakash.dto.response.EnquiryResponse;
import com.becenquiry.aakash.model.Courses;
import com.becenquiry.aakash.model.Enquiry;
import com.becenquiry.aakash.repository.EnquiryRepository;
import com.becenquiry.aakash.service.EnquiryService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EnquiryServiceImpl implements EnquiryService{

    private final EnquiryRepository enquiryRepository;

    @Override
    public BasicResponse<EnquiryResponse> getEnUser() {
        List<Enquiry> enquiries = enquiryRepository.findAll();
        List<EnquiryResponse> enquiryResponses = enquiries.stream().map(enquiry -> EnquiryResponse.builder()
        .id(enquiry.getId())
        .enquiry(enquiry.getEnquiry())
        .course_id(enquiry.getCourse_id())
        .user_id(enquiry.getUser_id())
        .build())
        .collect(Collectors.toList());

        return BasicResponse.<EnquiryResponse>builder()
                .message("Enquiry Data fetched").data(enquiryResponses).build();

    }

    @Override
    public BasicResponse<EnquiryResponse> createEnquiry(EnquiryRequest request) {
        var enquiry = Enquiry.builder()
            .id(request.getId())
            .enquiry(request.getEnquiry())
            .user_id(request.getUser_id())
            .course_id(request.getCourse_id())
            .build();
            enquiryRepository.save(enquiry);
            return BasicResponse.<EnquiryResponse>builder()
            .message("Success")
            .build();
    }

    @Override
    public BasicResponse<EnquiryResponse> deleteEnquiry(String courseId) {
        if (enquiryRepository.existsById(courseId)) {
            enquiryRepository.deleteById(courseId);
            return BasicResponse.<EnquiryResponse>builder()
                .message("Enquiry deleted successfully")
                .build();
        } else {
            return BasicResponse.<EnquiryResponse>builder()
                .message("Enquiry not found with ID: " + courseId)
                .build();
        }
    }

    @Override
    public BasicResponse<EnquiryResponse> createEnquiry(String courseId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createEnquiry'");
    }

    @Override
    public BasicResponse<EnquiryResponse> updateCourse(String enquiryId, EnquiryRequest courseRequest) {
        BasicResponse<EnquiryResponse> response = new BasicResponse<>();
        try {
            Optional<Enquiry> optionalCourse = enquiryRepository.findById(enquiryId);
            if (optionalCourse.isPresent()) {
                Enquiry existingCourse = optionalCourse.get();
                existingCourse.setEnquiry(courseRequest.getEnquiry());
                existingCourse.setCourse_id(courseRequest.getCourse_id());
                existingCourse.setUser_id(courseRequest.getUser_id());
                enquiryRepository.save(existingCourse);
                response.setMessage("Course updated successfully");
            } else {
                response.setMessage("Course not found with ID: " + enquiryId);
            }
        } catch (Exception e) {
            response.setMessage("Failed to update course: " + e.getMessage());
        }
        return response;
    }


}
