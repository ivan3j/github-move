/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Modelo.DAO.PedidoDAO;
import java.io.IOException;
import java.net.URL;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Ivan
 */
public class CadastrarPedidoServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       
        HttpSession session=request.getSession(false);  
        if(session!=null){  
        String name=(String)session.getAttribute("usuario");  
     
            try {
                
    
    String nomeCliente = request.getParameter("nomecliente");
    String dataVenda = request.getParameter("datavenda");
    String nomeVendedor = request.getParameter("vendedor");
    String qtdeChips = request.getParameter("qtdechips");
    String valorvenda = request.getParameter("valor");
    
    PedidoDAO pedido = new PedidoDAO();
    ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
    URL url = classLoader.getResource("/Modelo/BD/pedido.properties");
  
    pedido.IncluiPedido(nomeCliente, dataVenda, nomeVendedor, qtdeChips, valorvenda, url);

    request.getRequestDispatcher("/WEB-INF/JSP/cadastrar-pedido.jsp").forward(request, response);

            } catch (Exception e) {
                throw new ServletException(
                  "A l??gica de neg??cios causou uma exce????o", e);
            }
    }
       
        
       else{  
           request.getRequestDispatcher("sessionError.html").include(request, response);  
            request.getRequestDispatcher("login.html").include(request, response);  
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
