package dut.info.projet;

import java.awt.Color;
import java.util.ArrayList;

public class SunShroom extends SunFlower {
	private final String name = "SunShroom";
	private int pv=20;
	private Coordinates coordonnee;
	private Color color = Color.pink;
	private final int damage=0;
	private final int cout =25 ;
	private final int cooldown = 1;
	private int compteur = 0;
	private boolean inCharge= false;
	private boolean attack = false;

	
	public SunShroom(Coordinates coordonnee) {
		super(coordonnee);
		this.coordonnee=coordonnee;
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
		return super.sameCoordonnee(ap);
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
			 color = Color.pink;
	}
	// pour les planter
	public String getName() {
		return name;
	}
	// Mort
	public boolean dead() {
		return super.dead();
	}
	public boolean inRange(InterfaceZombie az ) {
		return super.inRange(az);
		
	}
	// TOUTES LES ACTIONS DE LA PLANTES !!
	public void ActionPlant(InterfaceZombie az) {
		mangedColor(az);
		mangedDamage(az);

	}
	public void sunFlowerEffect(ArrayList <Sun> sun) {
		
		if (attack == false) {
			if (compteur <200){
			sun.add(new LittleSun(new Coordinates(getCoordonnee().getI(),getCoordonnee().getJ())));
			}
			else {
				sun.add(new Sun(new Coordinates(getCoordonnee().getI(),getCoordonnee().getJ())));
			}
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
		return "SunShroom [name=" + name + ", coordonnee=" + coordonnee + "]";
	}

}
