class ListNode{
    ListNode next;
    int val;
    ListNode(int val){
        this.val = val;
    }

}

public class LinkedListPalindrome {


    public boolean isPalindrome(ListNode head) {
        // write your code here
        if(head == null || head.next == null){
            return true;
        }
        ListNode middle = findMiddle(head);
        middle = reverse(middle.next);
        ListNode p1 = head;
        ListNode p2 = middle;
        while(p1!=null && p2!=null && p1.val==p2.val){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2==null;


    }

    public ListNode findMiddle(ListNode head){
        if(head == null){
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next!=null && fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;

        }

        return slow;

    }


    public ListNode reverse(ListNode head){

        ListNode prev = null;
        while(head!=null){
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;

        }

        return prev;
    }
}

