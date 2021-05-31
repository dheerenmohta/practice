// Returns count of possible paths to reach
        // cell at row number m and column number n from
        // the topmost leftmost cell (cell at 1, 1)
                                    // 3 3
        static int numberOfPaths(int m, int n)
        {
                // Create a 2D table to store results
                // of subproblems
                int count[][] = new int[m][n];// int count[][] = new int[3][3]

                // Count of paths to reach any cell in
                // first column is 1
                // i 0 1 2
                for (int i = 0; i < m; i++){
                    // 😊
                    // c00 = 1
                    // c10 = 1 
                    // c20 = 1
                        count[i][0] = 1;
                }

                // Count of paths to reach any cell in
                // first column is 1
                // j = 0 1 2
                for (int j = 0; j < n; j++){
                        // c00 = 1
                        // c01 = 1 
                        // c02 = 1 😊😊
                        count[0][j] = 1;
                }
                // Calculate count of paths for other
                // cells in bottom-up manner using
                // the recursive solution
                    // i 1 2 
                for (int i = 1; i < m; i++) {
                    // j 1 2 
                        for (int j = 1; j < n; j++){

                                // By uncommenting the last part the
                                // code calculates the total possible paths
                                // if the diagonal Movements are allowed
                                // c11 = c01 + c10
                                // c12 = c02 + c11
                                //
                                // c21 = c11 + c20
                                // c22 = c12 + c21
                                count[i][j] = count[i - 1][j] + count[i][j - 1]; //+ count[i-1][j-1];
                
                        }            
                }           
                        // c22
                return count[m - 1][n - 1];
        }
