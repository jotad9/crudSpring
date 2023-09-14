package com.jotad9.crud.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jotad9.crud.model.Rutina;

@Repository
public  interface RepositoryRutina extends CrudRepository<Rutina, Integer> {
    
}
