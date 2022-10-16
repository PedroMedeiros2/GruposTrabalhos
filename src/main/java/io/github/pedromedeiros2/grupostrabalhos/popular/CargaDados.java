/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.pedromedeiros2.grupostrabalhos.popular;

import io.github.pedromedeiros2.grupostrabalhos.atuacao.Atuacao;
import io.github.pedromedeiros2.grupostrabalhos.endereco.Endereco;
import io.github.pedromedeiros2.grupostrabalhos.endereco.TipoLogradouro;
import io.github.pedromedeiros2.grupostrabalhos.grupo.Grupo;
import io.github.pedromedeiros2.grupostrabalhos.pessoa.Pessoa;
import io.github.pedromedeiros2.grupostrabalhos.pessoa.PessoaBeanLocal;
import io.github.pedromedeiros2.grupostrabalhos.telefone.Telefone;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

/**
 *
 * @author Pedro Medeiros <phsm at aluno.ifnmg.edu.br>
 */

@Singleton
@Startup
public class CargaDados implements CargaDadosLocal {
    
    @Inject
    private PessoaBeanLocal pb;
    
    @PostConstruct
    @Override
    public void popularBanco() {
        
        Pessoa p1 = new Pessoa();
        p1.setNome("Ana Zaira");
        p1.setEmail("ana@mail.com");
        p1.setNascimento(LocalDate.of(2001, Month.JANUARY, 1));
        p1.setEndereco(new Endereco(TipoLogradouro.RUA, "1",  1111, "Humberto"));
        p1.setTelefones(List.of(
                new Telefone((byte)11, 11111111),
                new Telefone((byte)12, 12121212),
                new Telefone((byte)12, 13131313)
            ));
        
        Pessoa p2 = new Pessoa();
        p2.setNome("Beatriz Yana");
        p2.setEmail("beatriz@mail.com");
        p2.setNascimento(LocalDate.of(2002, Month.FEBRUARY, 2));
        p2.setEndereco(new Endereco(TipoLogradouro.AVENIDA, "2",  2222, "Doisberto"));
        p2.setTelefones(List.of(
                new Telefone((byte)22, 22222222)
            ));
        
        Pessoa p3 = new Pessoa();
        p3.setNome("Cecília Xerxes");
        p3.setEmail("cecilia@mail.com");
        p3.setNascimento(LocalDate.of(2003, Month.MARCH, 3));
        p3.setEndereco(new Endereco(TipoLogradouro.AVENIDA, "3",  3333, "Trêsberto"));
        
        Pessoa p4 = new Pessoa();
        p4.setNome("Débora Wendel");
        p4.setEmail("debora@mail.com");
        p4.setNascimento(LocalDate.of(2004, Month.APRIL, 4));
        p4.setEndereco(new Endereco(TipoLogradouro.PRACA, "4",  4444, "Quatroberto"));
        p4.setTelefones(List.of(
                new Telefone((byte)44, 44444444),
                new Telefone((byte)45, 45454545)
            ));    
        
        
        
        Grupo g1 = new Grupo("Estudo I", false);
        Grupo g2 = new Grupo("Estudo II", true);
        Grupo g3 = new Grupo("Estudo III", false);
        Grupo g4 = new Grupo("Estudo IV", true);
        
        g1.setLider(p1);
        g2.setLider(p2);
        g3.setLider(p3);
        g4.setLider(p2);
        
        p1.setGrupos(List.of(g1));
        p2.setGrupos(List.of(g1,g2,g4));
        p3.setGrupos(List.of(g1,g3,g4));
        p4.setGrupos(List.of(g1,g2,g3,g4));
        
        p1.setAtuacoes(List.of(
                new Atuacao(LocalDate.of(2011, Month.JANUARY, 1), LocalDate.of(2021, Month.NOVEMBER, 11), g1),
                new Atuacao(LocalDate.of(2012, Month.JANUARY, 1),LocalDate.of(2022, Month.NOVEMBER, 11), g1)
            ));
        p2.setAtuacoes(List.of(
                new Atuacao(LocalDate.of(2012, Month.JANUARY, 2), LocalDate.of(2021, Month.JANUARY, 12), g1),
                new Atuacao(LocalDate.of(2012, Month.JANUARY, 2), g2),
                new Atuacao(LocalDate.of(2012, Month.JANUARY, 4), LocalDate.of(2012, Month.JANUARY, 14), g4)
            ));
        p3.setAtuacoes(List.of(
                new Atuacao(LocalDate.of(2013, Month.JANUARY, 3), LocalDate.of(2021, Month.JANUARY, 13), g1),
                new Atuacao(LocalDate.of(2012, Month.JANUARY, 3), LocalDate.of(2023, Month.JANUARY, 13), g3),
                new Atuacao(LocalDate.of(2012, Month.JANUARY, 4), LocalDate.of(2012, Month.JANUARY, 14), g4)
            ));
        p4.setAtuacoes(List.of(
                new Atuacao(LocalDate.of(2014, Month.JANUARY, 4), LocalDate.of(2021, Month.JANUARY, 14),g1),
                new Atuacao(LocalDate.of(2012, Month.JANUARY, 2), g2),
                new Atuacao(LocalDate.of(2012, Month.JANUARY, 3), LocalDate.of(2023, Month.JANUARY, 13),g3),
                new Atuacao(LocalDate.of(2012, Month.JANUARY, 4), LocalDate.of(2012, Month.JANUARY, 14),g4)
            ));
        
        pb.save(p1);
        pb.save(p2);
        pb.save(p3);
        pb.save(p4);    
    }   
}
