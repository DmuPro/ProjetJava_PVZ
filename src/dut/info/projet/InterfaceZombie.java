package dut.info.projet;

import java.awt.Color;

import fr.umlv.zen5.ApplicationContext;

public interface InterfaceZombie {
	public int getDamage();//getter
	public Coordinates getCoordonnee();//getter
	public Color getColor();//getter
	public String getName();//getter
	public boolean manger(InterfacePlant ap);//Manger
	public void immobile(InterfacePlant ap);//S'immobile
	public void move(ApplicationContext context);//déplacement
	void Damage(InterfacePlant ip);//dégats
	Color Color(InterfacePlant ip);//change de couleur 
	double Ms(InterfacePlant ip);//ralentit
	void Bobo(InterfacePlant ip);//Toutes les actions du peashooter
	public boolean dead();//verifie si le zombie est mort
	public double getCherryBombed(int damage);//action du cherrybomb
	public void oneShot();// pour se faire tuer instant
	public void freeze();// gèle les zombies
}
