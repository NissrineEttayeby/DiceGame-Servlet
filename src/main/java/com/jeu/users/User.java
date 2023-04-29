package com.jeu.users;

public class User {

    private String nom;


    private String prenom;

    private String login;

    private String password;

    private int score ;

    private int bestScore;

    private int compteurLancer;

    public User() {
    }
    public User(String nom, String prenom, String login, String password, int score, int bestScore,
                int compteurLancer) {
        this.nom = nom;
        this.prenom = prenom;
        this.login = login;
        this.password = password;
        this.score = score;
        this.bestScore = bestScore;
        this.compteurLancer = compteurLancer;
    }

    public String toString() {
        return "Utilisateur [ nom=" + nom + ", prenom=" + prenom + ", login="
                + login + ", password=" + password + ", score=" + score + ", bestScore=" + bestScore
                + ", compteurLancer=" + compteurLancer + "]";
    }

    public User(String nom, String prenom, String login, String password, int score, int bestScore) {
        this.nom = nom;
        this.prenom = prenom;
        this.login = login;
        this.password = password;
        this.score = score;
        this.bestScore = bestScore;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom(){
        return prenom;
    }
    public void setPrenom(String prenom){
        this.prenom = prenom;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public void setScore(int score) {

        this.score = score;
    }
    public double getScore() {
        return score;
    }

    public void setBestScore(int bestScore) {
        this.bestScore = bestScore;
    }

    public double getBestScore() {
        return bestScore;
    }






}
