package com.becenquiry.aakash.model;

import static jakarta.persistence.GenerationType.*;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="courses")
public class Courses {

    @Id
    @GeneratedValue(strategy = UUID)
    @Column(name = "courses_id")
    private String courseId;

    @Column(nullable = false)
    private String courseName;

    @Column(nullable = false,length = 1000)
    private String description;

    @Column(nullable = false)
    private String duration;

    @Column(nullable = false)
    private double cost;

    @Column(nullable = false)
    private String img;
}
