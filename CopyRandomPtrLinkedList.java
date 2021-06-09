

// copy list with random pointer



//head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
//Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]

                            // 7
    public void copyNodes(Node root){
        Node curr = root; // 7 13 11 10
        while(curr!=null){ // 7 != null
            Node forw = curr.next; // 13 // 11 // 10 // 1 // null
            Node temp = new Node(curr.val);// (7) (13) (11) (10) (1)
            curr.next = temp; // 7-(7)//-13-(13)//-11-(11)//-10-(10)//-1-(1)
            temp.next = forw;//  7-(7)-13 //-(13)-11//-(11)-10//-(10)-1//-(1)-null
            curr = forw;// 13 // 11 // 10 // 1 // null
        }
    }       
                            // 7
    public void copyRandom(Node root){
        Node curr = root; // 7
        while(curr!=null){ // 7 !=null // 13 !=null // 11 != null
                // (7 null) null == null f 
                // (13 0) 0 !=null t
                // (11 4) 4 !=null t
            if(curr.random != null) 
                curr.next.random = curr.random.next; // [7 null]-(7, null)-[13 0]-(13 0) // [11 4]-(11 4)
            curr = curr.next.next; // 7-(7)-13-(13)-11
        }
    }


    public Node extractList(Node root){
        Node dummy = new Node(-1); // -1
        Node curr = root; // 7
        Node prev = dummy; // -1
                // 7 != null
                // 13 != null
                // 11 != null 
        while(curr!=null){
            prev.next = curr.next;// -1-(7)//-(13)
            prev = prev.next;// -1-(7)-(13)
            
            curr.next = curr.next.next; // 7-13//-11
            curr = curr.next; // 13//11
        }
        return dummy.next; // -1-(7) // return (7)
    }

    
    //                      [[7,null],[13,0],[11,4],[10,2],[1,0]]
    public Node copyRandomList(Node head) {
        copyNodes(head);
        copyRandom(head);
        return extractList(head);
    }
 }
