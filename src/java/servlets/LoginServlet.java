/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.User;
import services.AccountService;

/**
 *
 * @author musta
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {        
        RequestDispatcher loginDispatcher = getServletContext()
            .getRequestDispatcher("/WEB-INF/login.jsp");
        String logout = req.getParameter("logout");
        HttpSession session = req.getSession();
        
        if (logout != null) {
            session.invalidate();
            req.setAttribute("msg", "Logged out!");
            loginDispatcher.forward(req, resp);
            return;
        }
        
        if (session.getAttribute("username") != null) {
            resp.sendRedirect("home");
            return;
        }
        
        loginDispatcher.forward(req, resp);
        return;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher loginDispatcher = getServletContext()
            .getRequestDispatcher("/WEB-INF/login.jsp");
        
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        
        req.setAttribute("username", username);
        req.setAttribute("password", password);
        
        if (
            username == null ||
            username.equals("") ||
            password == null ||
            password.equals("")
            ) {
            req.setAttribute("msg", "Empty credentials");
            loginDispatcher.forward(req, resp);
            return;
        }
        
        User user = (new AccountService()).login(username, password);
        
        if (user == null) {
            req.setAttribute("msg", "Incorrect credentials");
            loginDispatcher.forward(req, resp);
            return;
        }
        
        HttpSession session = req.getSession();
        session.setAttribute("username", username);
        
        resp.sendRedirect("home");
        return;
    }
    
    
}