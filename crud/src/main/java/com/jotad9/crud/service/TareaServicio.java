package com.jotad9.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jotad9.crud.interfaceService.InterfazService;
import com.jotad9.crud.interfaces.interfazTarea;
import com.jotad9.crud.model.Tarea;

@Service
public class TareaServicio implements InterfazService {

    @Autowired
    private interfazTarea data;
    @Override
    public List<Tarea> listar() {
        return (List<Tarea>)data.findAll();
    }

    @Override
    public Optional<Tarea> listarId(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listarId'");
    }

    @Override
    public int save(Tarea t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public void delete(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
    
}
