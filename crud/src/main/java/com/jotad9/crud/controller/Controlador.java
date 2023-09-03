package com.jotad9.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jotad9.crud.interfaceService.InterfazService;
import com.jotad9.crud.model.Tarea;

@Controller
@RequestMapping
public class Controlador {

    @Autowired
    private InterfazService service;

    @GetMapping("/listar")
    public String listar(Model model){
        //crea una lista de tareas de la interfaz service
        List<Tarea> tareas = service.listar();
        //"tareas" es el nombre de la variable que se va a usar en la vista
        model.addAttribute("tareas", tareas);
        return "index";
    }
}
