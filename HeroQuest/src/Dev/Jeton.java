package Dev;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;

import javax.swing.JPanel;

public class Jeton extends JPanel{

	//Attributs
	private Personnage personnage;
	
	//Getters
	public Personnage getPersonnage() {
		return personnage;
	}
	
	//Constructeurs
	public Jeton(Personnage personnage) {
		this.personnage = personnage;
		setOpaque(false);
		setForeground(Color.WHITE);
		setBackground(Color.RED);
	}
	
	//Méthodes
    @Override
    public void paintComponent(Graphics g){
        Paint paint;
        Graphics2D g2d;
        if (g instanceof Graphics2D) {
            g2d = (Graphics2D) g;
        }
        else {
            System.out.println("Error");
            return;
        }
        paint = new GradientPaint(0,0, getBackground(), getWidth(), getHeight(), getForeground());
        g2d.setPaint(paint);
        g.fillOval(5, 5, getWidth()-10, getHeight()-10);

    }
}
