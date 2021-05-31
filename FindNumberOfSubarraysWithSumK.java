// Function to find number of subarrays
        // with sum exactly equal to k.
                        //  { 10, 2, -2, -20, 10 }; 5 -10
                        //  { 10, 2, -2 }; 3  2
                        //  {10 10 10}      3      10
        static int findSubarraySum(int arr[], int n, int sum)
        {
                // HashMap to store number of subarrays
                // starting from index zero having
                // particular value of sum.
                                 // prevSum {}
                HashMap<Integer, Integer> prevSum = new HashMap<>();

                int res = 0; // 0

                // Sum of elements so far.
                int currsum = 0; // 0

            // i 0 1 2 3 4
             // i 0 1 2 
                for (int i = 0; i < n; i++) {

                        // Add current element to sum so far.
                        currsum += arr[i];// 10 12 10 -10 0
                              // 10 12 10 
                              // 10 20 30

                        // If currsum is equal to desired sum,
                        // then a new subarray is found. So
                        // increase count of subarrays.
            // 10 == -10 f 
            // 12 == -10 f
            // 10 == -10 f
            // -10 == -10 t
            // 0 == -10 f

            // 10 == 2 f
            // 12 == 2 f
            // 10 == 2 f

            // 10 == 10 t
            // 20 == 10 f
            // 30 == 10 f
                        if (currsum == sum)
                                res++; // 1 
                       // 1

                        // currsum exceeds given sum by currsum
                        // - sum. Find number of subarrays having
                        // this sum and exclude those subarrays
                        // from currsum by increasing count by
                        // same amount.
            
            //  prevSum.(10-(-10)) // prevSum(20) f
            //  prevSum.(12-(-10)) // prevSum(22) f
            //  prevSum(10 - (-10))// prevSum(20) f
            //  prevSum(-10-(-10))// prevSum(0) f
            //  prevSum(0-(-10)) // prevSum(10) t

            //prevSum(10-2) // prevSum(8) f
            //prevSum(12-2) // prevSum(10) t
            //prevSum(10-2) // prevSum(8)

            // prevSum(10-10) // prevSum(0) f//  
            // prevSum(20-10) // prevSum(10)
            // prevSum(30-10) // prevSum(20)
                        if (prevSum.containsKey(currsum - sum))
                                res += prevSum.get(currsum - sum); // 2+1 = 3
                                                   //0+1
                                                   //1+1 = 2+1 = 3 

                        // Add currsum value to count of
                        // different values of sum.
                        Integer count = prevSum.get(currsum); // prevSum(10) // null // prevSum(12) // null // prevSum(-10) // null // prevSum(0) // null
                                                  // prevSum(10) // null // prevSum(12) // null // prevSum(10) // 1
                                                  //  prevSum(10) // null // prevSum(20) // null // prevSum(30) // null
                        if (count == null)
                                prevSum.put(currsum, 1); // {10 2}
                                         // {12 1}
                                         // {-10 1}
                                         // {0 1}

                                         //{10 2}
                                         //{12 1}

                                         // {10 1}
                                         // {20 1}
                                         // {30 1}
                        else
                                prevSum.put(currsum, count + 1);
                }

                return res; // 1
                    // 3
        }







Input:
N = 5
Arr = {10 , 2, -2, -20, 10}
k = -10
Output: 3
Explaination: 
Subarrays: arr[0...3], arr[1...4], arr[3..4]
have sum exactly equal to -10.




