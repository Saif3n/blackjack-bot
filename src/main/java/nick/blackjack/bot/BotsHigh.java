package nick.blackjack.bot;

import java.util.Random;

import nick.blackjack.Participant;

public class BotsHigh implements BotsStrategy {

	@Override
	public Participant.Action getRisk(int score) {
		// high risk strategy
		if (score >= 19) {
			return Participant.Action.HOLD;
		} else {
			return Participant.Action.HIT;
		}

	}

	@Override
	public int betAmount() {
		// random number between 50 and 100
		Random bet = new Random();
		int randomBet = bet.nextInt(100 - 50) + 50;
		return randomBet;
	}

}
