package dut.info.projet;

import java.awt.Graphics;
import java.util.ArrayList;

import fr.umlv.zen5.ApplicationContext;
import fr.umlv.zen5.ScreenInfo;

public class PlantSelect {
	private int totalplante;
	private ArrayList<InterfacePlant> menu;
	private final int longueurplateau;
	private final int largeurPlateau;
	private final int tailleCaseL;
	private final int largeurCaseL;
	private final int debutP;
	private InterfacePlant plant;
	//private ArrayList<InterfacePlant> plant = [new PeaShooter(new Coordinates(-1,-1)),new WallNut(new Coordinates(-1,-1)),new CherryBomb(new Coordinates(-1,-1))];

	public PlantSelect(ApplicationContext context) {
		menu = new ArrayList<InterfacePlant>();
		ScreenInfo screenInfo = context.getScreenInfo();
		longueurplateau = (int) (screenInfo.getWidth() * 70 / 100);
		largeurPlateau = (int) (screenInfo.getHeight() * 70 / 100);
		tailleCaseL = longueurplateau / 10;
		largeurCaseL = largeurPlateau / 5;
		debutP=10;
	}
	public  ArrayList<InterfacePlant> getMenu(){
		return menu;
	}
	
	public int size() {
		return menu.size();
	}
	public InterfacePlant get(int i) {
		return menu.get(i);
	}
	public InterfacePlant getPlant() {
		return plant;
	}
	public boolean getPlants(int x,int y) {
        for (int i = 0; i <= size(); i++) {
            if ((x < tailleCaseL + tailleCaseL * i) && (x > tailleCaseL * i)) {
                if ((y < largeurCaseL + debutP + largeurPlateau) && (y > largeurPlateau + debutP)) {
                    plant = menu.get(i);
                    return true;
                }
            }
        }
        return false;

    }
	
	public void menuCreation() {
			add(new PeaShooter(new Coordinates(-1,-1)));
			add(new WallNut(new Coordinates(-1,-1)));
			add(new CherryBomb(new Coordinates(-1,-1)));
			add(new SunFlower(new Coordinates(-1,-1)));
			add(new Chomper(new Coordinates(-1,-1)));
			add(new Repeater(new Coordinates(-1,-1)));
			add(new SnowPea(new Coordinates(-1,-1)));
			add(new LilyPad(new Coordinates(-1,-1)));
	}
	//génére aléatoirement des plantes
	public void randPlant() {
		plant =get(Graphique.nombreAlea(menu.size(), 0));
	}
	//ajoute des plantes au menu
	public void add(InterfacePlant p){
		menu.add(p);
	}
	public void remove(InterfacePlant p){
		menu.remove(p);
	}
	
	public void creationMenuSelection() {
		
		add(new PeaShooter(new Coordinates(-1,-1)));
		add(new WallNut(new Coordinates(-1,-1)));
		add(new CherryBomb(new Coordinates(-1,-1)));
		add(new SunFlower(new Coordinates(-1,-1)));
		add(new Chomper(new Coordinates(-1,-1)));
		add(new DoomShroom(new Coordinates(-1,-1)));
		add(new Repeater(new Coordinates(-1,-1)));
		add(new SnowPea(new Coordinates(-1,-1)));
		add(new LilyPad(new Coordinates(-1,-1)));
		add(new PuffShroom(new Coordinates(-1,-1)));
		add(new IceShroom(new Coordinates(-1,-1)));
		add(new Jalapeno(new Coordinates(-1,-1)));
		add(new MagnetShroom(new Coordinates(-1,-1)));
		add(new PotatoMine(new Coordinates(-1,-1)));
		add(new SunShroom(new Coordinates(-1,-1)));
		add(new ScaredyShroom(new Coordinates(-1,-1)));
		add(new FumeShroom(new Coordinates(-1,-1)));
		add(new SpikeWeed(new Coordinates(-1,-1)));
		add(new Squash(new Coordinates(-1,-1)));
		add(new TwinSunflower(new Coordinates(-1,-1)));
		add(new GraveBuster(new Coordinates(-1,-1)));
		
		
		
	}
	
	public void ajouterPlant(int x,int y,PlantSelect ps) {
		int colonne = 0;
        for (int i = 0; i <= ps.size(); i++) {
            if ((x < tailleCaseL + tailleCaseL * i) && (x > tailleCaseL * i)) {
                if ((y > 0) && (y < largeurPlateau)) {
                	if (y>largeurCaseL) {
                		colonne+=1*((int)y/largeurCaseL);
                	}
                	int index = i + 10*colonne ;
                	if((index <ps.size())&&(totalplante<10)) {
                    plant = ps.get(index);
                    ps.remove(plant);
                    add(plant);
                    totalplante+=1;
                	}
                	
                }
            }
        }
	}
	

	

	public void removePlant(int x,int y,PlantSelect ps) {
		if (!(menu.isEmpty())) {
        for (int i = 0; i <= size(); i++) {
            if ((x < tailleCaseL + tailleCaseL * i) && (x > tailleCaseL * i)) {
                if ((y < largeurCaseL + debutP + largeurPlateau) && (y > largeurPlateau + debutP)) {
                	InterfacePlant plante = menu.get(i);
                	if ((plante != null)&&(!(menu.isEmpty()))) {
                		menu.remove(plante);
                		ps.add(plante);
                		totalplante-=1;
                	}
                }
            }
        }
		}
	}
	
	

}

