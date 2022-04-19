import java.util.ArrayList;
import java.util.List;

public class MaxSumSubArrayEndFirst {

    public List<Integer> continuousSubarraySum(int[] A) {
        // write your code here

        int maxSum = A[0], sum = 0;
        int first=0, last=0, bg=0;

        for(int i =0 ; i < A.length; i++){
            if(sum >=0){
                sum += A[i];
            }else{
                bg = i;
                sum = A[i];
            }

            if(sum > maxSum){
                maxSum = sum;
                first = bg;
                last = i;
            }


        }

        List<Integer> ans = new ArrayList<>();
        ans.add(first);
        ans.add(last);

        return ans;

    }
}
}
