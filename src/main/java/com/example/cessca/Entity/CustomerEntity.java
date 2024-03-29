package com.example.cessca.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "customer") // Nombre de la tabla en la base de datos
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CustomerEntity implements Serializable {
    @Id
    @Column(name = "id", length = 45)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false,name = "rfc")
    private String rfc;

    @Column(name = "denomination")
    private String denomination;

    @Column(name = "address")
    private String address;

    @Column(name = "password")
    private String password;


    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "usercessca_id",nullable = true) // Nombre de la columna de clave foránea en "customer"
    private UserEntity userId;



}
