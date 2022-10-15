/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.pedromedeiros2.grupostrabalho.pessoa;

import io.github.pedromedeiros2.grupostrabalho.endereco.Endereco;
import io.github.pedromedeiros2.grupostrabalho.telefone.Telefone;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

/**
 *
 * @author Pedro Medeiros <phsm at aluno.ifnmg.edu.br>
 */
@Entity
public class Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(length = 65)
    private String nome;
    @Column(length = 250)
    private String email;
    private LocalDate nascimento;
    @Transient
    private Byte idade;

    
    public Pessoa() {}

    public Pessoa(String nome, String email, LocalDate nascimento, Byte idade) {
        this.nome = nome;
        this.email = email;
        this.nascimento = nascimento;
        this.idade = idade;
    }
    
    
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "pessoa_id")
            private List<Telefone> telefones;
    
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "pessoa_id")
            private List<Endereco> endereco;
    
    
    
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "io.github.pedromedeiros2.grupostrabalhos.pessoa.Pessoa[ id=" + id + " ]";
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
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the nascimento
     */
    public LocalDate getNascimento() {
        return nascimento;
    }

    /**
     * @param nascimento the nascimento to set
     */
    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }

    /**
     * @return the idade
     */
    public Byte getIdade() {
        return idade;
    }

    /**
     * @param idade the idade to set
     */
    public void setIdade(Byte idade) {
        this.idade = idade;
    }
    
    
    
}
