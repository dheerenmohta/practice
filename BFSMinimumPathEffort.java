class Solution {
    int [] dir = new int [] {0,1,0,-1,0};
    public int minimumEffortPath(int[][] heights) {
        
        int m = heights.length;
        int n = heights[0].length;
        
        int [][] efforts = new int[m][n];
        for(int [] effort : efforts){
            Arrays.fill(effort, Integer.MAX_VALUE);    
        }
        
    
        //PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b)->a[0]-b[0]));
          PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b) -> (a[0]-b[0]));
        efforts[0][0] = 0;
        pq.offer(new int[]{0,0,0});
        
        while(!pq.isEmpty()){
            int size = pq.size();
            int[] head = pq.poll();
            int x = head[1];
            int y = head[2];
            int currentEffort = head[0];
            if(x == m-1 && y == n-1 ){
                return currentEffort;
            }
            
            for(int i =0 ; i < 4; i++){
                int newX = x + dir[i];
                int newY = y + dir[i+1];
                
                if(newX>=0 && newX < m && newY >= 0 && newY <n){
                    int newEffort = Math.max(currentEffort, Math.abs(heights[newX][newY]-heights[x][y] ));
                        if(newEffort < efforts[newX][newY]){
                            efforts[newX][newY] = newEffort;
                            pq.offer(new int[]{newX, newY, newEffort});
                        }
                }
            }
            
        }

        return 0;
    
    }
}
