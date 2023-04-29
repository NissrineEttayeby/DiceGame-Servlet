package com.jeu.web.servlet;

import jakarta.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import com.jeu.users.User;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
        request.getRequestDispatcher("/WEB-INF/inscriptionJeu.jsp").forward(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //request.getRequestDispatcher("inscriptionJeu.jsp").forward(request,response);
        ServletContext cntx = getServletContext();

        PrintWriter out = response.getWriter();

        String action = request.getParameter("action");
        if (action != null && action.equals("list")) {

            ArrayList<User> list = (ArrayList<User>) cntx.getAttribute("listusers");
            if (list != null ) {
                request.setAttribute("listUsers", list);
                request.getRequestDispatcher("/WEB-INF/listUsers.jsp").forward(request, response);
                return;

            }

        } else if (action != null && action.equals("create")) {

            String nom = request.getParameter("nom");
            String prenom = request.getParameter("prenom");
            String login = request.getParameter("login");
            String password = request.getParameter("password");




            User user = new User();
            user.setNom(nom);
            user.setPrenom(prenom);
            user.setLogin(login);
            user.setPassword(password);

            ArrayList<User> list;
            if (cntx.getAttribute("listusers") == null) {
                list = new ArrayList<>();
                cntx.setAttribute("listusers", list);
            } else {

                list = (ArrayList<User>) cntx.getAttribute("listusers");
            }

            list.add(user);
            request.getRequestDispatcher("/WEB-INF/loginJeu.jsp").forward(request,response);

        }


    }



}
