package com.crud.crud.dtos;



import javax.validation.constraints.NotBlank;



import lombok.Getter;
import lombok.Setter;

@Setter

@Getter

public class CrudDto {
    //se estiver algum campo fazio ele nem entra de fato 
    @NotBlank
    private String jt_codigo;
    
    @NotBlank
    private String jt_nome;

    @NotBlank
    private String jt_data_nascimento;


    private Boolean ativo;


    
    
}
