/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.pedromedeiros2.grupostrabalhos.pessoa;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Pedro Medeiros <phsm at aluno.ifnmg.edu.br>
 */
@Local
public interface PessoaBeanLocal {
    
    public void save(Pessoa pessoa);
    
    ///Q1
    public List<Pessoa> allPessoaQuery();
    public List<Pessoa> allPessoaTypedQuery();
    public List<Pessoa> allPessoaNamedQuery();
    
    ///Q2
    public List<String> namePessoaQuery();
    public List<String> namePessoaTypedQuery();
    public List<String> namePessoaNamedQuery();
    
    ///Q2
    public List<Object> nameEndPessoaQuery();
    public List<Pessoa> nameEndPessoaTypedQuery();
    public List<Pessoa> nameEndPessoaNamedQuery();
}
