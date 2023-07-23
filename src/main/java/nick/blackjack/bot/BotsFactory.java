package nick.blackjack.bot;

public class BotsFactory {

	/**
	 * Takes the string entered at the start and passes through a switch case, where
	 * it is assigned to the corresponding class
	 * 
	 * @param riskRandom is the name of the strategy picked at the start
	 * 
	 * @param score      is the score of the current hand
	 * 
	 * @return will return the action as a form of enum
	 * 
	 */

	public static BotsStrategy returnRisk(String riskRandom, int score) {

		// switch cases for each strategy will return enum for the respective action
		switch (riskRandom) {
		case "HR":
			return new BotsHigh();

		case "LR":
			return new BotsLow();

		case "R":
			return new BotsRandom();

		default:
			return null;
		}
	}

	/**
	 * Takes the string entered at the start and passes through a switch case, where
	 * it is assigned to the corresponding class
	 * 
	 * @param riskRandom is the name of the strategy picked at the start
	 * 
	 * @return will return an integer (the bet amount)
	 * 
	 */

	public static int betCalc(String riskRandom) {

		// switch cases for each strategy will return the bet amount
		switch (riskRandom) {
		case "HR":
			// create objects for each respective strategy
			BotsHigh riskHigh = new BotsHigh();
			return riskHigh.betAmount();

		case "LR":
			BotsLow riskLow = new BotsLow();
			return riskLow.betAmount();

		case "R":
			BotsRandom riskRand = new BotsRandom();
			return riskRand.betAmount();

		default:
			return 0;
		}
	}

}