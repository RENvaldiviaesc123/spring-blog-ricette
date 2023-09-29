package org.learning.java.springblogricette.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Entity
@Table(name = "categories")
public class Categoria {
    //ATTRIBUTES
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank(message = "Inserisce una categoria")
    private String name;

    @OneToMany(mappedBy = "categoria", cascade = {CascadeType.REMOVE})
    @NotNull
    private List<Ricetta> ricettaList;

    //GETTER E SETTER

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Ricetta> getRicettaList() {
        return ricettaList;
    }

    public void setRicettaList(List<Ricetta> ricettaList) {
        this.ricettaList = ricettaList;
    }

    //METODI


}
