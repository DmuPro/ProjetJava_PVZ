
package dut.info.projet;

import java.awt.Color;

public class SnowPea extends PeaShooter{
	private String name="SnowPea";
	private double slow= 0.1 ;
	private int cout= 150 ;
	private final int cooldown = 7;
	private Color color= Color.DARK_GRAY;
	private Coordinates coordonnee;
	private int compteur = 0;
	private boolean inCharge= false;
	private boolean attack = false;
	private final double as=5;
	public SnowPea(Coordinates coordonnee) {
		super(coordonnee);
		this.coordonnee=coordonnee;
	}
	@Override
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
	public int getCout() {
		return cout;
	}
	@Override
	public Color getColor() {
		return color;
	}
	@Override
	public double getSlow() {
		return slow;
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
		 color= Color.DARK_GRAY;
		}
		
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
		return "SnowPea [name=" + name + ", coordonnee=" + coordonnee + "]";
	}

}
