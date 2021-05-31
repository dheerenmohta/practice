// Function to calculate the maximum stolen value
                            // {6, 7, 1} 3
        static int maxLoot(int hval[], int n)
        {   
            // 3 ==0f
                if (n == 0) return 0;
                // 3 == 1f
                if (n == 1)        return hval[0];
                // 3 == 2f
                if (n == 2) return Math.max(hval[0], hval[1]);

                // dp[i] represent the maximum value stolen
                // so far after reaching house i.
                // dp[3]
                int[] dp = new int[n];

                // Initialize the dp[0] and dp[1]
                dp[0] = hval[0]; // 6
                dp[1] = Math.max(hval[0], hval[1]);// 7

                // Fill remaining positions
                // i 2 
                for (int i = 2; i<n; i++)
                {   // dp2 = max(a[2]+dp0, dp1)
                        dp[i] = Math.max(hval[i]+dp[i-2], dp[i-1]);
                }
                return dp[n-1];
        }
