package com.bridgelabz.gambling;

public class Gambler {

	static double stakeValue = 100;
	private int play;
	static int day = 0;

	public void dailyPlay() {
		double totalDailyAmount = 0;

		Gambler gamble = new Gambler();
		for (int day = 0; day <= 20; day++) {
			totalDailyAmount = gamble.gamePlay(stakeValue,
					day);
			System.out.println(
					"The total daily amount won for day "
							+ day + " is $"
							+ totalDailyAmount);
		}
		stakeValue = totalDailyAmount + 100;
	}

	public double gamePlay(double stakeValue, int day) {

		double stakeWin = stakeValue * 1.5;
		double stakeLose = stakeValue * 0.5;

		while (stakeValue < stakeWin
				&& stakeValue > stakeLose) {
			play = (int) Math.floor((Math.random()) * 2);
			double amount_win_lose = stakeValue;
			if (play > 0.5) {
				stakeValue = stakeValue + 1;
				System.out.println(
						"Hurray!!! you have won this play,your current stakeValue is :$"
								+ stakeValue);
			} else {
				stakeValue = stakeValue - 1;
				System.out.println(
						"Oops!!! you lose this play,your current stakeValue is :$"
								+ stakeValue);
			}
			play++;
			if (amount_win_lose > stakeValue) {
				amount_win_lose = stakeValue
						+ amount_win_lose;
				System.out.println("The amount won for day "
						+ day + " is : $"
						+ amount_win_lose);
			} else if (amount_win_lose < stakeValue) {
				amount_win_lose = stakeValue
						- amount_win_lose;
				System.out
						.println("The amount lost for day "
								+ day + " is : $"
								+ amount_win_lose);

			}
			System.out.println(
					"You have bet a total stake value of $"
							+ stakeValue);
			System.out.println("===========================================");

		}

		System.out.println(
				"You have reached the maximum amount of your game value,Please end your game");

		return (stakeValue);
	}

	public static void main(String[] args) {

		System.out.println(
				"Welcome to Gambling simulator \n");
		Gambler gambler = new Gambler();
		gambler.dailyPlay();
	}

}