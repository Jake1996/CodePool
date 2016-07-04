package CodePool;
import java.util.Scanner;

/**
 * Input : the size of the array followed by the elements of the array 
 * Output : the maximum length of strictly increasing subsequence of the elements of the array not necessarily continuous
 * @author jatin
 *
 */
public class LongestIncreasingSubsequence {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int size = in.nextInt();
		int arr[] = new int[size];
		for(int i=0;i<size;i++) {
			arr[i] = in.nextInt();
		}
		System.out.println(subsequence(arr));
		in.close();
	}
	
	/**
	 * 
	 * @param arr the array to find max length of the strictly increasing subsequence in 
	 * @return the length of the subsequence
	 */
	public static int subsequence(int arr[]) {
		int max = 1;
		int lis[] = new int[arr.length];
		lis[0] = 1;
		for(int i=1;i<lis.length;i++) {
			for(int j=0;j<i;j++) {
				if(arr[i]>arr[j]) {
					lis[i] = lis[i]>(lis[j]+1)?lis[i]:(lis[j]+1);
				}
			}
			max = max>lis[i]?max:lis[i];
		}
		return max;
	}
}
