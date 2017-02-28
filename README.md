# projetANFD_AFD
AFND => AFD

========guide d'utilisation de l'application========

1-Ajouter les alphabets de l'automate :
	1.1-Sélectionner le nombre des alphabets
	1.2-cliquer sur ajouter Alphabet
   une fentere va s'afficher 
	1.3-entrer l'alphabet 
        PS: en cas d'un automate avec epsilons transitions 
	utiliser l'alphabet 'E' 
	1.4-Cliquer sur valider
   les alphabets ajoutés vont être affichés à la fin de l'ajout de tous les alphabets

2- Ajouter les etats de l'automate :
	2.1- Ajouter les etats normales
	   --Selectionner le nombre d'etats normales
	   --Cliquer sur ajouter Etat
	Pour chaque etat :
 	une fenetre va s'afficher
	   --Entrer l'etat
	PS:les états  sont des nombre de 0 jusqu 'à n  ( etat1=0 etat2=1 etat3=2 .....)
	   --Cliquer sur valider
	les etats normales ajoutés vont etre affiché à la fin de l'ajout de tous les etats
	2.2-Ajouter les etats finales	
	   --Selectionner le nombre d'etats finaux
	   --Cliquer sur ajouter Etat
 	Pour chaque etat :
	une fenetre va s'afficher
	   --Entrer l'etat
	PS:l'etat entré doit etre un entier, ayant la valeur suivante du dernier
	etat normal ajouté
	
	les etats finaux vont etre affiché à la fin de l'ajout de tous les etats
3- Ajouter les transitions
pour chaque transition :
cliquer sur ajout trans
	3.1-selectionner l'etat  initial de la transition
	3.2-selectionner l'etat final de la transition
	3.3-selectionner l'alphabet de la transition
	3.4-cliquer sur valider

4-cliquer sur Transformer pour avoir le resultat


=======les resultats obtenus=======

 1- le programme teste si l'automate contient des epsilons transitions ou non
    si le programme contient des epsilons transitions la fentere affichée contient :  
        "Eliminer les epsilons transitions" 
	cliquer sur ok
	la fentre affiche : 
        "Epsilons transitions eliminées"
    si le programme ne contient pas des epsilons transitions la fenetre affiche :
	"Cet automate ne contient pas des epsilons transitions"
2 - le programme teste ensuite si l'automate est déja déterministe ou non
     la fenetre affcihe :
     "Cet automate est déja déterministe"
	ou
     "Cet automate n'est pas deterministe"

3 - Le programme applique l'algorithme de déterminisation au cas où l'automate n'est pas deterministe
    le fenetre affiche 
    "AFD obtenu"
    cliquer sur ok pour visualiser l'automate deterministe



