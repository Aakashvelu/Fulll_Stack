package com.becenquiry.aakash.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CourseRequest {
    private String id;
    private String course;
    private String summary;
    private String cost;
    private String duration;
    private String courseImage;
}
