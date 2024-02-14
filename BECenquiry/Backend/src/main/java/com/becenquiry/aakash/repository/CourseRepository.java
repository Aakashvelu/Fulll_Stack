package com.becenquiry.aakash.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.becenquiry.aakash.model.Courses;

public interface CourseRepository extends JpaRepository<Courses, String> {

    
}
