                                // 2
static void generatePrintBinary(int n)
    {
        // Create an empty queue of strings
        Queue<String> q = new LinkedList<String>();
 
        // Enqueue the first binary number
        q.add("1"); //[1]
 
        // This loops is like BFS of a tree with 1 as root
        // 0 as left child and 1 as right child and so on
                // 2-- 
                // 1 > 0 t
                // 0 > 0
        while (n-- > 0) {
            // print the front of queue
            String s1 = q.peek(); s1 = 1 // s1 10
            q.remove(); // [11] 
            System.out.println(s1); // 1// 10
 
            // Store s1 before changing it
            String s2 = s1; // s2 1 // s2 10
 
            // Append "0" to s1 and enqueue it
            q.add(s1 + "0");// [10] // [11 100]
 
            // Append "1" to s2 and enqueue it. Note that s2
            // contains the previous front
            q.add(s2 + "1");// s2 [11 100 101]
        }
    }



Input:
N = 2
Output:
1 10
Explanation:
Binary numbers from
1 to 2 are 1 and 10.
