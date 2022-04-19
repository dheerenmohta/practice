public class MaxSumSubarraySolution {

    class Solution {
        public int maxSubArray(int[] nums) {
        /*
        int s =nums[0];
        int max = nums[0];
        for(int i : nums){
        s += i;

        if(s<0){
            s = 0;
        }

        max = Math.max(s, max);

    }
        return max;
        */
            int max = nums[0];
            if(nums== null || nums.length == 0 ) return 0;
            for(int i =1; i < nums.length; i++){
                nums[i] = Math.max(nums[i], nums[i-1]+nums[i]);
                max = Math.max(nums[i], max);
            }

            return max;
        }
    }
}
