class Solution {
    
                        // [3,1,4,1,5] 2
    public int findPairs(int[] nums, int k) {
        int count =0;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        // i 0 1 2 3 4 
        for(int i = 0; i < nums.length; i++) {
                // (3) !f t
                // (1) !f t
                // (4) !f t
                // (1) !t f
            if(!map.containsKey(nums[i])) {
                //  3+2 5 f 
                //  1+2 3 t
                //  4+2 6 f
                //  1+2 3 t
                if(map.containsKey(nums[i] + k)) count++;// 1 // 2
                // 3-2 1 f 
                // 1-2 -1 f
                // 4-2 2 f
                // 1-2 -1 f
                if(map.containsKey(nums[i] - k)) count++;
                // {3,1}
                // {1,1}
                // {4,1}
                // {}
                map.put(nums[i], 1);
            } else if (k == 0) {
                   if(map.get(nums[i]) == 1)
                      count++;
                   map.put(nums[i], map.get(nums[i]) + 1);
            }         
        }
        return count;
    }
}