package com.crud.crud.models;

import javax.persistence.*; // importou tudo

import java.time.LocalDateTime;
import java.util.UUID;

import java.io.Serializable;

@Entity
@Table(name = "crud")


public class CrudModel implements Serializable {
    private static final long serialVersionUID = 1L;

    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false, unique = true, length = 100)
    private String jt_codigo;
    @Column(nullable = false, unique = true, length = 100)
    private String jt_nome;
    @Column(nullable = false, length = 70)
    private LocalDateTime jt_data_nascimento;
    @Column(nullable = false, length = 2)
    private Boolean ativo;
    
    public static long getSerialversionuid() {
        return serialVersionUID;
    }
    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }
    public String getJt_codigo() {
        return jt_codigo;
    }
    public void setJt_codigo(String jt_codigo) {
        this.jt_codigo = jt_codigo;
    }
    public String getJt_nome() {
        return jt_nome;
    }
    public void setJt_nome(String jt_nome) {
        this.jt_nome = jt_nome;
    }
    public LocalDateTime getJt_data_nascimento() {
        return jt_data_nascimento;
    }
    public void setJt_data_nascimento(LocalDateTime jt_data_nascimento) {
        this.jt_data_nascimento = jt_data_nascimento;
    }
    public Boolean getAtivo() {
        return ativo;
    }
    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }
    public void setRegistrationDate(LocalDateTime now) {
    }
    
    

}
