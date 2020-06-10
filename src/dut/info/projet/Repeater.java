package dut.info.projet;

import java.awt.Color;

public class Repeater extends PeaShooter{
	private String name="Repeater";
	private int damage= 12 ;
	private int cout= 200 ;
	private Color color= Color.YELLOW;
	private Coordinates coordonnee;
	private final int cooldown = 5;
	private boolean planter= false; 
	private int compteur=0;
	private boolean attack = false;
	private final double as=5;
	public Repeater(Coordinates coordonnee) {
		super(coordonnee);
		this.coordonnee=coordonnee;
		
		
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
	@Override
	public Color getColor() {

		return color;
	}
	@Override
	public int getDamage() {
		return damage;
	}
	@Override 
	public String getName() {
		return name;
	}
	@Override 
	public Coordinates getCoordonnee() {
		return coordonnee;
	}
	@Override
	public void mangedColor(InterfaceZombie az) {
		if (az.manger(this)) {
			 color=Color.red;
		}
		else {
		 color= Color.YELLOW;
		}
		
	}
	public int getCout() {
		return cout;
	}
	@Override
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
	
	@Override
	public String toString() {
		return "Repeater [name=" + name + ", coordonnee=" + coordonnee + "]";
	}

}
