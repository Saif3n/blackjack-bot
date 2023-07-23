package nick.blackjack.dealer;

import java.util.List;

import nick.blackjack.Participant;
import nick.blackjack.Player;

public interface DealerInterface {

	/**
	 * This method will take inputs and return the corresponding actions in the form
	 * of an enum.
	 * 
	 * @param player is a list of the players
	 * 
	 * @param dealerScore is the score of the dealer
	 * 
	 * @param mostWinsPosition is the position of the player, represented in int
	 * 
	 * @return an enum in the form of an action
	 * 
	 */

	public Participant.Action targetPlayer(List<Player> player, int dealerScore, int mostWinsPosition);

}
