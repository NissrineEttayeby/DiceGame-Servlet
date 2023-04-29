package com.jeu.web.servlet;

import jakarta.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import com.jeu.users.User;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/JeuServlet")

public class JeuServlet extends HttpServlet {

    //Liste pour stocker les numéros de dés déjà lancés
    private List<Integer> desLances = new ArrayList<>();
    int[] resultats = new int[3];

    //liste pour stocker les BestScore des utilisateurs
    private List<Integer> BestScore = new ArrayList<>();

    //Methode pour retourner le maximum des BestScore
    public static Integer getMax(List<Integer> BestScore)
    {
        if (BestScore == null || BestScore.size() == 0) {
            return 0;
        }

        return Collections.max(BestScore);
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ServletContext cntx = getServletContext();
        HttpSession s = request.getSession();
        User user = (User) s.getAttribute("connecteduser");
        String numero = request.getParameter("numero");
        PrintWriter out = response.getWriter();
        response.setContentType("text/html;charset=UTF-8");


        StringBuffer sb = new StringBuffer();

        if (user != null) {
            if (request.getParameter("reinit") != null) {

                desLances.clear();
                s.setAttribute("nbrLancees", 0);
                s.setAttribute("score", 0);
                user.setScore(0);
                user.setBestScore(getMax(BestScore));
                Arrays.fill(resultats, 0);
                sb.append("Nouvelle Partie");
                request.getRequestDispatcher("/WEB-INF/homeJeu.jsp").forward(request, response);
                return;



            } else {
                //user.setBestScore(getMax(BestScore));

                int nbrLancees = 0;

                if (s.getAttribute("nbrLancees") != null) {
                    nbrLancees = (Integer) s.getAttribute("nbrLancees");
                }

                if (nbrLancees < 3) {

                    if (desLances.size() < 3) {

                        if (numero != null) {

                            switch (numero) {

                                case "1":
                                    if (desLances.contains(1)) {
                                        user.setScore(-1);
                                        out.println("<h2>La partie est terminee</h2>");
                                        out.println("<p>Vous avez lance le de plus d'une fois.</p>");
                                        s.setAttribute("score", -1);
                                        return;

                                    } else {
                                        Random rd1 = new Random();
                                        int resultat1 = 1 + rd1.nextInt(6);
                                        resultats[0] = resultat1;
                                        out.print("Resultat de de 1 = " + resultats[0]);
                                        desLances.add(1);

                                    }
                                    if(resultats.length==3){

                                        int scores = 0;

                                        if (resultats[0] > resultats[1] && resultats[1] > resultats[2]) {
                                            scores = resultats[0] + resultats[1] + resultats[2];
                                            user.setScore(scores);
                                            s.setAttribute("score", scores);
                                            if (scores > user.getBestScore()) {
                                                BestScore.add(scores);
                                            }


                                        } else if(resultats[0] < resultats[1] && resultats[1] < resultats[2]) {
                                            sb.append("Bravo gagne!");
                                            scores = resultats[0] * resultats[1] * resultats[2];
                                            user.setScore(scores);
                                            s.setAttribute("score", scores);
                                            if (scores > user.getBestScore()) {
                                                BestScore.add(scores);
                                            }


                                        } else {
                                            scores = 0;
                                            user.setScore(scores);
                                            s.setAttribute("score", scores);
                                            if (scores > user.getBestScore()) {
                                                BestScore.add(scores);
                                            }
                                        }
                                        return;

                                    }


                                case "2":
                                    if (desLances.contains(2)) {
                                        user.setScore(-1);
                                        out.println("<h2>La partie est terminee</h2>");
                                        out.println("<p>Vous avez lance le de plus d'une fois.</p>");
                                        s.setAttribute("score", -1);
                                        return;


                                    } else {
                                        Random rd2 = new Random();
                                        int resultat2 = 1 + rd2.nextInt(6);
                                        resultats[1] = resultat2;
                                        out.print("Resultat de de 2 = " + resultats[1]);
                                        desLances.add(2);

                                    }
                                    if(resultats.length==3){

                                        int scores = 0;

                                        if (resultats[0] > resultats[1] && resultats[1] > resultats[2]) {
                                            scores = resultats[0] + resultats[1] + resultats[2];
                                            user.setScore(scores);
                                            s.setAttribute("score", scores);
                                            if (scores > user.getBestScore()) {
                                                BestScore.add(scores);
                                            }


                                        } else if (resultats[0] < resultats[1] && resultats[1] < resultats[2]) {
                                            sb.append("Bravo gagne!");
                                            scores = resultats[0] * resultats[1] * resultats[2];
                                            user.setScore(scores);
                                            s.setAttribute("score", scores);
                                            if (scores > user.getBestScore()) {
                                                BestScore.add(scores);
                                            }

                                        } else {
                                            scores = 0;
                                            user.setScore(scores);
                                            s.setAttribute("score", scores);
                                            if (scores > user.getBestScore()) {
                                                BestScore.add(scores);
                                            }
                                        }
                                        return;

                                    }


                                case "3":
                                    if (desLances.contains(3)) {
                                        user.setScore(-1);
                                        out.println("La partie est terminee");
                                        out.println("Vous avez lancé le de plus d'une fois.</p>");
                                        s.setAttribute("score", -1);
                                        return;


                                    } else {
                                        Random rd3 = new Random();
                                        int resultat3 = 1 + rd3.nextInt(6);
                                        resultats[2] = resultat3;
                                        out.print("Resultat de de 3 = " + resultats[2]);
                                        desLances.add(3);


                                    }
                                    if(resultats.length==3){

                                        int scores = 0;

                                        if (resultats[0] > resultats[1] && resultats[1] > resultats[2]) {
                                            scores = resultats[0] + resultats[1] + resultats[2];
                                            user.setScore(scores);
                                            s.setAttribute("score", scores);
                                            if (scores > user.getBestScore()) {
                                                BestScore.add(scores);
                                            }


                                        } else if ((resultats[0] < resultats[1]) && (resultats[1] < resultats[2])) {
                                            sb.append("Bravo gagne!");
                                            scores = resultats[0] * resultats[1] * resultats[2];
                                            user.setScore(scores);
                                            s.setAttribute("score", scores);
                                            if (scores > user.getBestScore()) {
                                                BestScore.add(scores);
                                            }


                                        } else {
                                            scores = 0;
                                            user.setScore(scores);
                                            out.print("Game Over");
                                            s.setAttribute("score", scores);
                                            if (scores > user.getBestScore()) {
                                                BestScore.add(scores);
                                            }
                                        }
                                        return;

                                    }


                                default:


                                    //out.print("<h1>Attention!</h1>");
                                    //out.print("<p>Le de que vous avez saisies est n'est pas valide pour ce jeu</p>");
                                    request.getRequestDispatcher("/WEB-INF/erreur.jsp").forward(request,response);
                                    break;


                            }

                        }else if(desLances.size()>3){
                            request.getRequestDispatcher("/WEB-INF/erreur.jsp").forward(request, response);

                        }


                        }
                    s.setAttribute("nbrLancees", nbrLancees + 1);

                } else{
                    request.getRequestDispatcher("/WEB-INF/erreur.jsp").forward(request, response);

                }
                request.getRequestDispatcher("/WEB-INF/erreur.jsp").forward(request, response);

            }
        }

         else {
            request.getRequestDispatcher("/WEB-INF/loginJeu.jsp").forward(request, response);
            return;
        }


    }
}

























