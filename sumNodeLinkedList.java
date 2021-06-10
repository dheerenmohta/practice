class Solution {
                                        1-1       9-9
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode p1 = l1; // 1
        int sum = 0; 
        int carry = 0 ; 
        ListNode lastNode = l1; // 1
        
             //  1 != null && 9 !=null
             //  1 != null && 9 !=null

        while(l1!=null && l2!=null){
             sum = (l1.val+l2.val+carry)%10; // 1+9+0%10 = 0 // 1+9+1%10 = 1
             carry = (l1.val+l2.val+carry)/10; // 10 /10 = 1 //  // 11 /10 = 1 
             l1.val = sum; // 0 // 1
            lastNode = l1;// lN 0 //ln 1
            l1 = l1.next; // 1 // null
            l2 = l2.next; // 9 // null
        }

        while(l1!=null){
            sum = (l1.val+carry)%10; 
            carry = (l1.val+carry)/10;
            l1.val = sum;
            lastNode = l1;
            l1=l1.next;
        }
        if(l2!=null )
        lastNode.next = l2;
        while(l2!=null){
             sum = (l2.val+carry)%10; 
             carry = (l2.val+carry)/10;
             l2.val = sum; 
             lastNode = l2;
             l2 = l2.next;   
        }
        //  1 != 0 
        if(carry !=0){
            // 0-1-1
            lastNode.next = new ListNode(carry);
        }
        
        return p1; // p1 = l1  - 0-1-1
    }
}
