package com.bridgelabz.gambling;

public class Gambler {

	//Initialing variables
	static int dailyStake = 100;
	static int betInDollar = 1;

	public static void main(String[] args) {
		System.out.println("*********Welcome To Gambling Simulation************");
		
		int random = (int) ((Math.random() * 10) % 2);
		if(random == 1) {
			dailyStake++;
			System.out.println("Won");
		}else {
			dailyStake--;
			System.out.println("Loose");
		}

		System.out.println("Total daily Stake is : " + dailyStake);
		System.out.println("Betting Dollar for every game : " + betInDollar);
	}
}
