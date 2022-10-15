/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.pedromedeiros2.grupostrabalho.atuacao;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Pedro Medeiros <phsm at aluno.ifnmg.edu.br>
 */
@Entity
public class Atuacao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private LocalDate inicio;
    private LocalDate termino;
    
     public Atuacao() {}

    public Atuacao(LocalDate inicio, LocalDate termino) {
        this.inicio = inicio;
        this.termino = termino;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "io.github.pedromedeiros2.grupostrabalhos.atuacao.Atuacao[ id=" + id + " ]";
    }

    /**
     * @return the inicio
     */
    public LocalDate getInicio() {
        return inicio;
    }

    /**
     * @param inicio the inicio to set
     */
    public void setInicio(LocalDate inicio) {
        this.inicio = inicio;
    }

    /**
     * @return the termino
     */
    public LocalDate getTermino() {
        return termino;
    }

    /**
     * @param termino the termino to set
     */
    public void setTermino(LocalDate termino) {
        this.termino = termino;
    }
    
}
