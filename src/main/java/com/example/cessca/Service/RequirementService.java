package com.example.cessca.Service;

import com.example.cessca.Dto.RequirementDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public interface RequirementService {
    String addRequirement(RequirementDto requirementDto);
    String deleteRequirement(RequirementDto requirementDto);
    List<RequirementDto> allRequirementsOfANorm(RequirementDto requirementDto);
}
