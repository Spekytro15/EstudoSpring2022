package com.crud.crud.models;

import javax.persistence.*; // importou tudo

import lombok.Getter;
import lombok.Setter;


import java.time.LocalDateTime;
import java.util.UUID;


@Setter
@Getter

@Entity
@Table(name = "crud")


public class CrudModel  {
   
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;


    @Column(nullable = false, unique = true, length = 100)
    private String jt_codigo;

    @Column(nullable = false, length = 100)
    private String jt_nome;
    
    @Column(nullable = false, length = 70)
    private String jt_data_nascimento;

    @Column(length = 130)
    private Boolean ativo;
    



}
