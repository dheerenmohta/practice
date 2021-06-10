
class Solution {


                //IP 0,1,0,2
                //OP 1
                //        0,1,0,2
    public int trap(int[] height) {
        int[] leftMax=new int[height.length]; // 4 l[]
        int[] rightMax=new int[height.length];// 4 r[]
        int max=Integer.MIN_VALUE;// -1

            // i 1 2 3
        for(int i=1;i<height.length;i++)
        {
                // max(-1, 0) 0
                // max(0,1)   1
                // max(1,0)   1
            max=Math.max(max,height[i-1]);
            leftMax[i]=max; // l[ ,0,1,1]
        }
        max=Integer.MIN_VALUE; // -1
        // i 4-2 // 2 1 0
        for(int i=height.length-2;i>=0;i--)
        {
                // max(-1, 2) 2
                // max(2,0) 2
                // max(2,1) 2
            max=Math.max(max,height[i+1]);
            rightMax[i]=max; // r[2,2,2,]
        }

        int ans=0;
        for(int i=0;i<height.length;i++)
        {
                    // l[ ,0,1,1]
                    // r[2,2,2,]
                    //  ans = 0+0+1+0 // 1
            ans+=Math.min(leftMax[i],rightMax[i])-height[i]>0?
                Math.min(leftMax[i],rightMax[i])-height[i]
                :
            0;
        }



        return ans; // 1
    }
}
