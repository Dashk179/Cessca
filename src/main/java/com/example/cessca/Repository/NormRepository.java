package com.example.cessca.Repository;

import com.example.cessca.Entity.NormEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface NormRepository extends JpaRepository<NormEntity, Integer> {
    Optional<NormEntity> findByIdAndName(Integer id,String name);
    NormEntity findByName(String name);
}
