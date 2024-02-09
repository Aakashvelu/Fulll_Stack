package com.becenquiry.aakash.model;



import static jakarta.persistence.GenerationType.*;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name="enquiry")
public class Enquiry {

    @Id
    @GeneratedValue(strategy = UUID)
    @Column(name = "enquiry_id")
    private String id;

    // @Column(nullable = false)
    private String enquiry;

    // @Column(nullable = false)
    private String user_id;

    // @Column(nullable = false)
    private String course_id;

    // @ManyToOne
    // @JoinColumn(name = "courses_id")
    // private Courses courses;



}
