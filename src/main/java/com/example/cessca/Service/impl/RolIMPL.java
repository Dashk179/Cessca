package com.example.cessca.Service.impl;

import com.example.cessca.Dto.RolDto;
import com.example.cessca.Entity.RolEntity;
import com.example.cessca.Repository.RolRepository;
import com.example.cessca.Service.RolService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RolIMPL implements RolService {
    private final RolRepository rolRepository;
    @Override
    public String addRol(RolDto rolDto) {

        RolEntity rolEntity = new RolEntity(
                rolDto.getRolId(),
                rolDto.getName()
        );
        rolRepository.save(rolEntity);
        return rolEntity.getName();
    }

    @Override
    public String deleteRol(RolDto rolDto) {
        RolEntity rolEntity = rolRepository.findById(rolDto.getRolId())
                .orElseThrow(()->new NoSuchElementException("No se encontro el rol con el ID: " + rolDto.getRolId()));
        this.rolRepository.deleteById(rolDto.getRolId());
        return rolDto.getName();
    }

    @Override
    public List<String> getAllRol() {
        return rolRepository.findAll().stream()
                .map(RolEntity::getName)
                .collect(Collectors.toList());
    }
}
