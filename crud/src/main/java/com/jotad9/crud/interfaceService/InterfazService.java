package com.jotad9.crud.interfaceService;

import java.util.List;
import java.util.Optional;

import com.jotad9.crud.model.Tarea;

public interface InterfazService {
    public List<Tarea> listar();
    public Optional<Tarea> listarId(int id);
    public int save(Tarea t);
    public void delete(int id);

}
