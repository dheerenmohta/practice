public class Longset_Sub
{
        // return the length of the longest
        // subsequence of consecutive integers
                                    // { 1, 9, 3, 2,2 } 4
        static int findLongestConseqSubseq(int arr[], int N)
        {

                PriorityQueue<Integer> pq
                        = new PriorityQueue<Integer>();
                for (int i = 0; i < N; i++)
                {
                        // adding element from
                        // array to PriorityQueue
                        pq.add(arr[i]); // [1 2 2 3 9]
                }
                
                // Storing the first element
                // of the Priority Queue
                // This first element is also
                // the smallest element
                int prev = pq.poll(); // 1 [2 2 3 9]
                
                // Taking a counter variable with value 1
                int c = 1; // 1
                
                // Storing value of max as 1
                // as there will always be
                // one element
                int max = 1; // 1

        // i 1 2 3 4
                for (int i = 1; i < N; i++)
                {
                        // check if current peek
                        // element minus previous
                        // element is greater then
                        // 1 This is done because
                        // if it's greater than 1
                        // then the sequence
                        // doesn't start or is broken here
                // 2 - 1 1 > 1 f
                // 3 - 2 > 1 f
                // 9 - 3 > 1 t
                        if (pq.peek() - prev > 1)
                        {
                                // Store the value of counter to 1
                                // As new sequence may begin
                                c = 1; // 1
                                
                                // Update the previous position with the
                                // current peek And remove it
                                prev = pq.poll(); // 9 []
                        }
                        
                        // Check if the previous
                        // element and peek are same
            //        2 - 1 1 == 0 f
            //        3 - 2 1 == 0 f
            //        2 - 2 0 == 0 t
                        else if (pq.peek() - prev == 0)
                        {
                                // Update the previous position with the
                                // current peek And remove it
                                prev = pq.poll(); // [2 3 9] > [3 9]
                        }
                        // if the difference
                        // between previous element and peek is 1
                        else
                        {
                                // Update the counter
                                // These are consecutive elements
                // 2 // 3
                                c++;
                                
                                // Update the previous position
                                // with the current peek And remove it
                                prev = pq.poll(); // 2 [ 3 9] // 3 [9]
                        }

                        // Check if current longest
                        // subsequence is the greatest
               // 1 < 2
               // 2 < 3
                        if (max < c)
                        {
                                // Store the current subsequence count as
                                // max = 2 // 3
                                max = c;
                        }
                }

                return max;
        }
