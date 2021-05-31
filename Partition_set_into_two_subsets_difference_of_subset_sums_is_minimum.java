// Function to find the minimum sum
                                    //      {3}     1.         0.          3
                                    //      ({3}, 1-1,     0+a[1-1],      3 )
                                    //      (({3}, 0,          3 ,        3 ))
                                    //       ({3}, 0 ,         0,         3)
                                    // //. {3,2}   2.         0.             5
                                    // //. {3,2}   1.          2.          5)
                                    //     {3,2}   1.         0            5)
                                    
                                    //. {3,2,1}     3.          0.           6
                                    // ({3,2,1}     2.          1.           6)
        public static int findMinRec(int arr[], int i,int sumCalculated,int sumTotal)
        {
                // If we have reached last element.
                // Sum of one subset is sumCalculated,
                // sum of other subset is sumTotal-
                // sumCalculated. Return absolute
                // difference of two sums.
                // 1 == 0 f
                // 2 == 0 f
                // 1 == 0 f
                // 1 == 0 f
                
                // 3 == 0 f
                // 2 == 0 f
                if (i == 0)             {
                        
                        //                 //3-3 -3 // 3
                        return Math.abs((sumTotal-sumCalculated) -
                                                                sumCalculated);
                }
        
                // For every item arr[i], we have two choices
                // (1) We do not include it first set
                // (2) We include it in first set
                // We return minimum of two choices
                            // min [({3}, 1-1, 0+a[1-1],3 ), ({3},1-1,0,3)]
                            // min [3, 3]
                            
                            // min (//{3,2}  1. 2.  5)
                                    //{3,2}  0. 5.  5) == 5-5-5 = 5
                                                        //{3,2}  1. 0  5)
                                                        //min({3,2}  1-1 3  5) == 1, ({3,2}  1-1 0  5) =5)
                                                        
                            // min(5, 1) == 1
                            
                            // min(//{3,2,1}  2. 1.  6), = 4                                           //{3,2,1}  2. 0.  6)
                            //.      {3,2,1}  1. 3.  6). = 0                     {3,2,1}  1. 1.  6) 4
                            // {3,2,1}  0. 6. 6) 6  //{3,2,1}  0. 3.  6) 0.    //  {3,2,1}  0. 4.  6).= 2 {3,2,1}  0. 1.  6) 4
                return Math.min(findMinRec(arr, i - 1, sumCalculated
                                                                + arr[i-1], sumTotal),
                                                                findMinRec(arr, i-1,
                                                                sumCalculated, sumTotal));
        }
        
        // Returns minimum possible difference between
        // sums of two subsets  
                                // {3,2,1}.  3
                                // {3,2}     2    
                                                          // {3}       1
                                                          // {3,2,1}.  3
        public static int findMin(int arr[], int n)
        {
                // Compute total sum of elements
                int sumTotal = 0;
                       // i 0 1 
                for (int i = 0; i < n; i++)
                        sumTotal += arr[i]; // 3 + 2 +1 =6

                // Compute result using recursive function
                                  //{3,2,1}  3. 0.  6
                return findMinRec(arr, n, 0, sumTotal);
        
    }




// Returns the minimum value of
        //the difference of the two sets.
                       //     {1, 2}.    2
        static int findMin(int arr[], int n)
        {
                // Calculate sum of all elements
                int sum = 0;
                for (int i = 0; i < n; i++)
                        sum += arr[i]; // 3 
        
                // Create an array to store
                // results of subproblems       [3][4]
                boolean dp[][] = new boolean[n + 1][sum + 1];
        
                // Initialize first column as true.
                // 0 sum is possible with all elements.
                //[tfff]
                //[t]
                //[t]
                //[]
                       // i 0 1 2
                       //   00 10 20 t
                for (int i = 0; i <= n; i++)
                        dp[i][0] = true;
        
                // Initialize top row, except dp[0][0],
                // as false. With 0 elements, no other
                // sum except 0 is possible
                //    i 1 2 3
                //      01 02 03
                //[tfff]
                //[t]
                //[t]
                //[]
                for (int i = 1; i <= sum; i++)
                        dp[0][i] = false;
        
                // Fill the partition table
                // in bottom up manner
                
                //[tfff]
                //[ttff]
                //[tttt]
                //[]
                
                //   i 1 2
                for (int i = 1; i <= n; i++)
                {          // j 1 2 3
                        for (int j = 1; j <= sum; j++)
                        {
                                // If i'th element is excluded
                                // dp[1][1] = dp[1-1][1] = dp[0][1] f
                                // dp[1][2] = dp[0][2] 
                                // dp[1][3] f
                                dp[i][j] = dp[i - 1][j];
        
                                // If i'th element is included
                                // 1-1 =0 a[0] <= 1 // 1 <= 1
                                if (arr[i - 1] <= j){
                                    // dp[1][1] = dp[1][1] | dp[0][1-a[0]]= dp[0][0] // f | t 
                                    //                     | dp[0][1-1]
                                    // dp[1][1] = t
                                    // dp[1][2] = dp[0][2-1] dp[0][1] f
                                    // dp[1][3] = dp[0][2] f
                                    //
                                    // dp[2][1] = dp[1][1-a[2]] dp[1][1-2]  f
                                    // dp[2][2] = dp[1][2-a[1]] dp[1][2-2] dp[1][0] t
                                    // dp[2][3] = dp[1][3-2] dp[1][1] t
                                        dp[i][j] |= dp[i - 1][j - arr[i - 1]];
                        
                                    
                                }
                        
                        }
                }
        
                // Initialize difference of two sums.
                int diff = Integer.MAX_VALUE; // 100
                
                //[tfff]
                //[ttff]
                //[tftt]
                //[]
                // Find the largest j such that dp[n][j]
                // is true where j loops from sum/2 t0 0
                       // j 3/2 1,0
                for (int j = sum / 2; j >= 0; j--)
                {
                        // Find the
                        // dp[2][1] == t // f ==t false
                        // dp[2][0] == t // t ==t true
                        if (dp[n][j] == true)
                        {   
                            // 
                                diff = sum - 2 * j; // 3 - 2*1 // 1
                                break;
                        }
                }
                
                for(int i =0 ; i < 3 ; i++){
                    for(int j =0; j < 4; j++){
                        //[tfff]
                        //[ttff]
                        //[tttt]
                        //[]
                        System.out.print(dp[i][j]+" ");
                    }
                    System.out.println();
                }
                
                return diff;// 3
        }



Debug output

true false false false
true true false false
true true true true
The minimum difference between 2 sets is 1
