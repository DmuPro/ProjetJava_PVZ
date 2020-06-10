package dut.info.projet;



import java.awt.Color;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

import fr.umlv.zen5.Application;
import fr.umlv.zen5.ApplicationContext;
import fr.umlv.zen5.Event;
import fr.umlv.zen5.ScreenInfo;
import fr.umlv.zen5.Event.Action;


public class BungeeZombie implements InterfaceZombie{
	private final String name ="BungeeZombie";
	private final int damage ;
	private int pv;
	private Coordinates coordonnee;
	private  double ms;
	private Color color=Color.MAGENTA ;
	private final double slow =0.25 ;
	private boolean freeze = false;
	private int compteur;
	public BungeeZombie(Coordinates coordonnee) {
		this.coordonnee=coordonnee;

		ms=0.5;
		pv = 20;
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
		
	}


	//Immobilise le zombie pour manger
	public boolean manger(InterfacePlant ip) {
		if ((ip.getCoordonnee().getI()>=coordonnee.getI()-1)&&(ip.getCoordonnee().getI()<=coordonnee.getI()+1)) {
			ip.oneShot();
			oneShot();
			return true ;
		}
		else {
			return false ;
		}
	}
	public void immobile(InterfacePlant ip) {
		if( manger(ip)==true) {
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
			return color=Color.magenta;
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
		return "BungeeZombie [name=" + name + ", coordonnee=" + coordonnee + "]";
	}


	
	
}