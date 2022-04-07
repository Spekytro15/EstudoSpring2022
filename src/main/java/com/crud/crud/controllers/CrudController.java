package com.crud.crud.controllers;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.validation.Valid;

import com.crud.crud.dtos.CrudDto;
import com.crud.crud.models.CrudModel;
import com.crud.crud.services.CrudService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;

@Data

@RestController
@CrossOrigin(origins ="*", maxAge = 3600)
@RequestMapping("/crud-on") //rota post

public class CrudController {
    
    @Autowired
    private CrudService crudService;

    private CrudModel crudModel;
     
    //create
    @PostMapping
    public ResponseEntity<Object> saveCrud(@RequestBody @Valid CrudDto crudDto){

        crudModel = new CrudModel();
        BeanUtils.copyProperties(crudDto, crudModel);

        return ResponseEntity.status(HttpStatus.CREATED).body(this.crudService.save(crudModel));
    }
    //Read all
  @GetMapping
  public ResponseEntity<List<CrudModel>>getallCrud(){
      //codigo responsavel para enviar dados ResponseEntity para body 
      return ResponseEntity.status(HttpStatus.OK).body(this.crudService.findAll());
  }
   //Read one
  @GetMapping("/{id}")
  public ResponseEntity<Object>getOneCrud(@PathVariable(value="id") UUID id){
      //@PathVariable para pegar id da url 

      //função findById ja existe no repository
      Optional<CrudModel> crudModelOptional = crudService.findById(id);

      //verifica se existe esse cadastro
      if(!crudModelOptional.isPresent()){ 
          return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Dados não encontrados");
      }
      return ResponseEntity.status(HttpStatus.OK).body(crudModelOptional.get());
    }

    //Delete
   @DeleteMapping("/{id}")
   public ResponseEntity<Object>DeleteOneCrud(@PathVariable(value="id") UUID id){

    Optional<CrudModel> crudModelOptional = crudService.findById(id);
    if(!crudModelOptional.isPresent()){ 
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Dados não encontrados");
    }
     crudService.delete(crudModelOptional.get());
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Dados Deletados com sucesso !");
}
    
//update
@PutMapping("/{id}")
public ResponseEntity<Object>DeleteOneCrud(@PathVariable(value="id") UUID id, //Pega o id
                                           @RequestBody @Valid CrudDto crudDto){// Valida ve se esta tudo ok deacordo com Dto

    Optional<CrudModel> crudModelOptional = crudService.findById(id);                                        
    if(!crudModelOptional.isPresent()){ 
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Dados não encontrados");
                                  }
    
    
    crudModel = crudModelOptional.get();
    crudModel.setJt_codigo(crudModel.getJt_codigo());
    crudModel.setJt_nome(crudDto.getJt_nome());
    crudModel.setJt_data_nascimento(crudDto.getJt_data_nascimento());
    crudModel.setAtivo(crudDto.getAtivo());
    
 


    return ResponseEntity.status(HttpStatus.CREATED).body(this.crudService.save(crudModel));
}
   
}
