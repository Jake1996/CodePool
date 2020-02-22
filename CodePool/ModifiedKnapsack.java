package CodePool.CodePool;

import java.util.Scanner;

public class ModifiedKnapsack {

	public static int solution[][][];

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n, capacity, v[], w[], k[];
		n = in.nextInt();
		v = new int[n];
		w = new int[n];
		k = new int[n];
		for (int i = 0; i < n; i++)
			v[i] = in.nextInt();
		for (int i = 0; i < n; i++)
			w[i] = in.nextInt();
		for (int i = 0; i < n; i++)
			k[i] = in.nextInt();
		capacity = in.nextInt();
		solution = new int[n][capacity + 1][n];
		for (int i = 1; i < n; i++)
			for (int j = 1; j < capacity; j++)
				for (int l = 0; l < n; l++)
					solution[i][j][l] = -1;
		System.out.println(modifiedKnapsack(v, w, k, capacity));
		in.close();

	}

	public static int modifiedKnapsack(int v[], int w[], int k[], int capacity) {
		int max = 0;

		return max;
	}

}
