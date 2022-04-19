public class MaxSumQuery {

        int [] sum ;
        public  MaxSumQuery(int[] nums) {
            int n = nums.length;
            sum = new int[n+1];
            for(int i = 1; i <=n;i++){
                sum[i] = sum[i-1]+ nums[i-1];
            }
        }

        public int sumRange(int left, int right) {
            return sum[right + 1] - sum[left];
        }
}
