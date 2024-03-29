package com.example.cessca.EmpleadoController;

import com.example.cessca.Dto.RequirementDto;
import com.example.cessca.Service.RequirementService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@CrossOrigin
@RequestMapping(path = "cessca/v1/requirement")
public class RequirementController {
    private  final RequirementService requirementService;

    public RequirementController(RequirementService requirementService) {
        this.requirementService = requirementService;
    }


    @PostMapping(path = "/save")
    public String saveRequirement(@RequestBody RequirementDto requirementDto){
        String id = requirementService.addRequirement(requirementDto);
        return id;
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteRequirement(@RequestBody RequirementDto requirementDto){
        log.info("Id del requerimiento a eliminar {}",requirementDto.getRequirementId());
        this.requirementService.deleteRequirement(requirementDto);
        return  ResponseEntity.noContent().build();
    }

    @PostMapping("/allRequirementsOfANorm")
    public String getAllRequirementsOfANorm(@RequestBody RequirementDto requirementDto) {
        return requirementService.allRequirementsOfANorm(requirementDto).toString();
    }
}
