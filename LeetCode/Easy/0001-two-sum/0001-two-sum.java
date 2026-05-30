import java.util.*;
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hash = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            int n = target-nums[i];
            if(hash.containsKey(n)) return new int[]{hash.get(n), i};
            else hash.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }
}