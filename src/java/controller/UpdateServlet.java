/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dbhelpers.AddQuery;
import dbhelpers.UpdateQuery;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ClevelandIndians;

/**
 *
 * @author jarmes
 */
@WebServlet(name = "UpdateServlet", urlPatterns = {"/updatePlayer"})
public class UpdateServlet extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UpdateServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        
        //Pass execution on to doPost
        doPost (request,response);
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
        
        //get the form data and set up a Player object
        int PlayerID = Integer.parseInt (request.getParameter("PlayerID"));
        String PlayerName = request.getParameter ("PlayerName");
        String College = request.getParameter ("College");
        String PlayerPosition = request.getParameter ("PlayerPosition");
        int Age = Integer.parseInt (request.getParameter("Age"));
        String Hometown = request.getParameter ("Hometown");
        
        //set up a player object
        ClevelandIndians player = new ClevelandIndians ();
        player.setPlayerID(PlayerID);
        player.setPlayerName(PlayerName);
        player.setCollege (College);
        player.setPlayerPosition (PlayerPosition);
        player.setAge (Age);
        player.setHometown (Hometown);
        
        //set up an UpdateQuery object
        UpdateQuery uq = new UpdateQuery ();
        //pass the player to addQuery to add to the database
        uq.doUpdate(player);
        //pass execution control to the ReadServlet
        String url = "/read";
        
        RequestDispatcher dispatcher = request.getRequestDispatcher (url);
        dispatcher.forward (request, response);
    }

    
   

}
