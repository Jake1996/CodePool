package CodePool;
import java.util.Scanner;
/**
 * Input : The size of the array followed by the elements in the array
 * Output : the maximum continuous sum in the elements of the array
 * @author jatin
 *
 */
public class Max1DSumKadane {

	public static void main(String[] args) {
		int size,arr[];
		Scanner in = new Scanner(System.in);
		size = in.nextInt();
		arr = new int[size];
		for(int i=0;i<size;i++) 
			arr[i] = in.nextInt();
		System.out.println(kadaneMaxSum(arr));
		in.close();

	}
	/**
	 * 
	 * @param arr the array to find the max continuous sum in
	 * @return the max sum
	 */
	public static int kadaneMaxSum(int arr[]) {
		int sum=0,ans=0;
		for(int i = 0;i<arr.length;i++) {
			sum+=arr[i];
			ans = Math.max(ans,sum);
			if(sum<0) sum =0;
		}
		return ans;
	}


}
