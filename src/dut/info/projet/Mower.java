package dut.info.projet;

import java.awt.Color;

public class Mower {
	
	private Coordinates coordonnee;
	private  Color color=Color.WHITE ;
	public Mower(Coordinates coordonnee) {
		this.coordonnee=coordonnee;
	}
	public Coordinates getCoordonnee() {
		return coordonnee;
	}


	public Color getColor() {
		return color;
	}
	public String toString() {
		return "tondeuse"+ coordonnee;
	}
}