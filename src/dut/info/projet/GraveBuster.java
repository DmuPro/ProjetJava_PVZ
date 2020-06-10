package dut.info.projet;

import java.awt.Color;

public class GraveBuster implements InterfacePlant {
	private final String name = "GraveBuster";
	private int pv;
	private Coordinates coordonnee;
	private Color color = Color.getHSBColor(10, 10, 10);
	private final int damage;
	private final int cout =75 ;
	private final int cooldown = 4;
	private int compteur = 0;
	private boolean inCharge= false;
	public GraveBuster(Coordinates coordonnee) {
		this.coordonnee=coordonnee;
		pv = 80;
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

	// Pour les afficher sur le terrain
	@Override
	public Color getColor() {
		return color;
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
			color = Color.getHSBColor(10, 10, 10);
		}
	}
	// pour les inCharge
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
	public void ActionPlant(InterfaceZombie az,BoardZombie bz) {
		mangedColor(az);
		mangedDamage(az);

	}
	
		
	public boolean inRange(InterfaceZombie az ) {
		return false;
	}
	@Override
	public String toString() {
		return "GraveBuster [name=" + name + ", coordonnee=" + coordonnee + "]";
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
