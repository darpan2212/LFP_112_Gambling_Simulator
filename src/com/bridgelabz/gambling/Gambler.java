package com.bridgelabz.gambling;

public class Gambler {
	
	static int win =0;
	static int loss = 0;
	static int lucky_day;
	static int unlucky_day;
	double max_win_day=0;
	double max_lose_day=0;
	int daily_win =0;
	int daily_lose=0;
	double stake_value = 100;
	
	
	public static void main(String[] args) {
		double monthly_investment = 20*100; //100$ per day invested so in a month it is 2000 $
		System.out.println("*********Welcome to the Gambling Simulator...!!!**********");
		System.out.println();
		Gambler gamble = new Gambler();
		double stake_value = gamble.playForMonth();
		System.out.println("******Number of win this month is " + win + "************ Number of lost games this month is " + loss + "**********" );
		System.out.println("******Lucky day is : DAY " + lucky_day + "********* Unlucky day is : DAY " + unlucky_day + "*********");
		System.out.println();
		if(stake_value>monthly_investment) {  //UC7, IF earned amount is more than the monthly investment play again else exit the game
			System.out.println("You have won for last month!! So play next month also!!");
			gamble.playForMonth();
		}else {
			System.out.println("You have face a loss last month!! Please exit the Game!!");
		}
	}
	
	public double play(double stake_value,int day) {
		double ifloststake = 0.5 * stake_value;
		double ifwonstake = 1.5 * stake_value; 
		double daily_won_lose = stake_value;
		while(stake_value< ifwonstake && stake_value > ifloststake) {  // UC3 Checking the condition to play the game for the day
			int win_lose = (int) Math.floor((Math.random()*2)); //UC2 Deciding win or lose
			if(win_lose == 1) {
				stake_value = stake_value + 1;
			}else {
				stake_value = stake_value - 1;
			}
		}
		if(stake_value>daily_won_lose) {   //checking for games won and lost as well as amount lost or gained
			daily_won_lose = stake_value - daily_won_lose;
			System.out.println("Amount earned for day : " + day + " is  $"+ daily_won_lose);
			if( daily_won_lose > max_win_day) {  //UC6 , To know the day when you won Maximum
				max_win_day = daily_won_lose;
				lucky_day = day;
			}
			win++;
		}else {
			daily_won_lose = daily_won_lose - stake_value;
			System.out.println("Amount lost for day : " + day + " is "+ daily_won_lose);
			if( daily_won_lose > max_lose_day) { //UC6 , To know the day when you lost Maximum
				max_lose_day = daily_won_lose;
				unlucky_day = day;
			}
			loss++;
		}
		return stake_value;
	}
	
	public double playForMonth() {
	Gambler gamble = new Gambler();
	for(int day = 1; day<=20; day++) {  // UC 4 Playing for 20 days a month
		double Daily_Earned_amount = gamble.play(stake_value,day); //calling method to play for everyday
		System.out.println("Total amount after day : " + day + " is : $ " + Daily_Earned_amount ); //Printing total amount earned after each day
		System.out.println();
		stake_value  = Daily_Earned_amount + 100; //UC1 after finish of every day adding 100$ to the total balance for next day
	}
	return (stake_value-100);
	}
}
