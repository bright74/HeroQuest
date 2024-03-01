package Dev;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

public class Screen extends JPanel{

	private static final long serialVersionUID = 1L;

	public void init() {
		GridBagLayout gridbag = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		Grille grille = new Grille();
		Menu menu = new Menu(grille);
		
		setLayout(gridbag);
		
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1/1.3;
		c.weighty = 1.0;
		gridbag.setConstraints(grille, c);
		add(grille);
		
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.weightx = 0.0;
		gridbag.setConstraints(menu, c);
		add(menu);
	}
	
	public Screen() {
		init();
	}
}
