/* Author: Tyler Mooney
 * Date: 5 - 9 - 17
 * Help From:
 */

/*Checks the players status in each level/area
* takes player into level
* or out into the hub menu when the level is beaten
* Also instantiates each level when they are selected
* so they certain enemies spawn correctly
*/

public class LevelChecker {
	//Instance Variables
	final int STAGE1 = 1;
	final int STAGE2 = 2;
	final int STAGE3 = 3;
	final int STAGE4 = 4;
	
	
	private int input = 0;
	private boolean stage1 = false;
	private boolean stage2 = false;
	private boolean stage3 = false;
	private boolean stage4 = false;
	private boolean menu = false;
	
	
	//name, hp, atk, deg, mag, mp, exp, boolean, maxhp, meaxexp
	//Enemies
	Character bear = new Character("Teddi Bear", 20, 15, 10, 5, 0, 25, true, 20, 0);
	Character bear2 = new Character("Teddi Bear", 20, 15, 10, 5, 0, 25, true, 20, 0);

	Character spirit1 = new Character("Wandering Spirit", 20, 5, 5, 13, 25, 25, true, 20, 0);
	Character spirit2 = new Character("Wandering Spirit", 20, 5, 5, 13, 25, 25, true, 20, 0);

	Character moose1 = new Character("Rampant Moose", 32, 16, 9, 8, 0, 25, true, 32, 0);
	Character moose2 = new Character("Rampant Moose", 32, 16, 9, 8, 0, 25, true, 32, 0);

	Character fox1 = new Character("Frostbitten Fox", 25, 5, 6, 15, 30, 25, true, 25, 0);
	Character fox2 = new Character("Frostbitten Fox", 25, 5, 6, 15, 30, 25, true, 25, 0);

	Character skeleton1 = new Character("Skeleton", 35, 18, 14, 10, 0, 25, true, 35, 0);
	Character skeleton2 = new Character("Skeleton", 35, 18, 14, 10, 0, 25, true, 35, 0);

	Character eye1 = new Character("Disembodied Eye", 30, 6, 10, 20, 30, 25, true, 30, 0);
	Character eye2 = new Character("Disembodied Eye", 30, 6, 10, 20, 30, 25, true, 30, 0);

	Character knight1 = new Character("Nightly Knight", 45, 22, 15, 10, 0, 50, true, 45, 0);
	Character knight2 = new Character("Nightly Knight", 45, 22, 15, 10, 0, 50, true, 45, 0);

	Character necromancer1 = new Character("Necromancer", 40, 10, 10, 26, 50, 50, true, 40, 0);
	Character necromancer2 = new Character("Necromancer", 40, 10, 10, 26, 50, 50, true, 40, 0);

	//Bosses
	Character rabbit = new Character("Rabbit of Caerbannog", 40, 18, 12, 7, 20, 100, true, 40, 0);
	
	Character hag = new Character("Snowfall Hag", 35, 8, 10, 18, 60, 100, true, 35, 0);
	
	Character troll = new Character("The Internet Troll", 65, 24, 13, 12, 20, 100, true, 65, 0);
	
	Character fafnir = new Character("Fafnir", 100, 30, 18, 22, 80, 0, true, 100, 0);
	
	Character bear1 = bear;
	
	//ArrayLists of enemies, make rest of the 
	final Character[] MOB1 ={spirit1, spirit2, bear1, bear2, rabbit};
	final Character[] MOB2 ={fox1, fox2, moose1, moose2, hag};
	final Character[] MOB3 ={eye1, skeleton1, eye2, skeleton2, troll};
	final Character[] MOB4 ={necromancer1, knight1, knight2, necromancer2, fafnir};
	
	public void setStage(int x){
		input = x;
	}
	
	
	public void levelSelect(){
	if(input == STAGE1){
			//go to stage1
			stage1 = true;
			
			//sets other stages to false
			menu = stage2 = stage3 = stage4 = false;
		}else if(input == STAGE2){
			//go to stage2
			stage2 = true;
			
			//sets other stages to false
			menu = stage1 = stage3 = stage4 = false;
		}else if(input == STAGE3){
			//go to stage3
			stage3 = true;
			
			//sets other stages to false
			menu = stage1 = stage2 = stage4 = false;
		}else if(input == STAGE4){
			//go to stage4
			stage4 = true;
			
			//sets other stages to false
			menu = stage1 = stage2 = stage3 = false;
		}
		else{
			//go to main menu
			menu = true;
			
			//sets other stages to false
			stage1 = stage2 = stage3 = stage4 = false;
		}
	}

	//returns  a boolean if the last stage is true
	public boolean lastStage(){
		if(stage4){
			return true;
		}
		return false;
	}
	//method adds each enemy depending on which stage is true
	//name, hp, atk, deg, mag, mp, exp, boolean, maxhp, meaxexp
	public Character[] addEnemies(int stage){
		Character[] temp = new Character[5];
		if(stage == STAGE1){
			for(int i = 0; i<MOB1.length; i++){
				temp[i] = new Character(MOB1[i].getName(),MOB1[i].getHP(), MOB1[i].getATK(), MOB1[i].getDEF(), MOB1[i].getMAG(), MOB1[i].getMP(), MOB1[i].getEXP() ,true, MOB1[i].getMAXHP(), MOB1[i].getMAXEXP());
			}
			return temp;
		}else if(stage == STAGE2){
			return MOB2;
		}else if(stage == STAGE3){
			return MOB3;
		}else if(stage == STAGE4){
			return MOB4;
		}
		return null;
	}
	
}