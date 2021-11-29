
public class Battle {
	// instance variables
	private Warrior warriorOne;
	private Warrior warriorTwo;
	private int currentAttacker; // 1 => warriorOne, 2 => warriorTwo
		
	// constructor
	public Battle(Warrior warrior1, Warrior warrior2) {
		warriorOne = warrior1;
		warriorTwo = warrior2;
		
		// randomize who goes first
		Die coin = new Die(2);
		coin.roll();
		currentAttacker = coin.getFaceValue();

	}
		
	// instance methods
	public void fight() {
		// ALLOW warriors to take turns attacking each other
		// as long as the battle is Not over
		while (!isOver()) {
			// whose turn is it? make sure the current attacter
			// attacks the other
			if(currentAttacker == 1) {
				warriorOne.attack(warriorTwo);
			}else {
				warriorTwo.attack(warriorOne);
			}
			// now swithch turns after an attack
			currentAttacker = 3 - currentAttacker;
		}
			
	}
		
	public String winner() {
		// check if the battle is over first
		if(isOver()) {
			// there has to be a winner because
			// this battle is over
			if (warriorOne.isDefeated()) {
				return warriorTwo.getName();
			}else {
				return warriorOne.getName();
			}
		}
		throw new RuntimeException("The battle isn't over!");
			
	}
		
	private boolean isOver() {
		return warriorOne.isDefeated() || warriorTwo.isDefeated();
			
	}

}
