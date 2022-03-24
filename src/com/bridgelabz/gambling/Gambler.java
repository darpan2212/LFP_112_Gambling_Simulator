package com.bridgelabz.gambling;

import java.util.Scanner;

public class Gambler {

	double stake = 100;
	int N = 0;
	double stakeValue;

	public void gamePlay() {

		System.out.println(
				"Enter number of games to bet your stake :");
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		for (int i = 0; i < N; i++) {
			double play = Math.random() * 2;

			if (play > 0.5) {
				stake += 1;
				System.out.println(
						"Hurray!!! you won, your stake value is :"
								+ stake);
			} else {
				stake -= 1;
				System.out.println(
						"Oops!!! you lose, your stake value is :"
								+ stake);
			}
			System.out.println(
					"You have bet a total stake value of $"
							+ stake);
		}
		sc.close();
	}

	public static void main(String[] args) {

		System.out.println(
				"Welcome to Gambling simulator \n");

		Gambler gambler = new Gambler();
		gambler.gamePlay();
	}
}