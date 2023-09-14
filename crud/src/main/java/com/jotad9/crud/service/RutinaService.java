package com.jotad9.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jotad9.crud.interfaceService.interfazRutina;
import com.jotad9.crud.model.Rutina;
import com.jotad9.crud.repository.RepositoryRutina;

@Service
public class RutinaService implements interfazRutina {

    @Autowired
    private RepositoryRutina data;
    @Override
    public List<Rutina> listar() {
        return (List<Rutina>)data.findAll();
    }

    @Override
    public Optional<Rutina> listarId(int id) {
        return this.data.findById(id);
    }

    @Override
    public Rutina save(Rutina t) {
        t.setDia(t.getDia());
        return this.data.save(t);
    }

    @Override
    public void delete(int id) {
        this.data.deleteById(id);
    }
    
}
