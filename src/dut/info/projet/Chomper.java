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

public class Chomper implements InterfacePlant {
	private final String name = "Chomper";
	private int pv;
	private Coordinates coordonnee;
	private Color color = Color.PINK;
	private final int damage;
	private final int cout = 150;
	private final int cd = 8;
	private int compteur;
	private boolean manger = false;
	private final int cooldown = 4;
	private boolean planter =false; 
	private final int as =5;

	public Chomper(Coordinates coordonnee) {
		this.coordonnee = coordonnee;
		pv = 20;
		damage = 0;
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
				if (compteur%20 == 0) {
					planter = false;
				}
			}
		return false;
		
	}
	public Coordinates getCoordonnee() {
		return coordonnee;
	}

	// Pour les afficher sur le terrain
	@Override
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
		compteur += 1;
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

		color = Color.PINK;

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
	//portée de la plante
	public boolean inRange(InterfaceZombie az ) {
		if ((az.getCoordonnee().getI() <= getCoordonnee().getI() + 1)
			&& (az.getCoordonnee().getJ() == getCoordonnee().getJ())) {
			return true ;
		}
		else {
			return false;
		}
		
	}
	//manger le zombie et le fait digérer
	public void attack(InterfaceZombie az) {
		if (manger == false) {
			if (inRange(az)==true) {
				az.oneShot();
				manger = true;

			}
		}
			else if (manger == true){
				compteur += 1;
				if (compteur%as == 0) {
					manger = false;
				}
			}
		}

	// TOUTES LES ACTIONS DE LA PLANTES !!
	public void ActionPlant(InterfaceZombie az,BoardZombie bz) {
		attack(az);
		mangedColor(az);
		mangedDamage(az);

	}
	@Override
	public String toString() {
		return "Chomper [name=" + name + ", coordonnee=" + coordonnee + "]";
	}

	@Override
	public boolean onWater() {
		return false;
	}

	@Override
	public void oneShot() {
		pv=0;
	}







}
