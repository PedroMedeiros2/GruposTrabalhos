/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package io.github.pedromedeiros2.grupostrabalhos.servlet;

import io.github.pedromedeiros2.grupostrabalhos.pessoa.PessoaBeanLocal;
import io.github.pedromedeiros2.grupostrabalhos.util.Util;
import java.io.IOException;
import java.io.PrintWriter;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

/**
 *
 * @author Pedro Medeiros <phsm at aluno.ifnmg.edu.br>
 */
@Transactional
@WebServlet(name = "Consultas", urlPatterns = {"/Consultas"})
public class Consultas extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
   @Inject
    private PessoaBeanLocal pb;
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            StringBuilder sb = new StringBuilder();
            
            sb.append("<!DOCTYPE html>");
            sb.append("<html>");
            sb.append("<head>");
            sb.append("<title>Servlet Consultas</title>");            
            sb.append("</head>");
            sb.append("<body>");
            sb.append("<h1>Consultas</h1>");
            
            ///Q1
           
            sb.append("<h2>1.A - Pessoas cadastradas por meio de Query: </h2>");
            sb.append("<pre>" + Util.toJson(pb.allPessoaQuery()) + "</pre>");
            
            sb.append("<h2>1.B - Pessoas cadastradas por meio de Typed Query: </h2>");
            sb.append("<pre>" + Util.toJson(pb.allPessoaTypedQuery()) + "</pre>");
            
            sb.append("<h2>1.C - Pessoas cadastradas por meio de Named Query: </h2>");
            sb.append("<pre>" + Util.toJson(pb.allPessoaNamedQuery()) + "</pre>");
            
            ///Q2
           
            sb.append("<h2>2.A - Nomes das pessoas por meio de Query: </h2>");
            sb.append("<pre>" + Util.toJson(pb.namePessoaQuery()) + "</pre>");
            
            sb.append("<h2>2.B - Nomes das pessoas por meio de Typed Query: </h2>");
            sb.append("<pre>" + Util.toJson(pb.namePessoaTypedQuery()) + "</pre>");
            
            sb.append("<h2>2.C - Nomes das pessoas por meio de Named Query: </h2>");
            sb.append("<pre>" + Util.toJson(pb.namePessoaNamedQuery()) + "</pre>");
            
             ///Q3
 
            sb.append("<h2>3.A - Nomes das pessoas e seus respectivos endereços por meio de Query: </h2>");
            //sb.append("<pre>" + Util.toJson(pb.nameEndPessoaQuery()) + "</pre>");
            
            sb.append("<h2>3.B - Nomes das pessoas e seus respectivos endereços por meio de Typed Query: </h2>");
            //sb.append("<pre>" + Util.toJson(pb.nameEndPessoaTypedQuery()) + "</pre>");
            
            sb.append("<h2>3.C - Nomes das pessoas e seus respectivos endereços  por meio de Named Query: </h2>");
            //sb.append("<pre>" + Util.toJson(pb.nameEndPessoaNamedQuery()) + "</pre>");
            
             ///Q4
           
            sb.append("<h2>4.A - Pessoas que moram em avenidas por meio de Query: </h2>");
            //sb.append("<pre>" + Util.toJson(pb.allPessoaQuery()) + "</pre>");
            
            sb.append("<h2>4.B - Pessoas que moram em avenidas por meio de Typed Query: </h2>");
            //sb.append("<pre>" + Util.toJson(pb.allPessoaTypedQuery()) + "</pre>");
            
            sb.append("<h2>4.C - Pessoas que moram em avenidas por meio de Named Query: </h2>");
            //sb.append("<pre>" + Util.toJson(pb.allPessoaNamedQuery()) + "</pre>");
            
            
             ///Q5
           
            sb.append("<h2>5.A - Pessoas que não moram em praças por meio de Query: </h2>");
            //sb.append("<pre>" + Util.toJson(pb.allPessoaQuery()) + "</pre>");
            
            sb.append("<h2>5.B - Pessoas que não moram em praças por meio de Typed Query: </h2>");
            //sb.append("<pre>" + Util.toJson(pb.allPessoaTypedQuery()) + "</pre>");
            
            sb.append("<h2>5.C - Pessoas que não moram em praças por meio de Named Query: </h2>");
            //sb.append("<pre>" + Util.toJson(pb.allPessoaNamedQuery()) + "</pre>");
            
            
             ///Q6
           
            sb.append("<h2>6.A - Nomes das pessoas e seus respectivos telefones por meio de Query: </h2>");
            //sb.append("<pre>" + Util.toJson(pb.allPessoaQuery()) + "</pre>");
            
            sb.append("<h2>6.B - Nomes das pessoas e seus respectivos telefones por meio de Typed Query: </h2>");
            //sb.append("<pre>" + Util.toJson(pb.allPessoaTypedQuery()) + "</pre>");
            
            sb.append("<h2>6.C - Nomes das pessoas e seus respectivos telefones por meio de Named Query: </h2>");
            //sb.append("<pre>" + Util.toJson(pb.allPessoaNamedQuery()) + "</pre>");
            
            
            
            sb.append("</body>");
            sb.append("</html>");
            out.print(sb.toString());
            out.print("AAAAAAAAAAAAAAAAAAA: " + pb.nameEndPessoaQuery());
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
