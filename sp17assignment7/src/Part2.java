
public class Part2 {

	// this declares and initializes a static array of integers
	
	// old line: public static int [ array = {3, 5, 1, 3, 7, -4, 0};
	public static int [] array = {3, 5, 1, 3, 7, -4, 0};
	
	// this function checks if the element in cell index has the value comp
	public static boolean compare(int index, int comp) {
		if (array[index] == comp) {
			return true;
		}
		// old line: return true;
		return false;
	}
	
	public static void main(String[] args) {
		// getting how long the array is
		int len = array.length;
		// flip the values in the array start to end
		for (int i = 0; i<len/2; i++) {
			// old line: temp = array[i];
			int temp = array[i];
			
			// old line: array[j] = array[len-1-i];
			array[i] = array[len-1-i];
			array[len-1-i] = temp;
		}

		// compare each cell to 3 and print the result
		
		// old line: for (int i = -1; i<len; i++) {
		for (int i = 0; i<len; i++) {
			// old line: if (compare(i, 3))
			if (compare(i, 3)) {
				System.out.println("The content of cell "+i+" is 3");
			} else {
				System.out.println("The content of cell "+i+" is not 3");
			}
		}

	}

}