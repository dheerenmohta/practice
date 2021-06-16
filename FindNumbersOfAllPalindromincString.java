class Solution {
    int res=0;          
                    //      ab 0 0
                    //      ab 0 1
                    //      ab 1 1
    
                    //      aba 0 0
                    //      aba 0 1
                    //      aba 1 1
                    //      aba 1 2
                    //      aba 2 2
                    //      aba 2 3
    public void expand(char a[],int l,int r){
            
            // 0 >=0 t && 0 < 2 t
            // 0 >=0 t && 1 < 2 t
            // 1 >=0 t && 1 < 2 t
        

            // 0 >=0 t && 0 < 3 t
            // 0 >=0 t && 1 < 3 t
            // 1 >=0 t && 1 < 3 t
                //  0; 2 
            // 1 >=0 t && 2 < 3 t
            // 2 >=0 t && 2 < 3 t
                // 1; 3 f
            // 2 >=0 t && 2 < 3 t
            // 2 >=0 t && 3 < 3 f
        while(l>=0 && r<a.length){
            // a0 != a0 a != a f
            // a0 != a1 a != b t
            
            // a1 != a1 b != b f
            
            // a0 != a0 a != a f
            // a0 != a1 a != b t 
            // a1 != a1 b != b f
            // a0 != a2 a != a f
            // a1 != a2 b != a t
            // a2 != a2 a != a f
            if(a[l]!=a[r])
            {
                return; 
            }else
            {
                // 1 ; -1; -1
                // 2 ; 0; 2
                
                // 1; -1; 1
                // 2;  0; 2
                // 3; -1; 3
                // 4;  1; 3
                res++;l--;r++;
            }
        }
    }
    public int countSubstrings(String s) {
        char a[] = s.toCharArray();
        // i 0 1
        // i 0 1 2
        for(int i=0;i<a.length;i++){
            // ab 0 0
            // ab 1 1
            
            // aba 0 0
            // aba 1 1
            // aba 2 2
            expand(a,i,i);
            // ab 0 1
            // ab 1 2
            
            // aba 0 1
            // aba 1 2
            // aba 2 3
            expand(a,i,i+1);
        }
        return res;
    }
}