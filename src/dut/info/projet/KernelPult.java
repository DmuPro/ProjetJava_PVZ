
package dut.info.projet;

import java.awt.Color;

public class KernelPult extends PeaShooter{
	private String name="KernelPult";
	private double slow= 0.1 ;
	private int cout= 150 ;
	private final int cooldown = 7;
	private Color color= Color.YELLOW;
	private Coordinates coordonnee;
	private int compteur = 0;
	private boolean planter= false;
	private boolean attack = false;

	public KernelPult(Coordinates coordonnee) {
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
		 color= Color.YELLOW;
		}
		
	}
	@Override
	public void attack(InterfaceZombie az) {
		if (attack == false) {
			if (inRange(az)==true) {
				az.Bobo(this);
				if (Graphique.nombreAlea(5, 0)== 5) {
					az.freeze();
				}
				
				attack = true;
			}
		}
			else if (attack == true){
				compteur += 1;
				if (compteur%cooldown == 0) {
					attack = false;
				}
			}
		}
	@Override
	public String toString() {
		return "KernelPult [name=" + name + ", coordonnee=" + coordonnee + "]";
	}

}
