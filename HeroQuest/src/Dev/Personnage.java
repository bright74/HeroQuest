package Dev;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

public class Personnage {

	//Attributs
	
	private String name;
	private int power;
	private int defense;
	private int spirit;
	private int health;
	private boolean isMonster;
	private int move;
	
	//Getters
	
	public String getName() {
		return name;
	}
	
	public int getPower() {
		return power;
	}
	
	public int getDefense() {
		return defense;
	}
	
	public int getSpirit() {
		return spirit;
	}
	
	public int getHealth() {
		return health;
	}
	
	public boolean getIsMonster() {
		return isMonster;
	}
	
	public int getMove() {
		return move;
	}
	
	//Setters
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPower(int power) {
		this.power = power;
	}
	
	public void setDefense(int defense) {
		this.defense = defense;
	}
	
	public void setSpirit(int spirit) {
		this.spirit = spirit;
	}
	
	public void setHealth(int health) {
		this.health = health;
	}
	
	public void setIsMonster(boolean isMonster) {
		this.isMonster = isMonster;
	}
	
	public void setMove(int move) {
		this.move = move;
	}
	
	//Constructeur
	
	public Personnage(String name, int power, int defense, int spirit, int health) {
		this.name = name;
		this.power = power;
		this.defense = defense;
		this.spirit = spirit;
		this.health = health;
		this.move = 3;
	}
	
	//Méthodes
	
	public int moveRoll() {
		return ((int)(Math.random()*6) + (int)(Math.random()*6) + 2);
	}
	
	public int attack() {
		Dice diceResult = new Dice();
		diceResult.roll(this.getPower());
		return diceResult.getFaces(DiceFace.skull);
	}
	
	public int defense() {
		Dice diceResult = new Dice();
		DiceFace face;
		if (getIsMonster()) {
			face = DiceFace.b_shield;
		}
		else {
			face = DiceFace.w_shield;
		}
		return diceResult.getFaces(face);
	}
		
	public void combat(Personnage personnage) {
		int res = (this.attack() - personnage.defense());
		if (res > 0) {
			personnage.setHealth(personnage.getHealth() - res);	
		}
	}
	
}