import javax.swing.*;//TODO make this not a wildcard later


/*
 * TODO
 * We will be merging view and controller in the interests of time in this class
 * TODO
 * Create a jpanel
 * 	this panel will hold the attack button, goto button, instructions text area, and quit button
 *  make instructions uneditable
 *  make this panel unfocusable, if you plan to add support for keypresses, you only want one focusable component
 *  
 * Create another panel
 * 	this one will hold two text areas, one for each enemy
 * 	Each text area and this panel should be unfocosable and uneditable
 * 	You'll probably want wordwrap enabled
 * 
 * Create a third panel
 *  this holds the two text areas, one for each player
 *  Each text area and this panel should be unfocosable and uneditable
 * 	You'll probably want wordwrap enabled
 *  
 * Create a fourth panel
 *  set a vertical layout such as boxlayout y axis
 *  add the enemy panel and player panel to this fourth panel
 *  make this panel unfocusable
 *  
 * Create a fifth panel
 *  set this to a flow layout with a box layout x axis argument, this will lock everything to the top right corner
 *  add panel 1
 *  add panel 4
 *  
 * Create a JFrame
 * 	this will be our main window
 *  set panel 5 as our content pane
 *  
 * Create a popup menu
 * 	this will have two buttons, 1 for each enemy to attack
 * 
 * Create a popup menu
 * 	this will have 5 buttons, 1 for each area to visit
 * 
 */
public class mainView {
	private JFrame battleWindow;
	private JPanel contentPane;
	private JPanel enemyPane;
	private JPanel playerPane;
	private JPanel dataPane;
	private JPanel buttonPane;
	private JButton atkOptions;
	private JButton gotoOptions;
	private JPopupMenu atkMenu;
	private JPopupMenu gotoMenu;
	private JMenuItem atk;//TODO
	

}
