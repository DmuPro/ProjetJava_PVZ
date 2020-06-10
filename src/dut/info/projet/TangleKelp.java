package dut.info.projet;

import java.awt.Color;

public class TangleKelp implements InterfacePlant{
	private final String name = "TangleKelp";
	boolean onWater = true;
	private int pv;
	private Coordinates coordonnee;
	private Color color = Color.GREEN;
	private final int cout;
	private final int cd;
	private int compteur;
	private boolean manger = false;
	private final int cooldown = 10;
	private boolean planter =false; 
	private boolean attack = false;
	public TangleKelp(Coordinates coordonnee) {
		pv = 30;
		color = Color.GREEN;
		this.coordonnee = coordonnee;
		cd = 5;
		cout = 25;
		
		
	}
	
	public boolean onWater() {
		return onWater;
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

		// Pour infliger des dégats
		public int getDamage() {
			return 0;
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

			color = Color.black;

		}

		// pour les planter
		public String getName() {
			return name;
		}

		// Mort
		public boolean dead() {
			if (pv <= 0 ||attack ==true) {
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
			if (attack == false) {
				if (inRange(az)==true) {
					az.oneShot();
					attack = true;

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
			return "TangleKelp [name=" + name + ", coordonnee=" + coordonnee + "]";
		}
		public void oneShot() {
			pv=0;
		}

	
	

}
