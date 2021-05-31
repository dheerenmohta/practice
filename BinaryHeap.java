
/*
 * 
Arr[(i-1)/2]        Returns the parent node
Arr[(2*i)+1]        Returns the left child node
Arr[(2*i)+2]        Returns the right child node
 **/


// Java implementation of Min Heap
public class MinHeap {
        private int[] Heap;
        private int size;
        private int maxsize;

        private static final int FRONT = 1;
                    // 15
        public MinHeap(int maxsize)
        {
                this.maxsize = maxsize;// 15
                this.size = 0;
                Heap = new int[this.maxsize + 1];// Heap[0 1 2 ... 16]
                Heap[0] = Integer.MIN_VALUE;// h0 -1
        }

        // Function to return the position of
        // the parent for the node currently
        // at pos
        private int parent(int pos)
        {
                return pos / 2;
        }

        // Function to return the position of the
        // left child for the node currently at pos
        private int leftChild(int pos)
        {
                return (2 * pos);
        }

        // Function to return the position of
        // the right child for the node currently
        // at pos
        private int rightChild(int pos)
        {
                return (2 * pos) + 1;
        }

        // Function that returns true if the passed
        // node is a leaf node
        private boolean isLeaf(int pos)
        {
                if (pos >= (size / 2) && pos <= size) {
                        return true;
                }
                return false;
        }

        // Function to swap two nodes of the heap
        private void swap(int fpos, int spos)
        {
                int tmp;
                tmp = Heap[fpos];
                Heap[fpos] = Heap[spos];
                Heap[spos] = tmp;
        }

        // Function to heapify the node at pos
        private void minHeapify(int pos)
        {

                // If the node is a non-leaf node and greater
                // than any of its child
                if (!isLeaf(pos)) {
                        if (Heap[pos] > Heap[leftChild(pos)]
                                || Heap[pos] > Heap[rightChild(pos)]) {

                                // Swap with the left child and heapify
                                // the left child
                                if (Heap[leftChild(pos)] < Heap[rightChild(pos)]) {
                                        swap(pos, leftChild(pos));
                                        minHeapify(leftChild(pos));
                                }

                                // Swap with the right child and heapify
                                // the right child
                                else {
                                        swap(pos, rightChild(pos));
                                        minHeapify(rightChild(pos));
                                }
                        }
                }
        }

        // Function to insert a node into the heap
                            // 5
                        // 3

    /*
    size :0maxsize :15
Heap[++size] = element;5element :5
int current = size; :1size :1 // not return
        h1 < h(p0)
        5  < -2147473648 
while (Heap[current] &lt; Heap[parent(current)]) :5 Heap[parent(current): -2147483648
if (size >= maxsize) { //size :1maxsize :15 // 1 > 15 false not return
// h2 = 3 
Heap[++size] = element;3element :3
//   
int current = size; :2size :2  // 2
        h2 < h(p2) // h2 < h1 // 3 < 5
while (Heap[current] &lt; Heap[parent(current)]) :3 Heap[parent(current): 5
//    2 , p2 // 2, 1
swap(current, parent(current))2,1
current = parent(current);2=1
size :2maxsize :15
h3 = 17
Heap[++size] = element;17element :17 
int current = size; :3size :3
while (Heap[current] &lt; Heap[parent(current)]) :17 Heap[parent(current): 3
size :3maxsize :15
Heap[++size] = element;10element :10
int current = size; :4size :4
while (Heap[current] &lt; Heap[parent(current)]) :10 Heap[parent(current): 5
size :4maxsize :15
Heap[++size] = element;84element :84
int current = size; :5size :5
while (Heap[current] &lt; Heap[parent(current)]) :84 Heap[parent(current): 5
size :5maxsize :15
Heap[++size] = element;19element :19
int current = size; :6size :6
while (Heap[current] &lt; Heap[parent(current)]) :19 Heap[parent(current): 17
size :6maxsize :15
Heap[++size] = element;6element :6
int current = size; :7size :7
while (Heap[current] &lt; Heap[parent(current)]) :6 Heap[parent(current): 17
swap(current, parent(current))7,3
current = parent(current);7=3
size :7maxsize :15
Heap[++size] = element;22element :22
int current = size; :8size :8
while (Heap[current] &lt; Heap[parent(current)]) :22 Heap[parent(current): 10
size :8maxsize :15
Heap[++size] = element;9element :9
int current = size; :9size :9
while (Heap[current] &lt; Heap[parent(current)]) :9 Heap[parent(current): 10
swap(current, parent(current))9,4
current = parent(current);9=4
    /*
        public void insert(int element)
        {       // 0 >= 15
            // 1 >= 15
                if (size >= maxsize) {
                        return;
                }
        // h1        =  5  
        // h2        =  3
                Heap[++size] = element;
                int current = size; //  1 // 2
                    //  h1 5 < h(p1) h0 -1
                    // h2 3 < h1 5
                while (Heap[current] < Heap[parent(current)]) {
                        swap(current, parent(current));// 1  p1 0 // 2  1
                        current = parent(current); // 0 0 // 2 1

                }
        }

        // Function to print the contents of the heap
        public void print()
        {
                for (int i = 1; i <= size / 2; i++) {
                        System.out.print(" PARENT : " + Heap[i]
                                                        + " LEFT CHILD : " + Heap[2 * i]
                                                        + " RIGHT CHILD :" + Heap[2 * i + 1]);
                        System.out.println();
                }
        }

        // Function to build the min heap using
        // the minHeapify
        public void minHeap()
        {
                for (int pos = (size / 2); pos >= 1; pos--) {
                        minHeapify(pos);
                }
        }

        // Function to remove and return the minimum
        // element from the heap
        public int remove()
        {
                int popped = Heap[FRONT];
                Heap[FRONT] = Heap[size--];
                minHeapify(FRONT);
                return popped;
        }

        // Driver code
        public static void main(String[] arg)
        {
                System.out.println("The Min Heap is :");
                MinHeap minHeap = new MinHeap(15);
                minHeap.insert(5);
                minHeap.insert(3);
                minHeap.insert(17);
                minHeap.insert(10);
                minHeap.insert(84);
                minHeap.insert(19);
                minHeap.insert(6);
                minHeap.insert(22);
                minHeap.insert(9);
                minHeap.minHeap();

                minHeap.print();
                System.out.println("The Min val is " + minHeap.remove());
        }
}



The Min Heap is :

 PARENT : 3 LEFT CHILD : 5 RIGHT CHILD :6
 PARENT : 5 LEFT CHILD : 9 RIGHT CHILD :84
 PARENT : 6 LEFT CHILD : 19 RIGHT CHILD :17
 PARENT : 9 LEFT CHILD : 22 RIGHT CHILD :10
The Min val is 3






// Function to insert a node into the heap
                            // 5
                        // 3

    /*
    size :0maxsize :15
Heap[++size] = element;5element :5
int current = size; :1size :1 // not return
        h1 < h(p0)
        5  < -2147473648 
while (Heap[current] &lt; Heap[parent(current)]) :5 Heap[parent(current): -2147483648
if (size >= maxsize) { //size :1maxsize :15 // 1 > 15 false not return
// h2 = 3 
Heap[++size] = element;3element :3
//   
int current = size; :2size :2  // 2
        h2 < h(p2) // h2 < h1 // 3 < 5
while (Heap[current] &lt; Heap[parent(current)]) :3 Heap[parent(current): 5
//    2 , p2 // 2, 1
swap(current, parent(current))2,1
current = parent(current);2=1
size :2maxsize :15
h3 = 17
Heap[++size] = element;17element :17 
int current = size; :3size :3
while (Heap[current] &lt; Heap[parent(current)]) :17 Heap[parent(current): 3
size :3maxsize :15
Heap[++size] = element;10element :10
int current = size; :4size :4
while (Heap[current] &lt; Heap[parent(current)]) :10 Heap[parent(current): 5
size :4maxsize :15
Heap[++size] = element;84element :84
int current = size; :5size :5
while (Heap[current] &lt; Heap[parent(current)]) :84 Heap[parent(current): 5
size :5maxsize :15
Heap[++size] = element;19element :19
int current = size; :6size :6
while (Heap[current] &lt; Heap[parent(current)]) :19 Heap[parent(current): 17
size :6maxsize :15
Heap[++size] = element;6element :6
int current = size; :7size :7
while (Heap[current] &lt; Heap[parent(current)]) :6 Heap[parent(current): 17
swap(current, parent(current))7,3
current = parent(current);7=3
size :7maxsize :15
Heap[++size] = element;22element :22
int current = size; :8size :8
while (Heap[current] &lt; Heap[parent(current)]) :22 Heap[parent(current): 10
size :8maxsize :15
Heap[++size] = element;9element :9
int current = size; :9size :9
while (Heap[current] &lt; Heap[parent(current)]) :9 Heap[parent(current): 10
swap(current, parent(current))9,4
current = parent(current);9=4
    /*
        public void insert(int element)
        {       // 0 >= 15
            // 1 >= 15
                if (size >= maxsize) {
                        return;
                }
        // h1        =  5  
        // h2        =  3
                Heap[++size] = element;
                int current = size; //  1 // 2
                    //  h1 5 < h(p1) h0 -1
                    // h2 3 < h1 5
                while (Heap[current] < Heap[parent(current)]) {
                        swap(current, parent(current));// 1  p1 0 // 2  1
                        current = parent(current); // 0 0 // 2 1

                }
        }
