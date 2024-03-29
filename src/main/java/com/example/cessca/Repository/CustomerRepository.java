package com.example.cessca.Repository;

import com.example.cessca.Entity.CustomerEntity;
import com.example.cessca.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@EnableJpaRepositories
@Repository
public interface CustomerRepository  extends JpaRepository<CustomerEntity,Integer> {
    Optional<CustomerEntity> findOneByRfcAndPassword(String rfc, String password);

    @Query("SELECT c FROM CustomerEntity c WHERE c.rfc = :rfc")
    CustomerEntity findByRfc(@Param("rfc") String rfc);


}
