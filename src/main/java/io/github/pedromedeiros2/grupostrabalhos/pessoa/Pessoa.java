/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.pedromedeiros2.grupostrabalhos.pessoa;

import io.github.pedromedeiros2.grupostrabalhos.atuacao.Atuacao;
import io.github.pedromedeiros2.grupostrabalhos.endereco.Endereco;
import io.github.pedromedeiros2.grupostrabalhos.grupo.Grupo;
import io.github.pedromedeiros2.grupostrabalhos.telefone.Telefone;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

/**
 *
 * @author Pedro Medeiros <phsm at aluno.ifnmg.edu.br>
 */
@Entity
@NamedQueries({
    @NamedQuery( name = "Pessoa.findAll", query = "SELECT p FROM Pessoa p"),
    @NamedQuery(name = "Pessoa.findNome", query = "SELECT p.nome FROM Pessoa p"),
    @NamedQuery(name = "Pessoa.findNomeEndereco", query = "SELECT p.nome, p.endereco FROM Pessoa p"),
    @NamedQuery(name = "Pessoa.findPessoaMoramAvenida", query = "SELECT p FROM Pessoa p WHERE p.endereco.tipoLogradouro = 1"),
    @NamedQuery(name = "Pessoa.findPessoaNaoMoramPraca", query = "SELECT p FROM Pessoa p WHERE NOT p.endereco.tipoLogradouro = 2"),
    @NamedQuery(name = "Pessoa.findPessoaNomeTelefone", query = "SELECT p.nome, t FROM Pessoa p, IN (p.telefones) t")
})
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
    
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "pessoa_id")
            private List<Telefone> telefones;
    
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "endereco_id")
            private Endereco endereco;
    
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "pessoa_id")
            private List<Atuacao> atuacoes;
    
    @OneToMany(mappedBy = "lider", cascade = CascadeType.ALL, orphanRemoval = true)
            private List<Grupo> grupos;
    
    
    
    public Pessoa() {
        telefones = new ArrayList<>();
        atuacoes = new ArrayList<>();
        grupos = new ArrayList<>();
    }

    public Pessoa(String nome, String email, LocalDate nascimento) {
        this.nome = nome;
        this.email = email;
        this.nascimento = nascimento;
        this.idade = (byte) (LocalDate.now().getYear() - this.nascimento.getYear());
    }
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "io.github.pedromedeiros2.grupostrabalhos.pessoa.Pessoa[ id=" + getId() + " ]";
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
        this.setIdade((Byte) (byte) (LocalDate.now().getYear() - this.nascimento.getYear()));
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

    /**
     * @return the telefones
     */
    public List<Telefone> getTelefones() {
        return telefones;
    }

    /**
     * @param telefones the telefones to set
     */
    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }

    /**
     * @return the endereco
     */
    public Endereco getEndereco() {
        return endereco;
    }

    /**
     * @param endereco the endereco to set
     */
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
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
     * @return the grupos
     */
    public List<Grupo> getGrupos() {
        return grupos;
    }

    /**
     * @param grupos the grupos to set
     */
    public void setGrupos(List<Grupo> grupos) {
        this.grupos = grupos;
    }
    
    
    
}
