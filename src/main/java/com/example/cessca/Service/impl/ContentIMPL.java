package com.example.cessca.Service.impl;

import com.example.cessca.Dto.ContentDto;
import com.example.cessca.Entity.ContentEntity;
import com.example.cessca.Entity.CustomerEntity;
import com.example.cessca.Entity.NormEntity;
import com.example.cessca.Entity.RequirementEntity;
import com.example.cessca.Repository.ContentRepository;
import com.example.cessca.Repository.CustomerRepository;
import com.example.cessca.Repository.NormRepository;
import com.example.cessca.Repository.RequirementRepository;
import com.example.cessca.Service.ContentService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.NoSuchElementException;

@Slf4j
@Service
@AllArgsConstructor
public class ContentIMPL implements ContentService {
    private final NormRepository normRepository;
    private final RequirementRepository requirementRepository;
    private final CustomerRepository customerRepository;
    private final ContentRepository contentRepository;

    @Override
    public int createContent(ContentDto contentDto) {
        NormEntity normEntity = normRepository.findById(contentDto.getNormId())
                .orElseThrow(() -> new NoSuchElementException("No se encontro la norma con el id " + contentDto.getNormId()));

        RequirementEntity requirementEntity = requirementRepository.findById(contentDto.getRequirementId())
                .orElseThrow(() -> new NoSuchElementException(("No se encontro el requerimiento con el id" + contentDto.getRequirementId())));

        CustomerEntity customerEntity = customerRepository.findById(contentDto.getCustomerId())
                .orElseThrow(() -> new NoSuchElementException("No se encontro el cliente con el id" + contentDto.getCustomerId()));

        var contentEntity = ContentEntity.builder()
                .customer(customerEntity)
                .normId(normEntity)
                .requirementId(requirementEntity)
                .contains(contentDto.isContains())
                .doesNotContain(contentDto.isDoesNotContain())
                .notApplicable(contentDto.isNotApplicable())
                .obsertations(contentDto.getObservations())
                .annualValidity(Date.valueOf(contentDto.getAnnualValidity()))
                .archive(contentDto.getArchive()).build();
        contentRepository.save(contentEntity);
        return contentEntity.getId();
    }
}
