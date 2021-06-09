class Solution {
    /*
    Your input
[1,1,2,2,2,3]


Output
[3,1,1,2,2,2]

    Your input
[1,1,2,2,3,3]



[3,3,2,2,1,1]

    */
                                // [1,1,2,2,2,3]
    public int[] frequencySort(int[] arr) {
        int n = arr.length; // 6
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int ele:  arr)
          map.put(ele,map.getOrDefault(ele,0)+1);
        
        // {1 2}
        // {2 3}
        // {3 1}
          
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->{
            System.out.println("a :"+a+ " b :"+b); 
                //m(2) 3   - m(1) 2 
                //m(3) 1     m(1) 2
                //m(1) 2     m(2) 3
            if(map.get(a) != map.get(b)){
              System.out.println("map.get(a) :"+ map.get(a)+ " map.get(b) :"+map.get(b));       
                     //m(2) 3   - m(1) 2 = 1 
                     //m(3) 1     m(1) 2 = -1
                     //m(1) 2     m(2) 3 = -1
              return map.get(a) - map.get(b);// 
            }
            else{ 
              // [3,3,2,2,1,1]  
              return b - a; // 
            }
        });
        
        for(Integer ele : map.keySet()){
            pq.add(ele);
        }
        int count = 0;
        int[] ans = new int[n];
        while(pq.size() != 0){
         int key = pq.remove();    
          for(int i=0;i<map.get(key);i++)
            ans[count++] = key;
        }
        return ans;
    }
}
