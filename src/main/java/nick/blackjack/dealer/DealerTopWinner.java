package nick.blackjack.dealer;

import java.util.List;

import nick.blackjack.Participant;
import nick.blackjack.Player;

public class DealerTopWinner implements DealerInterface {

	@Override
	public Participant.Action targetPlayer(List<Player> player, int dealerScore, int mostWinsPosition) {
		// grabs score of current player
		int playerScore = player.get(mostWinsPosition).getHand().getScore();

		// checks if player is bust
		if (playerScore > 21) {
			return Participant.Action.HOLD;
		}

		// Targeting top player, we see that the conditions for win or loss are the
		// same
		if (playerScore <= 21 && !player.get(mostWinsPosition).getHand().isBlackJack()) {
			if (dealerScore < playerScore) {
				return Participant.Action.HIT;
			} else if (dealerScore >= playerScore) {
				return Participant.Action.HOLD;
			}
		}

		if (player.get(mostWinsPosition).getHand().isBlackJack() && dealerScore >= 17) {
			return Participant.Action.HIT;
		} else {
			return Participant.Action.HIT;
		}
	}

}