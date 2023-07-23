package nick.blackjack.bot;

import java.util.Random;

import nick.blackjack.Participant;

public class BotsRandom implements BotsStrategy {

	@Override
	public Participant.Action getRisk(int score) {

		// allows us to generate random number between 0 and 1
		Random decision = new Random();
		int randomDecision = decision.nextInt(1) + 1;

		// random number assigned to hit or hold
		if (randomDecision == 1) {
			return Participant.Action.HIT;
		} else {
			return Participant.Action.HOLD;
		}
	}

	@Override
	public int betAmount() {
		// Code adapted from
		// https://www.codegrepper.com/code-examples/java/java+random+number+between+0+and+100
		Random bet = new Random();
		int randomBet = bet.nextInt(100) + 1;
		return randomBet;
	}

}
