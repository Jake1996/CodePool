package CodePool;

import java.util.Scanner;
/**
 * Input : The no of different coins followed by the value of each coin and finaly the amount for which change is required
 * Output : The min no of coins required to pay the amount
 * @author jatin
 *
 */
public class CoinChange {
	/**
	 * array to store the min coins required (index is the amount
	 */
	public static int change[];
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n,coins[],amount;
		n = in.nextInt();
		coins = new int[n];
		for(int i=0;i<n;i++) {
			coins[i] = in.nextInt();
		}
		amount = in.nextInt();
		change = new int[amount+1];
		change[0] = 0;  //base condition
		System.out.println(minCoinsRequired(amount, coins));
		in.close();

	}
	/**
	 * 
	 * @param amount the amount for which the change is required
	 * @param coins the value of different coins
	 * @return the minimum no of coins required for the given amount
	 */
	public static int minCoinsRequired(int amount,int coins[]) {
		if(amount==0) {
			return 0;
		}
		if(amount <0) {
			return 1000000;
		}
		if(change[amount]!=0) {
			return change[amount];
		}
		int min = Integer.MAX_VALUE;
		for(int i=0;i<coins.length;i++) {
			int temp = minCoinsRequired(amount-coins[i], coins);
			min = min<temp?min:temp;
		}
		change[amount]=min+1;
		return change[amount];
	}

}
