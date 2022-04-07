package com.crud.crud.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import com.crud.crud.models.CrudModel;
import com.crud.crud.repositores.CrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CrudService {

    @Autowired
    private CrudRepository crudRepository;

    @Transactional
    public CrudModel save(CrudModel crudModel) {
        return crudRepository.save(crudModel);
    }
    
    public List<CrudModel>findAll(){
        return crudRepository.findAll();

    }


    public Optional<CrudModel>findById(UUID id ){
        return crudRepository.findById(id);

    }
    
    public void delete(CrudModel crudModel) {
      crudRepository.delete(crudModel);
    }
}
