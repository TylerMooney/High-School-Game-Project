import java.util.*;

/* Author:Tyler Mooney
 * Date: May 8th, 2017
 * Help From: 
 */

/* So for the attack button you should make it a drop down button
 * So that you don't need to specify the enemies that much when they're
 * in the arraylist
 */

public class BattleSystem {
	
	ArrayList<Character> list = new ArrayList<Character>();
	//private Controller control;
	int turn = 0; //used to determine which unit's turn it is
	int target = 0;//used to determine which unit will be attacked
	int enemyCnt = 0;
	Scanner scan = new Scanner(System.in);

	/*public BattleSystem(View v, Model m){
		model = m;
		view = v;
		control = new Controller(view, model, BattleSystem);
	}*/
	
	public void nextTurn(){
		if(turn == list.size()-1 || turn>= 3){
			turn = -1;
		}
		
		turn++;
	}
	
	public int getTurn(){
		return turn;
	}
	
	
	public void reset(){
		turn = 0;
	}
	
	//Main class method, Primarily only for the npc attack
	public void BattleRun(){
		//npc battle code
		target = (int)(Math.random() * 2);
		
		if(list.get(target).getHP() <= 0){
			if(target == 1){
				target = 0;
			}else{
				target = 1;
			}
			
			if((int)(Math.random() * 2) == 0){
				npcPHYAttack();
			}else{
				npcMAGAttack();
			}
		}else{
			if((int)(Math.random() * 2) == 0){
				npcPHYAttack();
			}else{
				npcMAGAttack();
			}
		}
		nextTurn();
	}
	
	//may be needed for later use
	/*public void getEnemyCount(){
		enemyCnt = list.size()-2;
	}*/
	
	public void getEnemies(Character[] enemies){
		for(int k = 0; k < enemies.length; k++){
			list.add(enemies[k]);
		}
	}
	//removes one enemy when they die, this method is primarily for testing purposes and will not be used in the final game
	public void removeEnemy(){
		list.remove(2);
	}
	//removes all enemies when going to another area(retreat)
	public void removeAll(){
		for(int k = 2; k<list.size(); k++){
			list.remove(k);
		}
	}
	//this is to get the stat text of the present enemies
	public String getTXT(int pos){
		try{
			return list.get(2 + pos).toString();
		}catch(IndexOutOfBoundsException e){
			return ("N/A");
		}
	}
	//this is to get the names of the present enemies for the popdown buttons
	public String getName(int pos){
		try{
			return list.get(2 + pos).getName();
		}catch(IndexOutOfBoundsException e){
			return ("N/A");
		}
	}
	
	public void addChar(Character item){
		list.add(item);
	}
	//this method(s) is for npc attacks
	//physical attack
	public void npcPHYAttack(){
		if(list.get(turn).getATK() > list.get(target).getDEF()){
			list.get(target).decHP(list.get(turn).getATK() - list.get(target).getDEF());
		}
	}
	//magic attack
	public void npcMAGAttack(){
		if(list.get(turn).getMAG() > list.get(target).getDEF()){
			list.get(target).decHP(list.get(turn).getMAG() - list.get(target).getDEF());
		}
	}
	
	//This method(s) is for Player Attacks //TODO finish this
	//Physical Attack
	public void playerPHYAttack(int pos){
		if(list.get(turn).getATK() > list.get(pos).getDEF()){
			list.get(pos).decHP(list.get(turn).getATK() - list.get(pos).getDEF());
		}
		
		if(list.get(pos).getHP() <= 0){
			list.get(turn).decEXP(list.get(pos).getEXP());
			list.remove(pos);
		}
	}
	//Magic Attack
	public void playerMAGAttack(int pos){
		if(list.get(turn).getMAG() > list.get(pos).getDEF()){
			list.get(pos).decHP(list.get(turn).getMAG() - list.get(pos).getDEF());
		}
		
		if(list.get(pos).getHP() <= 0){
			list.get(turn).decEXP(list.get(pos).getEXP());
			list.remove(pos);
		}
	}
	
	public void decTarget(int pos){
		target = pos;
	}
	
	//this is for the textboxes
	public String getToString(int pos){
		try{
			return list.get(pos).toString();
		}catch(IndexOutOfBoundsException e){
			return "N/A";
		}
	}
	//This is for the potion buttons
	public void potion(int i){
		list.get(i).setHP(list.get(i).getMAXHP());
	}
	public void elixir(int i){
		list.get(i).setMP(20);
	}
	public void ether(int i){
		list.get(i).setHP(list.get(i).getMAXHP()/2);
		list.get(i).setMP(10);
	}
	public boolean lose(){
		//make a private varaible for this boolean and the other boolean temps
		if(list.get(0).getHP() <= 0 && list.get(1).getHP() <= 0){
			return true;
		}
		
		return false;
	}
	public boolean win(){
		if(list.size() < 3){
			return true;
		}
		return false;
	}
	public void levelUP(){
		if(list.get(turn).getEXP() >= list.get(turn).getMAXEXP()){
			list.get(turn).setEXP(list.get(turn).getEXP() - list.get(turn).getMAXEXP());
			list.get(turn).setMAXHP(list.get(turn).getMAXHP() + 5);
			list.get(turn).setATK(list.get(turn).getATK() + 2);
			list.get(turn).setMP(list.get(turn).getMP() + 3);
			list.get(turn).setDEF(list.get(turn).getDEF() + 2);
			list.get(turn).setHP(list.get(turn).getMAXHP());
		}
	}
	public boolean isDead(){
		if(list.get(turn).getHP() <= 0){
			return true;
		}
		return false;
	}
}