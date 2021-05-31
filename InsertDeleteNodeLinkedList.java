class LinkedList {
        Node head; // head of the list

        class Node {
                int data;
                Node next;
                Node(int d)
                {
                        data = d;
                        next = null;
                }
        }

        /* Given a reference to the head of a list and an int,
                inserts a new Node on the front of the list. */
                                // 1
                                // 4
        public void push(int new_data)
        {
                /* 1. alloc the Node and put the data */
                Node new_Node = new Node(new_data); // 1 //4

                /* 2. Make next of new Node as head */
                new_Node.next = head; //4> h1> null

                /* 3. Move the head to point to new Node */
                head = new_Node; //h4>1>null
        }

        /* This function prints contents of linked list
                starting from the given Node */
        public void printList()
        {
                Node tNode = head;
                while (tNode != null) {
                        System.out.print(tNode.data + " ");
                        tNode = tNode.next;
                }
        }
                                // 4 > 1>null
                            // h4
                            // h1
        public void deleteNode(Node Node_ptr)
        {
                Node temp = Node_ptr.next; // t = 4.next = 1 // h1.next = null
                Node_ptr.data = temp.data; // 4.data = 1 // 1.data = null.data = null
                Node_ptr.next = temp.next; // 4.next = 1.next // null
                temp = null; // 4 = null // 1 = null
        }

        public static void main(String[] args)
        {
                LinkedList llist = new LinkedList();

                /* Use push() to construct below list
                1->12->1->4->1 */
                llist.push(1);
                llist.push(4);
                llist.push(1);
                llist.push(12);
                llist.push(1);

                System.out.println("Before deleting");
                llist.printList();

                /* I m deleting the head itself.
                You can check for more cases */
                llist.deleteNode(llist.head);

                System.out.println("\nAfter Deleting");
                llist.printList();
        }
