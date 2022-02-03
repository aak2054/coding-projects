// Anamo Kisho
//This project is a STEM Quiz application that allows users to take a quiz with five questions from
//either Science,Technology,Engineering or Mathematics subjects. The user will make a note of their choices, 
//at the end the user will be able to check their answers base on the Correct Answers displayed for all questions. 
//We went to the PQRC to get assistance
// We used Oracle, GUI package and other resources found on Sakai
//We got our STEM quiz questions from https://www.proprofs.com/quiz-school/story.php?title=geas-quiz ,
//https://www.indiabix.com/general-knowledge/general-science/, https://www.q4quiz.com/math-quiz-questions-
//answers-online-latest-math-quizzes-learn-mathematics/

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		
		// create a new frame
		JFrame QuizFrame1 = new JFrame("STEM QUIZ");

		// when the window is closed, terminate the java application
		QuizFrame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		QuizFrame1.setResizable(false);
		
		// Get contentpane and add to quizpanel1
		QuizFrame1.getContentPane().add(new QuizPanel());

		// pack the frame
		QuizFrame1.pack();

		// make the frame visible
		QuizFrame1.setVisible(true);
		


	}



}

