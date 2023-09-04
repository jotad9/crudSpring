package com.jotad9.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jotad9.crud.interfaceService.InterfazService;
import com.jotad9.crud.model.Rutina;
import com.jotad9.crud.repository.repositoryRutina;

@Service
public class RutinaService implements InterfazService {

    @Autowired
    private repositoryRutina data;
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
