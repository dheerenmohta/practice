public class MinimumSizeSubArraySum {

    public int minimumSize(int[] nums, int s) {
        // write your code here
        int i =0, j =0;
        int sum =0;
        int ans = Integer.MAX_VALUE;

        for(i =0; i < nums.length; i++){
            while(j < nums.length && sum < s){
                sum += nums[j];
                j++;
            }
            if(sum >=s){
                ans = Math.min(ans, j-i);
            }

            sum -= nums[i];
        }

        if(ans == Integer.MAX_VALUE){
            ans = -1;
        }
        return ans;

    }
}
}
