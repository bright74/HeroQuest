package Dev;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ListenerJeton implements MouseListener{

	private Grille grille;
	private Jeton jeton;
	
	public ListenerJeton(Jeton jeton, Grille grille) {
		this.grille = grille;
		this.jeton = jeton;
	}
	
public void mouseClicked(MouseEvent arg0) {
        
    }

    public void mouseEntered(MouseEvent arg0) {
    
    }

    public void mouseExited(MouseEvent arg0) {
        
    }

    public void mousePressed(MouseEvent arg0) {
    	grille.afficherPossibilites(jeton);
    }

    public void mouseReleased(MouseEvent arg0) {
        
    }
}
