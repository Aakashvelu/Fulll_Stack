package com.becenquiry.aakash.model;
import static jakarta.persistence.GenerationType.UUID;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
public class Enquiry {

    @Id
    @GeneratedValue(strategy = UUID)
    private String enquiryId;

    // @Temporal(TemporalType.DATE)
    private String email;
 
    private String name;

    private String title;
 
    private String description;
 

    private String user_id;

}