package dut.info.projet;

import java.awt.Color;
import java.awt.geom.Point2D;
import fr.umlv.zen5.Application;
import fr.umlv.zen5.ApplicationContext;
import fr.umlv.zen5.Event;
import fr.umlv.zen5.Event.Action;
import fr.umlv.zen5.KeyboardKey;
import fr.umlv.zen5.ScreenInfo;

public class PvZGame {

	static void Game(ApplicationContext context) {
		int etape = 0;
		boolean selectionner = false;
		boolean debug = false;
		Point2D.Float location;
		int nbZombie = 5, choix = 0;
		PlantSelect menux = new PlantSelect(context);
		int compteur = 0;
		Graphique g = Graphique.CreationPlateau(context);
		PvZData data = new PvZData();
		PlantSelect affichageTest = new PlantSelect(context);
		affichageTest.creationMenuSelection();
		// PLATEAU
		data.generateMower();
		while (true) {
			if (etape == 0) {
				g.afficherSelection(context);
			}
			else if (etape == 1) {
				g.afficherselectionplants(context);
				g.afficheMenuSelection(affichageTest,context);
				g.afficherMenuselect(menux, context);
				g.afficherbouton(context);
			}
			else if (etape == 2) {
				compteur += 1;
				data.gameProgress(compteur, context,choix,debug,menux);
				g.afficherTout(context, data, menux, choix);

			}
			Event event = context.pollOrWaitEvent(200);
			if (event == null) {
				continue;// no event
			}

			Action action = event.getAction();
			if (action == Action.KEY_PRESSED) {
				if (event.getKey() == KeyboardKey.Q) {
					if (debug) {
						debug = false;
					} else if (!debug) {
						debug = true;
					}
				} else {
					context.exit(0);
					return;
				}
			}
			
			//POINT AND CLICK

			location = event.getLocation();
			if (action != Action.POINTER_DOWN) {
				continue;
			}
			else if (action == Action.POINTER_DOWN) {
				int ligneHorizon = (int) g.getLongueur();
				int ligneVerticale = (int) g.getLargeur();
				Coordinates clic = new Coordinates((int) location.getX() / ligneHorizon + 1,
						(int) location.getY() / ligneVerticale + 1);
				data.recupererSoleil(clic);

				if (!(selectionner)) {
					selectionner = menux.getPlants((int) location.getX(), (int) location.getY());
				} else {
					selectionner = false;
					if (clic.getJ() < 6 && clic.getJ() > 0) {
						if (choix!=3) {
						data.rajoutePlante(clic, menux.getPlant(),choix);
						}
						else {
							data.rajoutePlante(clic, menux.getPlant(),choix);
						}
					}

				}
				if (etape == 0) {
					choix = donnerlaMap((int) location.getX(), context);
					data.generateGame(context,choix);
					g.resetScreen(context);
					etape += 1;

				}
				else if (etape == 1) {
					menux.ajouterPlant((int)location.getX(), (int)location.getY(),affichageTest);
					menux.removePlant((int)location.getX(), (int)location.getY(),affichageTest);
					if (g.launchGame(location.getX(), location.getY())) {
						etape+=1;
						g.resetScreen(context);
					}
					
				}
			}

		}
	}
	//Choisir la map 
	public static int donnerlaMap(int locationX, ApplicationContext context) {
		ScreenInfo screenInfo = context.getScreenInfo();

		if ((locationX > 0) && (locationX <= (screenInfo.getWidth() / 3))) {
			return 1;
		} else if ((locationX > (screenInfo.getWidth() / 3)) && (locationX <= (screenInfo.getWidth() / 3) * 2)) {
			return 2;
		}
		return 3;
	}
	
	
// AFFICHAGE

	public static void main(String[] args) {
		Application.run(Color.WHITE, PvZGame::Game);

	}
}
