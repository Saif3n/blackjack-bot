package nick.blackjack;

import java.util.ArrayList;
import java.util.List;

import nick.blackjack.bot.Bot;
import nick.blackjack.dealer.Dealer;

/**
 * Unless it is specified in the JavaDoc, you cannot change any methods.
 * 
 * You can add new methods and/or new instance fields
 */
public class BlackJack {

	// Initialisation of variables
	private List<Player> players;
	private int[] winList = new int[3];
	private int[] lossList = new int[3];
	private Dealer dealer;
	private Deck deck;
	private int mostWinsPosition;
	private int netWins;

	public BlackJack(Deck deck) {
		this.deck = deck;
		players = new ArrayList<>();
		players.add(new Human("Player1")); // add the Human player first.
	}

	/**
	 * This constructor is for testing reasons
	 * 
	 * @param cards
	 */
	protected BlackJack(Card... cards) {
		this(new Deck(cards));

	}

	public BlackJack() {
		this(new Deck());
	}

	public List<Player> getPlayers() {
		return players;
	}

	private String getBotStrategy() {
		System.out.println("Choose Bot strategy: random (R) - low risk (LR) - high risk (HR)");
		String result = Main.scanner.next();
		while (!result.equals("R") && !result.equals("LR") && !result.equals("HR") && !result.equals("A")) {
			System.out.println("please type \"R\", \"LR\",  \"HR\"");
			result = Main.scanner.next();
		}
		return result;
	}

	// do not change this method
	public void start() {
		initBots();
		initDealer();
		String res;
		int round = 0;
		do {
			round++;
			for (Participant p : players) {
				p.play(deck, round);
			}
			dealer.play(deck, round);
			printAndUpdateResults(round); // after each game print result and update scoreboard
			System.out.println("Do you want to play again?");
			res = Main.scanner.next();
			while (!res.equals("yes") && !res.equals("no")) {
				System.out.println("please type either \"yes\" or \"no\"");
				res = Main.scanner.next();
			}
		} while (res.equals("yes"));
		printGameStatistics(); // when the user terminates the game print the statistics
	}

	/**
	 * This method initializes the Bots, getting the risk input and passing to bot
	 * class. Players.add(bot) also adds bots to Participant
	 */
	protected void initBots() {
		String botStrategyString = getBotStrategy();

		Bot bot1 = new Bot("Bot1", botStrategyString);
		Bot bot2 = new Bot("Bot2", botStrategyString);

		players.add(bot1);
		players.add(bot2);

	}

	/**
	 * This method initializes the Dealer, passing player list, netwins, and the
	 * position of the mostWins
	 */
	protected void initDealer() {
		// set the initial strategy using the Strategy pattern
		dealer = new Dealer("Dealer", players, netWins, mostWinsPosition);

	}

	/**
	 * This method assigns wins and losses to an array. A win will increment the
	 * array element by one and a loss decreases it by one (as according to netwins
	 * = numwins minus numloss). The array is then passed into the dealer class so
	 * that a strategy can be determined. Method then prints game statistics after
	 * each round
	 * 
	 * @param round is the round number
	 * 
	 * 
	 */
	protected void printAndUpdateResults(int round) {

		// Initialisation of variables
		int i;
		int[] winOrLoss = new int[3];
		int betAmount;
		String namePlayer;

		// Loops through ArrayList to determine win or loss through if statements
		for (i = 0; i < players.size(); i++) {

			// Specific if conditionals to account for win or loss
			if (players.get(i).getHand().getScore() > 21) {
				winList[i] = winList[i];
				lossList[i] = lossList[i] + 1;
				winOrLoss[i] = 0;
				// We'll assign loss or win to 0, which will be reinitialised every round.
			} else if (dealer.getHand().getScore() > 21 && players.get(i).getHand().getScore() <= 21) {
				winList[i] = winList[i] + 1;
				winOrLoss[i] = 1;

			} else if (players.get(i).getHand().isBlackJack() && !dealer.getHand().isBlackJack()) {
				winList[i] = winList[i] + 1;
				winOrLoss[i] = 1;

			} else if (!players.get(i).getHand().isBlackJack() && dealer.getHand().isBlackJack()) {
				winList[i] = winList[i];
				lossList[i] = lossList[i] + 1;
				winOrLoss[i] = 0;

			} else if (players.get(i).getHand().getScore() > dealer.getHand().getScore()) {
				winList[i] = winList[i] + 1;
				winOrLoss[i] = 1;

			} else if (players.get(i).getHand().getScore() <= dealer.getHand().getScore()) {
				winList[i] = winList[i];
				lossList[i] = lossList[i] + 1;
				winOrLoss[i] = 0;

			}
		}

		// Assigns mostWinsPosition to index, so that the largest element can be found
		mostWinsPosition = 0;
		for (i = 0; i < players.size(); i++) {
			if (winList[i] > winList[mostWinsPosition]) {
				mostWinsPosition = i;

			}
		}

		// Loop through array and make all elements 0 if negative
		for (i = 0; i < players.size(); i++) {
			if (winList[i] < 0) {
				winList[i] = 0;
			}
		}

		// Getting net win amount
		netWins = winList[mostWinsPosition] - lossList[mostWinsPosition];

		// Passing to dealer to determine strategy
		dealer = new Dealer("Dealer", players, netWins, mostWinsPosition);

		// Grabs name of player and prints whether they won or not
		for (i = 0; i < players.size(); i++) {

			betAmount = players.get(i).getHand().getBet();
			namePlayer = players.get(i).getName();

			// Use winOrLoss array to see if round was won or lost, namePlayer means that
			// playername isn't hard coded
			if (winOrLoss[i] == 1) {
				System.out.println("Round " + round + ": " + namePlayer + " won " + betAmount + " chips");
			} else if (winOrLoss[i] == 0) {
				System.out.println("Round " + round + ": " + namePlayer + " lost " + betAmount + " chips");
			}

		}

	}

	/**
	 * Method prints game statistics when the game ends, with the name of the player
	 * changing depending on element in array
	 */
	protected void printGameStatistics() {
		int i;
		String namePlayer;

		for (i = 0; i < players.size(); i++) {
			namePlayer = players.get(i).getName();
			System.out.println(namePlayer + " won " + winList[i] + " times and lost " + lossList[i] + " times");

		}
	}

}
