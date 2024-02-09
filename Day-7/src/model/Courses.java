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
    private String id;

    // @Column(nullable = false)
    private String course;

    // @Column(nullable = false)
    private String summary;

    // @Column(nullable = false)
    private String courseImage;

    // @Column(nullable = false)
    private String cost;

    // @Column(nullable = false)
    private String duration;

    public void setEnquiry(String enquiry) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setEnquiry'");
    }


    


}
