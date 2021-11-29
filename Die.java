import java.util.Random;

public class Die {
	// attributes/ properties
	// instance variables
	private int numberOfSides;
	private int faceValue;
	private Random randomizer;
	
	
	// How to create a die object
	// constructors
	public Die(int sides) {
		numberOfSides = sides;
		// this. to use the same name
		randomizer = new Random();
		roll();

	}
	
	// default constructors
	public Die() {
		/*
		numberOfSides = 6;
		randomizer = new Random();
		roll();
		*/
		this(20);
		// to reuse constructors we can use this. to refer to other constructors
	}
	// behaviors/methods
	// instance methods 
	public int getNumberOfSides() {
		return numberOfSides;
		
	}
	// getfaceValue method
	public int getFaceValue() {
		return faceValue;
	}
	
	// roll method
	public void roll() {
		// compute a random face value based on the number of sides 
		faceValue = randomizer.nextInt(numberOfSides) + 1;
		
		
	}

}
