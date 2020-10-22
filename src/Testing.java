//http://www.leepoint.net/GUI/structure/40mvc.html


public class Testing {

	public static void main(String[] args) {
		
		//name, hp, atk, deg, mag, mp, exp, boolean, maxhp, meaxexp
		Character Ephraim = new Character("Ephraim", 40, 16, 10, 5, 20, 0, true, 40, 100);
		Character Myrrh = new Character("Myrrh", 32, 7, 7, 18, 50, 0, true, 32, 100);
		
		//instance scanners
		//Everything here uses the same model, so initialize it first and pass it in to anything that needs it
		BattleSystem system = new BattleSystem();
		LevelChecker level = new LevelChecker();
		View view = new View(system);
		//Finally, initialize the controller with the model and view passed in
		Controller controller = new Controller(view, system, level);
		
		
		//basic setup code
		system.addChar(Ephraim);
		system.addChar(Myrrh);
		system.getEnemies(level.addEnemies(1));
		view.updateLabel3();
		view.updateLabel4();
		
		
		//The controller needs a view, so the view most come after the model but before the controller, pass in the model we made earlier
		view.updateMenu1(system.getName(0));
		view.updateMenu2(system.getName(1));
		
		//Now we make the view visible to the user
		view.setVisible(true);
		controller.timer.start();
	}
}