package com.example.cessca.Service.impl;

import com.example.cessca.Dto.RequirementDto;
import com.example.cessca.Entity.NormEntity;
import com.example.cessca.Entity.RequirementEntity;
import com.example.cessca.Repository.NormRepository;
import com.example.cessca.Repository.RequirementRepository;
import com.example.cessca.Service.RequirementService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;
@Slf4j
@Service
@AllArgsConstructor
public class RequirementIMPL implements RequirementService {
    private final RequirementRepository requirementRepository;
    private final NormRepository normRepository;
    @Override
    public String addRequirement(RequirementDto requirementDto) {
        NormEntity normEntity = normRepository.findById(requirementDto.getNormId())
                .orElseThrow(()->new NoSuchElementException("No se encontro la norma con el id " + requirementDto.getNormId()));

        var requirementEntity = RequirementEntity.builder()
                        .requirement(requirementDto.getRequirement())
                                .foundation(requirementDto.getFoundation())
                                        .normId(normEntity).build();

    requirementRepository.save(requirementEntity);
        return requirementEntity.getRequirement();
    }

    @Override
    public String deleteRequirement(RequirementDto requirementDto) {
        RequirementEntity requirementEntity = requirementRepository.findById(requirementDto.getRequirementId())
                .orElseThrow(()-> new NoSuchElementException("No se encontro el requerimieto con el id:" + requirementDto.getRequirementId()));

        this.requirementRepository.deleteById(requirementEntity.getId());
        return requirementEntity.getRequirement();
    }

    @Override
    public List<RequirementDto> allRequirementsOfANorm(RequirementDto requirementDto) {
        // Obtener el normId del DTO
        int normId = requirementDto.getNormId();
        log.info("El id de la norma que estás consultando: " + normId);

        // Consultar los requerimientos asociados al normId
        List<RequirementEntity> requirementEntities = requirementRepository.findByNormId(normId);

        // Mapear los objetos Entity a DTO
        List<RequirementDto> requirementDtos = requirementEntities.stream()
                .map(this::mapToRequirementDto)
                .collect(Collectors.toList());

        return requirementDtos;
    }

    private RequirementDto mapToRequirementDto(RequirementEntity requirementEntity) {
       return  RequirementDto.builder()
               .requirementId(requirementEntity.getId())
               .normId(requirementEntity.getNormId().getId())
               .requirement(requirementEntity.getRequirement())
               .foundation(requirementEntity.getFoundation()).build();
    }

}
