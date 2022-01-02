//A class with multiple choice questions 
public class MCQ {
	
	//instance variables
	private String Question;
	private String[] Choices;
	private String CorrectAns;
	
	//constructors
	public MCQ(String Question,String[]Choices, String CorrectAns) {
		this.Question = Question;
		this.Choices = Choices;
		this.CorrectAns = CorrectAns;
		
	}
	//instance methods
	public String getQuestion() {
		return this.Question;
	}
	public String[] getChoices() {
		return this.Choices;
	}
	public String getCorrect() {
		return this.CorrectAns;
	}	
	
	
	
	
}
