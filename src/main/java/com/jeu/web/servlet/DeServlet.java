package com.jeu.web.servlet;

import com.jeu.users.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import com.jeu.users.De;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/DeServlet")
public class DeServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);

    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext cntx = getServletContext();

        PrintWriter out = response.getWriter();

        String action = request.getParameter("action");
        if (action != null && action.equals("list")) {

            ArrayList<De> list = (ArrayList<De>) cntx.getAttribute("listnums");
            if (list != null ) {
                request.setAttribute("listnums", list);
                request.getRequestDispatcher("JeuServlet").forward(request, response);
                return;

            }

        } else if (action != null && action.equals("create")) {

            String numero = (request.getParameter("numero"));
            De de = new De();

            ArrayList<De> list;
            if (cntx.getAttribute("listnums") == null) {
                list = new ArrayList<>();
                cntx.setAttribute("listnums", list);
            } else {

                list = (ArrayList<De>) cntx.getAttribute("listnums");
            }

            list.add(de);




        }
}}
