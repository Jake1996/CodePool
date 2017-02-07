package CodePool;
import java.util.Scanner;
/**
 * @author Jatin
 * Input: size of the array followed by the elements of the array
 * Output: the maximum continuous sum in the array
 */
public class Max1DSum {

	public static void main(String[] args) {
		int size,arr[];
		Scanner in = new Scanner(System.in);
		size = in.nextInt();
		arr = new int[size];
		for(int i=0;i<size;i++) 
			arr[i] = in.nextInt();		
		System.out.println(maxSum(arr));
		in.close();

	}
	/**
	 * @param arr the array for which the maximum continuous sum is to be found
	 * @return the maximum continuous sum
	 */
	public static int maxSum(int arr[]){
		int min,max;
		for(int i=1;i<arr.length;i++)
			arr[i]+=arr[i-1];
		min = -1; max = 0;
		int tempmin = -1;
		for(int i=1;i<arr.length;i++) {
			if(arr[i]>arr[max]) {
				max = i;
				if(tempmin!=-1) {
					min = tempmin;
				}
			}
			if(arr[i]<0) {
				if(tempmin!=-1&&arr[i]<arr[tempmin]) {
					tempmin = i;
				}
				else if(tempmin==-1) {
					tempmin = i;
				}
			}
		}
		return  min!=-1?arr[max]-arr[min]:arr[max];
	}

}
