
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.JOptionPane;

/*
 * in this case, the controller handles events
 */
public class Controller {
	private View view;
	private BattleSystem system;
	public Timer timer;
	private LevelChecker level;
	
	//The controller is the intermediary between the GUI and the DATA, so it needs to see both, hence the model and view
	public Controller(View i_view, BattleSystem battle, LevelChecker level_i){
		view = i_view;
		system = battle;
		timer = new Timer(50,new TimerListener());
		level = level_i;
		//Register our listeners here using the methods from our view and inner classes below
		//primary buttons
		view.addButton1Listener(new Button1Listener());//new Button1Listener()
		view.addButton2Listener(new Button2Listener());
		view.addButton3Listener(new Button3Listener());
		view.addButton4Listener(new Button4Listener());
		view.addButton5Listener(new Button5Listener());
		//popdown buttons
		view.addMenuItemListener(new MenuItemListener());//new Button1Listener()
		view.addMenuItem2Listener(new MenuItem2Listener());//Adding a menuItem listener is the same as a button listener, just a different name in the code
		view.addMenuItem3Listener(new MenuItem3Listener());
		view.addMenuItem4Listener(new MenuItem4Listener());
		view.addMenuItem5Listener(new MenuItem5Listener());
		view.addMenuItem6Listener(new MenuItem6Listener());
		view.addMenuItem7Listener(new MenuItem7Listener());
		view.addMenuItem8Listener(new MenuItem8Listener());
		view.addMenuItem9Listener(new MenuItem9Listener());
		view.addMenuItem10Listener(new MenuItem10Listener());
		view.addMenuItem11Listener(new MenuItem11Listener());
		view.addMenuItem12Listener(new MenuItem12Listener());
		view.addMenuItem13Listener(new MenuItem13Listener());
	}
	
	/*
	 * so for the timer to pro[erly stop we are going to add a method to battle system and controller
	 * the method in battle system is going to get the current turn
	 * so the timerlistener method is going to call this in an if/else and stop the timer if it is a player turn, then the player attack button should start the timer again
	 */
	
	//These two classes are how we tell the buttons in our GUI to do things.
	
	//these listeners are for the primary buttons
	
	//attack button listener
	class Button1Listener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			view.getPop().show(view.getButton1(), view.getButton1().getX()+view.getButton1().getSize().width, view.getButton1().getY());
		}
	}
	//Go to button listener
	class Button2Listener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			view.getPop2().show(view.getButton2(), view.getButton2().getX()+view.getButton2().getSize().width, view.getButton2().getY()- view.getButton2().getSize().height);
		}
	}
	//Items button listener
	class Button5Listener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e){
			view.getPop3().show(view.getButton5(), view.getButton5().getX()+view.getButton5().getSize().width, view.getButton5().getY()- (view.getButton5().getSize().height * 2));
		}
	}
	//Instructions button Listener
	class Button3Listener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			//have a new window appear with the instructions
			String str = "Welcome to [NAME]!" + 
			"In [NAME] you use the attack button to select an attack and an opponent.\n" + 
			"The turn order is always 1. Ephraim 2. Myrrh 3. Enemies.\n"+
			"The current turn is highlighted by white text\n" +
			" You can change your stage whenever you wish,\n" +
			"To beat the game, you must defeat Fafnir of The Mournful Castle.";
			
			UIManager UI=new UIManager();
			UI.put("OptionPane.background", Color.BLACK);
			UI.put("Panel.background", Color.BLACK);
			UI.put("OptionPane.messageForeground", Color.BLUE);
			
			JOptionPane.showMessageDialog(null,str,"TITLE",JOptionPane.QUESTION_MESSAGE);
		}
	}
	//Quit button Listener
	class Button4Listener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}
	
	//These methods are for the pop down buttons
	
	//These listeners are for the attack pop down buttons
	//Choice of Mag or Phy attack buttons
	class MenuItem10Listener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			view.getPop4().show(view.getButton1(), view.getButton1().getX()+view.getButton1().getSize().width, view.getButton1().getY());
		}
	}
	class MenuItem11Listener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			view.getPop5().show(view.getButton1(), view.getButton1().getX()+view.getButton1().getSize().width, view.getButton1().getY());
		}
	}
	
	//Physical Attack Buttons
	class MenuItemListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			//TODO make this button set target to enemy 0
			system.playerPHYAttack(2);
			system.levelUP();
			system.nextTurn();
		}
	}
	class MenuItem2Listener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			system.playerPHYAttack(3);
			system.levelUP();
			system.nextTurn();
		}
	}
	//Magic Attack Buttons
	class MenuItem12Listener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			system.playerMAGAttack(2);
			system.levelUP();
			system.nextTurn();
		}
	}
	class MenuItem13Listener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			system.playerMAGAttack(3);
			system.levelUP();
			system.nextTurn();
		}
	}
	//these listeners are for the go to pop down buttons
	class MenuItem3Listener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			//TODO when we have the functioning game edit this code
			system.removeAll();
			system.removeAll();
			system.removeAll();
			system.reset();
			system.getEnemies(level.addEnemies(1));
			level.setStage(1);
			level.levelSelect();
		}
	}
	class MenuItem4Listener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			//TODO when we have the functioning game edit this code
			system.removeAll();
			system.removeAll();
			system.removeAll();
			system.reset();
			system.getEnemies(level.addEnemies(2));
			level.setStage(2);
			level.levelSelect();
		}
	}
	class MenuItem5Listener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			//TODO when we have the functioning game edit this code
			system.removeAll();
			system.removeAll();
			system.removeAll();
			system.reset();
			system.getEnemies(level.addEnemies(3));
			level.setStage(3);
			level.levelSelect();
		}
	}
	class MenuItem6Listener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			//TODO when we have the functioning game edit this code
			system.removeAll();
			system.removeAll();
			system.removeAll();
			system.reset();
			system.getEnemies(level.addEnemies(4));
			level.setStage(4);
			level.levelSelect();
		}
	}
	//Potion button
	class MenuItem7Listener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e){
			system.potion(system.getTurn());
			system.nextTurn();
		}
	}
		//Ether button
	class MenuItem8Listener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e){
			system.elixir(system.getTurn());
			system.nextTurn();
		}
	}
		//Elixir button
	class MenuItem9Listener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e){
			system.ether(system.getTurn());
			system.nextTurn();
		}
	}
	//this is the timer listener
	class TimerListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if(system.getTurn() >= 2){
				system.BattleRun();
			}
			if(system.getTurn()<= 1){
				system.levelUP();
			}
			if(system.isDead()){
				system.nextTurn();
			}
			//updates textfields
			view.updateLabel1();
			view.updateLabel2();
			view.updateLabel3();
			view.updateLabel4();
			//updates the enemy names in the attack choices
			view.updateMenu1(system.getName(0));
			view.updateMenu2(system.getName(1));
			view.updateMenu12(system.getName(0));
			view.updateMenu13(system.getName(1));
			//shows which turn it is
			view.updateCOLORS(system.getTurn());
			//checks game status (win or lose)
			if(system.lose()){
				view.loseWindow();
			}
			if(system.lose()){
				view.loseWindow();
				timer.stop();
			}
			if(level.lastStage()){
				if(system.win()){
					view.winWindow();
					timer.stop();
				}
			}
		}
	}
}
