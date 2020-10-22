import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.*;

/*
 * This class is the end user view of the program, it can be anything from a simple command line interface to a sophisticated
 * GUI with buttons, sliders, icons and animations
 * 
 */

public class View extends JFrame{
	//Popdown strings for the Physical Attack Buttons
	private String menuItem1TXT = "Click";
	private String menuItem2TXT = "Click";
	//Popdown strings for the go to buttons
	private String menuItem3TXT = "Fanatic Forest";
	private String menuItem4TXT = "Tundra";
	private String menuItem5TXT = "Cave";
	private String menuItem6TXT = "Mournful Castle";
	//Popdown for strings for the items
	private String menuItem7TXT = "Potion";
	private String menuItem8TXT = "Ether";
	private String menuItem9TXT = "Elixir";
	//Popdown strings for the Attack Choice Buttons
	private String menuItem10TXT = "PHYSICAL";
	private String menuItem11TXT = "MAGIC";
	//Popdown strings for the Magic Attack Buttons
	private String menuItem12TXT = "Click";
	private String menuItem13TXT = "Click";
	
	//the window
	private JPanel panel;
	//button instances
	private JButton button1 = new JButton("Attack");
	private JButton button2 = new JButton("Go To");
	private JButton button3 = new JButton("Instructions");
	private JButton button4 = new JButton("Quit");
	private JButton button5 = new JButton("Items");
	//text instances
	private JTextArea label1 = new JTextArea();
	private JTextArea label2 = new JTextArea();
	private JTextArea label3 = new JTextArea();
	private JTextArea label4 = new JTextArea();
	
	//private JMenu menu = new JMenu("Menu");
	
	//These two menuItems are for the Physical attack buttons
	private JMenuItem menuItem= new JMenuItem(menuItem1TXT);
	private JMenuItem menuItem2= new JMenuItem(menuItem2TXT);
	//These 5 menuItems are for the Go To button
	private JMenuItem menuItem3 = new JMenuItem(menuItem3TXT);
	private JMenuItem menuItem4 = new JMenuItem(menuItem4TXT);
	private JMenuItem menuItem5 = new JMenuItem(menuItem5TXT);
	private JMenuItem menuItem6 = new JMenuItem(menuItem6TXT);
	//These four menuItems are for the Items button
	private JMenuItem menuItem7 = new JMenuItem(menuItem7TXT);
	private JMenuItem menuItem8 = new JMenuItem(menuItem8TXT);
	private JMenuItem menuItem9 = new JMenuItem(menuItem9TXT);
	//These two menuItems are for the Magic and Physical attack holders\
	private JMenuItem menuItem10 = new JMenuItem(menuItem10TXT);
	private JMenuItem menuItem11 = new JMenuItem(menuItem11TXT);
	//These two menuItems are for the Magic Attack Buttons
	private JMenuItem menuItem12 = new JMenuItem(menuItem12TXT);
	private JMenuItem menuItem13 = new JMenuItem(menuItem13TXT);
	
	//Popup menus
	
	//popup menu for attack button
	private JPopupMenu pop= new JPopupMenu();//This is the menu that will appear when we click a button
	//popup menu for go to stage button
	private JPopupMenu pop2= new JPopupMenu();
	//popup menu for items button
	private JPopupMenu pop3= new JPopupMenu();
	//popup menu for PHY attack button
	private JPopupMenu pop4= new JPopupMenu();
	//popup menu for MAG attack button
	private JPopupMenu pop5= new JPopupMenu();

	//The view needs access to the model to display the data, it doesn't need to be aware of the controller though
	private BattleSystem system;
	
	public View(BattleSystem i_system){
		system = i_system;
		
		label1.setText(system.getToString(0));
		label2.setText(system.getToString(1));
		label3.setText(system.getToString(2));
		label4.setText(system.getToString(3));
		
		//panels that hold the buttons
		panel = new JPanel();
		JPanel panel1 = new JPanel();//we could move these to the rest of our declarations if we want
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		//panels that hold the text boxes
		JPanel panel4 = new JPanel();
		JPanel panel5 = new JPanel();
		JPanel panel6 = new JPanel();
		JPanel panel7 = new JPanel();
		//panels that separate the text boxes
		JPanel panel8 = new JPanel();
		JPanel panel9 = new JPanel();
		
		//this makes the button have hover text
		//button1.setToolTipText("pie");
		
		//layouts make the elements resize and stay grouped regardless of window size
		panel.setLayout(new FlowLayout(BoxLayout.X_AXIS));//this locks everything to the top left corner, there is probably a smarter way to do this, but it works
		panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
		panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));
		panel3.setLayout(new BoxLayout (panel3, BoxLayout.Y_AXIS));
		
		//Set Editables
		label1.setEditable(false);
		label2.setEditable(false);
		label3.setEditable(false);
		label4.setEditable(false);
		
		
		//this part assembles the gui elements piece by piece
		//adds buttons
		panel1.add(button1);
		panel1.add(button2);
		panel1.add(button5);
		panel1.add(button3);
		panel1.add(button4);
		//adds textboxes
		//top boxes
		panel2.add(panel4.add(label3));
		panel3.add(panel5.add(label4));
		//seperaters
		panel2.add(panel8);
		panel3.add(panel9);
		//bottom boxes
		panel2.add(panel6.add(label1));
		panel3.add(panel7.add(label2));
		
		//add panels to the window
		panel.add(panel1);
		panel.add(panel2);
		panel.add(panel3);
		
		button1.setLayout(new FlowLayout());
//		pop.setLayout(new BoxLayout(pop, BoxLayout.Y_AXIS));
		//for attack choice button
		pop.add(menuItem10);
		pop.add(menuItem11);
		button1.setFocusable(false);
		
		//for go to button
		pop2.add(menuItem3);
		pop2.add(menuItem4);
		pop2.add(menuItem5);
		pop2.add(menuItem6);
		button2.setFocusable(false);
		
		//Running items
		pop3.add(menuItem7);
		pop3.add(menuItem8);
		pop3.add(menuItem9);
		button5.setFocusable(false);
		
		//for PHY ATK Choice button
		pop4.add(menuItem);
		pop4.add(menuItem2);
		
		//for MAG ATK Choice button
		pop5.add(menuItem12);
		pop5.add(menuItem13);
		
		//menu.add(menuItem3);
		//menuBar.add(menu);
		//this.setJMenuBar(menuBar);
		//we want the program to terminate on close, we're using "this" because the View class is actually a JFrame element
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//this sets the panel sizes            x ,  y
		panel.setPreferredSize(new Dimension(1000,600));
		panel1.setPreferredSize(new Dimension(100,200));
		panel2.setPreferredSize(new Dimension(250,250));
		panel3.setPreferredSize(new Dimension(250,250));
		panel8.setPreferredSize(new Dimension(100,100));
		panel9.setPreferredSize(new Dimension(100,100));
		
		//setting colors
		//panels
		panel.setBackground(Color.BLACK);
		panel1.setBackground(Color.BLACK);
		panel2.setBackground(Color.BLACK);
		panel3.setBackground(Color.BLACK);
		panel4.setBackground(Color.BLACK);
		panel5.setBackground(Color.BLACK);
		panel6.setBackground(Color.BLACK);
		panel7.setBackground(Color.BLACK);
		panel8.setBackground(Color.BLACK);
		panel9.setBackground(Color.BLACK);
		
		//text fields
		label1.setBackground(Color.BLACK);
		label2.setBackground(Color.BLACK);
		label3.setBackground(Color.BLACK);
		label4.setBackground(Color.BLACK);
		
		label1.setForeground(Color.MAGENTA);
		label2.setForeground(Color.YELLOW);
		label3.setForeground(Color.PINK);
		label4.setForeground(Color.PINK);
		
		//buttons
		button1.setBackground(Color.BLACK);
		button2.setBackground(Color.BLACK);
		button3.setBackground(Color.BLACK);
		button4.setBackground(Color.BLACK);
		button5.setBackground(Color.BLACK);
		
		button1.setForeground(Color.CYAN);
		button2.setForeground(Color.ORANGE);
		button3.setForeground(Color.BLUE);
		button4.setForeground(Color.RED);
		button5.setForeground(Color.GREEN);
		
		//menuItems
		menuItem.setBackground(Color.MAGENTA);
		menuItem2.setBackground(Color.MAGENTA);
		menuItem3.setBackground(Color.GRAY);
		menuItem4.setBackground(Color.DARK_GRAY);
		menuItem5.setBackground(Color.BLACK);
		menuItem6.setBackground(Color.RED);
		menuItem7.setBackground(Color.GREEN);
		menuItem8.setBackground(Color.GREEN);
		menuItem9.setBackground(Color.GREEN);
		menuItem10.setBackground(Color.BLACK);
		menuItem11.setBackground(Color.BLACK);
		menuItem12.setBackground(Color.YELLOW);
		menuItem13.setBackground(Color.YELLOW);
		
		menuItem.setForeground(Color.BLACK);
		menuItem2.setForeground(Color.BLACK);
		menuItem3.setForeground(Color.GREEN);
		menuItem4.setForeground(Color.CYAN);
		menuItem5.setForeground(Color.WHITE);
		menuItem6.setForeground(Color.BLACK);
		menuItem7.setForeground(Color.BLACK);
		menuItem8.setForeground(Color.BLACK);
		menuItem9.setForeground(Color.BLACK);
		menuItem10.setForeground(Color.MAGENTA);
		menuItem11.setForeground(Color.YELLOW);
		menuItem12.setForeground(Color.BLACK);
		menuItem13.setForeground(Color.BLACK);
		
		//setting tooltips
		menuItem7.setToolTipText("Max HP Heal");
		menuItem8.setToolTipText("Max MP Heal");
		menuItem9.setToolTipText("Half Heal to HP/MP");
		
		
		//these prepare the whole view to be displayed, actual call to display the view is in the main method
		this.setContentPane(panel);
		this.setTitle("Generic");
		this.pack();
		
	}
	
	//returns popup menus
	public JPopupMenu getPop(){
		return pop;
	}
	public JPopupMenu getPop2(){
		return pop2;
	}
	public JPopupMenu getPop3(){
		return pop3;
	}
	public JPopupMenu getPop4(){
		return pop4;
	}
	public JPopupMenu getPop5(){
		return pop5;
	}
	
	//returns buttons
	public JButton getButton1(){
		return button1;
	}
	public JButton getButton2(){
		return button2;
	}
	public JButton getButton5(){
		return button5;
	}
	
	//This method is called by the controller to refresh the text in the label element
	public void updateLabel1(){
		label1.setText(system.getToString(0));
	}
	
	public void updateLabel2(){
		label2.setText(system.getToString(1));
	}
	public void updateLabel3(){
		label3.setText(system.getToString(2));
	}
	public void updateLabel4(){
		label4.setText(system.getToString(3));
	}
	
	//This method is called by the controller to refresh the text in the meunItem element
	public void updateMenu1(String str){
		menuItem.setText(str);
	}
	public void updateMenu2(String str){
		menuItem2.setText(str);
	}
	public void updateMenu12(String str){
		menuItem12.setText(str);
	}
	public void updateMenu13(String str){
		menuItem13.setText(str);
	}
	
	//This method prepares an event listener for mouse clicks on a button, it is called in the controller class
	//Primary button listners
	public void addButton1Listener(ActionListener click){
		button1.addActionListener(click);
	}
	
	public void addButton2Listener(ActionListener click){
		button2.addActionListener(click);
	}
	public void addButton3Listener(ActionListener click){
		button3.addActionListener(click);
	}
	public void addButton4Listener(ActionListener click){
		button4.addActionListener(click);
	}
	public void addButton5Listener(ActionListener click){
		button5.addActionListener(click);
	}
	
	//pop down button Listeners
	public void addMenuItemListener(ActionListener click){
		menuItem.addActionListener(click);
	}
	public void addMenuItem2Listener(ActionListener click){
		menuItem2.addActionListener(click);
	}
	public void addMenuItem3Listener(ActionListener click){
		menuItem3.addActionListener(click);
	}
	public void addMenuItem4Listener(ActionListener click){
		menuItem4.addActionListener(click);
	}
	public void addMenuItem5Listener(ActionListener click){
		menuItem5.addActionListener(click);
	}
	public void addMenuItem6Listener(ActionListener click){
		menuItem6.addActionListener(click);
	}
	public void addMenuItem7Listener(ActionListener click){
		menuItem7.addActionListener(click);
	}
	public void addMenuItem8Listener(ActionListener click){
		menuItem8.addActionListener(click);
	}
	public void addMenuItem9Listener(ActionListener click){
		menuItem9.addActionListener(click);
	}
	public void addMenuItem10Listener(ActionListener click){
		menuItem10.addActionListener(click);
	}
	public void addMenuItem11Listener(ActionListener click){
		menuItem11.addActionListener(click);
	}
	public void addMenuItem12Listener(ActionListener click){
		menuItem12.addActionListener(click);
	}
	public void addMenuItem13Listener(ActionListener click){
		menuItem13.addActionListener(click);
	}
	
	public void loseWindow(){
		String str = "Game Over\n\n" +
				"Credits:\n" +
				"James Eckroth\n" +
				"Tyler Mooney\n" +
				"Richard\n" +
				"StackOverFlow\n\n" +
				"Special Thanks:\n" +
				"Mrs. Tucker\n" +
				"Computer Science AP class of 2017";
		
			UIManager UI=new UIManager();
			UI.put("OptionPane.background", Color.BLACK);
			UI.put("Panel.background", Color.BLACK);
			UI.put("OptionPane.messageForeground", Color.RED);

			JOptionPane.showMessageDialog(null, str, "You Are Dead", JOptionPane.WARNING_MESSAGE);
			System.exit(0);
	}
	public void winWindow(){
		String str = "Congragulations! You defeated the dragon Fafnir\n\n" + 
				"Credits:\n" +
				"James Eckroth\n" +
				"Tyler Mooney\n" +
				"Richard\n" +
				"StackOverFlow\n\n" +
				"Special Thanks:\n" +
				"Mrs. Tucker\n" +
				"Computer Science AP class of 2017";
		
		UIManager UI=new UIManager();
		UI.put("OptionPane.background", Color.WHITE);
		UI.put("Panel.background", Color.WHITE);
		UI.put("OptionPane.messageForeground", Color.BLACK);
		
		JOptionPane.showMessageDialog(null, str, "You Win, The Game Is Over", JOptionPane.PLAIN_MESSAGE);
		System.exit(0);
	}
	public void updateCOLORS(int i){
		if(i == 0){
			resetCOLORS();
			
			label1.setForeground(Color.WHITE);
		}else if(i == 1){
			resetCOLORS();
			
			label2.setForeground(Color.WHITE);
		}else if(i == 2){
			resetCOLORS();
			
			label3.setForeground(Color.WHITE);
		}else{
			resetCOLORS();
			
			label4.setForeground(Color.WHITE);
		}
	}
	public void resetCOLORS(){
		label1.setForeground(Color.MAGENTA);
		
		label2.setForeground(Color.YELLOW);
		
		label3.setForeground(Color.PINK);
		
		label4.setForeground(Color.PINK);
	}
}
