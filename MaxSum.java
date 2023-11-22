package dsa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaxSum {
	public static void main(String[] args) {
		int A[] = { 51, 71, 17, 42 };
		int A1[] = { 42, 33, 60 };
		int A2[] = { 51, 32, 43 };
		System.out.println("Max Sum: " + getMaxSum(A));
		System.out.println("Max Sum: " + getMaxSum(A1));
		System.out.println("Max Sum: " + getMaxSum(A2));
	}

	public static int getMaxSum(int A[]) {
		Map<Integer, Integer> digitSums = new HashMap<>();

		for (int num : A) {
			int originalNum = num;
			int sum = 0;

			while (num > 0) {
				sum += num % 10;
				num /= 10;
			}
			digitSums.put(originalNum, sum);
		}
		// {51:6,71:8,17:8,42:6}
		Map<Integer, List<Integer>> valueToKeys = new HashMap<>();
		for (Map.Entry<Integer, Integer> entry : digitSums.entrySet()) {
			Integer key = entry.getKey();
			Integer value = entry.getValue();

			if (!valueToKeys.containsKey(value)) {
				valueToKeys.put(value, new ArrayList<>());
			}
			valueToKeys.get(value).add(key); // 6:[51,42] 8:[71,17]
		}
		int maxSum = -1;
		for (List<Integer> nums : valueToKeys.values()) {
			if (nums.size() > 1) {
				Collections.sort(nums, Collections.reverseOrder());
				for (int i = 0; i < nums.size(); i++) {
					maxSum = Math.max(maxSum, nums.get(0) + nums.get(1));
				}
			}
		}
		return maxSum;
	}
}//Onlogn
