package com.bridgelabz.gambling;

public class Gambler {

	static int stakeAmount = 100;
	static int bet = 1;
	int maxWinDay = 0;
	int maxLooseDay = 0;
	static int luckyDay;
	static int unluckyDay;
	static int win = 0;
	static int loose = 0;

	public int winOrLoose(int day, int stakeAmount) {
		int dailyGame = stakeAmount;

		while (stakeAmount < 150 && stakeAmount > 50) { // UC3 Checking the condition to play the game for the day
			int random = (int) Math.floor((Math.random() * 2));// UC2 win or lose
			if (random == 1) {
				stakeAmount++;
				System.out.println("You are Won " + "and amount is " + stakeAmount);
			} else {
				stakeAmount--;
				System.out.println("You are Loose " + "and amount is " + stakeAmount);
			}
		}

		if (stakeAmount > dailyGame) {
			dailyGame = stakeAmount - dailyGame;
			System.out.println("Amount earned for day : " + day + " is " + dailyGame + "$");
			if (dailyGame > maxWinDay) { // UC6 - To know the day when you won Maximum
				maxWinDay = dailyGame;
				luckyDay = day;
			}
			win++;
		} else {
			dailyGame = dailyGame - stakeAmount;
			System.out.println("Amount lost for day : " + day + " is " + dailyGame + "$");
			if (dailyGame > maxLooseDay) { // UC6 - To know the day when you won Maximum
				maxLooseDay = dailyGame;
				unluckyDay = day;
			}
			loose++;
		}
		return stakeAmount;
	}

	public int playingForMonth() {
		Gambler gambler = new Gambler();
		for (int day = 1; day <= 20; day++) { // UC4 - Playing for 20 days a month
			int earnedAmount_daily = gambler.winOrLoose(stakeAmount, day);
			System.out.println("Total amount after day : " + day + " is : " + earnedAmount_daily + "$");
			stakeAmount = earnedAmount_daily + 100;
		}
		return (stakeAmount - 100);
	}

	public static void main(String[] args) {
		System.out.println("*********Welcome to the Gambling Simulator**********");
		Gambler gambler = new Gambler();
		gambler.winOrLoose(bet, stakeAmount);
		int stakeValue = gambler.playingForMonth();
		System.out.println("******Number of win this month is " + win
				+ "************ Number of lost games this month is " + loose + "**********");
		System.out.println(
				"******Lucky day is : DAY " + luckyDay + "********* Unlucky day is : DAY " + unluckyDay + "*********");
		System.out.println();
		int investMonthly = 20 * 100; // 100$ per day invested so in a month it is 2000 $
		if (stakeValue > investMonthly) { // UC7 - Earned amount is more than the monthly investment and play again else
											// exit the game.
			System.out.println("You have won for last month!! So play next month also!!");
			gambler.playingForMonth();
		} else {
			System.out.println("You have face a loss last month!! Please exit the Game!!");
		}

	}
}
