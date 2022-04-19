class Solution {
    public int minimumTime(String s) {
        
        int [] num = new int[s.length()];
        int min = s.length();
        int n = num.length;
        
        for(int i = 0; i <n; i++){
            num[i] = s.charAt(i)-'0';
        }
        
        
        int [] left = new int[num.length];
        left[0] = num[0];
        for(int i =1; i < n; i++){
            left[i] = Math.min(i+1,left[i-1]+(num[i]==1?2:0));
            
        }
        
                
        int [] right = new int[num.length];
        right[n-1] = num[n-1];
        for(int i =n-2; i >=0; i--){
            right[i] = Math.min(n-i,right[i+1]+(num[i]==1?2:0));
            
        }
        
        for(int i =0; i < n; i++){
            int left1 = left[i];
            int right1 = (i==n-1)?0:right[i+1];
            min = Math.min(left1+right1, min);
            
        }

        return min;
    }
}
