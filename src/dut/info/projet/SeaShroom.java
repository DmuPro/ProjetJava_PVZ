package dut.info.projet;

import java.awt.Color;

public class SeaShroom extends PeaShooter {
	boolean onWater = true;
	private String name="SeaShroom";
	private int damage= 2 ;
	private int cout= 0 ;
	private Color color= Color.getHSBColor(300, 100, 50);
	private Coordinates coordonnee;
	private final int cooldown = 7;
	private int compteur = 0;
	private boolean planter= false;
	private boolean attack = false;
	public SeaShroom(Coordinates coordonnee) {
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
	public boolean onWater() {
		return onWater;
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
	public boolean inRange(InterfaceZombie az ) {
		if ((4>az.getCoordonnee().getI())&&(az.getCoordonnee().getI()>=coordonnee.getI())) {
			return true ;
		}
		else {
			return false;
		}
		
	
	}
	@Override
	public void mangedColor(InterfaceZombie az) {
		if (az.manger(this)) {
			 color=Color.red;
		}
		else {
		 color= Color.getHSBColor(300, 100, 50);
		}
		
	}
	
	@Override
	public String toString() {
		return "SeaShroom [name=" + name + ", coordonnee=" + coordonnee + "]";
	}
	@Override
	public void attack(InterfaceZombie az) {
		super.attack(az);
	}

}
