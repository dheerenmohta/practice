
                        // [1 2 3] , 2
                        // [1,2,3,4], 3
public int findKthLargest(int[] nums, int k) {
    PriorityQueue<Integer> q = new PriorityQueue<Integer>(k);
    //i = 0 1 2
    //    0 1 2 3
    for(int i: nums){
        q.offer(i); // 1 2 3 // 2 3 4
        // 1 > 2 f // 2 > 2 // 3 > 2t
        if(q.size()>k){
            q.poll();// [2,3] // [3,4] 
        }
    }
 
    return q.peek(); // 2 // 3 
}
