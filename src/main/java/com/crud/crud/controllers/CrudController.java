package com.crud.crud.controllers;

import java.time.LocalDateTime;
import java.time.ZoneId;

import javax.validation.Valid;

import com.crud.crud.dtos.CrudDto;
import com.crud.crud.models.CrudModel;
import com.crud.crud.services.CrudService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins ="*", maxAge = 3600)
@RequestMapping("/crud-on") //rota post
public class CrudController {
    
    @Autowired
    private CrudService crudService;

    private CrudModel crudModel;
  
    @PostMapping
    public ResponseEntity<Object> saveCrud(@RequestBody @Valid CrudDto crudDto){
        crudModel = new CrudModel();
        BeanUtils.copyProperties(crudDto, crudModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(this.crudService.save(crudModel));
    }
       
    
}
