
public class MyArray {

	public static void main(String[] args) {
		int[] my_arr = {7, -1, 2, 3, 0, -3, 5};
		
		int max = 0;
		for(int i = 0; i < 7; i++) {
			if(my_arr[i] > max) {
				max = my_arr[i];
			}
		}
		System.out.println("The max value of the array is " + max);
		
		int min = 0;
		
		for(int i = 0; i < 7; i++) {
			if(my_arr[i] < min) {
				min = my_arr[i];
			}
		}
		System.out.println("The min value of the array is " + min);
	}

}