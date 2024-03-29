package com.example.cessca.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class RequirementDto {
    private int requirementId;
    private int normId;
    private String requirement;
    private String foundation;
}
