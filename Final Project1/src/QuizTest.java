import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.TimerTask;
//import javax.swing.Timer;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.*;
import java.awt.*;

public class QuizTest extends QuizPanel implements ActionListener {
	
	//instance variables
		String answer;
		int index;
		int seconds = 10;
		
		
		//Create new frame
		JFrame QFrame = new JFrame();
		
		//create textfield and textarea object
		JTextField Qtextfield = new JTextField();
		JTextArea textarea = new JTextArea();
		JTextArea resultarea = new JTextArea();
		
		JPanel centerPane3 = new JPanel();
		//Create button object
		JButton btnchoiceA = new JButton();
		JButton btnchoiceB = new JButton();
		JButton btnchoiceC = new JButton();
		JButton btnchoiceD = new JButton();
		
		//create answer label object
		JLabel  answe_labelA = new JLabel();
		JLabel  answe_labelB = new JLabel();
		JLabel  answe_labelC = new JLabel();
		JLabel  answe_labelD = new JLabel();
		
		//create time and seconds label object
		JLabel  time_label = new JLabel();
		JLabel  seconds_left = new JLabel();
		
		JTextField number_r = new JTextField();
		JTextField percentage = new JTextField();
		
		//create array list and pass it to MCQ
		private ArrayList<MCQ> questions;
		public int total_q;
		
		//constructor
		public QuizTest(ArrayList<MCQ> questions) {
			this.questions = questions;
			total_q =  questions.size();
			QFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			QFrame.setSize(650,650);
			QFrame.getContentPane();
			QFrame.setLayout(null);
			QFrame.setResizable(false);
			QFrame.setVisible(true);
			
			//create timer and seconds
			new Timer().schedule(new TimerTask(){

			int second = 120;
			
			//timer
			@Override
			public void run() {
				
				
				QFrame.setTitle("TIMER : " + second-- + " seconds.");

			}
			},0, 1000);
			
			
			//set  Qtextfield properties
			Qtextfield.setBounds(0,0,650,50);
			Qtextfield.setBorder(BorderFactory.createBevelBorder(1));
			Qtextfield.setHorizontalAlignment(JTextField.CENTER);
			Qtextfield.setEditable(false);
			
			//add font
			Font font = new Font("Serif", Font.BOLD, 15);
			textarea.setFont(font);
			
			//set textarea properties
			textarea.setBounds(0,50,650,50);
			textarea.setLineWrap(true);
			textarea.setWrapStyleWord(true);
			textarea.setBorder(BorderFactory.createBevelBorder(1));
			textarea.setEditable(false);
			
			
			// set buttons properties
			btnchoiceA.setBounds(0,100,100,100);
			btnchoiceA.setPreferredSize(new Dimension(30, 30));
			btnchoiceA.setFocusable(false);
			btnchoiceA.addActionListener(this);
			btnchoiceA.setText("A");
			
			btnchoiceB.setBounds(0,200,100,100);
			btnchoiceB.setFocusable(false);
			btnchoiceB.addActionListener(this);
			btnchoiceB.setText("B");
			
			btnchoiceC.setBounds(0,300,100,100);
			btnchoiceC.setFocusable(false);
			btnchoiceC.addActionListener(this);
			btnchoiceC.setText("C");
			
			btnchoiceD.setBounds(0,400,100,100);
			btnchoiceD.setFocusable(false);
			btnchoiceD.addActionListener(this);
			btnchoiceD.setText("D");
			
			// set answerlabels bounds
			answe_labelA.setBounds(125,100,500,100);
			answe_labelB.setBounds(125,200,500,100);
			answe_labelC.setBounds(125,300,500,100);
			answe_labelD.setBounds(125,400,500,100);
			
			//add all to Qframe
			QFrame.add(textarea);
			QFrame.add(Qtextfield);
			QFrame.add(seconds_left);
			
			QFrame.add(answe_labelA);
			QFrame.add(answe_labelB);
			QFrame.add(answe_labelC);
			QFrame.add(answe_labelD);
			
			QFrame.add(btnchoiceA);
			QFrame.add(btnchoiceB);
			QFrame.add(btnchoiceC);
			QFrame.add(btnchoiceD);
			
			
			//SET QFrame visible 
			QFrame.setVisible(true);
			
			//next question method
			nextQuestion();
			
	
			
		}
		
		
		
		public void nextQuestion() {
			// get next question and 
			if(index>= total_q) {
				
				
			}
			
			else {
				Qtextfield.setText("STEM QUIZ");
				textarea.setText(questions.get(index).getQuestion());
				String[] choices = questions.get(index).getChoices();
				answe_labelA.setText(choices[0]);
				answe_labelB.setText(choices[1]);
				answe_labelC.setText(choices[2]);
				answe_labelD.setText(choices[3]);
				
			}
			
		}

		

		@Override
		public void actionPerformed(ActionEvent e) {
			
			btnchoiceA.setEnabled(false);
			btnchoiceB.setEnabled(false);
			btnchoiceC.setEnabled(false);
			btnchoiceD.setEnabled(false);
			
			// if correct guesses matches correct answer increment correct guesses
			if(e.getSource()==btnchoiceA ) {
				answer = "A";
				if(answer == questions.get(index).getCorrect()) {
					
				}
			}
			if(e.getSource()==btnchoiceB ) {
				answer = "B";
				if(answer == questions.get(index).getCorrect()) {
				
				}
			}
			if(e.getSource()==btnchoiceC ) {
				answer = "C";
				if(answer == questions.get(index).getCorrect()) {
				
				}
			}
			if(e.getSource()==btnchoiceD ) {
				answer = "D";
				if(answer == questions.get(index).getCorrect()) {
					
				}
			}
			
			//resetChoices method
			resetChoices();
			
			
		}
		
		public void resetChoices() {
			// disables the button
			btnchoiceA.setEnabled(false);
			btnchoiceB.setEnabled(false);
			btnchoiceC.setEnabled(false);
			btnchoiceD.setEnabled(false);
			
			if(answer != "A");
			
			if(answer != "B");
			
			if(answer!= "C");
			
			if(answer!= "D");
			
					
					answer = " ";
					seconds =10;
					seconds_left.setText(String.valueOf(seconds));
					
					//enable the button
					btnchoiceA.setEnabled(true);
					btnchoiceB.setEnabled(true);
					btnchoiceC.setEnabled(true);
					btnchoiceD.setEnabled(true);
					
					//increment index
					index++;
					
					// nextQuestion method
					nextQuestion();
			
			
		}
		
		

	}

