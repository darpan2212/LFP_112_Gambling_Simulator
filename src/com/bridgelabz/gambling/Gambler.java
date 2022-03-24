package com.bridgelabz.gambling;


public class Gambler {
	
	double stake=100;
	double betPrice=1;
	double stakeValue=stake;
	int numberOfPlays=0;
	int numberOfWin=0;
	int numberOfLoss=0;
	double goal=150;
	
	public static void main(String[] args) {
		Gambler gd = new Gambler();
		gd.playGame(); 
		gd.showResult();
	}
		public void showResult()
		{
		System.out.println("Number of time Game played is:"+numberOfPlays);
		System.out.println("stake is:"+stake);
		System.out.println("stackValue is:"+stakeValue);
		System.out.println("Goal is:"+goal);
		System.out.println("Bet Price is:"+betPrice);
		System.out.println("Number of Win is:"+numberOfWin);
		System.out.println("Number of Loss is:"+numberOfLoss);
		System.out.println("Ammount of Win and Loss is:"+(stake-stakeValue));

		}
		
	
	
	public boolean winOrLoss() {
		if(Math.random()<0.5)
			return true;
		else
			return false;
			
		
	}
	public void playGame() {
		numberOfPlays++;
		if(winOrLoss()) {
			numberOfWin++;
			stake=stake+betPrice;
				}else {
					numberOfLoss++;
					stake=stake-betPrice;
				}
		if(stake<=50 || stake>=goal)
			return;
		else
			playGame();
		
	}
}

