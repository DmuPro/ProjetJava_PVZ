package dut.info.projet;

import java.awt.Color;

public class Sun {
	
	private Coordinates coordonnee;
	private  Color color=Color.YELLOW ;
	public Sun(Coordinates coordonnee) {
		this.coordonnee=coordonnee;
	}
	public Coordinates getCoordonnee() {
		return coordonnee;
	}
	public Color getColor() {
		return color;
	}
}
