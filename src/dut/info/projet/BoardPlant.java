package dut.info.projet;

import java.util.ArrayList;

import fr.umlv.zen5.ApplicationContext;
import fr.umlv.zen5.ScreenInfo;

public class BoardPlant {
	private final ArrayList<InterfacePlant> p;
	private final int longueurplateau;
	private final int largeurPlateau;
	private final int ligne ;
	private Coordinates coordonne;
	private CherryBomb cbomb;
	private DoomShroom dshroom;
	private IceShroom iceshroom;
	private Jalapeno jala;
	public BoardPlant(ApplicationContext context,int ligne) {
		p = new ArrayList<InterfacePlant>();
		this.ligne= ligne ;
		ScreenInfo screenInfo = context.getScreenInfo();
		longueurplateau = (int) (screenInfo.getWidth() * 70 / 100);
		largeurPlateau = (int) (screenInfo.getHeight() * 70 / 100);
		

	}
	public int getLine() {
		return ligne;
	}
	public InterfacePlant get(int i) {
		return p.get(i);
	}

	public Coordinates getCoordinates() {
		return coordonne;
	}
	public ArrayList<InterfacePlant> getBoard() {
		return p;
	}
	public int size() {
		return p.size();
	}
	public boolean isEmpty() {
		return p.isEmpty();
	}
	//Verifier si 2 plantes ont les mêmes coordonnées
	public boolean containsCoordinates(Coordinates coordonnee) {
		for (InterfacePlant pl : p) {
			if ((pl.getCoordonnee().getI()==coordonnee.getI())&&(pl.getCoordonnee().getJ()==coordonnee.getJ())){
				return true;
			}
		}
		return false;
	}
	public boolean containsCoordinates(InterfacePlant plant) {
		for (InterfacePlant pl : p) {
			if ((pl.getCoordonnee().getI()==plant.getCoordonnee().getI())&&(pl.getCoordonnee().getJ()==plant.getCoordonnee().getJ())){
				return true;
			}
		}
		return false;
	}
	//ajout d'une plante
	public void add(InterfacePlant plant) {
		if (!(plant.onWater())) {
			p.add(plant);
			System.out.println("La plante"+plant+"a été ajouté");
		}
	}
	//MORT
	public void dead() {
		for (int i =0 ;i<size();i++) {
			if ((p.get(i).dead() == true)) {
				p.remove(i);
				System.out.println("La plante"+p+"a été enlever");
			}
		}
	}
	//Se faire attaquer
	public void getManged(BoardZombie bz) {
		for (InterfacePlant plant : p) {
			for (InterfaceZombie zombie : bz.getBoard()) {	
					plant.ActionPlant(zombie,bz);
				}
				
			}	
		}
	public Coordinates randomPlantes() {
		
		int plante = (int)Graphique.nombreAlea(size()-1, 0);
		return get(plante).getCoordonnee();
		

		
	}
	//pour Planter !!
	public boolean planter(Coordinates c,InterfacePlant plant,int energy) {
		int x = (int)c.getI();
		int y = ligne;
		if (plant.getCout()<=energy&&(plant.inCharge()==true)&&(containsCoordinates(c)==false)&&(!(plant.onWater()))) {
			
			if ((plant instanceof WallNut)) {
				add(new WallNut(new Coordinates(x,y)));
			}
			if ((plant instanceof TallNut)) {
				add(new WallNut(new Coordinates(x,y)));
			}
			else if (plant instanceof SnowPea) {
				add(new SnowPea(new Coordinates(x, y)));
			}
			else if (plant instanceof Repeater) {
				add(new Repeater(new Coordinates(x, y)));
			}
			else if (plant instanceof PuffShroom) {
				add(new PuffShroom(new Coordinates(x, y)));
			}
			else if (plant instanceof FumeShroom) {
				add(new FumeShroom(new Coordinates(x, y)));
			}
			else if (plant instanceof DoomShroom) {
				add(new DoomShroom(new Coordinates(x, y)));
				dshroom = (new DoomShroom(new Coordinates(x, y)));
			}
			else if (plant instanceof IceShroom) {
				add(new IceShroom(new Coordinates(x, y)));
				iceshroom = (new IceShroom(new Coordinates(x, y)));
			}
			else if (plant instanceof Jalapeno) {
				add(new Jalapeno(new Coordinates(x, y)));
				jala = (new Jalapeno(new Coordinates(x, y)));
			}
			else if (plant instanceof MagnetShroom) {
				add(new MagnetShroom(new Coordinates(x, y)));
			}
			else if (plant instanceof SpikeWeed) {
				add(new SpikeWeed(new Coordinates(x, y)));
			}
			else if (plant instanceof SplitPea) {
				add(new SplitPea(new Coordinates(x, y)));
			}
		
			else if (plant instanceof CherryBomb) {
				add(new CherryBomb(new Coordinates(x, y)));
				cbomb = (new CherryBomb(new Coordinates(x, y)));
			}
			else if (plant instanceof SunShroom) {
				add(new SunShroom(new Coordinates(x, y)));
			}
			else if (plant instanceof ScaredyShroom) {
				add(new ScaredyShroom(new Coordinates(x, y)));
			}
			else if (plant instanceof Squash) {
				add(new Squash(new Coordinates(x, y)));
			}
			else if (plant instanceof TwinSunflower) {
				add(new TwinSunflower(new Coordinates(x, y)));
			}
			else if (plant instanceof SeaShroom) {
				add(new SeaShroom(new Coordinates(x, y)));
			}
			else if (plant instanceof PeaShooter) {
				add(new PeaShooter(new Coordinates(x, y)));
			}
			else if (plant instanceof SunFlower) {
				add(new SunFlower(new Coordinates(x, y)));
			}
			else if (plant instanceof Chomper) {
				add(new Chomper(new Coordinates(x, y)));
			}
			else if (plant instanceof PotatoMine) {
				add(new PotatoMine(new Coordinates(x, y)));
			}
			else if (plant instanceof GraveBuster) {
				add(new GraveBuster(new Coordinates(x, y)));
			}
			return true ;
		}
		return false ;
	}
	// afficher toutes les plantes sur la ligne 
	public String toString() {
		StringBuilder s1 = new StringBuilder();
		for (InterfacePlant p1: p) {
			s1.append(p1+"\n");
		}
		return s1.toString();
	}
	//explosion de la cherryBomb
	public void boom(ArrayList <BoardZombie> z) {
        if (cbomb != null) { 
            cbomb.boom(z); //fait exploser la cherryBomb 
            cbomb = null; 
        } 
        if (jala != null) { 
        	jala.boom(z); //fait exploser la cherryBomb 
        	 jala = null; 
        } 
        if (dshroom != null) { 
        	dshroom.boom(z); //fait exploser la cherryBomb 
        	 dshroom = null; 
        } 
        if (iceshroom != null) { 
        	iceshroom.boom(z); //fait exploser la cherryBomb 
        	 iceshroom = null; 
        } 
	}
	
	
	//TOUTES LES ACTIONS DES PLANTES !!
	public void actionPlant(BoardZombie bz,ArrayList <BoardZombie> z) {
		if (!(isEmpty())) {
		getManged(bz);
		boom(z);
		dead();
		}
	}


}
