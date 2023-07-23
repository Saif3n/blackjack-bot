package nick.blackjack.bot;

import nick.blackjack.Hand;
import nick.blackjack.Player;

/**
 * you should change this class for TASK 1
 */
public class Bot extends Player {

	private String risk;

	/**
	 * This function takes name of player, and the string, assigning it to Hand
	 * (parent class), and allowing botStrategyStirng to be used in decideAction
	 * 
	 * @param name              of the player
	 * 
	 * @param botStrategyString is the risk
	 * 
	 */
	public Bot(String name, String botStrategyString) {
		super(name);
		this.risk = botStrategyString;
	}

	@Override
	public Action decideAction(Hand hand) {

		// grabbign score from Hand so that it can be passed to BotsFactory
		int score = hand.getScore();
		BotsStrategy riskType = BotsFactory.returnRisk(risk, score);
		return riskType.getRisk(score);
	}

	@Override
	public int makeABet() {
		return BotsFactory.betCalc(risk);

	}
}
