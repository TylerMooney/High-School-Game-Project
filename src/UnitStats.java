/*	Author: Tyler Mooney
 * 	Date: May 4th, 2017
 * 	Help From:
 */

public class UnitStats {

	//Instance Variables
	private String name;
	private int hp;
	private int atk;
	private int def;
	private int mag;
	private int mp;
	private int exp;
	private boolean npc;
	private int maxHP;
	private int maxEXP;
	
	//Constructor
	public UnitStats(String n, int health, int attack, int defense, int magic, int magicpoints, int experience, boolean player, int maxhp, int maxexp){
		name = n;
		hp = health;
		atk = attack;
		def = defense;
		mag = magic;
		mp = magicpoints;
		exp = experience;
		npc = player;
		maxHP = maxhp;
		maxEXP = maxexp;
	}
	
	//setter methods for each variable
	public void setHP(int health){
		hp = health;
	}
	public void setEXP(int experience){
		exp = experience;
	}
	public void setATK(int attack){
		atk = attack;
	}
	public void setDEF(int defense){
		def = defense;
	}
	public void setMAG(int magic){
		mag = magic;
	}
	public void setMP(int magicpoints){
		mp = magicpoints;
	}
	public void setMAXHP(int max){
		maxHP = max;
	}
	public void setMAXEXP(int max){
		maxHP = max;
	}
	
	//Return methods for each variable
	public String getName(){
		return name;
	}
	public int getHP(){
		return hp;
	}
	
	public int getATK(){
		return atk;
	}
	
	public int getDEF(){
		return def;
	}
	
	public int getMAG(){
		return mag;
	}
	
	public int getMP(){
		return mp;
	}
	
	public int getEXP(){
		return exp;
	}
	public boolean isNPC(){
		return npc;
	}
	public int getMAXHP(){
		return maxHP;
	}
	public int getMAXEXP(){
		return maxEXP;
	}
}