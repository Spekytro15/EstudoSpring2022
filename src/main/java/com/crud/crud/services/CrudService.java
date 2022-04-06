package com.crud.crud.services;

import javax.transaction.Transactional;

import com.crud.crud.models.CrudModel;
import com.crud.crud.repositores.CrudRepository ;
import org.springframework.stereotype.Service;

@Service
public class CrudService {
   
   final CrudRepository crudRepository;

   public CrudService(CrudRepository crudRepository){
       this.crudRepository = crudRepository;
   }


@Transactional
public static  CrudModel save(CrudModel crudModel) {
    return crudRepository.save(crudModel);
}
}
