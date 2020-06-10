package dut.info.projet;

import java.awt.Color;
import java.awt.geom.Rectangle2D;

import fr.umlv.zen5.ApplicationContext;

public class AllStarZombie extends BucketHeadZombie{
	private final String name ="AllStarZombie";
	
	private int pv;
	private  double ms;
	private Coordinates coordonnee;
	private Color color=Color.cyan ;
	private final int damage ;
	private final double slow =0.2;
	private boolean freeze = false;
	private int compteur;
	private int item =140;



		public AllStarZombie(Coordinates coordonnee) {
			super(coordonnee);
			this.coordonnee=coordonnee;
			ms=0.4;
			pv = 20;
			damage=6;
		
				this.coordonnee = new Coordinates(coordonnee.getI(),coordonnee.getJ());
			
		
		}
		
		public Coordinates getCoordonnee() {
			return coordonnee;
		}
		@Override
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
			System.out.println(coordonnee);
		}


		//Immobilise le zombie pour manger
		public boolean manger(InterfacePlant ap) {
			if (!(ap instanceof SpikeWeed)) {
				if (ap.getCoordonnee().getI()>=coordonnee.getI()) {
					return true ;
				}
				
				return false;
			}
			else {
				return false ;
			}
		}
		public void immobile(InterfacePlant ip) {
		
			if( manger(ip)==true || freeze ==true) {
				 ms =0;
			}
			else {
				ms= 0.4;
			}
		}
		@Override
		//inflige des dégâts aux zombies
		public void Damage(InterfacePlant ip) {
			if (ip.inRange(this)==true) {
				if (item>0) {
					item =item-ip.getDamage();
					}
				else{
				pv = pv - ip.getDamage();
				}
			}
		}
		//change la couleur si le zombie recoit des dégats
		public Color Color(InterfacePlant ip) {
			if (ip.inRange(this)==true) {
			
				return color = Color.red;
			}
			else {
				return color=Color.cyan;
			}
			
		}
		//ralentit le zombie si il recoit des pois
		public double Ms(InterfacePlant ip) {
			if (ip.inRange(this)==true) {
					return ms = slow;
			}
			else {
				return ms=0.4;
			}
		}
		//toutes les actions du peashooter
		public void Bobo(InterfacePlant ip) {
				Damage(ip);
				Color(ip);
				Ms(ip);
		}
		public void protectless() {
			super.protectless();
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
			return "AllStarZombie [name=" + name + ", coordonnee=" + coordonnee + "]";
		}
		

}
		
		
	