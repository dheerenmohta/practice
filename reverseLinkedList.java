
// 20 4 15 85

static Node reverse(Node head)
        {      // 20 != null    4 != null
           //  4 != null    15 != null
           //  15 != null    85 != null
           //  85 != null    null == null
           
                if (head == null || head.next == null)
                        return head; // 85

                /* reverse the rest list and put
                the first element at the end */

                Node rest = reverse(head.next);//20.next //rev(4) // rev(15) // rev(85) = 85
                head.next.next = head; // 85 > 15 > 4 > 20

                /* tricky step -- see the diagram */
                head.next = null;// 20> null

                /* fix the head pointer */
                return rest;
        }
