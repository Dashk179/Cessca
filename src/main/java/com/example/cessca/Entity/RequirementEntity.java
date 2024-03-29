package com.example.cessca.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "requirement") // Nombre de la tabla en la base de datos
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class RequirementEntity implements Serializable {

    @Id
    @Column(name = "id",length = 45)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "requirement",length = 255)
    private String requirement;

    @Column(name = "foundation",length = 500)
    private String foundation;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "norm_id")
    private NormEntity normId;
}
