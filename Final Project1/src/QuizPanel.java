import javax.swing.JPanel;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;



public class QuizPanel extends JPanel implements ActionListener {
	
	//instance variables
	protected JButton startButton;
	protected JComboBox CategoryBox;
	private JLabel TextLabel;
	private JLabel TextLabe2;
	
	
	//Constructors
	public QuizPanel() {
		
		//set size of panel
		super.setPreferredSize(new Dimension(800, 500));
		
		// Choices for the JComboBox
		String[] choice = {" ","Science","Technology", "Engineering", "Mathematics"};

		// create a drop down box 
		CategoryBox = new JComboBox(choice);
	
		
		//create start button
		startButton = new JButton("Start");
		
		//Activate the start button
		startButton.addActionListener(this);
		CategoryBox.addActionListener(this);
	
		
		// Create label to display
		TextLabel = new JLabel ("ALL QUIZ WILL BE TIMED. PLEASE WRITE DOWN YOUR ANSWERS AND CHECK ANSWERS AT THE END OF QUIZ");
		TextLabe2 = new JLabel ("SUBJECTS");
		
		// set panel border layout
		super.setLayout(new BorderLayout());
		
		
		//create gridlayout
		GridLayout gridlayout = new GridLayout(0,1);
		
		setLayout(gridlayout);
		
		
		// create new JPanel
		JPanel centerPanel = new JPanel();
		
	
		// set the size of the combobox 
		CategoryBox.setPreferredSize(new Dimension(720, 30));
		
		// add the top textlabe2 and combobox to the new panel centerPanel
		centerPanel.add(TextLabe2, BorderLayout.WEST);
		centerPanel.add(CategoryBox, BorderLayout.EAST);
		
		// set the panel centerPanel at the Page_Start
		super.add(centerPanel, BorderLayout.PAGE_START);
		
		
		// ADD  The textlabe1 to the  center of the panel
		JPanel centerPane3 = new JPanel();
		super.add(centerPane3, BorderLayout.CENTER);
		
		//add textlabel to center of centerpane3
		centerPane3.add(TextLabel, BorderLayout.CENTER);
		//set size of textlabel1
		TextLabel.setPreferredSize(new Dimension(700, 100));
		
		
		
		
		//create a new panel centerpane2 and add to end of page
		JPanel centerPane2 = new JPanel();
		super.add(centerPane2, BorderLayout.PAGE_END);
		
		//add the start button to the end of the centerpane2
		centerPane2.add(startButton, BorderLayout.PAGE_END);
		centerPane2.setLayout(null);
		
		//set position and size of start button
		startButton.setBounds(1,128,798,40);
		startButton.setPreferredSize(new Dimension(500, 30));
		
	}
	
	

	
	@Override
	public void actionPerformed(ActionEvent events) {
		//get selected value of combo box
		String subject = (String) CategoryBox.getSelectedItem();
		
		// If science is chosen get Science questions
		if(events.getSource()== startButton && subject == "Science" ) {
			
			//Create Array list
			ArrayList<MCQ> scienceQuestions = new ArrayList<>();
			
			scienceQuestions.add(new MCQ("1. Brass gets discoloured in air because of the presence of which of the following gases in air?", new String[] {"Oxygen","Hydrogen sulphide","Carbon dioxide","Nitrogen"}, "B"));
			
			scienceQuestions.add(new MCQ("2. Which of the following is a non metal that remains liquid at room temperature?",new String[] {"Phosphorous","Bromine","Chlorine","Helium"}, "B"));
			
			scienceQuestions.add(new MCQ("3. Chlorophyll is a naturally occurring chelate compound in which central metal is",new String[] {"Copper","Magnesium","Iron","Calcium"}, "B"));
			
			scienceQuestions.add(new MCQ("4. Which of the following is used in pencils ?", new String[] {"Graphite","Silicon","Charcoal","Phosphorous"}, "A"));
			
			scienceQuestions.add(new MCQ("5. Which of the following metals forms an amalgam with other metals?", new String[] {"Tin","Mercury","Lead","Zinc"}, "B"));
			
			scienceQuestions.add(new MCQ( "Correct Answers for Science Questions are as follows:", new String[] {"1. Hydrogen sulphide", "2. Bromine", "3. Magnesium", "4.Graphite","5.Mercury"},""));
			
			//Create a Science question Object
			QuizTest obj = new QuizTest(scienceQuestions);
			
			
			
		}
		
		// If Technology is chosen get Technology questions
		else if(events.getSource()== startButton && subject == "Technology"){
			
			//Create Array list
			ArrayList<MCQ> technologyQuestions = new ArrayList<>();
	
			technologyQuestions.add(new MCQ("1. How many computer languages are in use?", new String[] {"2000","5000","50","20"}, "A"));
			
			technologyQuestions.add(new MCQ("2. Which of these is not an early computer?", new String[] {"ENIAC","UNIVAC","NASA","SAGE"}, "C"));
			
			technologyQuestions.add(new MCQ("3. Who founded Apple Computer ?",new String[] {"Stephen Fry","Bill Gates","Steve Jobs","Stephen Hawking"}, "C"));
			
			technologyQuestions.add(new MCQ("4. Which one is not a peripheral, in computer terms?", new String[] {"Keyboard","Monitor","Mouse","Motherboard"}, "D"));
			
			technologyQuestions.add(new MCQ("5. Which of the following is not one of the early “protocols,” or ways to use the Internet?", new String[] {"Blogging","Telnet","Gopher","FTP"}, "A"));
			
			technologyQuestions.add(new MCQ( "Correct Answers for Technology Questions are as follows:", new String[] {"1. 2000", "2. NASA", "3. Steve Jobs", "4.Motherboard","5.Blogging"},""));
			
			
			//Create a Technology question Object
			QuizTest obj = new QuizTest(technologyQuestions);
			
		}
		
		// If Engineering is chosen get Engineering  questions
		else if(events.getSource()== startButton && subject == "Engineering") {
			
			//Create Array list
			ArrayList<MCQ> engineeringQuestions = new ArrayList<>();
			
			
			engineeringQuestions.add(new MCQ("1.What is a substance that attracts a piece of iron?", new String[] {"Core","Magnet","Iron","Cladding"}, "B"));
			
			engineeringQuestions.add(new MCQ("2. What is the ratio of stress to strain?", new String[] {"Elastic modules of ther material","Elastic strength of the material","Ultimate strength of the material","Yield stress of the material"}, "C"));
			
			engineeringQuestions.add(new MCQ("3. What is the unit of work?", new String[] {"Newton meter per second","Newton meter","Newton meter squared","One Newton meter or one Joule"}, "D"));
			
			engineeringQuestions.add(new MCQ("4. Quantities which possesses magnitude are called?", new String[] {"Vector quantities","Magnitude","Direction","Scalar quantities"}, "D"));

			engineeringQuestions.add(new MCQ("5. Efficiency of the machine is the ratio of?", new String[] {"Power output to power input","Power input to power output","Total work done to total energy","Total energy tro total power"}, "A"));
			
			engineeringQuestions.add(new MCQ( "Correct Answers for Engineering Questions are as follows:", new String[] {"1. Magnet", "2. Ultimate strength of the material", "3.One Newton meter or one Joule","4 Scalar Quantities", "5. Power output to power input "},""));
			
			//Create a Engineering question Object
			QuizTest obj = new QuizTest(engineeringQuestions);
			
			
			
		}
		
		// If Mathematics is chosen get Mathematics questions
		else if(events.getSource()== startButton && subject == "Mathematics") {
			
			//Create Array 
			ArrayList<MCQ> mathematicsQuestions = new ArrayList<>();
			
			mathematicsQuestions.add(new MCQ("1. If a + 54 = 5a - 18, then the value of 'a' is?", new String[] {"19","18","27","24"}, "B"));
			
			mathematicsQuestions.add(new MCQ("2. How many digits in Hindu-Arabic System?", new String[] {"10","20","30","40"}, "A"));
			
			mathematicsQuestions.add(new MCQ("3. Among the following which natural number has no predecessor?", new String[] {"100","200","1","0"}, "C"));
			
			mathematicsQuestions.add(new MCQ("4. Which among the following is the largest known number in the world?", new String[] {"âˆž","googol","googolplex","gram"}, "C"));
			
			mathematicsQuestions.add(new MCQ("5. What does 1 googol means?", new String[] {"1 followed by hundred zeros","1 followed by thousand zeros","1 followed by ten thousand zeros","1 followed by 1 lakh zeros"}, "A"));
			
			mathematicsQuestions.add(new MCQ( "Correct Answers for Mathematics Questions are as follows:", new String[] {"1. 18", "2. 10 ", "3. 1", "4. googolplex","5. 1 followed by hundred zeros "},""));
			
			//Create a Mathematics question Object
			QuizTest obj = new QuizTest(mathematicsQuestions);
			
		}
	}
	
}


		
		
			
	
		





