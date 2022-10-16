/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.pedromedeiros2.grupostrabalhos.pessoa;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author Pedro Medeiros <phsm at aluno.ifnmg.edu.br>
 */

@Stateless
public class PessoaBean implements PessoaBeanLocal {

    @PersistenceContext(unitName = "GruposTrabalhoPU")
    private EntityManager entityManager;

    @Override
    public void save(Pessoa pessoa) {
        entityManager.persist(pessoa);
    } 

    
    ///Q1
    @Override
    public List<Pessoa> allPessoaQuery() {
        Query q = entityManager.createQuery("SELECT p FROM Pessoa p");
        return (List<Pessoa>) q.getResultList();
    }

    @Override
    public List<Pessoa> allPessoaTypedQuery() {
        TypedQuery q = entityManager.createQuery("SELECT p FROM Pessoa p",Pessoa.class);
        return q.getResultList();
    }

    @Override
    public List<Pessoa> allPessoaNamedQuery() {
        return entityManager.createNamedQuery("Pessoa.findAll",Pessoa.class).getResultList();
    }

    ///Q2
    @Override
    public List<String> namePessoaQuery() {
         Query q = entityManager.createQuery("SELECT p.nome FROM Pessoa p");
        return (List<String>) q.getResultList();
    }

    @Override
    public List<String> namePessoaTypedQuery() {
        TypedQuery q = entityManager.createQuery("SELECT p.nome FROM Pessoa p", String.class);
        return q.getResultList();
    }

    @Override
    public List<String> namePessoaNamedQuery() {
         return entityManager.createNamedQuery("Pessoa.findNome", String.class).getResultList();
    }
    
    ///Q2
    @Override
    public List<Object> nameEndPessoaQuery() {
         Query q = entityManager.createQuery("SELECT p.nome, e FROM Pessoa p, Endereco e Where p.endereco_id = e.id");
        return (List<Object>) q.getResultList();
    }

    @Override
    public List<Pessoa> nameEndPessoaTypedQuery() {
        TypedQuery q = entityManager.createQuery("SELECT p.nome, p.endereco FROM Pessoa p", Pessoa.class);
        return q.getResultList();
    }

    @Override
    public List<Pessoa> nameEndPessoaNamedQuery() {
         return entityManager.createNamedQuery("Pessoa.findNomeEndereco", Pessoa.class).getResultList();
    }

   
}
