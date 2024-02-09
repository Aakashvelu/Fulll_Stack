package com.becenquiry.aakash.service.impl;



import org.springframework.stereotype.Service;

import com.becenquiry.aakash.dto.request.CourseRequest;
import com.becenquiry.aakash.dto.response.BasicResponse;
import com.becenquiry.aakash.dto.response.CourseResponse;
import com.becenquiry.aakash.model.Courses;
import com.becenquiry.aakash.repository.CourseRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.becenquiry.aakash.service.CourseService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService{

    private final CourseRepository courseRepository;

    @Override
    public BasicResponse<CourseResponse> getUser() {
        List<Courses> courses = courseRepository.findAll();
        List<CourseResponse> courseResponses = courses.stream().map(course -> CourseResponse.builder()
        .id(course.getId())
        .summary(course.getSummary())
        .course(course.getCourse())
        .cost(course.getCost())
        .duration(course.getDuration())
        .courseImage(course.getCourseImage())
        .build())
        .collect(Collectors.toList());

        return BasicResponse.<CourseResponse>builder()
                .message("Payment Data fetched").data(courseResponses).build();

    }

   

    @Override
    public BasicResponse<CourseResponse> deleteCourse(String courseId) {
        if (courseRepository.existsById(courseId)) {
            courseRepository.deleteById(courseId);
            return BasicResponse.<CourseResponse>builder()
                .message("Booking deleted successfully")
                .build();
        } else {
            return BasicResponse.<CourseResponse>builder()
                .message("Booking not found with ID: " + courseId)
                .build();
        }

    }



    @Override
    public BasicResponse<CourseResponse> createCourse(CourseRequest request) {
        var book = Courses.builder()
            .id(request.getId())
            .summary(request.getSummary())
            .course(request.getCourse())
            .cost(request.getCost())
            .duration(request.getDuration())
            .courseImage(request.getCourseImage())
            .build();
        courseRepository.save(book);
        return BasicResponse.<CourseResponse>builder()
            .message("Success")
            .build();
        }




    

    @Override
    public BasicResponse<CourseResponse> updateCourse(String courseId, CourseRequest courseRequest) {
        BasicResponse<CourseResponse> response = new BasicResponse<>();
        try {
            Optional<Courses> optionalCourse = courseRepository.findById(courseId);
            if (optionalCourse.isPresent()) {
                Courses existingCourse = optionalCourse.get();
                existingCourse.setSummary(courseRequest.getSummary());
                existingCourse.setCourse(courseRequest.getCourse());
                existingCourse.setCost(courseRequest.getCost());
                existingCourse.setDuration(courseRequest.getDuration());
                existingCourse.setCourseImage(courseRequest.getCourseImage());
                courseRepository.save(existingCourse);
                response.setMessage("Course updated successfully");
            } else {
                response.setMessage("Course not found with ID: " + courseId);
            }
        } catch (Exception e) {
            response.setMessage("Failed to update course: " + e.getMessage());
        }
        return response;
    }



    @Override
    public BasicResponse<CourseResponse> createBooking(CourseRequest courseRequest) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createBooking'");
    }



  



    

}
