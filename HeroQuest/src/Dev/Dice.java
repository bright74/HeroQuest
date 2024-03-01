package Dev;

import java.util.Arrays;
import java.util.stream.Stream;

public class Dice {

	//Attributs
	private DiceFace[] faces;

	//Getters
	public int getFaces(DiceFace face) {
		Stream<DiceFace> stream = Arrays.stream(faces);
		return (int)stream.filter(elem -> elem.equals(face)).count();
	}
	
	//Setters
	public void roll(int nbDice) {
		faces = new DiceFace[nbDice];
		for (int i = 0; i < nbDice; i++) {
			faces[i] = faceRoll();
		}
	}
	
	//Constructeur
	public Dice() {
		faces = new DiceFace[] {};
	}
	
	//Méthodes
	private DiceFace faceRoll() {
		int die = (int)(Math.random()*6+1);
		DiceFace res = null;
		if (die < 4) {
			res = DiceFace.skull;
		}
		else if(die >= 6) {
			res = DiceFace.b_shield;
		}
		else {
			res = DiceFace.w_shield;
		}
		return res;
	}
	
}
