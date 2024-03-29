package com.example.cessca.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "norm") // Nombre de la tabla en la base de datos
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class NormEntity implements Serializable {
    @Id
    @Column(name = "id",length = 45)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int  Id;

    @Column(name = "name",length = 255)
    private String name;

    @Column(name = "description",length = 255)
    private String description;

}
