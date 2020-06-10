package dut.info.projet;

import java.awt.Color;

public class Grave {
	private final Coordinates coordinates;
	private final Color color;
	
	private Grave(Coordinates coordinates) {
		this.coordinates = coordinates;
		color = Color.black;
	}
	
	public static Grave CreateGrave(Coordinates coordinates) {
		return new Grave(coordinates);
	}
	
	public boolean blockPlants(Coordinates c) {
		if (coordinates.equals(c)) {
			return true;
		} else {
			return false;
		}
	}

	public Coordinates getCoordonnee() {
		return coordinates;
	}
	public Color getColor() {
		return color;
	}

}
