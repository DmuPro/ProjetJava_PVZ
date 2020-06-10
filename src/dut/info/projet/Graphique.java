package dut.info.projet;

import java.awt.Color;
import java.awt.Font;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import fr.umlv.zen5.ApplicationContext;
import fr.umlv.zen5.ScreenInfo;
import dut.info.projet.InterfacePlant;
import dut.info.projet.PlantSelect;
import dut.info.projet.PvZData;

public class Graphique {
	static int compteur;
	private final int longueur;
	private final int largeur;
	private final int tailleCase;
	private final int largeurCase;
	private final int longueurEcran;
	private final int largeurEcran;
	
	private Graphique(int longueur,int largeur,ScreenInfo screenInfo) {
		this.longueur = longueur;
		this.largeur = largeur;
		tailleCase = longueur/10;
		largeurCase = largeur/5;
		longueurEcran = (int)screenInfo.getWidth();
		largeurEcran = (int)screenInfo.getHeight();
	}
	
	public static Graphique CreationPlateau(ApplicationContext context) {
		ScreenInfo screenInfo = context.getScreenInfo();
		return new Graphique((int)(screenInfo.getWidth() * 70) / 100,(int)(screenInfo.getHeight() * 70) / 100,screenInfo);
	}



	public void generateZombie(ApplicationContext context,ArrayList <BoardZombie> bz) {
		for (BoardZombie z:bz) {
			generateLineZombie(z,context);
		}
	}
	
	public void generateLineZombie(BoardZombie bz,ApplicationContext context) {
		if (!(bz.isEmpty())) {
			for (InterfaceZombie z : bz.getBoard()){
				if (z.getCoordonnee().getI() <= 10
						&& (z.getCoordonnee().getJ() >= 1 && z.getCoordonnee().getJ() <= 5)) {
					context.renderFrame(truc -> {
						truc.setColor(z.getColor());
						truc.fill(new Rectangle2D.Float(
								(tailleCase / 3 + (float) z.getCoordonnee().getI() * tailleCase - tailleCase),
								(largeurCase /4 + (float) z.getCoordonnee().getJ() * largeurCase - largeurCase),
								tailleCase / 2, largeurCase / 2));

					});
				}

			}
		}
		
	}
	public int getLongueur() {
		return tailleCase;
	}
	
	public int getLargeur() {
		return largeurCase;
	}
	
	public static int nombreAlea(int mult,int chiffre) {
		int rand = (int) ((Math.random() * mult)+chiffre);
		
		return rand;
	}
	

	
	// nouveau
	public void generatePlant(ApplicationContext context,ArrayList <BoardPlant> bp) {
		for (BoardPlant p:bp)
			generatePlantLine(p,context);
		
	}
	
	public void generatePlantLine(BoardPlant pb,ApplicationContext context) {
		if (!(pb.isEmpty())) {
			for (InterfacePlant p : pb.getBoard()) {
				
				context.renderFrame(truc -> {
					if (p instanceof LilyPad) {
					truc.setColor(p.getColor());
					truc.fill(new Rectangle2D.Float(
							(tailleCase / 10 + (int) p.getCoordonnee().getI() * tailleCase - tailleCase),
							(largeurCase / 12 + (int) p.getCoordonnee().getJ() * largeurCase - largeurCase),
							tailleCase / 4, largeurCase / 3));
					}
					else {
					truc.setColor(p.getColor());
					truc.fill(new Ellipse2D.Float(
							(tailleCase / 3 + (int) p.getCoordonnee().getI() * tailleCase - tailleCase),
							(largeurCase / 4 + (int) p.getCoordonnee().getJ() * largeurCase - largeurCase),
							tailleCase / 2, largeurCase / 2));
					}
				});
			}
		}
		
	}
	public void generateSun(ApplicationContext context,ArrayList<Sun> sun) {
		if (!(sun.isEmpty())) {
			for (Sun s : sun) {
				context.renderFrame(truc -> {
					truc.setColor(s.getColor());
					truc.fill(new Ellipse2D.Float(
							(tailleCase / 3 + (int) s.getCoordonnee().getI() * tailleCase - tailleCase),
							(largeurCase / 2 + (int) s.getCoordonnee().getJ() * largeurCase - largeurCase),
							tailleCase / 3, largeurCase / 3));
				});
			}
		}
		
	}
	public void generateMower(ApplicationContext context,ArrayList<Mower> mower) {
		if (!(mower.isEmpty())) {
			for (Mower mw : mower) {
				context.renderFrame(truc -> {
					truc.setColor(mw.getColor());
					truc.fill(new Rectangle2D.Float(
							(tailleCase+ (int) mw.getCoordonnee().getI() * tailleCase - tailleCase),
							(largeurCase  + (int) mw.getCoordonnee().getJ() * largeurCase - largeurCase),
							tailleCase / 2, largeurCase / 2));

				});
			}
		}
		
	}
	
	public void affichergrave(ApplicationContext context,PvZData data) {
		context.renderFrame(graphics->{
			for (Grave g:data.getGraveList()) {
			graphics.setColor(g.getColor());
			graphics.fill(
					new Rectangle2D.Float(
					(tailleCase / 3 + (float) g.getCoordonnee().getI() * tailleCase - tailleCase),
					(largeurCase /4 + (float) g.getCoordonnee().getJ() * largeurCase - largeurCase),
					tailleCase / 2, largeurCase / 2));
			}
		});
		

	}

	public void normalLevel(ApplicationContext context) {

		int debutP = 10;
		int haut = 0;

		// Initie les différentes parties de notre plateau
				context.renderFrame(graphics -> {
					graphics.setColor(Color.GREEN);
					graphics.fill(new Rectangle2D.Float(debutP, haut, longueur, largeur));

				});
				/* ********************************************* */

				// Quadrillage
				context.renderFrame(graph -> {
					graph.setColor(Color.BLACK);
					for (int i = debutP; i <= longueur + tailleCase; i += tailleCase) {
						for (int j = haut; j <= largeur; j += largeurCase) {
							graph.drawLine(i, haut, i, largeur);
							graph.drawLine(debutP, j, longueur + debutP, j);
						}
					}
				});
				context.renderFrame(graphique -> {
					graphique.setColor(Color.BLACK);
					for (int i = debutP; i <= longueur + tailleCase; i += tailleCase) {
						for (int j = largeur + debutP; j <= largeur + debutP + tailleCase; j += tailleCase) {
							graphique.drawLine(i, largeur + debutP, i, largeur + tailleCase + debutP);
							graphique.drawLine(debutP, j, longueur + debutP, j);

						}
					}

				});


		/* ******************************************** */
		// Menu

		context.renderFrame(graphil -> {
			graphil.setColor(Color.GRAY);
			graphil.fill(new Rectangle2D.Float(debutP, largeur + debutP, longueur, (int) (largeurCase)));
		});
	}
	public void nightLevel(ApplicationContext context,PvZData data) {

		int debutP = 10;
		int haut = 0;

		// Initie les différentes parties de notre plateau
				context.renderFrame(graphics -> {
					graphics.setColor(Color.MAGENTA);
					graphics.fill(new Rectangle2D.Float(debutP, haut, longueur, largeur));

				});
				/* ********************************************* */

				// Quadrillage
				context.renderFrame(graph -> {
					graph.setColor(Color.BLACK);
					for (int i = debutP; i <= longueur + tailleCase; i += tailleCase) {
						for (int j = haut; j <= largeur; j += largeurCase) {
							graph.drawLine(i, haut, i, largeur);
							graph.drawLine(debutP, j, longueur + debutP, j);
						}
					}
				});
				context.renderFrame(graphique -> {
					graphique.setColor(Color.BLACK);
					for (int i = debutP; i <= longueur + tailleCase; i += tailleCase) {
						for (int j = largeur + debutP; j <= largeur + debutP + tailleCase; j += tailleCase) {
							graphique.drawLine(i, largeur + debutP, i, largeur + tailleCase + debutP);
							graphique.drawLine(debutP, j, longueur + debutP, j);

						}
					}

				});


		/* ******************************************** */
		// Menu

		context.renderFrame(graphil -> {
			graphil.setColor(Color.GRAY);
			graphil.fill(new Rectangle2D.Float(debutP, largeur + debutP, longueur, (int) (largeurCase)));
		});
		
		affichergrave(context,data);
	}
	public void waterLevel(ApplicationContext context) {

		int debutP = 10;
		int haut = 0;

		// Initie les différentes parties de notre plateau
				context.renderFrame(graphics -> {
					graphics.setColor(Color.GREEN);
					graphics.fill(new Rectangle2D.Float(debutP, haut, longueur, largeur));

				});
				/* ********************************************* */
				context.renderFrame(graphics -> {
					graphics.setColor(Color.BLUE);
					graphics.fill(new Rectangle2D.Float(debutP, largeurCase*2, longueur, largeurCase));

				});

				// Quadrillage
				context.renderFrame(graph -> {
					graph.setColor(Color.BLACK);
					for (int i = debutP; i <= longueur + tailleCase; i += tailleCase) {
						for (int j = haut; j <= largeur; j += largeurCase) {
							graph.drawLine(i, haut, i, largeur);
							graph.drawLine(debutP, j, longueur + debutP, j);
						}
					}
				});
				context.renderFrame(graphique -> {
					graphique.setColor(Color.BLACK);
					for (int i = debutP; i <= longueur + tailleCase; i += tailleCase) {
						for (int j = largeur + debutP; j <= largeur + debutP + tailleCase; j += tailleCase) {
							graphique.drawLine(i, largeur + debutP, i, largeur + tailleCase + debutP);
							graphique.drawLine(debutP, j, longueur + debutP, j);

						}
					}

				});


		/* ******************************************** */
		// Menu

		context.renderFrame(graphil -> {
			graphil.setColor(Color.GRAY);
			graphil.fill(new Rectangle2D.Float(debutP, largeur + debutP, longueur, (int) (largeurCase)));
		});
	}

	
	public void afficherSelection(ApplicationContext context) {
		context.renderFrame(graphics -> {
			graphics.setColor(Color.GREEN);
			graphics.fill(new Rectangle2D.Float(0,0, longueurEcran/3, largeurEcran));

		});
		context.renderFrame(graphic -> {
			graphic.setColor(Color.BLUE);
			graphic.fill(new Rectangle2D.Float(longueurEcran/3,0, longueurEcran/3, largeurEcran));

		});
		context.renderFrame(graphic -> {
			graphic.setColor(Color.RED);
			graphic.fill(new Rectangle2D.Float((longueurEcran/3)*2,0, longueurEcran/3, largeurEcran));

		});
		
		
	}
	
	public void afficherMenuselect(PlantSelect j, ApplicationContext context) {

		compteur = (int) tailleCase / 3;

		for (InterfacePlant p : j.getMenu()) {

			context.renderFrame(graphics -> {

				graphics.setColor(p.getColor());
				graphics.fill(new Ellipse2D.Float(compteur, largeur + largeurCase / 3, tailleCase / 2,
						largeurCase / 2));
				compteur += tailleCase;
			});
			context.renderFrame(graphics->{
				graphics.setColor(Color.WHITE);
				graphics.drawString(p.getName(),  compteur-tailleCase,largeur + largeurCase / 3);
			});

		}

	}
	/* *******************************Interface******************************** */
	public void afficherGaugeEnergy(ApplicationContext context, int energy) {
		context.renderFrame(graphics->{
			graphics.setColor(Color.WHITE);
			graphics.fill(new Rectangle2D.Float(longueur,0,1000,1000));
		});
		context.renderFrame(graphip -> {
		graphip.drawString(Integer.toString(energy), longueur+100,50);
	
		});
		
		
	}
	
	
	
	public void afficherselectionplants(ApplicationContext context) {
		int debutP = 10;
		int haut = 0;
		context.renderFrame(graphics -> {
			graphics.setColor(Color.DARK_GRAY);
			graphics.fill(new Rectangle2D.Float(0, 0, longueurEcran, largeurEcran));
		});

		context.renderFrame(graph -> {
			graph.setColor(Color.BLACK);
			for (int i = debutP; i <= longueur + tailleCase; i += tailleCase) {
				for (int j = haut; j <= largeur; j += largeurCase) {
					graph.drawLine(i, haut, i, largeur);
					graph.drawLine(debutP, j, longueur + debutP, j);
				}
			}
		});
		context.renderFrame(graphique -> {
			graphique.setColor(Color.BLACK);
			for (int i = debutP; i <= longueur + tailleCase; i += tailleCase) {
				for (int j = largeur + debutP; j <= largeur + debutP + tailleCase; j += tailleCase) {
					graphique.drawLine(i, largeur + debutP, i, largeur + tailleCase + debutP);
					graphique.drawLine(debutP, j, longueur + debutP, j);

				}
			}

		});
		context.renderFrame(graphil -> {
			graphil.setColor(Color.GRAY);
			graphil.fill(new Rectangle2D.Float(debutP, largeur + debutP, longueur, (int) (largeurCase)));
		});
	}

	public void resetScreen(ApplicationContext context) {
		context.renderFrame(graphics -> {
			graphics.setColor(Color.WHITE);
			graphics.fill(new Rectangle2D.Float(0, 0, longueurEcran, largeurEcran));
		});
	}

	public void afficherTout(ApplicationContext context, PvZData data, PlantSelect s, int choix) {

		normalLevel(context);
		afficherGaugeEnergy(context, data.getEnergy());
		if (choix == 1) {
			normalLevel(context);
		} else if (choix == 2) {
			waterLevel(context);
		} else if (choix == 3) {
			nightLevel(context,data);
		}
		generateSun(context, data.getSun());
		generateZombie(context, data.getZboard());
		generatePlant(context, data.getPboard());
		generateMower(context, data.getMower());
		afficherMenuselect(s, context);
	}
	
	public void draw(ApplicationContext context,int x,int y,InterfacePlant p) {
		context.renderFrame(truc -> {
			truc.setColor(p.getColor());
			truc.fill(new Ellipse2D.Float(
					(tailleCase / 3 + x * tailleCase - tailleCase),
					(largeurCase / 4 + y * largeurCase - largeurCase),
					tailleCase / 2, largeurCase / 2));
			
		});
	}
	
	public void drawText(ApplicationContext context,int x,int y,InterfacePlant p) {
		context.renderFrame(truc -> {
			truc.setColor(Color.WHITE);
			truc.drawString(p.getName(),(tailleCase / 3 + x * tailleCase - tailleCase), (largeurCase / 4 + y * largeurCase - largeurCase));
		});
		
	}
	


	public void afficheMenuSelection(PlantSelect ps, ApplicationContext context) {
		int line = 1;
		int colonne = 1;
		for (InterfacePlant p : ps.getMenu()) {
			draw(context,line,colonne,p);
			drawText(context,line,colonne,p);
			line += 1;
			if (line % 11 == 0) {
				colonne += 1;
				line = 1;
			}

		}

	}
	
	public void afficherbouton(ApplicationContext context) {
		context.renderFrame(graphics->{
			graphics.setColor(Color.WHITE);
			graphics.fill(new Rectangle2D.Float(longueur-tailleCase,largeur+10+largeurCase,100,100));
			
			
		});
		
		context.renderFrame(graphics->{
			graphics.drawString("Lancer le jeu !", longueur-tailleCase+(tailleCase/6), largeur+10+largeurCase+(largeurCase/2));
		});
		
	}
	
	public boolean launchGame(double d,double e) {
		if ((d>(longueur-tailleCase))&&(d<longueur-tailleCase+100)) {
			if ((e>(largeur+10+largeurCase))&&(e<(largeur+10+largeurCase+100))) {
				return true;
			}
		}
		return false;
	}

}