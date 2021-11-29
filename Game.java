// Anamo Kisho
// This program will start with N number of coins and two players will play the game by taking one turn at a time and each player are allowed to take 1,2,3 coins and 
// the player who has no more coins to remove from the pile of coins loses.
// I worked on this assigment with Catlyn
// I exercised Gilligan's Island rule

public class Game {
	// instance variables
	private Player leftPlayer;
	private Player rightPlayer;
	private int   startingCoins;
	private int currentCoins;
	private int numberOfTurns;
	private boolean leftPlayerTurn; 


	// constructor
	public Game(int initialcoin, Player Player1, Player Player2) {
		startingCoins = initialcoin;
		currentCoins=initialcoin;
		leftPlayer = Player1;
		rightPlayer = Player2;
		// leftPlayer -- 1 and rightPlayer 2
		Die turn = new Die(2);
		turn.roll();
		if(turn.getFaceValue()==1) {
			leftPlayerTurn = true;
		}else {
			leftPlayerTurn = false;
		}

	}


	// instance methods
	public String getLeftPlayerName() {
		// get player one name
		return leftPlayer.getName();

	}
	public int getLeftPlayerCoins() {
		// get the number of coins player one has
		return leftPlayer.getCoins();

	}
	public String getRightPlayerName() {
		// get player two name
		return rightPlayer.getName();

	}
	public int getRightPlayerCoins() {
		// get the number of coins player two has
		return rightPlayer.getCoins();

	}
	public int getTurns() {
		// returns the number of turns so far
		return numberOfTurns;
	}

	public String winner() {
		// returns the left player's name if the left player won, the right player's name if the right player won. If the game isn't over yet, it throws an exception.
		if(isOver()) {
			if(leftPlayerTurn == false) {
				return leftPlayer.getName();
			}else {
				return rightPlayer.getName();
			}
		}
		throw new RuntimeException("The game isn't over!");
	}

	public void play() {
		// lets two players take turns until the game is over. // use the playOneTurn method to implement the play method
		if(!isOver()) {
			playOneTurn();
		}
	}

	public void reset() {
		// reset the game (set the number of coins on the table to the initial number of coins) and also decide who goes first randomly
		currentCoins = startingCoins;
		leftPlayer.resetCoins();
		rightPlayer.resetCoins();
		numberOfTurns = 0;
		
		// randomize who will go again
		Die turn = new Die(2);
		turn.roll();
		if(turn.getFaceValue()==1) {
			leftPlayerTurn = true;
		}else {
			leftPlayerTurn = false;
		}


	}
	private void playOneTurn() {
		// it lets the next player to play a turn. throws an exception if the game is over
		// randomize who goes first
		if (isOver()) {
			throw new RuntimeException("The game is over!");
		}
		while (!isOver()) {
			if (leftPlayerTurn== true) {
				currentCoins-= leftPlayer.takeCoins(currentCoins);
				leftPlayerTurn = false;
			}else{
				leftPlayerTurn = true;
				currentCoins-= rightPlayer.takeCoins(currentCoins);;
			}
		
			numberOfTurns +=1;}




	}
	private int getCoinsLeft() {
		// get the coins that still remain
		return currentCoins;
	}
	private boolean isOver() {
		// returns true when the game is over (no more coins left on the table)
		// if getcoinsleft is 0 return true alse continue
		if (getCoinsLeft() == 0) {
			return true;
		}else {
			return false;
		}
	}


}
