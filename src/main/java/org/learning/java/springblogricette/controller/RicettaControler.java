package java.org.learning.java.springblogricette.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.org.learning.java.springblogricette.model.Ricetta;
import java.org.learning.java.springblogricette.repository.RicettaRepository;
import java.util.List;

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

    //METODO PER UNA UPDATE DI UNA RICETTA


    //METODO PER LA DELETE DI UNA RICETTA



}
