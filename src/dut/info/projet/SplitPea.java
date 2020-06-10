package dut.info.projet;

import java.awt.Color;

public class SplitPea extends PeaShooter{
	private String name="SplitPea";
	private int damage= 8 ;
	private int cout= 200 ;
	private Color color= Color.BLACK;
	private Coordinates coordonnee;
	private final int cooldown = 7;
	private boolean attack = false;

	private boolean inCharge= false; 
	public SplitPea(Coordinates coordonnee) {
		super(coordonnee);
		this.coordonnee=coordonnee;
		
		
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
		if ((10>az.getCoordonnee().getI())) {
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
		 color= Color.black;
		}
		
	}
	@Override
	public String toString() {
		return "SplitPea [name=" + name + ", coordonnee=" + coordonnee + "]";
	}
	@Override
	public void attack(InterfaceZombie az) {
		super.attack(az);
	}
}
