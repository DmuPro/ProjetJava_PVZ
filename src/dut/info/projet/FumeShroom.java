package dut.info.projet;

import java.awt.Color;

public class FumeShroom extends PeaShooter {
	private String name="FumeShroom";
	private int damage= 2 ;
	private int cout= 100 ;
	private Color color= Color.MAGENTA;
	private Coordinates coordonnee;
	private final int cooldown = 2;
	private boolean attack = false;
	private int compteur = 0;
	private boolean planter= false; 
	private final double as=15;
	public FumeShroom(Coordinates coordonnee) {
		super(coordonnee);
		this.coordonnee=coordonnee;
		
		
	}
	@Override
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
	public boolean inRange(InterfaceZombie az ) {
		if ((10>az.getCoordonnee().getI())&&(az.getCoordonnee().getI()>=coordonnee.getI())&&(az.getCoordonnee().getI()<=4+coordonnee.getI())) {
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
		 color= Color.MAGENTA;
		}
		
	}
	@Override
	public String toString() {
		return "FumeShroom [name=" + name + ", coordonnee=" + coordonnee + "]";
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
	}



