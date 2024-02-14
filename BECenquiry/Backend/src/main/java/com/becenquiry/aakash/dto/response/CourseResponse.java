    package com.becenquiry.aakash.dto.response;

    import lombok.AllArgsConstructor;
    import lombok.Builder;
    import lombok.Data;
    import lombok.NoArgsConstructor;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public class CourseResponse {
        private String courseName;

    private String courseId;
    private String description;

    private String duration;
    private String img;

    private double cost;

    private String message;

    }
