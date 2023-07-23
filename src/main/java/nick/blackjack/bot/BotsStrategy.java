package nick.blackjack.bot;

import nick.blackjack.Participant;

public interface BotsStrategy {

	/**
	 * Takes input of score determines whether bot should hit or hold, depending on
	 * the strategy and the score
	 * 
	 * @param score of current player hand
	 * 
	 * @return the action Enum
	 */
	public Participant.Action getRisk(int score);

	/**
	 * Returns the randomised bet amount depending on the strategy.
	 * 
	 * @return the betamount
	 * 
	 */
	public int betAmount();
}
