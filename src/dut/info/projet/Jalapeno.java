package dut.info.projet;

import java.awt.Color;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import fr.umlv.zen5.Application;
import fr.umlv.zen5.ApplicationContext;
import fr.umlv.zen5.Event;
import fr.umlv.zen5.ScreenInfo;
import fr.umlv.zen5.Event.Action;


public class Jalapeno implements InterfacePlant {
	private int pv;
	private final String name = "Jalapeno";
	private Coordinates coordonnee;
	private Color color = Color.RED;
	private final int damage;
	private final int cout = 150;
	private final int cooldown = 1;
	private int compteur = 0;
	private boolean planter= false;

	public Jalapeno(Coordinates coordonnee) {

		pv = 0;
		damage = 2000;
		this.coordonnee = new Coordinates(coordonnee.getI(), coordonnee.getJ());
	}

	public int getCout() {
		return cout;
	}
	public int getCooldown() {
		return cooldown;
	}
	public boolean inCharge() {
		if (planter == false) {				
			planter = true;
			return true;
		}
			else if (planter == true){
				compteur += 1;
				if (compteur%cooldown == 0) {
					planter = false;
				}
			}
		return false;
		
	}
	public Coordinates getCoordonnee() {
		return coordonnee;
	}

	// Pour les afficher sur le terrain
	public Color getColor() {
		return color;
	}

	// Pour infliger des dégats
	public int getDamage() {
		return damage;
	}

	// Eviter qu'il y'ait 2 plantes au même endroits
	public boolean sameCoordonnee(InterfacePlant ap) {
		if (coordonnee.equals(ap.getCoordonnee())) {
			return true;
		} else {
			return false;
		}
	}

	// recevoir les dégats du zombie
	public int mangedDamage(InterfaceZombie az) {

		if (az.manger(this)) {
			return pv = pv - az.getDamage();
		} else {
			return pv;
		}
	}

	// Change de couleur (Remplacer par l'affichage textuelle si possible
	public void mangedColor(InterfaceZombie az) {
		if (az.manger(this)) {
			 color = Color.red;
		}

		else {
			 color = Color.red;
		}
	}

	// pour les planter
	public String getName() {
		return name;
	}

	// Mort
	public boolean dead() {
		if (pv <= 0) {
			return true;

		}
		return false;

	}

	// TOUTES LES ACTIONS DE LA PLANTES !!
	public void ActionPlant(InterfaceZombie iz,BoardZombie bz) {
		mangedColor(iz);
		mangedDamage(iz);

	}

	public void explose(BoardZombie boardz) {
		for (InterfaceZombie z : boardz.getBoard()) {
			if (inRange(z)) {
				z.oneShot();
			}
		}
	}


	public void boom(ArrayList<BoardZombie> zboard) {
		int y = (int)coordonnee.getJ();
		System.out.println(y);
			explose(zboard.get(y-1));
		
	}
	

	public boolean inRange(InterfaceZombie z)  {
		if ((int) z.getCoordonnee().getI() <= 10){
			
			return true;
		}
		return false;
	}

	@Override
	public void oneShot() {
		pv=0;
	}

	@Override
	public boolean onWater() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String toString() {
		return "Jalapeno [name=" + name + ", coordonnee=" + coordonnee + "]";
	}
	




	
}

