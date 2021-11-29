
public class BattleSimulation {

	public static void main(String[] args) {
		Battle anEpicBattle =
				new Battle(
							new Warrior("Kai", 1000, 10, 50),
							new Warrior("Alec", 1000, 8, 55)
							// name, HP, armor, max damage
							);
		anEpicBattle.fight();
		System.out.println("The winner is " + anEpicBattle.winner()+ "!");

	}

}
