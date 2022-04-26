import java.util.HashMap;

public class SubArraySumEqualsK {
    public int subarraySumEqualsK(int[] nums, int k) {
        // write your code here
        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(0,1);
        int sum = 0;
        int count = 0;
        for(int i=0; i < nums.length; i++){
            sum += nums[i];
            if(map.containsKey(sum - k)){
                count = count + map.get(sum-k);
            }

            if(map.containsKey(sum)){
                map.put(sum, map.get(sum)+1);
            }else{
                map.put(sum, 1);
            }
        }

        return count;
    }

}
