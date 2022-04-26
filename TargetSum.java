public class TargetSum {
    /**
     * @param nums: an integer array and all positive numbers, no duplicates
     * @param target: An integer
     * @return: An integer


    Input: nums = [1, 2, 4], and target = 4
    Output: 6
    Explanation:
    The possible combination ways are:
    [1, 1, 1, 1]
    [1, 1, 2]
    [1, 2, 1]
    [2, 1, 1]
    [2, 2]
    [4]


     */
    public int backPackVI(int[] nums, int target) {
        // write your code here

        int [] sum = new int[target+1];

        sum[0] = 1;

        for(int i = 1; i <= target; i++){
            for(int num : nums){
                if(num <= i){
                    sum[i] += sum[i-num];
                }
            }
        }
        return sum[target];
    }

}
