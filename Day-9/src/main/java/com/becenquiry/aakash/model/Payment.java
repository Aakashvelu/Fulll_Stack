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
@Table(name="payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = UUID)
    @Column(name = "payment_id")
    private String id;

    @Column(nullable = false)
    private String amount;

    @Column(nullable = false)
    private String user_id;

    @Column(nullable = false)
    private String course_id;



}

