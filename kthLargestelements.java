public static void FirstKelements(int arr[], // 1 2 3
                                                                int size, // 3
                                                                int k) // 2
{
        
        // Creating Min Heap for given
        // array with only k elements
        // Create min heap with priority queue
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i = 0; i < k; i++)
        {
                minHeap.add(arr[i]); // 1 2 
        }
        
        // Loop For each element in array
        // after the kth element
    // i = 2
        for(int i = k; i < size; i++)
        {
                
                // If current element is smaller
                // than minimum ((top element of
                // the minHeap) element, do nothing
                // and continue to next element
        // 1 > a2 // 1 > 3 f
                if (minHeap.peek() > arr[i])
                        continue;
                
                // Otherwise Change minimum element
                // (top element of the minHeap) to
                // current element by polling out
                // the top element of the minHeap
                else
                {
            // 2 
                        minHeap.poll();
            // 2 3 
                        minHeap.add(arr[i]);
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




