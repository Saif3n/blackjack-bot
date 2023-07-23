package nick.blackjack.dealer;

import java.util.List;

import nick.blackjack.Hand;
import nick.blackjack.Participant;
import nick.blackjack.Player;

/**
 * 
 * You should change this class for Task 2
 *
 */
public class Dealer extends Participant {

	// initialisation of variables
	private List<Player> betPlayers;
	private int mostWins;
	private int mostWinsElement;

	/**
	 * takes variables and assigns them to private variables in Dealer class. this
	 * method does not return anything
	 * 
	 * @param name            of player
	 * 
	 * @param players         is a List type of players
	 * 
	 * @param mostWins        is the highest number of wins
	 * 
	 * @param mostWinsElement is position of player with highest number of wins
	 * 
	 */
	public Dealer(String name, List<Player> players, int mostWins, int mostWinsElement) {
		super(name);
		// assignment of variables so that decideAction can pass them
		this.betPlayers = players;
		this.mostWins = mostWins;
		this.mostWinsElement = mostWinsElement;
	}

	@Override
	public Action decideAction(Hand hand) {

		// calls dealerstrategy, which will output an enum as an action
		int score = hand.getScore();
		return DealerStrategy.dealHigh(betPlayers, mostWins, score, mostWinsElement);
	}

}
