package dut.info.projet;

import java.util.ArrayList;

import fr.umlv.zen5.ApplicationContext;

public class PvZData {
	private ArrayList<BoardPlant> pboard;
	private ArrayList<BoardZombie> zboard;
	private PlantSelect menu;
	private final ArrayList<Sun> sun = new ArrayList<>();
	private int energy = 5000;
	private final ArrayList<Mower> mower = new ArrayList<>();
	private final ArrayList<Grave> gravelist = new ArrayList<>();
	private final ArrayList<InterfaceZombie> zombie= new ArrayList<>();

	public PvZData() {
		pboard = new ArrayList<BoardPlant>();
		zboard = new ArrayList<BoardZombie>();
	}

	public PlantSelect getMenu() {
		return menu;
	}

	public ArrayList<BoardZombie> getZboard() {
		return zboard;
	}

	public ArrayList<BoardPlant> getPboard() {
		return pboard;
	}

	public ArrayList<Sun> getSun() {
		return sun;
	}

	public int getEnergy() {
		return energy;
	}

	public ArrayList<Mower> getMower() {
		return mower;
	}
	
	public ArrayList<Grave> getGraveList(){
		return gravelist;
	}

	public void generationBoard(ApplicationContext context) {
		for (int i = 1; i <= 5; i++) {
			pboard.add(new BoardPlant(context, i));
			zboard.add(new BoardZombie(context, i));
		}
	}
	public void generationNightBoard(ApplicationContext context) {
		for (int i = 1; i <= 5; i++) {
			pboard.add(new BoardNight(context, i));
			zboard.add(new BoardZombie(context, i));
		}
		for (int i = 0;i<=2;i++) {
			createGraves();
		}
	}

	public void generationWaterBoard(ApplicationContext context) {
		for (int i = 1; i <= 5; i++) {
			if (i == 3) {
				pboard.add(new BoardWater(context, i));
				zboard.add(new BoardZombie(context, i));
			}
			else {
			pboard.add(new BoardPlant(context, i));
			zboard.add(new BoardZombie(context, i));
			}
		}

	}
	
	public void Zombiepartype(int choix) {
		if (choix == 1) {
		zombie.add(new BasicZombie(new Coordinates(-1,-1)));
		zombie.add(new ConeZombie(new Coordinates(-1,-1)));
		zombie.add(new AllStarZombie(new Coordinates(-1,-1)));
		zombie.add(new BucketHeadZombie(new Coordinates(-1,-1)));
		zombie.add(new FlagZombie(new Coordinates(-1,-1)));
		zombie.add(new VaultingZombie(new Coordinates(-1,-1)));
		}
		else if(choix == 2) {
			zombie.add(new BasicZombie(new Coordinates(-1,-1)));
			zombie.add(new ConeZombie(new Coordinates(-1,-1)));
			zombie.add(new AllStarZombie(new Coordinates(-1,-1)));
			zombie.add(new BucketHeadZombie(new Coordinates(-1,-1)));
			zombie.add(new DolphinRiderZombie(new Coordinates(-1,-1)));
		}
		else if(choix == 3) {
			zombie.add(new BasicZombie(new Coordinates(-1,-1)));
			zombie.add(new ConeZombie(new Coordinates(-1,-1)));
			zombie.add(new AllStarZombie(new Coordinates(-1,-1)));
			zombie.add(new BucketHeadZombie(new Coordinates(-1,-1)));
			zombie.add(new NewsPaperZombie(new Coordinates(-1,-1)));
			
		}
	}

	public boolean loseCondition(ApplicationContext context, ArrayList<BoardZombie> bz) {
		for (BoardZombie z : bz) {
			if (z.lose() == true) {
				return true;
			}
		}
		return false;
	}

	public void generationMenu(ApplicationContext context) {
		menu = new PlantSelect(context);
		menu.menuCreation();
	}

	// Génére les zombies
	public void randomZombie(ApplicationContext context, int nbZombie) {
		int ligne;
		int colonne;
		int index;
		System.out.println("Une horde de" + nbZombie + "arrive");
		for (int compteur = 0; compteur <= nbZombie; compteur++) {
			index = Graphique.nombreAlea(5, 0);
			ligne = index + 1;

			colonne = Graphique.nombreAlea(20, 10);

			if (compteur == 0) {
				zboard.get(index).add(new FlagZombie(new Coordinates((int) 10, (int) ligne)));
			}
			if (compteur % 3 == 0) {

				zboard.get(index).add(new ConeZombie(new Coordinates((int) colonne, (int) ligne)));
			} else {
				zboard.get(index).add(new BasicZombie(new Coordinates((int) colonne, (int) ligne)));
			}
		}
	}
	public void harderRandomZombie(ApplicationContext context, int nbZombie) {
		int ligne;
		int colonne;
		int index;
		System.out.println("Une horde de" + nbZombie + "arrive");
		for (int compteur = 0; compteur <= nbZombie; compteur++) {
			index = Graphique.nombreAlea(5, 0);
			ligne = index + 1;

			colonne = Graphique.nombreAlea(20, 10);

			if (compteur % 5==0) {
				zboard.get(index).add(new BucketHeadZombie(new Coordinates((int) colonne, (int) ligne)));
			}
			if (compteur % 10 == 0) {

				zboard.get(index).add(new ScreenDoorZombie(new Coordinates((int) colonne, (int) ligne)));
			} 
			if (compteur % 4 == 0) {

				zboard.get(index).add(new VaultingZombie(new Coordinates((int) colonne, (int) ligne)));
			} 
			if (compteur %20 ==0) {
				
				zboard.get(index).add(new AllStarZombie(new Coordinates((int) colonne, (int) ligne)));
			}
		}
	}
	public void randomBungee(ApplicationContext context,ArrayList <BoardPlant> bp) {
		int nbZombie = Graphique.nombreAlea(5, 0); 
		for (BoardPlant p:bp)
			if (!(p.getBoard().isEmpty())){
				if (nbZombie>0) {
					Coordinates plante =p.randomPlantes();
					System.out.println("caca"+plante);
					zboard.get((int)plante.getJ()).add(new BungeeZombie(new Coordinates( (int)  plante.getI(),(int)plante.getJ())));
					nbZombie-=1;		
					}
			}
		} 
	



	// condition de victoire
	public boolean win(ArrayList<BoardZombie> bz) {
		for (BoardZombie z : bz) {
			if (z.isEmpty()) {
			return true;
		} 
			else {
			return false;
		}
		}
		return false;

	}

	// effectuer les actions de toutes les plantes
	public void entityActions(ApplicationContext context) {
		for (int i = 0; i < pboard.size(); i++) {
			pboard.get(i).actionPlant(zboard.get(i), zboard);
		}
		for (int i = 0; i < zboard.size(); i++) {
			zboard.get(i).actionZombie(pboard.get(i), context);
		}

	}

	public void addSun(Sun s) {
		sun.add(s);
	}

	public void delSun(Sun s) {
		if( s instanceof LittleSun) {
			energy += 15;
		}
		else {
		energy += 25;
		}
		sun.remove(s);
		
	}

	public boolean recupererSoleil(Coordinates clic) {
		for (Sun s : sun) {
			if (clic.equals(s.getCoordonnee())) {
				delSun(s);
				return true;
			}
		}
		return false;
	}

	// génére les soleils
	public void randomSun(ApplicationContext context) {
		int ligne = Graphique.nombreAlea(5, 0);
		int colonne = Graphique.nombreAlea(10, 1);
		addSun(new Sun(new Coordinates((int) colonne, (int) ligne)));
	}

	// produire le soleil
	public void productSun(ApplicationContext context, BoardPlant bp) {
		for (InterfacePlant p : bp.getBoard()) {
			if (p instanceof SunFlower) {
				((SunFlower) p).sunFlowerEffect(sun);
			}
		}

	}

	public void productSunAll(ApplicationContext context, ArrayList<BoardPlant> bp) {
		for (BoardPlant p : bp)
			productSun(context, p);

	}

	public void generateMower() {
		for (int j = 0; j < 5; j++) {
			mower.add(new Mower(new Coordinates(0, j)));
		}

	}

	public void del(ArrayList<Mower> mower, double ligne) {
		for (Mower mw : mower) {
			if (mw.getCoordonnee().getJ() + 1 == ligne) {
				mower.remove(mw);
				System.out.println(mw);
				break;

			}
		}
	}

	public void delMower(BoardZombie bz) {
		for (InterfaceZombie zombie : bz.getBoard()) {
			if ((zombie.getCoordonnee().getI() <= 0)) {
				del(mower, zombie.getCoordonnee().getJ());
			}
		}
	}

	public void mowerEffect() {
		for (BoardZombie z : zboard) {
			delMower(z);
		}
	}

	public void rajoutePlante(Coordinates c, /* String name */InterfacePlant plant,int choix) {
		
		if (choix == 3) {
			BoardNight n = (BoardNight)pboard.get((int) c.getJ() - 1);
			if (n.planter(c, plant, energy, gravelist) == true) {
				pboard.get((int) c.getJ() - 1).planter(c, plant, energy);
				energy -= plant.getCout();
			}
		}
		else {
			if (pboard.get((int) c.getJ() - 1).planter(c, plant, energy) == true) {
				energy-= plant.getCout();
			}
		}

	}

	// Génère la partie graphique
	public void generateGame(ApplicationContext context,int choix) {
		if (choix == 1) {
		generationBoard(context);
		}
		else if (choix == 2) {
			generationWaterBoard(context);
		}
		
		else if(choix ==3) {
			generationNightBoard(context);
		}
		
	
		generationMenu(context);
	}
	
	
	public void dayProgress(int compteur, ApplicationContext context, int choix,boolean debug,PlantSelect s) {
		mowerEffect();
		if (debug) {
			compteur*=2;
			planteRandom(context,s,debug,choix);
		}
		if (compteur % 5 == 0) {
			entityActions(context);
			productSunAll(context, pboard);
		}
		if (compteur % Graphique.nombreAlea(20, 10) == 0) {
			randomSun(context);
			
		}
		if (compteur ==1 ) {
			randomZombie(context, Graphique.nombreAlea(20, 10));
		}
		if (compteur==400) {
			harderRandomZombie(context, Graphique.nombreAlea(20, 10) );
			if (win(zboard) == true) {
				System.out.println("gagner");
				context.exit(0);
			}
			
		}
		if (loseCondition(context, zboard) == true) { 
			System.out.println("perdu");
			context.exit(0);
		}
		
	}
	
	public void nightProgress(int compteur, ApplicationContext context, int choix,boolean debug,PlantSelect s) {
		mowerEffect();
		if (debug) {
			compteur*=2;
			planteRandom(context,s,debug,choix);
		}
		if (compteur % 5 == 0) {
			entityActions(context);
			productSunAll(context, pboard);
		}
		if (compteur ==1 ) {
			randomZombie(context, Graphique.nombreAlea(20, 10));
		}
		if (compteur==400) {
			harderRandomZombie(context, Graphique.nombreAlea(20, 10) );
			if (win(zboard) == true) {
				System.out.println("gagner");
				context.exit(0);
			}
			
		}
		if (loseCondition(context, zboard) == true) { 
			System.out.println("perdu");
			context.exit(0);
		}
	}

	// effectue les actions des plantes
	public void gameProgress(int compteur, ApplicationContext context, int choix,boolean debug,PlantSelect s) {
		if (choix == 1) {
			dayProgress(compteur,context,choix,debug,s);
		}
		else if (choix == 2) {
			dayProgress(compteur,context,choix,debug,s);
		}
		else if (choix ==3) {
			nightProgress(compteur,context,choix,debug,s);
		}
		
		
	}
	public void planteRandom(ApplicationContext context, PlantSelect s, boolean debug,int choix) {
		if (debug == true) {
			Coordinates planterP = new Coordinates(Graphique.nombreAlea(10, 1), Graphique.nombreAlea(5, 1));
			System.out.println("Coordonnée" + planterP);
			s.randPlant();
			rajoutePlante(planterP, s.getPlant(),choix);
		}
	}
	
	public void  createGraves() {
		int x = Graphique.nombreAlea(10, 1);
		int y =Graphique.nombreAlea(5, 1);
		gravelist.add(Grave.CreateGrave(new Coordinates(x,y)));
	}
	public void delGrave(Grave g) {
		gravelist.remove(g);
		
	}
	
	
	
	
	
	

}
