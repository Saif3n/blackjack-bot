package nick.blackjack;

import java.util.Scanner;

/**
 * 
 * You cannot modify this class
 *
 */
public class Main {

	// I created this public static Scanner for testing reason, do not pay too much
	// attention
	public static Scanner scanner = new Scanner(System.in);

	public static void printBlackJack() {
		System.out.println("      _     _            _    _            _    \n"
				+ "     | |   | |          | |  (_)          | |   \n"
				+ "     | |__ | | __ _  ___| | ___  __ _  ___| | __\n"
				+ "     | '_ \\| |/ _` |/ __| |/ / |/ _` |/ __| |/ /\n"
				+ "     | |_) | | (_| | (__|   <| | (_| | (__|   < \n"
				+ "     |_.__/|_|\\__,_|\\___|_|\\_\\ |\\__,_|\\___|_|\\_\\\n"
				+ "                            _/ |                \n"
				+ "                           |__/                 \n" + "\n"
				+ ".------..------..------..------..------..------..------.\n"
				+ "|N.--. ||I.--. ||C.--. ||K.--. || .--. ||W.--. ||U.--. |\n"
				+ "| :/\\: || :/\\: || :(): || :/\\: || (\\/) || :(): || :/\\: |\n"
				+ "| :\\/: || :\\/: || ()() || (__) || :\\/: || ()() || :\\/: |\n"
				+ "| '--'N|| '--'I|| '--'C|| '--'K|| '--' || '--'W|| '--'U|\n"
				+ "`------'`------'`------'`------'`------'`------'`------'\n" + "\n"
		);
	}

	public static void main(String[] args) {
		printBlackJack();
		BlackJack game = new BlackJack();
		game.start();
	}

}
