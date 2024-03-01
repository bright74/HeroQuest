package Dev;

import java.awt.GridLayout;

import javax.swing.JPanel;

public class Grille extends JPanel{

	private static final long serialVersionUID = 1L;
	
	//Attributs
	private final static int TAILLE = 10;
	private Case caseActive;
	
	//Getters
	public Case getCases() {
		return caseActive;
	}
	
	//Setters
	public void setCases(Case c) {
		this.caseActive = c;
	}
	
	//Constructeurs
	public Grille() {
		setLayout(new GridLayout(TAILLE, TAILLE));
		for (int i = 0; i < TAILLE; i++) {	
			for (int j = 0; j < TAILLE; j++) {
				ajouterCase();
			}
		}
		init();
	}
	
	//Méthodes
	
	private void ajouterCase() {
		Case case1 = new Case();
		case1.addMouseListener(new ListenerCase(case1, this));
		add(case1);
	}
	
	private Jeton creerJeton(Personnage personnage) {
		Jeton jeton = new Jeton(personnage);
		jeton.addMouseListener(new ListenerJeton(jeton, this));
		return jeton;
	}
	
	private void init() {
		getCase(24).add(creerJeton(new Personnage("Batman", 3, 2, 8, 2)));
		getCase(26).add(creerJeton(new Personnage("Fararn", 2, 2, 8, 2)));
	}
	
	public Case getCase(int i, int j) {
		return (Case) getComponent(j+i*TAILLE);
	}
	
	public Case getCase(int i) {
		return (Case) getComponent(i);
	}
	
    public void afficherPossibilites(Jeton jeton){
        int i = 0;
        int j = 0;
        for(int k = 0; k < TAILLE*TAILLE; k++){
            getCase(k).setSelectionnee(false);
            if(getCase(k).getComponentCount()!=0 && getCase(k).getComponent(0).equals(jeton)){
                caseActive=getCase(k);
                i=k/TAILLE;
                j=k%TAILLE;
            }
        }
        selectionnerCase(i, j);
    }

    
	public void selectionnerCase(int i, int j) {
		Jeton jeton = (Jeton)(getCase(i, j).getComponent(0));
		for (int k = 0; k <= jeton.getPersonnage().getMove(); k++) {
			for (int l = 0; l <= jeton.getPersonnage().getMove(); l++) {
				if (i+k < TAILLE && j+l < TAILLE && k+l <= jeton.getPersonnage().getMove()) { //ça appelle une case en dehors de la grille -> à corriger
					getCase(i+k,j+l).setSelectionnee(true);
				}
				if (i+k < TAILLE && j-l >= 0 && k+l <= jeton.getPersonnage().getMove()) {
					getCase(i+k,j-l).setSelectionnee(true);
				}
				if (i-k >= 0 && j+l < TAILLE && k+l <= jeton.getPersonnage().getMove()) {
					getCase(i-k,j+l).setSelectionnee(true);
				}
				if (i-k >= 0 && j-l >= 0 && k+l <= jeton.getPersonnage().getMove()) {
					getCase(i-k,j-l).setSelectionnee(true);
				}
			}
		}
	}
	
	public void deplacer(Case case1) {
        case1.add(caseActive.getComponent(0));
        for(int k=0; k<TAILLE*TAILLE; k++){
            getCase(k).setSelectionnee(false);
        }
        caseActive.removeAll();
        caseActive.repaint();
        caseActive=null;
        case1.repaint();
	}
	
    private int getLigne(Case case1){
        int res=0;
        for(int i=0; i<TAILLE*TAILLE; i+=2){
            if(getCase(i).equals(case1)){
                res=i/TAILLE;
            }
        }
        return res;
    }
    
    private int getColonne(Case case1){
        int res=0;
        for(int i=0; i<TAILLE*TAILLE; i+=2){
            if(getCase(i).equals(case1)){
                res=i%TAILLE;
            }
        }
        return res;
    }
}
