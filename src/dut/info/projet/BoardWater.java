package dut.info.projet;

import java.util.ArrayList;

import fr.umlv.zen5.ApplicationContext;
import fr.umlv.zen5.ScreenInfo;

public class BoardWater extends BoardPlant{
	private CherryBomb cbomb;
	private final ArrayList<InterfacePlant> p;
	
	
	public BoardWater(ApplicationContext context,int ligne) {
		
		super(context, ligne);
		p = new ArrayList<InterfacePlant>();
	}
	
	public void add(InterfacePlant plant) {
		
			super.getBoard().add(plant);
			System.out.println("La plante "+plant+" a été ajouté");
		
	}

	public boolean containsCoordinates(Coordinates coordonnee) {
		for (InterfacePlant pl : p) {
			if ((pl.getCoordonnee().getI()==coordonnee.getI())&&(pl.getCoordonnee().getJ()==coordonnee.getJ())){
				return true;
			}
		}
		return false;
	}
	
	//MORT
	public void dead() {
		for (int i =0 ;i<size();i++) {
			if ((super.getBoard().get(i).dead() == true)) {
				super.getBoard().remove(i);
				System.out.println("La plante"+super.getBoard()+"a été enlever");
			}
		}
	}
	//Se faire attaquer
	public void getManged(BoardZombie bz) {
		for (InterfacePlant plant : super.getBoard()) {
			for (InterfaceZombie zombie : bz.getBoard()) {	
					plant.ActionPlant(zombie,bz);
				}
			}	
		}
	

	//pour Planter !!
	public boolean planter(Coordinates c,InterfacePlant plant,int energy) {
		int x = (int)c.getI();
		int y = super.getLine();
		if (plant.getCout()<=energy&&(plant.inCharge()==true)&&(containsCoordinates(c)==false&&((plant.onWater())))) {
			if (((plant instanceof LilyPad))) {
				add (new LilyPad(new Coordinates(x,y)));
				return true ;
			}	
		}
		super.planter(c, plant, energy);
		return false ;
	}
	// afficher toutes les plantes sur la ligne 
	public String toString() {
		StringBuilder s1 = new StringBuilder();
		for (InterfacePlant p1: super.getBoard()) {
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

	
	
	



