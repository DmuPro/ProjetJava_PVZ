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

public class SpikeWeed implements InterfacePlant {
	private final String name = "SpikeWeed";
	private int pv;
	private Coordinates coordonnee;
	private Color color = Color.blue;
	private final int as =10;
	private final int damage;
	private final int cout = 50;
	private final int cd = 4;
	private int compteur;
	private boolean attack = false;
	private final int cooldown = 10;
	private boolean planter =false; 

	public SpikeWeed(Coordinates coordonnee) {
		this.coordonnee = coordonnee;
		pv = 20;
		damage = 5;
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
	@Override
	public Color getColor() {
		return color;
	}

	// Pour infliger des d�gats
	public int getDamage() {
		return damage;
	}

	// Eviter qu'il y'ait 2 plantes au m�me endroits
	public boolean sameCoordonnee(InterfacePlant ap) {
		if (coordonnee.equals(ap.getCoordonnee())) {
			return true;
		} else {
			return false;
		}
	}

	// recevoir les d�gats du zombie
	public int mangedDamage(InterfaceZombie az) {

			return pv;
		
	}

	// Change de couleur (Remplacer par l'affichage textuelle si possible
	public void mangedColor(InterfaceZombie az) {
		

	}

	// pour les planter
	public String getName() {
		return name;
	}

	// Mort
	public boolean dead() {
		if (pv <= 0 ) {
			return true;

		}
		return false;

	}
	//port�e de la plante
	public boolean inRange(InterfaceZombie az ) {
		if ((az.getCoordonnee().getI()<=getCoordonnee().getI()+0.5)&&(az.getCoordonnee().getI()>=getCoordonnee().getI()-0.5)
			&& (az.getCoordonnee().getJ() == getCoordonnee().getJ())) {
			return true ;
		}
		else {
			return false;
		}
		
	}
	//manger le zombie et le fait dig�rer
	public void attack(InterfaceZombie az) {
		if (attack == false) {
			if (inRange(az)==true) {
				az.Bobo(this);
				attack = true;
			}
		}
			else if (attack == true){
				compteur += 1;
				if (compteur == 0) {
					attack = false;
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
		return "SpikeWeed [name=" + name + ", coordonnee=" + coordonnee + "]";
	}
	public void oneShot() {
		pv=0;
	}



	@Override
	public boolean onWater() {
		// TODO Auto-generated method stub
		return false;
	}






}
