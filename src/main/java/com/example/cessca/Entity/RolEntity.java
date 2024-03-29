package com.example.cessca.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "rol")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class RolEntity implements Serializable {
    @Id
    @Column(name = "id",length = 45)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name",length = 255)
    private String name;
}
