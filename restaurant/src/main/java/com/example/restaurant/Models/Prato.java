package com.example.restaurant.Models;


import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Prato {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String nome;

    private double preco;

    private boolean disponivel;
    
    
    

    public Prato(UUID id, double preco, boolean disponivel, String nome) {
        this.id = id;
        this.nome= nome;
        this.preco = preco;
        this.disponivel = disponivel;
    }

    @Override
    public String toString() {
        return "Prato [id=" + id + ", preco=" + preco + ", disponivel=" + disponivel + "]";
    }

    public Prato() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

      public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    



}
