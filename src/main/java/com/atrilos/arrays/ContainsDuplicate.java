package com.atrilos.arrays;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ContainsDuplicate {
    /**
     * Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [1,2,3,1]
     * Output: true
     * Example 2:
     *
     * Input: nums = [1,2,3,4]
     * Output: false
     * Example 3:
     *
     * Input: nums = [1,1,1,3,3,4,3,2,4,2]
     * Output: true
     *
     *
     * Constraints:
     *
     * 1 <= nums.length <= 105
     * -109 <= nums[i] <= 109
     *
     *
     */
    public boolean containsDuplicate(int[] nums) {
        return Arrays.stream(nums).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().anyMatch(e -> e.getValue() > 1);
    }
}