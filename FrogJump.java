/*
Input: nums = [2,3,1,1,4]
Output: 2
Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.

*/


class Solution {
                    // [2,3,1,1,4]
    public int jump(int[] nums) {
        int lastIndex = nums.length - 1; // 4
        int nextIndex = nums.length - 1; // 4
        int count = 0; 
        
            // 4 > 0
            // 1 > 0
        while (lastIndex > 0) {
                // i 4 3 2 1 0
                // i 0
            for (int i = lastIndex-1; i >=0 ; --i) {
                    // n4 >= 4-4 // 4 >= 0 t
                    // n3 >= 4-3 // 1 >= 1 t
                    // n2 >= 4-2 // 1 >= 2 f 
                    // n1 >= 4-1 // 3 >= 3 t
                    // n0 >= 4-0 // 2 >= 4 f

                    // n0 >= 1-0 // 2 >= 1 t
                if (nums[i] >= lastIndex-i) {
                    // nI = 4
                    // nI = 3
                    // nI = 1

                    // nI = 0
                    nextIndex = i;
                }
            }
            
            lastIndex = nextIndex; // 1 // 0
            count++;// 1 // 2
        }
        
        return count; // 2
    }
}
