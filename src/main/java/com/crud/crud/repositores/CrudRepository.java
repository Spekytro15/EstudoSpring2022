package com.crud.crud.repositores;

import com.crud.crud.models.CrudModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository

public interface CrudRepository extends JpaRepository <CrudModel, UUID> {
    
}
