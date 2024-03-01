package Dev;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ListenerCase implements MouseListener {

	private Case case1;
	private Grille grille;
	
    public ListenerCase(Case case1, Grille grille) {
        super();
        this.case1 = case1;
        this.grille = grille;
    }
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
        if(case1.isSelectionnee()){
            grille.deplacer(case1);
        }
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
