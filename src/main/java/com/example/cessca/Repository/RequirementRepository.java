package com.example.cessca.Repository;

import com.example.cessca.Entity.RequirementEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.List;
import java.util.Optional;


public interface RequirementRepository extends JpaRepository<RequirementEntity,Integer> {

    @Query("SELECT r.requirement FROM RequirementEntity r WHERE r.normId.Id = :normId")
    List<RequirementEntity> findNamesByNormId(@Param("normId") Integer normId);
    @Query("SELECT r FROM RequirementEntity r WHERE r.normId.Id = :normId")
    List<RequirementEntity> findByNormId(@Param("normId") Integer normId);

}
