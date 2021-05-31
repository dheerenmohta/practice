    // An Inplace function to
    // rotate a N x N matrix
    // by 90 degrees in
    // anti-clockwise direction
                        
                   //         {
                   //     {1, 2},
                   //     {3 4}

                   //    {1 2 3}
                   //    {4 5 6}
                   //    {7 8 9}
                   //        }    
    static void rotateMatrix(
        int N, int mat[][])
    {
        // Consider all squares one by one
        // x 0
        // x 0 
        for (int x = 0; x < N / 2; x++) {
            // Consider elements in group
            // of 4 in current square
            // y = 0 
            // y = 0 1 
            for (int y = x; y < N - x - 1; y++) {
                // Store current cell in
                // temp variable
                int temp = mat[x][y]; // t m00 1 // t m00 1 // t m01 2
 
                // Move values from right to top
                // m00 = m01  1 2  //  m00 = m02 1 3 // m01 = m12 2 6
                mat[x][y] = mat[y][N - 1 - x];
 
                // Move values from bottom to right
                // m01 = m11  2 4  // m02 = m22 3 9 // m12 = m21 6 8
                mat[y][N - 1 - x] 
                    = mat[N - 1 - x][N - 1 - y];
 
                // Move values from left to bottom
                // m11 = m10   4 3 // m22 = m20 9 7 // m21 = m10 8 4 
                mat[N - 1 - x][N - 1 - y] = mat[N - 1 - y][x];
 
                // Assign temp to left
                // m10 = temp  3 1 // m20 = 1 , 7= 1 // m10 = 2, 1 = 2 
                mat[N - 1 - y][x] = temp;
            }
        }
    }
