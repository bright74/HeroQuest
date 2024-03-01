package Dev;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Menu extends JPanel{
	
	private Grille grille;

	public Menu(Grille grille) {
		setLayout(new GridLayout(4, 0));
		setBackground(Color.WHITE);
		JPanel gIn = new JPanel();
		gIn.setBackground(Color.WHITE);
		JButton bAttack = new JButton("Attack");
		JButton bMove = new JButton("Move");
		bMove.addMouseListener(new ListenerButton(grille, bMove));
		bAttack.addMouseListener(new ListenerButton(grille, bAttack));
		bAttack.setPreferredSize(new Dimension(125, 125));
		bMove.setPreferredSize(new Dimension(125, 125));
		bAttack.setBackground(new Color(200, 50, 50));
		bMove.setBackground(new Color(50, 200, 120));
		gIn.add(bAttack);
		gIn.add(bMove);
		add(gIn);
	}
}
