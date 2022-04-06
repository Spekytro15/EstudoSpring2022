package com.crud.crud.dtos;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;


public class CrudDto {
    //se estiver algum campo fazio ele nem entra de fato 
    @NotBlank
    private String jt_codigo;
    @NotBlank
    private String jt_nome;
    @NotBlank
    private LocalDateTime jt_data_nascimento ;
    @NotBlank
    private Boolean Ativo;

    
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
        return Ativo;
    }
    public void setAtivo(Boolean ativo) {
        Ativo = ativo;
    }
  
    
}
