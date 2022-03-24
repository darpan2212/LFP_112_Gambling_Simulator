package com.bridgelabz.gambling;

import java.lang.Math;

public class Gambler {
	final int each_stake_value = 1;
	final int initial_stake = 100;
	
	public static void main(String[] args) {
		double initial_stake = 100;
		System.out.println("Welcome to the gambling Problem!!!");
		Gambler gamble = new Gambler();
		gamble.play(initial_stake);
	}
	
	public void play(double stake) {
		double ifloststake = 0.5 * initial_stake;
		double ifwonstake = 1.5 * initial_stake;  
		while(stake< ifwonstake && stake > ifloststake) {  // Checking the condition to play the game for the day
			boolean won = win_lose_decide(stake);
			if(won == true) {
				System.out.println("You have won the game!!");
				stake = stake + 1;
			}else {
				System.out.println("You have lost the game");
				stake = stake - 1;
			}
			System.out.println("Your amount after current game is : " + stake);
			System.out.println();
		}
	}
	
	public boolean win_lose_decide (double initial_stake) {
		int win_lose = (int) Math.floor((Math.random()*2));
		if(win_lose == 1) {
			return true;
		}
		else{
			return false;
		}
	}
}