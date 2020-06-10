package dut.info.projet;

import java.awt.Color;
import java.awt.geom.Rectangle2D;

import fr.umlv.zen5.ApplicationContext;

public class FlagZombie extends BasicZombie {
	private final String name ="FlagZombie";
	private int pv;
	private double ms;
	private Coordinates coordonnee;
	private Color color = Color.YELLOW;
	private final int damage;
	private final double slow = 0.5;
	private boolean freeze = false;
	private int compteur;
	public FlagZombie(Coordinates coordonnee) {
		super(coordonnee);
		this.coordonnee=coordonnee;
		ms = 1;
		pv = 20;
		damage = 4;
	
			this.coordonnee = new Coordinates(coordonnee.getI(), coordonnee.getJ());
		

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
	@Override
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
		if (pv <= 0) {
			return true ; 
			
		}
			return false ;
	}
	//CherryBomb
	@Override
	public double getCherryBombed(int damage) {
		return pv = pv-damage;
	}
	@Override
	public void oneShot() {
		pv=0;
	}
	@Override
	public void freeze() {
		if (freeze == false) {
				freeze = true;
				compteur += 1;
				if (compteur%20 == 0) {
					freeze = false;

			}
		}
	}	@Override
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
			return color=Color.BLACK;
		}
		
	}
	//ralentit le zombie si il recoit des pois
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
	
	
	@Override
	public String toString() {
		return "FlagZombie [coordonnee=" + coordonnee + ", name=" + name + "]";
	}

	
	
	
}
