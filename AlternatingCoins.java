package dsa;

public class AlternatingCoins {
	public static void main(String[] args) {
		int[] A = { 1, 0, 1, 0, 1, 1 };
		int[] A1 = { 1, 1, 0, 1, 1 };
		int[] A2 = { 0, 1, 0 };
		int[] A3 = { 0, 1, 1, 0 };
		System.out.println("Answer: " + solution(A));
		System.out.println("Answer: " + solution(A1));
		System.out.println("Answer: " + solution(A2));
		System.out.println("Answer: " + solution(A3));

	}

	public static int solution(int[] A) {
		int count0 = 0;
		int count1 = 0;

		for (int i = 0; i < A.length; i++) {
			// If the position is even in pattern 0,1,0,1...
			if (i % 2 == 0 && A[i] != 0)
				count0++;
			// If the position is odd in pattern 0,1,0,1...
			if (i % 2 == 1 && A[i] != 1)
				count0++;

			// If the position is even in pattern 1,0,1,0...
			if (i % 2 == 0 && A[i] != 1)
				count1++;
			// If the position is odd in pattern 1,0,1,0...
			if (i % 2 == 1 && A[i] != 0)
				count1++;
		}
		return Math.min(count0, count1);
	}

}//On
