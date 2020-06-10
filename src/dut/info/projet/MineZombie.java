package dut.info.projet;

import java.awt.Color;
import java.awt.geom.Rectangle2D;

import fr.umlv.zen5.ApplicationContext;

public class MineZombie extends BucketHeadZombie{
	private final String name ="MineZombie";
	
	private int pv;
	private  double ms;
	private Coordinates coordonnee;
	private Color color=Color.DARK_GRAY ;
	private final int damage ;
	private final double slow =0.2;
	private boolean dig = true;
	private boolean freeze = false;
	private int compteur;

		public MineZombie(Coordinates coordonnee) {
			super(coordonnee);
			this.coordonnee=coordonnee;
			ms=0.4;
			pv = 15;
			damage=4;
		
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
			digging();
		if (dig == true) {
				
				coordonnee = new Coordinates(coordonnee.getI() - ms, coordonnee.getJ());
				System.out.println(coordonnee);
		}
		else {
			coordonnee = new Coordinates(coordonnee.getI() + ms, coordonnee.getJ());
		}
		
			
		}
		public void digging() {
			if (coordonnee.getI()<1) {
				dig=false;
			}
		}

		//Immobilise le zombie pour manger
		
		@Override
		public boolean manger(InterfacePlant ap) {
			if (dig ==false) {
				if (!(ap instanceof SpikeWeed)) {
					if (ap.getCoordonnee().getI()>=coordonnee.getI()) {
						return true ;
					}

					else {
					return false;
					}
				}
			}
				return false ;
				
			
		}
		
		@Override
		public void immobile(InterfacePlant ip) {
			
				if( manger(ip)==true|| freeze ==true) {
					 ms =0;
				}
				else {
					ms= 0.4;
				}
		}
		//mort 
		@Override
		public boolean dead() {
		return super.dead();
		}
		//CherryBomb
		@Override
		public double getCherryBombed(int damage) {
			return super.getCherryBombed(damage);
		}
		
		@Override
		public void oneShot() {
			super.oneShot();
		}
		//Gèle
		@Override
		public void freeze() {
			super.freeze();
		}
		@Override
		//inflige des dégâts aux zombies
		public void Damage(InterfacePlant ip) {
		super.Damage(ip);
		}
		//change la couleur si le zombie recoit des dégats
		public Color Color(InterfacePlant ip) {
			if (ip.inRange(this)==true) {
			
				return color = Color.red;
			}
			else {
				return color=Color.DARK_GRAY;
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
			if (dig ==false) {
				Damage(ip);
				Color(ip);
				Ms(ip);
			}
		}
		public void protectless() {
			dig=false;
		}
		@Override
		public String toString() {
			return "MagnetShroom [name=" + name + ", coordonnee=" + coordonnee + "]";
		}
		

}
		
		
	