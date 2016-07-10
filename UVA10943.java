package CodePool;

import java.util.Scanner;

/**
 * Given an integer n, how many ways can K non-negative integers less than or equal to n add up to n?
 * @author jatin
 * Input : The Sum followed by how many ways it is supposed to be split into
 * Output: The total no of ways the sum can be obtained by adding the required number of numbers
 */
public class UVA10943 {

	/** 
	 * the matrix that helps implement the algorithm in a dynamic programming way 
	 */
	public static int soln[][];
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int sum,noOfNo;
		sum = in.nextInt();
		noOfNo = in.nextInt();
		in.close();
		soln = new int[sum+1][noOfNo+1];
		for(int i=1;i<=sum;i++)
			soln[i][1] = 1;
		for(int i =1;i<=noOfNo;i++)
			soln[0][i] = 1;
		for(int i=1;i<=sum;i++)
			for(int j=2;j<=noOfNo;j++)
				soln[i][j] = -1;
		System.out.println(ways(sum,noOfNo));
	}
	/**
	 * 
	 * @param sum the sum to be obtained
	 * @param noOfNo the number of numbers the sum is to be split into
	 * @return the total ways in which the sum can be obtained by adding noOfNo numbers 
	 */
	public static int ways(int sum,int noOfNo) {
		if(soln[sum][noOfNo]!=-1) {
			return soln[sum][noOfNo];
		}
		int total = 0;
		for(int i=0;i<=sum;i++) {
			total+=ways(sum-i,noOfNo-1);
		}
		soln[sum][noOfNo] = total;
		return soln[sum][noOfNo];
	}

}
