package nick.blackjack.bot;

import java.util.Random;

import nick.blackjack.Participant;

public class BotsLow implements BotsStrategy {

	@Override
	public Participant.Action getRisk(int score) {

		// Returns action depending on score
		if (score >= 17) {
			return Participant.Action.HOLD;
		} else {
			return Participant.Action.HIT;
		}

	}

	@Override
	public int betAmount() {
		// Code adapted from
		// https://www.codegrepper.com/code-examples/java/java+random+number+between+0+and+100
		Random bet = new Random();
		int randomBet = bet.nextInt(50 - 10) + 10;
		return randomBet;
	}

}
