package dut.info.projet;

import java.awt.Color;

public class LilyPad implements InterfacePlant{
	boolean onWater = true;
	private int pv;
	private Coordinates coordonnee;
	private Color color = Color.GREEN;
	private final int cout;
	private final int cd;
	private int compteur;
	private String name = "LilyPad";
	private boolean manger = false;
	private final int cooldown = 1;
	private boolean planter =false; 
	
	public LilyPad(Coordinates coordonnee) {
		pv = 30;
		color = Color.GREEN;
		this.coordonnee = coordonnee;
		cd = 5;
		cout = 25;
		
		
	}
	
	public boolean onWater() {
		return onWater;
	}

	@Override
	public int getDamage() {
		return 0;
	}

	@Override
	public Coordinates getCoordonnee() {
		return coordonnee;
	}

	@Override
	public Color getColor() {
		return color;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public boolean sameCoordonnee(InterfacePlant ap) {
		if (coordonnee.equals(ap.getCoordonnee())) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean dead() {
		if (pv <= 0) {
			return true;

		}
		return false;

	}

	@Override
	public int mangedDamage(InterfaceZombie az) {
		
		if (az.manger(this)) {
			return pv=pv-az.getDamage();
		}
		else {
			return pv  ;
		}
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
	public void ActionPlant(InterfaceZombie az,BoardZombie bz) {
		
	}

	@Override
	public int getCout() {
		return cout;
	}

	@Override
	public boolean inRange(InterfaceZombie az) {
		return false;
	}

	@Override
	public int getCooldown() {
		return cooldown;
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

	public void oneShot() {
		pv=0;
	}
	@Override
	public String toString() {
		return "LilyPad [name=" + name + ", coordonnee=" + coordonnee + "]";
	}
	
	

}
