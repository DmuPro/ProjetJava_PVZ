package dut.info.projet;

import java.awt.Color;

public class PotatoMine implements InterfacePlant {
	private final String name = "PotatoMine";
	private int pv;
	private Coordinates coordonnee;
	private Color color = Color.ORANGE;
	private final int damage;
	private final int cout =25 ;
	private boolean ready =true;
	private int compteur = 0 ;
	private final int cooldown = 1;
	private boolean inCharge= false;
	public PotatoMine(Coordinates coordonnee) {
		this.coordonnee=coordonnee;
		pv = 50;
		damage = 100;
		this.coordonnee = new Coordinates(coordonnee.getI(), coordonnee.getJ());

	}
	public int getCout() {
		return cout;
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
			color = Color.ORANGE;
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
	public boolean inRange(InterfaceZombie az ) {
		if ((az.getCoordonnee().getI() <= getCoordonnee().getI() )
			&& (az.getCoordonnee().getJ() == getCoordonnee().getJ())) {
			return true ;
		}
		else {
			return false;
		}
		
	}
	//Prépare la mine
	public void attack(InterfaceZombie az) {
		if (ready == false) {
			if (inRange(az)==true) {
				az.Damage(this);
				pv=0;
			}
		}
			else if (ready == true){
				compteur += 1;
				if (compteur%3 == 0) {
					ready = false;
				}
			}
		}

	// TOUTES LES ACTIONS DE LA PLANTES !!
	public void ActionPlant(InterfaceZombie az,BoardZombie bz) {
		mangedColor(az);
		mangedDamage(az);
		attack(az);

	}
	public void oneShot() {
		pv=0;
	}
	@Override
	public String toString() {
		return "PotatoMine [name=" + name + ", coordonnee=" + coordonnee + "]";
	}
	@Override
	public boolean onWater() {
		// TODO Auto-generated method stub
		return false;
	}
	
	

}