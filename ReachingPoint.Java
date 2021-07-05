/*
Input: sx = 1, sy = 1, tx = 3, ty = 5
Output: true
Explanation:
One series of moves that transforms the starting point to the target is:
(1, 1) -> (1, 2)
(1, 2) -> (3, 2)
(3, 2) -> (3, 5)
*/
class Solution {
                                    // 1.    1.     3.      5
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
            // 3 >= 1 T    5 >= 1 T
            // 3 >= 1 T    2 >= 1 t
        while(tx >= sx && ty >= sy){
         // 3 == 1 f 5 == 1 f
         // 3 == 1 f 2 == 1 f
         // 1 == 1 t 2 == 1 f
       if(tx==sx && ty == sy)
            return true;
       
        // 1 == 3 f
        // 1 == 3 f
        // 1 == 1 t
        if(sx==tx)
          return (ty-sy)%tx==0; // (2-1)%1 == 0
            // 1 == 5 f
            // 1 == 2 f
        else if(sy==ty)
            return (tx-sx)%ty==0;
             // 3 > 5 f
             // 3 > 2 t
        else if(tx > ty)
             tx=tx%ty; // 3/2 = 1 
        else    
            ty =ty%tx; // 5/3 = 2 
    }
    
    return false;
    }
}