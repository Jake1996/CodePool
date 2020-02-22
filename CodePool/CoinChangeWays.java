package CodePool.CodePool;

import java.util.Arrays;
import java.util.Scanner;

/**
 * no of ways to get n coins given unlimited no of m coins
 * 
 * @author jake
 *
 */
public class CoinChangeWays {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		long arr[][] = new long[n + 1][m];
		int coins[] = new int[m];
		for (int i = 0; i < m; i++) {
			coins[i] = in.nextInt();
		}
		in.close();
		Arrays.sort(coins);
		if (n >= coins[0]) {
			for (int i = 0; i < m; i++) {
				arr[coins[0]][i] = 1;
			}
			for (int i = coins[0]; i <= n; i += coins[0]) {
				arr[i][0] = 1;
			}
			for (int i = coins[0] + 1; i <= n; i++) {
				for (int j = 1; j < m; j++) {
					int k = 0;
					if (i % coins[j] == 0)
						arr[i][j]++;
					while (i - coins[j] * k > 0) {
						arr[i][j] += arr[i - coins[j] * k][j - 1];
						k++;
					}
				}
			}
			System.out.println(arr[n][m - 1]);
		} else {
			System.out.println("0");
		}
	}

}
