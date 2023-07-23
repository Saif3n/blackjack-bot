package nick.blackjack.dealer;

import java.util.List;

import nick.blackjack.Participant;
import nick.blackjack.Player;

public class DealerHighBidder implements DealerInterface {

	@Override
	public Participant.Action targetPlayer(List<Player> player, int dealerScore, int mostWinsPosition) {

		// initialisation of variables
		int largestElement = 0;
		int largestScore;

		// loops through player list to find largest bet
		for (int i = 0; i < player.size() - 1; i++) {
			if ((player.get(largestElement).getHand().getBet()) < (player.get(i + 1).getHand().getBet())) {
				// assigns to new position if bet is larger than current one
				largestElement = i + 1;
			}
		}

		largestScore = player.get(largestElement).getHand().getScore();

		// checks if player busted
		if (largestScore > 21) {
			return Participant.Action.HOLD;
		}

		// checks if player isn't blackjack, and so dealer will hit (as same score means
		// dealer wins if player isn't blackjack)
		if (largestScore <= 21 && !player.get(largestElement).getHand().isBlackJack()) {
			if (dealerScore < largestScore) {
				return Participant.Action.HIT;
			} else if (dealerScore >= largestScore) {
				return Participant.Action.HOLD;
			}
		}

		// if player is blackjack, and dealer score is greater than 17, hold
		if (player.get(largestElement).getHand().isBlackJack() && dealerScore >= 17) {
			return Participant.Action.HOLD;
		} else {
			return Participant.Action.HIT;
		}

	}

}
