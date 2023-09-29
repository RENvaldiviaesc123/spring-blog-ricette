package org.learning.java.springblogricette.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Entity
@Table(name = "recipes")
public class Ricetta {
    //ATTRIBUTI
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank(message = "Inserisca alcun ingrediente")
    private String title;
    @NotBlank(message = "Inserisca alcun ingrediente")
    private String ingredients;
    @NotBlank(message = "Aggiungi una foto")
    private String foto;
    @NotBlank(message = "Non dimenticare il tempo")
    private String time;
    @Max(15)
    @Min(1)
    @NotNull
    private Integer portions;
    @Column(length = 500)
    @NotBlank(message = "Inserisca una descrizione")
    private String description;

    @ManyToOne
    private Categoria categoria ;


    //GETTER E SETTER

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getPortions() {
        return portions;
    }

    public void setPortions(Integer portions) {
        this.portions = portions;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    //METODI




}
