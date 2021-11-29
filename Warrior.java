
public class Warrior {
	// instance variables
		private String name;
		private int hp;
		private int armor;
		private Die hitDie;
		private Die damageDie;
		
		// constructor
		public Warrior(String warriorName, int initialHP, int warriorArmor, int maxDamage) {
			name = warriorName;
			hp = initialHP;
			armor = warriorArmor;
			hitDie = new Die(20);
			damageDie = new Die(maxDamage);
			

		}
		
		// instance methods
		public String getName() {
			return name;
		
		}
		
		public boolean isDefeated() {
			return hp <= 0;
			
		}
		
		// X attacks Y
		// X.attack(Y)
		public void attack(Warrior opponent) {
			// roll  a hit die
			hitDie.roll();
			int hitCheck = hitDie.getFaceValue();
			// opponent tries to dodge my attack
			if(opponent.tryToDodge(hitCheck)) {
				// oppent dodges my attack\
				System.out.println(
						getName() + " tries to attack " + opponent.getName() + " but misses." );
			}else {
				// my attack lands or is successful
				opponent.takeDamage(computeDamage(hitCheck));
			}
			
			
			
		}
		
		private void takeDamage(int damage) {
			// reduce my hp based on the given damage amount
			hp -= damage; // hp= hp - damage
			
			System.out.println(
					getName() + " takes " + damage + " damage! OUCH! The current HP is " + hp + ".");
			
			
		}
		
		// Y tries to dodge X's attack
		// Y.tryToDodge(X's hit check value)
		private boolean tryToDodge(int hitCheck) {
			return armor > hitCheck;
			
		}
		
		private int computeDamage(int hitCheck) {
			damageDie.roll();
			int damage = damageDie.getFaceValue();
			// is it a critical attack?
			if (hitCheck == 20) {
				// double the damage
				damage *=2; // damage = damage * 2
				System.out.println(getName()+ "'s CRITICAL ATTACK!");
			}
			return damage;
			
		}

}
