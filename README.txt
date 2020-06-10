PROJET JAVA PHASE 1:
Ceci est le README qui résume l'avancement actuel de notre projet java.

L'implémentation : 


Tout d'abord nous avons implémenté les interfaces nécessaires aux fonctionnements du jeu c'est à dire:
-La création d'un plateau sur lequel pourra intéragir notre éco-système,
-L'implémentation des plantes,
-La création d'un menu qui rend possible la sélection des plantes,
-L'implémentation des zombies,
-La création d'un timer indiquant la durée de jeu et d'une condition de fin de partie,
-La création d'un mode débug qui joue de manière aléatoire en accéléré,
-Toutes les interractions plantes - zombies,

Ensuite nous avons donc implémenter les interfaces suivantes pour pouvoir stocker leurs "sous classes" dans les ArrayList (voir choix techniques):
-InterfacePlante qui regroupe toutes les méthodes des plantes, 
-InterfaceZombie qui regroupe toutes les méthodes des zombies,

Organisation du programme :

"PvZGame" est notre main qui regroupe l'affichage ainsi que les actions possibles dans le jeu.
Les ArrayList qui contiennent nos entités (IterfacePlante et Interfacezombie ainsi que leur "sous classes")
Ainsi qu'une classe par type de plantes et de zombies.

Choix techniques et Algorithmique :


Le choix d'une matrice nous semblait compliqué pour l'intéraction plantes /zombies, nous nous sommes donc orientés vers des ArrayLists et un système de coordonnées.
L'ArrayList poosède des avantages , notamment pour le gain de compléxité algorithmique. Grâce à sa strucutre l'ajout d'une entité possède une compléxité de  O(1).
Contrairement à une matrice sur laquelle, pour la parcourrir, il faut une boucle imbriqué O(n²) ,nous avons donc implémenter une ArrayList pour chaque ligne et pour chaque type. Ce qui nous fait aussi un gain de compléxité.
Nous avons du faire les calculs pour que les coordonnées récupérés sont égales à notre plateau afin de simuler les lignes et les colonnes.

Nous avons utilisé le Thread.sleep qui met en pause notre programme durant un lapse de temps pour aérer les actions et ainsi que le visuel soit plus compréhensible.
A la création de l'interaction utilisateur/jeu nous avons utilisé un drag and drop, cependant nous avons remarqué que le drag and drop prenait du temps à s'exécuter, ainsi nous avons décidé de préviliéger une solution moins intutive qui est le point and click.


Les problèmes rencontrés :
-Appréhender la bibliotèque graphique zen5 a été un véritable défi;
-Nous avons essayé de limiter au plus les getters;
-Ajuster le plateau aux coordonnées;
-Documentation des stats deszombies très pauvres sur internet. Nous avons donc décidé de faire un minimum cohérent;
-Appréhension du foncionnement de Plantes vs Zombies(Spécificiter de chaque Plantes/Zombies);
-Contrairement au projet Python, le Java est beaucoup plus complexe à travailler en groupe dût a ses classes. Ce qui nous force à faire des mises en commun régulièrement.


PROJET JAVA PHASE2 :

L'implémentation : 

-Système de soleil(Energy,cout,création des soleils)

-Temps de recharge 

-Séparation du programme:
	-Data(Données, déroulement du jeu)
	-Graphique(Toute la partie affichage)
	-PvZGame(Main + controller)

-Nouvelles plantes (Chomper,snowPea,Repeater, PotatoMine)

Projet JAVA Phase 3:

Tout d'abord, dû à un manque de temps nous n'avons pas commencer la phase 3.
Il s'agit donc du README consacré à la phase 2 que nous n'avions pas terminé précédemment.

Organisation du programme:
Nous avons donc gardé le programme sous un model data,Graphique,programme principal.
Toutes les plantes qui tirent des projectiles sont les classes filles issues de la classe PeaShooter.
Les lignes utilisées dans le niveau de la piscine et les lignes utilisées dans le niveau de la nuit sont les classes filles issues de la classe BoardPlant (ligne de plante).


L'implémentation:

-Les maps de la phase 2(Piscine et Nuit)
-Les plantes présentent dans les maps (Nuit et piscine).
-Un système de temps de rechargement, qui a un usage divers (la vitesse d'attaque des plantes, le temps de recharge à chaque fois que l'on plante)
-Le mécanisme des maps (Tombeau pour la nuit, piscine + nénuphar pour la piscine)
-Les zombies manquants
-Le menu de séléction des plantes avant de commencer un niveau
-L'affichage graphique qui a été amélioré (nom des plantes dans le menu pour facilité la reconnaissance de celle-ci)

Choix techniques et algorithmique:

Nous avons gardé l'usage des ArrayList.

Les problèmes rencontrés:
Les nénuphars étaient durs à coder






