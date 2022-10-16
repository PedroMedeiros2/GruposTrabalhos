/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.pedromedeiros2.grupostrabalhos.grupo;

import io.github.pedromedeiros2.grupostrabalhos.atuacao.Atuacao;
import io.github.pedromedeiros2.grupostrabalhos.pessoa.Pessoa;
import java.io.Serializable;
import java.util.List;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author Pedro Medeiros <phsm at aluno.ifnmg.edu.br>
 */
@Entity
public class Grupo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(length = 65)
    private String nome;
    private Boolean ativo = true;
    
    
    @OneToMany(mappedBy = "grupo",cascade = CascadeType.ALL, orphanRemoval = true)
            private List<Atuacao> atuacoes;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "lider_id")
    @JsonbTransient
            private Pessoa lider;
    
    public Grupo() {}

    public Grupo(String nome, Boolean ativo) {
        this.nome = nome;
        this.ativo = ativo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return "io.github.pedromedeiros2.grupostrabalhos.grupo.Grupo[ id=" + getId() + " ]";
    }
    
    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the ativo
     */
    public Boolean getAtivo() {
        return ativo;
    }

    /**
     * @param ativo the ativo to set
     */
    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    /**
     * @return the atuacoes
     */
    public List<Atuacao> getAtuacoes() {
        return atuacoes;
    }

    /**
     * @param atuacoes the atuacoes to set
     */
    public void setAtuacoes(List<Atuacao> atuacoes) {
        this.atuacoes = atuacoes;
    }

    /**
     * @return the lider
     */
    public Pessoa getLider() {
        return lider;
    }

    /**
     * @param lider the lider to set
     */
    public void setLider(Pessoa lider) {
        this.lider = lider;
    }
}
