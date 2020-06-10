package dut.info.projet;

import java.awt.Color;
import java.awt.geom.Rectangle2D;

import fr.umlv.zen5.ApplicationContext;

public class VaultingZombie extends BasicZombie{
	private final String name ="VaultingZombie";
	
	private int pv;
	private  double ms;
	private Coordinates coordonnee;
	private Color color=Color.orange ;
	private final int damage ;
	private final double slow =0.2;
	private boolean jump = true;
	private boolean freeze = false;
	private int compteur;

		public VaultingZombie(Coordinates coordonnee) {
			super(coordonnee);
			this.coordonnee=coordonnee;
			ms=0.4;
			pv = 20;
			damage=4;
		
				this.coordonnee = new Coordinates(coordonnee.getI(),coordonnee.getJ());
			
		
		}
		
		public Coordinates getCoordonnee() {
			return coordonnee;
		}
		public Color getColor() {
			return color;
		}
		public int getDamage() {
			return damage;
		}
		public String getName() {
			return name;
		}

		

		// Le zombie bouge selon sa speed
		public void move(ApplicationContext context) {
			coordonnee = new Coordinates(coordonnee.getI() - ms, coordonnee.getJ());
		}


		//Immobilise le zombie pour manger
		public boolean manger(InterfacePlant ap) {
			if (!(ap instanceof SpikeWeed)) {
				if (ap.getCoordonnee().getI()>=coordonnee.getI()) {
					return true ;
				}
				else {
				return false;
				}
			}
			else {
				return false ;
			}
		}
		public void immobile(InterfacePlant ip) {
			if( manger(ip)==true|| freeze ==true) {
				 ms =0;
			}
			else {
				ms= 0.5;
			}
		}

		
		//inflige des dégâts aux zombies
		public void Damage(InterfacePlant ip) {
			if (ip.inRange(this)==true) {
				pv = pv - ip.getDamage();
			}

		}
		//change la couleur si le zombie recoit des dégats
		public Color Color(InterfacePlant ip) {
			if (ip.inRange(this)==true) {
				return color = Color.red;
			}
			else {
				return color=Color.BLACK;
			}
		}
		//ralentit le zombie si il recoit des dégâts
		public double Ms(InterfacePlant ip) {
			if (ip.inRange(this)==true) {	
					return ms = slow;
			}
			else {
				return ms=1;
			}
		}
		//toutes les actions du peashooter
		public void Bobo(InterfacePlant ip) {
		
				Damage(ip);
				Color(ip);
				Ms(ip);
		}
		//mort 
		public boolean dead() {
			if (pv <= 0) {
				return true ; 
				
			}
				return false ;
			
		}

		// se fait exploser par la cherryBomb

		@Override
		public double getCherryBombed(int damage) {
			return pv = pv-damage;
		}
		public void oneShot() {
			pv=0;
		}
		public void freeze() {
			if (freeze == false) {
					freeze = true;
					compteur += 1;
					if (compteur%20 == 0) {
						freeze = false;

				}
			}
		}
	
		@Override
		public String toString() {
			return "VaultingZombie [name=" + name + ", coordonnee=" + coordonnee + "]";
		}
		//saute au dessus des wallNuts 
				public void specialAction(InterfacePlant ap) {
					if (ap instanceof WallNut) {
						if (jump == true) {
							if (ap.getCoordonnee().getI()==coordonnee.getI()) {
								coordonnee = new Coordinates(coordonnee.getI() - ms, coordonnee.getJ());
								jump = false ;
							}	
						}
					}		
				}

}
		
		
	