package com.bridgelabz.gambling;

public class Gambler {

	double stakeValue = 100;
	private int play;

	public void gamePlay() {

		double stakeWin = stakeValue * 1.5;
		double stakeLose = stakeValue * 0.5;
		
		while (stakeValue < stakeWin
				&& stakeValue > stakeLose) {
			play = (int) Math.floor((Math.random()) * 2);

			System.out.println(play);

			if (play > 0.5) {
				stakeValue = stakeValue + 1;
				System.out.println(
						"Hurray!!! you have won his play");
			} else {
				stakeValue = stakeValue -1;
				System.out.println(
						"Oops!!! you lose this play. try Again..");
			}
			play++;
			System.out.println(
					"You have bet a total stake value of $"
							+ stakeValue);
		}
	}

	public static void main(String[] args) {

		System.out.println(
				"Welcome to Gambling simulator \n");

		Gambler gambler = new Gambler();
		gambler.gamePlay();
		System.out.println("You have reached the maximum amount of your game,Please end your game");
	}
}