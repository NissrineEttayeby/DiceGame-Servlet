# DiceGame

* Durant une partie, un même dé ne doit pas être lancé plusieurs fois
* Si un joueur lance un même dé plus qu’une fois l’application arrête la partie de jeu et le joueur reçoit un score = -1. 
* Si le résultat (dé 1) < résultat (dé 2) < résultat (dé 3) --> le joueur reçoit un score égal 
à la somme des résultats obtenus pour les 3 dés.
* Si le résultat (dé 1) > résultat (dé 2) > résultat (dé 3) alors le joueur reçoit un score égal au produit des résultats 
obtenus pour les 3 dés.
* Sinon il reçoit un score nul. 
* L’application doit arrêter la partie une fois on peut conclure à propos du score.


# Interface 

## Inscription
![java1](https://user-images.githubusercontent.com/108592629/235283231-fce53bda-3c9f-4e0e-aa26-86985e7fe158.png)

## Login
![java2](https://user-images.githubusercontent.com/108592629/235283240-6f60b76e-0f3b-49ee-a142-859d01a6165a.png)

## Home

Une partie de jeu se termine donc soit après avoir lancé les 3 dés ou suite à une faute 
de lancement d’un même dé deux fois ou car la condition « résultat (dé 1) < résultat 
(dé 2) < résultat (dé 3) ou résultat (dé 1) > résultat (dé 2) > résultat (dé 3) » n’est 
pas remplie.

![java3](https://user-images.githubusercontent.com/108592629/235283248-bdc73f84-1079-4768-bd82-4e8b1f8c3673.png)

# Results

A la fin d’une partie, l’application affiche le score de la partie qui vient d’être jouée 
ainsi que le meilleur score enregistré sur l’application

![java4](https://user-images.githubusercontent.com/108592629/235283254-22cecdd1-ee5c-4ee1-a9ed-d83a675bfdfb.png)
