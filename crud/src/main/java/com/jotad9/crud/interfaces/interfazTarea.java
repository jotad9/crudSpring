package com.jotad9.crud.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jotad9.crud.model.Tarea;

@Repository
public  interface interfazTarea extends CrudRepository<Tarea, Integer> {
    
}
