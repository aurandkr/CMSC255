import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

public class ChineseZodiac extends JFrame{
	
	private JPanel inputPanel;
	private JTextField userYear;
	private GridLayout grid;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChineseZodiac frame = new ChineseZodiac();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/***************************
	 * This class build a GUI for our task.
	 ***************************/
	public ChineseZodiac() {
		grid = new GridLayout(2,0);
		
		setTitle("Chinese Zodiac Calculator");	//Sets title at top of window.
		setBounds(100, 100, 900, 535);			//Sets size of frame.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Sets exit operation for frame.
		
		JLabel zodiacText = new JLabel();			//zodiacText is what the program outputs.
		zodiacText.setBounds(21, 10, 900, 600);	//Use for testing purposes, until we understand how to import images.
		zodiacText.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		inputPanel = new JPanel();			//This panel is for the face of the GUI, not including output.
		inputPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		inputPanel.setLayout(null);
		grid.addLayoutComponent("inputpanel", inputPanel);
		JLabel userPrompt = new JLabel();	//userPrompt are the instructions for the user.
		userPrompt.setBounds(21, 21, 578, 35);
		userPrompt.setFont(new Font("Tahoma", Font.PLAIN, 20));
		userPrompt.setForeground(Color.BLACK);
		userPrompt.setBackground(Color.WHITE);
		userPrompt.setText("Please enter your birth year below to receive your Zodiac result.");
		
		userYear = new JTextField();		//userYear is the year the user inputs.
		userYear.setBounds(21, 70, 431, 32);
		userYear.setFont(new Font("Tahoma", Font.PLAIN, 20));
		userYear.setColumns(5);
		
		JButton submitButton = new JButton("Submit");
		submitButton.setBounds(458, 69, 141, 35);
		submitButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int year = Integer.parseInt(userYear.getText());	
				int sign = year % 12;					//Stores the string from JTextField as an int. NEEDS ERROR HANDLING.
				zodiacText.setText(zodiacSign(sign));
				zodiacText.setIcon(zodiacImage(sign));
				if(zodiacText.getIcon() == null) {
					System.out.println("no image found");
				}
				userYear.setText("");
														//Stores the returned String from method zodiacYear() into zodiacText.
			}
		});
		
		
		inputPanel.add(userPrompt);			//Adds values to inputPanel.
		inputPanel.add(userYear);
		inputPanel.add(submitButton);
		
		add(zodiacText);		//Adds values to frame.
		add(inputPanel);
		setVisible(true);
		
	}
	
	/***************************************
	 * This method is called with an integer parameter and returns
	 * the user's zodiac sign as an index of a string array 
	 * corresponding to the user's input year.
	 ***************************************/
	public static String zodiacSign(int sign) {
		String zodiac;
		String[] animals = { "Monkey", "Rooster", "Dog", "Boar", "Rat", "Ox", "Tiger", "Rabbit", "Dragon", "Snake",
				"Horse", "Ram" };

		zodiac = "According to the Chinese New Year, your zodiac sign is the " + animals[sign];

		return zodiac;
	}
	
	public static ImageIcon zodiacImage(int sign) {
		String[] path = {"monkey.png", "rooster.png", "", "", "", "", "", "", "", "", "", ""};
		
		ImageIcon zodiacImage = new ImageIcon(path[sign]);
		
		return zodiacImage;
	}
	
}
