package Dev;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Paint;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class Case extends JPanel {
	
	private static final long serialVersionUID = 1L;

	//Attributs
	private boolean selectionnee;
	
	//Getters
	public boolean isSelectionnee() {
		return selectionnee;
	}

	//Setters
	public void setSelectionnee(boolean selectionnee) {
		this.selectionnee = selectionnee;
        if(selectionnee){
            setBackground(Color.BLUE);
            setForeground(new Color(10, 10, 10));
        }
        else {
            setBackground(Color.WHITE);
            setForeground(new Color(100, 100, 100));
        }
    }
	
	//Constructeur
	public Case() {
		setLayout(new GridLayout(1,0));
		setBackground(Color.WHITE);
		setForeground(new Color(100,100,100));
	}
	
	
	//Méthodes
	@Override
	public void paintComponent(Graphics g) {
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
        g.fillRect(0, 0, getWidth(), getHeight());	
	}
	
}
