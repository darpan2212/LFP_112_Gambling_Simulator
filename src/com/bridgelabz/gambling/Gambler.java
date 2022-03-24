package com.bridgelabz.gambling;

public class Gambler {
	
	static int win =0;
	static int loss = 0;
	
	public static void main(String[] args) {
		
		double stake_value = 100;
		System.out.println("*********Welcome to the Gambling Simulator...!!!**********");
		System.out.println();
		Gambler gamble = new Gambler();
		for(int day = 1; day<=20; day++) {  // Running for 20 days
			double Daily_Earned_amount = gamble.play(stake_value,day); //calling method to play for everyday
			System.out.println("Total amount after day : " + day + " is : $ " + Daily_Earned_amount );
			System.out.println();
			stake_value  = Daily_Earned_amount + 100; //after finish of every day adding 100$ to the total balance for next day
		}
		System.out.println("******Number of win this month is " + win + "************ Number of lost games this month is " + loss + "**********" );
		
	}
	
	public double play(double stake_value,int day) {
		double ifloststake = 0.5 * stake_value;
		double ifwonstake = 1.5 * stake_value; 
		double daily_won_lose = stake_value;
		
		while(stake_value< ifwonstake && stake_value > ifloststake) {  // Checking the condition to play the game for the day
			int win_lose = (int) Math.floor((Math.random()*2));
			if(win_lose == 1) {
				stake_value = stake_value + 1;
			}else {
				stake_value = stake_value - 1;
			}
		}
		
		if(stake_value>daily_won_lose) {   //checking for games won and lost as well as amount lost or gained
			daily_won_lose = stake_value - daily_won_lose;
			System.out.println("Amount earned for day : " + day + " is  $"+ daily_won_lose);
			win++;
		}else {
			daily_won_lose = daily_won_lose - stake_value;
			System.out.println("Amount lost for day : " + day + " is "+ daily_won_lose);
			loss++;
		}
		return stake_value;
	}
}
