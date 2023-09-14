package com.jotad9.crud.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jotad9.crud.model.Rutina;
import com.jotad9.crud.service.RutinaService;

@Controller
@RequestMapping
public class Controlador {

    @Autowired
    private RutinaService service;

    @GetMapping("/listar")
    public String listar(Model model) {
        // crea una lista de gimnasio de la interfaz service
        List<Rutina> gimnasio = service.listar();
        // "rutina" es el nombre de la variable que se va a usar en la vista
        model.addAttribute("rutina", gimnasio);
        return "index";
    }

    @GetMapping("/crear")
    public String agregar(Model model) {
        model.addAttribute("rutina", new Rutina());
        List<String> diasDeLaSemana = new ArrayList<String>();
        diasDeLaSemana.add("Lunes");
        diasDeLaSemana.add("Martes");
        diasDeLaSemana.add("Miercoles");
        diasDeLaSemana.add("Jueves");
        diasDeLaSemana.add("Viernes");
        diasDeLaSemana.add("Sabado");
        diasDeLaSemana.add("Domingo");
        model.addAttribute("diasDeLaSemana", diasDeLaSemana);
        return "form";
    }

    @PostMapping("/save")
    public String save(Rutina t, Model model) {
        service.save(t);
        return "redirect:/listar";
    }

    @GetMapping("/delete/{id}") 
    public String delete(@PathVariable int id, Model model, RedirectAttributes redirAttrs){ 
        service.delete(id);
        // Enviamos un mensaje a la vista principal 
        redirAttrs.addFlashAttribute("success", "Eliminado Correctamente !");
        return "redirect:/listar";
    }

    @GetMapping("/leer/{id}")
    @RequestMapping(value = "/leer/{id}", method = RequestMethod.GET)
    public String leer(@PathVariable("id")int id, Model model) {
        Optional<Rutina> laTarea= service.listarId(id);

        if(laTarea.isEmpty()){
            System.out.println("No existe");
        }else{
            System.out.println(laTarea.get().getDia());
        }
        model.addAttribute("rutina", laTarea);
        return "leer";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable int id, Model model) {
        Optional<Rutina> gimnasio = service.listarId(id);
        model.addAttribute("rutina", gimnasio);
        List<String> diasDeLaSemana = new ArrayList<String>();
        diasDeLaSemana.add("Lunes");
        diasDeLaSemana.add("Martes");
        diasDeLaSemana.add("Miercoles");
        diasDeLaSemana.add("Jueves");
        diasDeLaSemana.add("Viernes");
        diasDeLaSemana.add("Sabado");
        diasDeLaSemana.add("Domingo");
        model.addAttribute("diasDeLaSemana", diasDeLaSemana);
        return "editar";
    }
}
