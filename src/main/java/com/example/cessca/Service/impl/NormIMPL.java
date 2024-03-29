package com.example.cessca.Service.impl;

import com.example.cessca.Dto.NormDto;
import com.example.cessca.Entity.NormEntity;
import com.example.cessca.Repository.NormRepository;
import com.example.cessca.Repository.RequirementRepository;
import com.example.cessca.Service.NormService;
import com.example.cessca.util.exceptions.IdNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class NormIMPL  implements NormService {
    private final NormRepository normRepository;
    private final RequirementRepository requirementRepository;
    @Override
    public String addNorm(NormDto normDto) {
       var normEntity = NormEntity.builder()
                       .Id(normDto.getNormId())
                               .name(normDto.getName())
                                       .description(normDto.getDescription()).build();
        normRepository.save(normEntity);
        return normEntity.getName();
    }

    @Override
    public String deleteNorm(NormDto normDto) {
        NormEntity normEntity = normRepository.findById(normDto.getNormId())
                .orElseThrow(()-> new IdNotFoundException("Norm"));
        this.normRepository.deleteById(normEntity.getId());
        return normEntity.getName();
    }

    @Override
    public String updateNorm(NormDto normDto) {
        NormEntity normEntity = normRepository.findById(normDto.getNormId())
                .orElseThrow(()-> new IdNotFoundException("Norm"));
        normEntity.setName(normDto.getName());
        normEntity.setDescription(normDto.getDescription());
        normRepository.save(normEntity);
        var message = ("La norma: "+ normEntity.getName() + " ha sido actualizada correctamente");
        return message;
    }

    @Override
    public List<NormDto> getAllNormsNames() {
        return normRepository.findAll().stream()
                .map(this::mapToNormDto)
                .collect(Collectors.toList());
    }

    private NormDto mapToNormDto(NormEntity normEntity){
        return  NormDto.builder()
                .normId(normEntity.getId())
                .name(normEntity.getName())
                .description(normEntity.getDescription())
                .build();
    }


}
