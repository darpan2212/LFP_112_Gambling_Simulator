package com.bridgelabz.gambling;

import java.util.Scanner;

public class Gambler {
		
	public static void main(String[] args) {
	
		double stake = 100;
		int N = 0;
		
		System.out.println("Welcome to Gambling simulator \n");
		System.out.println("Enter number of games to bet your stake :");
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		for (int i = 0; i < N; i++) {
			stake++;;
			System.out.println("You have bet a total stake value of $"+stake);
		}
	sc.close();
	}
	

}
