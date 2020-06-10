package dut.info.projet;

import java.awt.Color;

public class LittleSun extends Sun {
	
	private Coordinates coordonnee;
	private  Color color=Color.yellow ;
	public LittleSun(Coordinates coordonnee) {
		super(coordonnee);
		this.coordonnee=coordonnee;
	}
	public Coordinates getCoordonnee() {
		return coordonnee;
	}
	public Color getColor() {
		return color;
	}
}
