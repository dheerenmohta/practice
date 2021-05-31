


//{ 1, 4, 2, 10, 2, 3, 1, 0, 20 };
        static int maxSum(int arr[], int n, int k)
        {
                // n must be greater
              //         9 < 4 f
                if (n < k) {
                        System.out.println("Invalid");
                        return -1;
                }

                // Compute sum of first window of size k
                int max_sum = 0;
              // i 0 1 2 3  - 0
                for (int i = 0; i < k; i++)
        {
          // 0+arr[0]+arr[1]
          // { 1, 4, 2, 10, 2} 19
          max_sum += arr[i];
        }
                // Compute sums of remaining windows by
                // removing first element of previous
                // window and adding last element of
                // current window.

                int window_sum = max_sum;//19
                      // 4 5 6 7 8
                for (int i = k; i < n; i++) {
                                           // a4         - a4-4 a0
                                           // a5   - a5-4 a1
                                           // a6   - a[6-4] a2
                        window_sum += arr[i] - arr[i - k];
                        max_sum = Math.max(max_sum, window_sum);
                }

                return max_sum;
        }


//{ 1, 4, 2, 10, 2, 3, 1, 0, 20 };
        static int maxSum(int arr[], int n, int k)
        {
      System.out.println(n +" "+k);
                // Initialize result
                int max_sum = Integer.MIN_VALUE;

                // Consider all blocks starting with i.
              System.out.println("n - k + 1 :" + (n - k + 1));
                for (int i = 0; i < n - k + 1; i++) {
                  System.out.println("i :"+i);
                        int current_sum = 0;
                        for (int j = 0; j < k; j++){
                      System.out.println("i+j :" +(i+j));
                System.out.println("current_sum :"+current_sum);
                current_sum = current_sum + arr[i+j];
            }
                        // Update result if required.
                  System.out.println("max_sum " + max_sum);
          max_sum = Math.max(current_sum, max_sum);

                }

                return max_sum;
        }

//O(k*n) as it contains two nested loops.

/*
 * 9 4
n - k + 1 :6
i :0
i+j :0
current_sum :0
i+j :1
current_sum :1
i+j :2
current_sum :5
i+j :3
current_sum :7
max_sum -2147483648
i :1
i+j :1
current_sum :0
i+j :2
current_sum :4
i+j :3
current_sum :6
i+j :4
current_sum :16
max_sum 17
i :2
i+j :2
current_sum :0
i+j :3
current_sum :2
i+j :4
current_sum :12
i+j :5
current_sum :14
max_sum 18
i :3
i+j :3
current_sum :0
i+j :4
current_sum :10
i+j :5
current_sum :12
i+j :6
current_sum :15
max_sum 18
i :4
i+j :4
current_sum :0
i+j :5
current_sum :2
i+j :6
current_sum :5
i+j :7
current_sum :6
max_sum 18
i :5
i+j :5
current_sum :0
i+j :6
current_sum :3
i+j :7
current_sum :4
i+j :8
current_sum :4
max_sum 18
24
*/
