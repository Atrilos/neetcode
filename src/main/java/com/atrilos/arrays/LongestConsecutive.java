package com.atrilos.arrays;

import java.util.HashSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
 * <p>
 * You must write an algorithm that runs in O(n) time.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [100,4,200,1,3,2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 * Example 2:
 * <p>
 * Input: nums = [0,3,7,2,5,8,4,6,0,1]
 * Output: 9
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 0 <= nums.length <= 10^5
 * -10^9 <= nums[i] <= 10^9
 */
public class LongestConsecutive {

    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = IntStream.of(nums).boxed().collect(Collectors.toCollection(HashSet::new));
        int res = 0;

        for (Integer i : set) {
            if (!set.contains(i - 1)) {
                int current = i;
                int length = 1;
                while (set.contains(current + 1)) {
                    ++length;
                    ++current;
                }
                res = Math.max(res, length);
            }
        }

        return res;
    }
}
