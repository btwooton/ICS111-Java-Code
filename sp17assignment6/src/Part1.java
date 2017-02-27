
public class Part1 {
	
	public static int sumWithWhile(int x) {
		int sum = 0;
		// your implementation goes here
		int multiple = 3;
		while (multiple < x) {
			sum += multiple;
			multiple += 3;
		}
		//
		return sum;
	}
	
	public static int sumWithDoWhile(int x) {
		int sum = 0;
		// your implementation goes here
		int multiple = 3;
		do {
			sum += multiple;
			multiple += 3;
		} while (multiple < x);
		
		//
		return sum;
	}
	
	public static void main(String[] args) {
		// This main is used to test the functions and make sure they 
		// calculate the same values 
		int result = sumWithWhile(25);
		System.out.println(result);
		result = sumWithDoWhile(25);
		System.out.println(result);

	}
}