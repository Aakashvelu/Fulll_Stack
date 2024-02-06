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
@Table(name="transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = UUID)
    @Column(name = "transaction_id")
    private String id;


    @Column(nullable = false)
    private String payment_id;



}

