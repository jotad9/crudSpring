package com.jotad9.crud.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "rutina")
public class Rutina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String dia;
    private String parteDelCuerpo;


    public Rutina() {
    }
    
    public Rutina(int id, String dia, String parteDelCuerpo) {
        this.id = id;
        this.dia = dia;
        this.parteDelCuerpo = parteDelCuerpo;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getDia() {
        return dia;
    }
    public void setDia(String dia) {
        this.dia = dia;
    }
    public String getParteDelCuerpo() {
        return parteDelCuerpo;
    }
    public void setParteDelCuerpo(String parteDelCuerpo) {
        this.parteDelCuerpo = parteDelCuerpo;
    }
    
}
