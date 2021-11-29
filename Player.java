// Anamo Kisho
// This program will start with N number of coins and two players will play the game by taking one turn at a time and each player are allowed to take 1,2,3 coins and 
// the player who has no more coins to remove from the pile of coins loses.
// I worked on this assigment with Catlyn
// I exercised Gilligan's Island rule
public class Player {
	// instance variables
	private String name;
	private int coins;
	
	// constructor
	public Player(String name1) {
		name = name1;
	}
	
	// instance methods
	// it will return the name of the player
	public String getName() {
		return name;
	}
	// this method the player will randonly chose 1 or 2 or 3 but if the coinOnTheTable is less than 3 he can not take 3 and if it is 1 can not take 2 and it will add each player coins 
	public int takeCoins(int coinOnTheTable) {
		int countCoin = 0;
		if (coinOnTheTable == 1) {
			coins += 1; 
			countCoin =1;
		}
		if (coinOnTheTable == 2) {
			Die coin = new Die(2);
			coin.roll();
			coins += coin.getFaceValue(); 
			countCoin = coin.getFaceValue();
			//return coins;
		}
		if(coinOnTheTable >= 3) {
			Die coin = new Die(3);
			coin.roll();
			coins += coin.getFaceValue();
			countCoin = coin.getFaceValue();
			//return coins;
			}
		return countCoin;		
		
	}
	
	// it will return how many coins a player has
	public int getCoins() {
		return coins;
		
	}
	 // will reset the coins taken to 0
	public void resetCoins() {
	  coins= 0;
		
	}

}
