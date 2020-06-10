package dut.info.projet;

import java.awt.Color;

public class WallNut extends TallNut {
	private final String name = "WallNut";
	private int pv;
	private Coordinates coordonnee;
	private Color color = Color.CYAN;
	private final int damage;
	private final int cout =50 ;
	private final int cooldown = 1;
	private int compteur = 0;
	private boolean inCharge= false;
	public WallNut(Coordinates coordonnee) {
		super(coordonnee);
		this.coordonnee=coordonnee;
		pv = 50;
		damage = 0;
		this.coordonnee = new Coordinates(coordonnee.getI(), coordonnee.getJ());

	}
	public int getCout() {
		return cout;
	}
	public int getCooldown() {
		return cooldown;
	}
	public Coordinates getCoordonnee() {
		return coordonnee;
	}

	// Pour les afficher sur le terrain
	@Override
	public Color getColor() {
		return color;
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

	// Pour infliger des dégats
	@Override
	public int getDamage() {
		return damage;
	}

	// Eviter qu'il y'ait 2 plantes au même endroits
	@Override
	public boolean sameCoordonnee(InterfacePlant ap) {
		return super.sameCoordonnee(ap);
	}

	// recevoir les dégats du zombie
	@Override
	public int mangedDamage(InterfaceZombie az) {

		return super.mangedDamage(az);
	}

	// Change de couleur (Remplacer par l'affichage textuelle si possible
	@Override
	public void mangedColor(InterfaceZombie az) {
		if (az.manger(this)) {
			 color = Color.red;
		}
		else {
			color = Color.CYAN;
		}
	}
	// pour les inCharge
	@Override
	public String getName() {
		return name;
	}
	// Mort
	@Override
	public boolean dead() {
	return super.dead();

	}
	// TOUTES LES ACTIONS DE LA PLANTES !!
	public void ActionPlant(InterfaceZombie az) {
		mangedColor(az);
		mangedDamage(az);

	}
	public boolean inRange(InterfaceZombie az ) {
		return false;
	}
	@Override
	public String toString() {
		return "WallNut [name=" + name + ", coordonnee=" + coordonnee + "]";
	}
	@Override
	public boolean onWater() {
		return super.onWater();
	}
	@Override
	public void oneShot() {
		super.oneShot();
	}


}
