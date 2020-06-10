package dut.info.projet;

import java.awt.Color;

public interface InterfacePlant {
	public int getDamage(); //getter d�gats
	public Coordinates getCoordonnee();//getter coordonne
	public Color getColor();//getter couleur
	public String getName() ;//getter Nom
	public boolean sameCoordonnee(InterfacePlant ap );//verifie si 2 plantes ont les m�mes coordonn�es
	public String toString();
	public boolean dead();//v�rfie si la plante est morte
	public int mangedDamage(InterfaceZombie az);//Re�oit des d�gats
	public void mangedColor(InterfaceZombie az);//Change la couleur
	public void ActionPlant(InterfaceZombie az,BoardZombie bz);//effectues toutes les actions des zombies
	public int getCout();//avoir le co�t
	public boolean inRange(InterfaceZombie az);//Pour savoir si le zombie est dans la port�e du zombie
	public int getCooldown();//avoir le cout
	public boolean inCharge() ;//Le temps entre chaque plantage
	public boolean onWater();
	public void oneShot();
	
}
