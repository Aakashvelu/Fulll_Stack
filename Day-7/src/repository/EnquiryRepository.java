package com.becenquiry.aakash.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.becenquiry.aakash.model.Enquiry;

public interface EnquiryRepository extends JpaRepository<Enquiry, String>{

}
