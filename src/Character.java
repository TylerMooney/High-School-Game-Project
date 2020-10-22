/* Author:Tyler Mooney
 * Date:5-5-2017
 * Help From:
 */


//make max exp and max hp variables

public class Character extends UnitStats {

	//Constructor
	public Character(String name, int hp, int atk, int def, int mag, int mp, int exp, boolean npc, int maxhp, int maxexp){
		super(name, hp,atk,def,mag,mp, exp, npc, maxhp, maxexp);
	}
	//Talks with the BattleSystem Class to make the battles run
	/*public void attack(int position){
		
	}*/
	
	//Methods that set Stats
	public void decHP(int damage){
		super.setHP(super.getHP() - damage);
	}
	public void decEXP(int exp){
		super.setEXP(super.getEXP() + exp);
	}
	public void decATK(int atk){
		super.setATK(super.getATK() + atk);
	}
	public void decDEF(int def){
		super.setDEF(super.getDEF() + def);
	}
	public void decMAG(int mag){
		super.setMAG(super.getMAG() + mag);
	}
	public void decMP(int mp){
		super.setMP(super.getMP() + mp);
	}
	
	//Level Up methods
	public void levelUP(){
		super.setMAXHP(super.getATK() + 10);
		super.setHP(super.getMAXHP());
		super.setATK(super.getATK() + 3);
		super.setDEF(super.getATK() + 3);
		super.setMAG(super.getATK() + 3);
		super.setMP(super.getATK() + 3);
		super.setEXP(super.getEXP() - super.getMAXEXP());
		super.setMAXEXP(super.getMAXEXP() + 20);
	}
	
	//toString
	public String toString(){
		String strEXP = "";
		if(super.isNPC() == true){
			strEXP = "EXP: " + super.getEXP();
		}
		String str;
		str = 
		super.getName() + "\n" +
		"HP: " + super.getHP() + "\n" +
		"ATK: " + super.getATK() + "\n" +
		"DEF: " + super.getDEF() + "\n" +
		"MAG: " + super.getMAG() + "\n" +
		"MP: " + super.getMP() + "\n" +
		strEXP;
		return str;
	}
}