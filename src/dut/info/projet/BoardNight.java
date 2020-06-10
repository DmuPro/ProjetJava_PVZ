package dut.info.projet;

import java.util.ArrayList;

import fr.umlv.zen5.ApplicationContext;

public class BoardNight extends BoardPlant{
	private CherryBomb cbomb;
	

	public BoardNight(ApplicationContext context,int ligne) {
		super(context, ligne);
		
		

	}
	public int getLine() {
		return super.getLine();
	}
	public InterfacePlant get(int i) {
		return super.get(i);
	}

	public Coordinates getCoordinates() {
		return super.getCoordinates();
	}
	public ArrayList<InterfacePlant> getBoard() {
		return super.getBoard();
	}
	public int size() {
		return super.size();
	}
	public boolean isEmpty() {
		return super.isEmpty();
	}
	//Verifier si 2 plantes ont les mêmes coordonnées
	public boolean containsCoordinates(Coordinates coordonnee,InterfacePlant plant,ArrayList<Grave> grave) {
		if (OnGrave(coordonnee,grave)) {
			return true;
		}
		return super.containsCoordinates(coordonnee);
	}
	//ajout d'une plante
	public void add(InterfacePlant plant) {
		if (!(plant.onWater())) {
			super.getBoard().add(plant);
			System.out.println("La plante"+plant+"a été ajouté");
		}
	}
	//MORT
	public void dead() {
		super.dead();
	}
	//Se faire attaquer
	public void getManged(BoardZombie bz) {
		super.getManged(bz);	
		}
	public Coordinates randomPlantes() {
		return super.randomPlantes();
		

		
	}
	//pour Planter !!
	public boolean planter(Coordinates c,InterfacePlant plant,int energy,ArrayList<Grave> gravelist) {
		int x = (int)c.getI();
		int y = super.getLine();
		if (plant.getCout()<=energy&&(plant.inCharge()==true)&&(containsCoordinates(c,plant,gravelist)==false)) {
			if ((plant instanceof WallNut)) {
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
			}
			else if (plant instanceof IceShroom) {
				add(new IceShroom(new Coordinates(x, y)));
			}
			else if (plant instanceof Jalapeno) {
				add(new Jalapeno(new Coordinates(x, y)));
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
			return true ;
		}
		return false ;
	}
	// afficher toutes les plantes sur la ligne 
	public String toString() {
		return super.toString();
	}
	//explosion de la cherryBomb
	public void boom(ArrayList <BoardZombie> z) {
        super.boom(z);
	}
	
	
	//TOUTES LES ACTIONS DES PLANTES !!
	public void actionPlant(BoardZombie bz,ArrayList <BoardZombie> z) {
		super.actionPlant(bz, z);
	}
	
	public boolean OnGrave(Coordinates c,ArrayList<Grave> gravelist) {
		if (!(gravelist.isEmpty())) {
			for (Grave g:gravelist) {
				if (g.blockPlants(c)){
					return true;
				}
			}
		}
		
		System.out.println(gravelist.size());
		return false;
		
	}

	
	


}