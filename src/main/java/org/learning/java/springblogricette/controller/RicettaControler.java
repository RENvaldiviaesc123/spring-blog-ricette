package org.learning.java.springblogricette.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import org.learning.java.springblogricette.model.Ricetta;
import org.learning.java.springblogricette.repository.RicettaRepository;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/ricette")
public class RicettaControler {
    @Autowired
    RicettaRepository ricettaRepository;
    //Metodo che mostra la lista delle ricette
    @GetMapping
    public String index (Model model){
        List<Ricetta> ricettaList = ricettaRepository.findAll();
        model.addAttribute("recipes", ricettaList);
        return "index";
    }

    //METODO PER LA CREATE DI UNA RICETTA
    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("ricetta", new Ricetta());
    return "nuovaricetta";
    }

    @PostMapping("/create")
    public String doCreate(@Valid@ModelAttribute("ricetta") Ricetta formRicetta, Model model, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            model.addAttribute("ricettaList",ricettaRepository.findAll());
            return "nuovaricetta";
        }
        ricettaRepository.save(formRicetta);
        return "redirect:/ricette";
    }


    //METODO PER UNA UPDATE DI UNA RICETTA


    //METODO PER LA DELETE DI UNA RICETTA

    //METODO SHOW CHE MOSTRA I DETTAGLI DI UNA RICETTA
        @GetMapping("/show/{ricettaId}")
        public String show (@PathVariable("ricettaId") Integer id, Model model){
            Optional<Ricetta> ricettaOptional = ricettaRepository.findById(id);

            if(ricettaOptional.isPresent()) {
            Ricetta ricettaFromDb = ricettaOptional.get();
            model.addAttribute("ricetta", ricettaFromDb);
            return "/detail";
            } else {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND);
            }
        }

}
