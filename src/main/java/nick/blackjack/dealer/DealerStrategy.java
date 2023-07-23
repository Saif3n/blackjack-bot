package nick.blackjack.dealer;

import java.util.List;

import nick.blackjack.Participant;
import nick.blackjack.Player;

public class DealerStrategy {

	/**
	 * dealHigh is part of a strategy design pattern which takes variables and
	 * assigns them to the class accordingly
	 * 
	 * @param player           is the list of each player
	 * 
	 * @param mostWins         is the highest number of wins amongst all players
	 * 
	 * @param dealerScore      is the score of the dealer
	 * 
	 * @param mostWinsPosition is the position of the player with the highest number
	 *                         of wins
	 * 
	 * 
	 * @return an action (in the form of an enum)
	 * 
	 */
	public static Participant.Action dealHigh(List<Player> player, int mostWins, int dealerScore, int mostWinsPosition) {

		// players with net wins of at least 2 will enter the topwinner strategy
		if (mostWins >= 2) {
			DealerTopWinner stratWin = new DealerTopWinner();
			// returns an enum action
			return stratWin.targetPlayer(player, dealerScore, mostWinsPosition);

		} else {
			DealerHighBidder stratBid = new DealerHighBidder();
			return stratBid.targetPlayer(player, dealerScore, mostWinsPosition);
		}

	}
}
