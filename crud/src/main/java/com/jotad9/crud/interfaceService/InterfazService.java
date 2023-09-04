package com.jotad9.crud.interfaceService;

import java.util.List;
import java.util.Optional;

import com.jotad9.crud.model.Rutina;

public interface InterfazService {
    public List<Rutina> listar();
    public Optional<Rutina> listarId(int id);
    public Rutina save(Rutina t);
    public void delete(int id);

}
