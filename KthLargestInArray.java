public static void FirstKelements(int arr[],
                                                                int size,
                                                                int k)
{
        
        // Creating Min Heap for given
        // array with only k elements
        // Create min heap with priority queue
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i = 0; i < k; i++)
        {
                minHeap.add(arr[i]);
        }
          System.out.println("Dheeren 1 :" +minHeap.toString());
  
        
        // Loop For each element in array
        // after the kth element
                //i = 3 4 5 
                // { 11, 3, 2, 1, 15, 5 };
        for(int i = k; i < size; i++)
        {
                
                // If current element is smaller
                // than minimum ((top element of
                // the minHeap) element, do nothing
                // and continue to next element
                //               2 > 1
                //               2 > 15    
                if (minHeap.peek() > arr[i])
                        continue;
                
                // Otherwise Change minimum element
                // (top element of the minHeap) to
                // current element by polling out
                // the top element of the minHeap
                else
                {
                        minHeap.poll(); // 2
                        minHeap.add(arr[i]);// 15
                        System.out.println("Dheeren 2 :" +minHeap.toString());
                }
        }
        
        // Now min heap contains k maximum
        // elements, Iterate and print
        Iterator iterator = minHeap.iterator();
        
        while (iterator.hasNext())
        {
                System.out.print(iterator.next() + " ");
        }
}


Dheeren 1 :[2, 11, 3]
Dheeren 2 :[3, 11, 15]
Dheeren 2 :[5, 15, 11]
5 15 11 
