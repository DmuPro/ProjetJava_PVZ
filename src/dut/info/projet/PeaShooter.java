package dut.info.projet;

import java.awt.Color;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

import fr.umlv.zen5.Application;
import fr.umlv.zen5.ApplicationContext;
import fr.umlv.zen5.Event;
import fr.umlv.zen5.ScreenInfo;
import fr.umlv.zen5.Event.Action;

public class PeaShooter implements InterfacePlant{
	private final String name ="PeaShooter";
	private int pv;

	private Coordinates coordonnee;
	private  Color color=Color.white ;
	private final int damage ;
	private final int cout =100 ;
	private final int cooldown = 1;
	private int compteur = 0;
	private boolean inCharge= false;
	private boolean attack = false;
	private final double as=5;
	
		public PeaShooter(Coordinates coordonnee) {
			this.coordonnee=coordonnee;
			pv = 20;
			damage=4;
			this.coordonnee = new Coordinates(coordonnee.getI(),coordonnee.getJ());
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
		//Pour les afficher sur le terrain
		@Override
		public Color getColor() {
			return color;
		}
		// Pour infliger des dégats
		public int getDamage() {
			return damage;
		}
		public boolean inRange(InterfaceZombie az ) {
			if ((10>az.getCoordonnee().getI())&&(az.getCoordonnee().getI()>=coordonnee.getI())) {
				return true ;
			}
			else {
				return false;
			}
			
		}
		//Eviter qu'il y'ait 2 plantes au même endroits
		public boolean sameCoordonnee(InterfacePlant ap ) {
			if (coordonnee.equals(ap.getCoordonnee())) {
				return true;
			}
			else {
				return false;
			}
		}
		//recevoir les dégats du zombie
		public int mangedDamage(InterfaceZombie az) {
		
				if (az.manger(this)) {
					return pv=pv-az.getDamage();
				}
				else {
					return pv  ;
				}
			}
		//Change de couleur  (Remplacer par l'affichage textuelle si possible
		public void mangedColor(InterfaceZombie az) {
			if (az.manger(this)) {
				 color=Color.red;
			}
		
			else {
				 color=Color.white;
			}
		}
		//pour les inCharge
		public String getName() {
			return name;
		}
		
		//Mort
		public boolean dead() {
			if (pv <= 0) {
				return true ; 
				
			}
				return false ;
			
		}
		//TOUTES LES ACTIONS DE LA PLANTES !!
		public void ActionPlant(InterfaceZombie az,BoardZombie bz) {
			mangedColor(az);
			mangedDamage(az);
		
	}
		@Override
		public String toString() {
			return "PeaShooter [name=" + name + ", coordonnee=" + coordonnee + "]";
		}
		public double getSlow() {
			// TODO Auto-generated method stub
			return 1;
		}
		public void attack(InterfaceZombie az) {
			if (attack == false) {
				if (inRange(az)==true) {
					az.Bobo(this);
					attack = true;

				}
			}
				else if (attack == true){
					compteur += 1;
					if (compteur%as == 0) {
						attack = false;
					}
				}
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