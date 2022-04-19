class Solution {
    public int minJumps(int[] arr) {
        
        Map<Integer,List<Integer>> map = new HashMap<>();
        for(int i = 0; i < arr.length;i++){
            List<Integer> indices = map.getOrDefault(arr[i], new ArrayList<>());
            indices.add(i);
            map.put(arr[i], indices );
            
        }
        
        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(0);
        
        boolean[] visited = new boolean[arr.length];
        int level = 0;
        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                Integer head = q.poll();
                if(head == arr.length -1){
                    return level;
                }
                
                if(head <0|| head >=arr.length || visited[head] ){
                    continue;
                }
                
                if(head-1 > 0 && !visited[head-1] ){
                    q.offer(head-1);
                }
                
                if(head+1 < arr.length && !visited[head+1] ){
                    q.offer(head+1);
                }
                
                if(map.containsKey(arr[head])){
                    for(int index: map.get(arr[head])){
                        if(index >= 0 && index < arr.length && !visited[index]){
                            q.offer(index);
                        }
                    }
                    map.remove(arr[head]);
                }
                visited[head] = true;
            }
            level++;
            
        }
        
        return -1;
    }
}
