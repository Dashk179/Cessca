package com.example.cessca.Repository;

import com.example.cessca.Entity.RolEntity;
import com.example.cessca.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RolRepository extends JpaRepository<RolEntity,Integer> {
Optional<RolEntity>  findOneByIdAndAndName(Integer id, String name);
    RolEntity findByName(String name);
}
