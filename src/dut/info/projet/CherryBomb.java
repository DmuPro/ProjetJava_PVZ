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

/**
 * @author lowli
 *
 */
public class CherryBomb implements InterfacePlant {
	private int pv;
	private final String name = "CherryBomb";
	private Coordinates coordonnee;
	private Color color = Color.RED;
	private final int damage;
	private final int cout = 150;
	private final int cooldown = 5;
	private int compteur = 0;
	private boolean planter= false;

	public CherryBomb(Coordinates coordonnee) {

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
				z.Bobo(this);;
			}
		}
	}


	public void boom(ArrayList<BoardZombie> zboard) {
		double y = coordonnee.getJ();
		if ((y == 1) || (y == 2)) {
			explose(zboard.get(0));
		}
		if ((y == 1) || (y == 2) || (y == 3)) {
			explose(zboard.get(1));
		}
		if ((y == 2) || (y == 3) || (y == 4)) {
			explose(zboard.get(2));
		}
		if ((y == 3) || (y == 4) || (y == 5)) {
			explose(zboard.get(3));
		}
		if ((y == 4) || (y == 5)) {
			explose(zboard.get(4));
		}

	}
	

	public boolean inRange(InterfaceZombie z)  {
		if (((int) z.getCoordonnee().getI() <= (int) getCoordonnee().getI() + 1)
				&& ((int) z.getCoordonnee().getI() >= (int) getCoordonnee().getI() - 1)) {
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
		return "CherryBomb [name=" + name + ", coordonnee=" + coordonnee + "]";
	}
	




	
}
