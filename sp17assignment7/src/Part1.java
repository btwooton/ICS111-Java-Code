
public class Part1 {

	public static void main(String[] args) {
		// create a variable called arr which is an array of 7 integers
		int[] arr = new int[7];
		
		// make a for loop that will assign to each cell the value of its index
		for(int i = 0; i < arr.length; i++) {
			arr[i] = i;
		}
		// assign 8 to cell with index 4
		arr[4] = 8;
		
		// assign 3 to cell with index 2
		arr[2] = 3;
		
		// assign the content of index 6 minus content of index 2 to cell with index 5
		arr[5] = arr[6] - arr[2];
		
		// declare a variable sum that starts at 0
		int sum = 0;
		
		// make a for loop that goes over the first 5 elements in arr and adds each to sum
		for(int i = 0; i < 5; i++) {
			sum += arr[i];
		}
		
		// assign the content of sum divided by 5 to the first element in the array
		arr[0] = sum / 5;
		
		// declare a variable cnt that starts at 0
		int cnt = 0;
		
		// make a for loop that goes over arr and increments cnt for every cell that contains 3
		for(int i = 0; i < arr.length; i++) {
			if (arr[i] == 3) {
				cnt++;
			}
		}
		
		// print out cnt
		System.out.println(cnt);


	}

}