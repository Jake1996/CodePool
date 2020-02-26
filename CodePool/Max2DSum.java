package CodePool;

import java.util.Scanner;

/**
 * Input : Values of m and n in an mxn matrix followed by the elements of the
 * matrix row wise output : the maximum sum of a submatrix of the given matrix
 * 
 * @author jatin
 *
 */
public class Max2DSum {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n, m, sum = Integer.MIN_VALUE, arr[][], rect;
		n = in.nextInt();
		m = in.nextInt();
		arr = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				arr[i][j] = in.nextInt();
				if (i > 0)
					arr[i][j] += arr[i - 1][j];
				if (j > 0)
					arr[i][j] += arr[i][j - 1];
				if (i > 0 && j > 0)
					arr[i][j] -= arr[i - 1][j - 1];
			}
		}
		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++) {
				for (int l = i; l < n; l++)
					for (int k = 0; k < m; k++) {
						rect = arr[l][k];
						if (i > 0)
							rect -= arr[i - 1][k];
						if (j > 0)
							rect -= arr[l][j - 1];
						if (i > 0 && j > 0)
							rect += arr[i - 1][j - 1];
						if (rect > sum)
							sum = rect;
					}
			}
		System.out.println(sum);
		in.close();

	}

}
