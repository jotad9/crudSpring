package com.jotad9.crud.service;

import java.util.List;
import java.util.Optional;

import com.jotad9.crud.model.Rutina;

public interface RutinaService {
    public List<Rutina> listar();
    public Optional<Rutina> listarId(int id);
    public Rutina save(Rutina t);
    public void delete(int id);

}
