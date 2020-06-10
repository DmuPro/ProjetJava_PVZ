PROJET JAVA PHASE 1:
Ceci est le README qui r�sume l'avancement actuel de notre projet java.

L'impl�mentation : 


Tout d'abord nous avons impl�ment� les interfaces n�cessaires aux fonctionnements du jeu c'est � dire:
-La cr�ation d'un plateau sur lequel pourra int�ragir notre �co-syst�me,
-L'impl�mentation des plantes,
-La cr�ation d'un menu qui rend possible la s�lection des plantes,
-L'impl�mentation des zombies,
-La cr�ation d'un timer indiquant la dur�e de jeu et d'une condition de fin de partie,
-La cr�ation d'un mode d�bug qui joue de mani�re al�atoire en acc�l�r�,
-Toutes les interractions plantes - zombies,

Ensuite nous avons donc impl�menter les interfaces suivantes pour pouvoir stocker leurs "sous classes" dans les ArrayList (voir choix techniques):
-InterfacePlante qui regroupe toutes les m�thodes des plantes, 
-InterfaceZombie qui regroupe toutes les m�thodes des zombies,

Organisation du programme :

"PvZGame" est notre main qui regroupe l'affichage ainsi que les actions possibles dans le jeu.
Les ArrayList qui contiennent nos entit�s (IterfacePlante et Interfacezombie ainsi que leur "sous classes")
Ainsi qu'une classe par type de plantes et de zombies.

Choix techniques et Algorithmique :


Le choix d'une matrice nous semblait compliqu� pour l'int�raction plantes /zombies, nous nous sommes donc orient�s vers des ArrayLists et un syst�me de coordonn�es.
L'ArrayList poos�de des avantages , notamment pour le gain de compl�xit� algorithmique. Gr�ce � sa strucutre l'ajout d'une entit� poss�de une compl�xit� de  O(1).
Contrairement � une matrice sur laquelle, pour la parcourrir, il faut une boucle imbriqu� O(n�) ,nous avons donc impl�menter une ArrayList pour chaque ligne et pour chaque type. Ce qui nous fait aussi un gain de compl�xit�.
Nous avons du faire les calculs pour que les coordonn�es r�cup�r�s sont �gales � notre plateau afin de simuler les lignes et les colonnes.

Nous avons utilis� le Thread.sleep qui met en pause notre programme durant un lapse de temps pour a�rer les actions et ainsi que le visuel soit plus compr�hensible.
A la cr�ation de l'interaction utilisateur/jeu nous avons utilis� un drag and drop, cependant nous avons remarqu� que le drag and drop prenait du temps � s'ex�cuter, ainsi nous avons d�cid� de pr�vili�ger une solution moins intutive qui est le point and click.


Les probl�mes rencontr�s :
-Appr�hender la bibliot�que graphique zen5 a �t� un v�ritable d�fi;
-Nous avons essay� de limiter au plus les getters;
-Ajuster le plateau aux coordonn�es;
-Documentation des stats deszombies tr�s pauvres sur internet. Nous avons donc d�cid� de faire un minimum coh�rent;
-Appr�hension du foncionnement de Plantes vs Zombies(Sp�cificiter de chaque Plantes/Zombies);
-Contrairement au projet Python, le Java est beaucoup plus complexe � travailler en groupe d�t a ses classes. Ce qui nous force � faire des mises en commun r�guli�rement.


PROJET JAVA PHASE2 :

L'impl�mentation : 

-Syst�me de soleil(Energy,cout,cr�ation des soleils)

-Temps de recharge 

-S�paration du programme:
	-Data(Donn�es, d�roulement du jeu)
	-Graphique(Toute la partie affichage)
	-PvZGame(Main + controller)

-Nouvelles plantes (Chomper,snowPea,Repeater, PotatoMine)

Projet JAVA Phase 3:

Tout d'abord, d� � un manque de temps nous n'avons pas commencer la phase 3.
Il s'agit donc du README consacr� � la phase 2 que nous n'avions pas termin� pr�c�demment.

Organisation du programme:
Nous avons donc gard� le programme sous un model data,Graphique,programme principal.
Toutes les plantes qui tirent des projectiles sont les classes filles issues de la classe PeaShooter.
Les lignes utilis�es dans le niveau de la piscine et les lignes utilis�es dans le niveau de la nuit sont les classes filles issues de la classe BoardPlant (ligne de plante).


L'impl�mentation:

-Les maps de la phase 2(Piscine et Nuit)
-Les plantes pr�sentent dans les maps (Nuit et piscine).
-Un syst�me de temps de rechargement, qui a un usage divers (la vitesse d'attaque des plantes, le temps de recharge � chaque fois que l'on plante)
-Le m�canisme des maps (Tombeau pour la nuit, piscine + n�nuphar pour la piscine)
-Les zombies manquants
-Le menu de s�l�ction des plantes avant de commencer un niveau
-L'affichage graphique qui a �t� am�lior� (nom des plantes dans le menu pour facilit� la reconnaissance de celle-ci)

Choix techniques et algorithmique:

Nous avons gard� l'usage des ArrayList.

Les probl�mes rencontr�s:
Les n�nuphars �taient durs � coder






