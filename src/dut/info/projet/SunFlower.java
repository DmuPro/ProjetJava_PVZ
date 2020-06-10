package dut.info.projet;

import java.awt.Color;
import java.util.ArrayList;

public class SunFlower implements InterfacePlant {
	private final String name = "SunFlower";
	private int pv;
	private Coordinates coordonnee;
	private Color color = Color.PINK;
	private final int damage;
	private final int cout =100 ;
	private final int cooldown = 1;
	private int compteur = 0;
	private boolean inCharge= false;
	private boolean attack = false;

	public SunFlower(Coordinates coordonnee) {
		this.coordonnee=coordonnee;
		pv = 50;
		damage = 0;
		this.coordonnee = new Coordinates(coordonnee.getI(), coordonnee.getJ());

	}
	public int getCout() {
		return cout;
	}
	public int getCooldown() {
		return cooldown;
	}
	public Coordinates getCoordonnee() {
		return coordonnee;
	}
	public boolean inCharge() {
		if (inCharge == false) {				
			inCharge = true;
			return true;
		}
			else if (inCharge == true){
				compteur += 1;
				if (compteur%cooldown == 0) {
					inCharge = false;
				}
			}
		return false;
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
	public boolean inRange(InterfaceZombie az ) {
		return false;
		
	}
	// TOUTES LES ACTIONS DE LA PLANTES !!
	public void ActionPlant(InterfaceZombie az,BoardZombie bz) {
		mangedColor(az);
		mangedDamage(az);

	}

	public void sunFlowerEffect(ArrayList <Sun> sun) {
		if (attack == false) {
		sun.add(new Sun(new Coordinates(getCoordonnee().getI(),getCoordonnee().getJ())));
		attack = true;
			}
		else if (attack == true){
			compteur += 1;
			if (compteur%6== 0) {
				attack = false;
			}
		}
	}
	@Override
	public String toString() {
		return "SunFlower [name=" + name + ", coordonnee=" + coordonnee + "]";
	}
	@Override
	public boolean onWater() {
		// TODO Auto-generated method stub
		return false;
	}
	public void oneShot() {
		pv=0;
	}

	

}
