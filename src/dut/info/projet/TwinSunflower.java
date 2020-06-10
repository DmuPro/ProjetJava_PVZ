package dut.info.projet;

import java.awt.Color;
import java.util.ArrayList;

public class TwinSunflower extends SunFlower {
	private final String name = "TwinSunflower";
	private int pv=20;
	private Coordinates coordonnee;
	private Color color = Color.pink;
	private final int damage=0;
	private final int cout =125 ;
	private final int cooldown = 1;
	private int compteur = 0;
	private boolean inCharge= false;
	private boolean attack = false;
	
	public TwinSunflower(Coordinates coordonnee) {
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
	@Override
	public boolean sameCoordonnee(InterfacePlant ap) {
		return super.sameCoordonnee(ap);
	}
	// recevoir les dégats du zombie
	public int mangedDamage(InterfaceZombie az) {
		return super.mangedDamage(az);
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
			sun.add(new Sun(new Coordinates(getCoordonnee().getI(),getCoordonnee().getJ())));
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
		return "TwinSunflower [name=" + name + ", coordonnee=" + coordonnee + "]";
	}

}
