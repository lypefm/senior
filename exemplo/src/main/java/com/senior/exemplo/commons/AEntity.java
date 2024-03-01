package com.senior.exemplo.commons;

import jakarta.persistence.*;

import java.time.OffsetDateTime;

@MappedSuperclass
public abstract class AEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data_registro", columnDefinition = "TIMESTAMP")
    private OffsetDateTime dataRegistro;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OffsetDateTime getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(OffsetDateTime dataRegistro) {
        this.dataRegistro = dataRegistro;
    }
}
