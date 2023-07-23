package nick.blackjack;

/**
 * 
 * You can (and should) add new fields and/or methods
 *
 */
public abstract class Player extends Participant {

	public Player(String name) {
		super(name);
	}

	public abstract int makeABet();

}