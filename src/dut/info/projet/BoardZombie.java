package dut.info.projet;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import fr.umlv.zen5.ApplicationContext;
import fr.umlv.zen5.ScreenInfo;

public class BoardZombie {
	private final ArrayList<InterfaceZombie> z;
	private final int longueurPlateau;
	private final int largeurPlateau;
	private final int tailleCaseL;
	private final int largeurCaseL;
	private int plante = 0;
	private Coordinates coordonne;
	private final int ligne;

	public BoardZombie(ApplicationContext context, int ligne) {
		z = new ArrayList<InterfaceZombie>();
		this.ligne = ligne;
		ScreenInfo screenInfo = context.getScreenInfo();
		longueurPlateau = (int) (screenInfo.getWidth() * 70 / 100);
		largeurPlateau = (int) (screenInfo.getHeight() * 70 / 100);
		tailleCaseL = longueurPlateau / 10;
		largeurCaseL = largeurPlateau / 5;
	}
	public int getLine() {
		return ligne;
	}
	public InterfaceZombie get(int i) {
		return z.get(i);
	}

	public Coordinates getCoordinates() {
		return coordonne;
	}

	public ArrayList<InterfaceZombie> getBoard() {
		return z;
	}
	public boolean isEmpty() {
		return z.isEmpty();
	}
	public void add(InterfaceZombie zombie) {
		z.add(zombie);
		System.out.println("Le zombie"+zombie+"a été ajouté");

	}

	public void dead() {
		for (int i = 0; i < size(); i++) {
			if ((z.get(i).dead() == true)) {
				System.out.println("dead");
				z.remove(i);
				System.out.println("Le zombie"+z+"a été enlever");
			}
		}
	}
	// pour se faire peashooted

	public void getPeashooted(BoardPlant pPlant1) {
		

		for (InterfacePlant plant : pPlant1.getBoard()) {
			if (plant instanceof PeaShooter) {
					for(double i =plant.getCoordonnee().getI();i<=10;i+=0.5) {
						for (InterfaceZombie zombie :z) {
							if (zombie.getCoordonnee().getI()<=i) {
								((PeaShooter) plant).attack(zombie);
								System.out.println(zombie.getName() +plant.getDamage() +zombie.getCoordonnee());
								if (!(plant instanceof FumeShroom)) {
									break ;
								}
								
							}
							if (plant instanceof SplitPea) {
								for(double j =plant.getCoordonnee().getI();j<=10-plant.getCoordonnee().getI();j-=0.1) {
									if (zombie.getCoordonnee().getI()<=i) {
										((SplitPea) plant).attack(zombie);
										System.out.println(zombie.getName() +plant.getDamage() +zombie.getCoordonnee());
									break ;
									}
								}
					}
						
				}
						
							}
						}
					
			}
		}

		

							


	public int size() {
		return z.size();
	}

	public void deplacement(ApplicationContext context) {

		for (InterfaceZombie zombie : z) {
			zombie.move(context);

		}
	}
	
	public void immobile(BoardPlant pPlant1) {
		for (InterfaceZombie zombie : z) {
			for (InterfacePlant plant : pPlant1.getBoard()) {
					zombie.immobile(plant);	
			}
		}

	}
	//condition de défaites 
	public boolean lose() {
		for (InterfaceZombie zombie : z) {
			if (zombie.getCoordonnee().getI() <= -5) {
				return true;
			}
		}
		return false;
	}

	//Active l'effet des tondeuses
	public void lineDead() {
		for (InterfaceZombie zombie : z) {
			if (zombie.getCoordonnee().getI()<=10) {
				zombie.oneShot();
			}
		}
	}

	/*public void trieZombie(){
		Collections.sort(z,coordonnees);
		for (InterfaceZombie zombie : z) {
			System.out.println(zombie.getCoordonnes().getY() +zombie.getName());
		}
	}*/



	// toutes les actions des zombies
	public void actionZombie(BoardPlant p, ApplicationContext context) {
		if (!(isEmpty())) {
			
			getPeashooted(p);
			immobile(p);
			deplacement(context);
			dead();
		
			//trieZombie()
		}

	}

}
