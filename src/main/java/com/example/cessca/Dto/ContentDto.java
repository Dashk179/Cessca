package com.example.cessca.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ContentDto {
    private int contentId;
    private int customerId;
    private int normId;
    private int requirementId;
    private boolean contains;
    private boolean doesNotContain;
    private boolean notApplicable;
    private String observations;
    private LocalDate annualValidity;
    private String archive;
}
