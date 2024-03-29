package com.example.cessca.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "content")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ContentEntity implements Serializable {
    @Id
    @Column(name = "Id", length = 45)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_customer")
    private CustomerEntity customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_norm")
    private NormEntity normId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_requirement")
    private RequirementEntity requirementId;

    @Column(name = "contains")
    private boolean contains;

    @Column(name = "does_not_contain")
    private boolean doesNotContain;

    @Column(name = "not_applicable")
    private boolean notApplicable;

    @Column(name = "observations")
    private String obsertations;

    @Column(name = "annual_validity")
    private Date annualValidity;

    @Column(name = "archive")
    private String archive;



}
