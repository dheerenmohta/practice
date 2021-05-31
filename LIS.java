
class LIS
{
static int max_ref; // stores the LIS

/* To make use of recursive calls, this function must return
two things:
1) Length of LIS ending with element arr[n-1]. We use
        max_ending_here for this purpose
2) Overall maximum as the LIS may end with an element
        before arr[n-1] max_ref is used this purpose.
The value of LIS of full array of size n is stored in
*max_ref which is our final result */

//{ 10, 22, 9, 33, 21, 50, 41, 60 } , 8;
static int _lis(int arr[], int n)
{
        // base case
        if (n == 1)
                return 1;

        // 'max_ending_here' is length of LIS ending with arr[n-1]
        // 0. 1
        int res, max_ending_here = 1;

                /* Recursively get all LIS ending with arr[0], arr[1] ...
                arr[n-2]. If arr[i-1] is smaller than arr[n-1], and
                max ending with arr[n-1] needs to be updated, then
                update it */
                // { 10, 22, 9, 33, 21, 50, 41, 60 };
                for (int i = 1; i < n; i++). // n =1, n =2,
                {
                        res = _lis(arr, i);  // { 10, 22, 9, 33, 21, 50, 41, 60 } 1 return 1 // _lis(arr, 1)
                                                                 // { 10, 22, 9, 33, 21, 50, 41, 60 } 1 return 1 // _lis(arr, 2);
                                                                 // _lis(arr, 3);
                                                                 // for (int i = 1; i < 3; i++).
                                                                 //  i = 1, res = 1, i =2 res = 2,

                                                                 // _lis(arr, 4);
                                                                 // for (1, 3);
                                                                 // i = 1, res = 1, i =2 res = 2, i = 3, res = 2
                                                                 //
                        if (arr[i-1] < arr[n-1] && res + 1 > max_ending_here) // 10 < 22 && 1+1 > 1.//
                                max_ending_here = res + 1; // 1+1= 2
                }

                // Compare max_ending_here with the overall max. And
                // update the overall max if needed
                if (max_ref < max_ending_here) // 1 < 1  1< 2
                max_ref = max_ending_here; // 2

                // Return length of LIS ending with arr[n-1]
                return max_ending_here;
}

        // The wrapper function for _lis()
        static int lis(int arr[], int n)
        {
                // The max variable holds the result
                max_ref = 1;

                // The function _lis() stores its result in max
                _lis( arr, n);

                // returns max
                return max_ref;
        }


LIS /* Returns length of LCS for X[0..m-1], Y[0..n-1] */
  //        AA,             B ,    2,     1
  int lcs( char[] X, char[] Y, int m, int n )
  {
   // int L[][] = new int[3][2];
    int L[][] = new int[m+1][n+1];
    /* Following steps build L[m+1][n+1] in bottom up fashion. Note
         that L[i][j] contains length of LCS of X[0..i-1] and Y[0..j-1] */
         // i 0,1,2 
    for (int i=0; i<=m; i++)
    {       // j = 0,1
      for (int j=0; j<=n; j++)
      {     //i0 j0
        if (i == 0 || j == 0)
            L[i][j] = 0;
        else if (X[i-1] == Y[j-1])
            L[i][j] = L[i-1][j-1] + 1;
        else         // max(L01, L10)
                    // max(L11, L20)
            L[i][j] = max(L[i-1][j], L[i][j-1]);
      }
    }
  return L[m][n];
  }
  //AA,A
  //[3][2]

    0   1
 0 [0   0]
 1 [0   0]
 2 [0    ] 





/* Dynamic Programming Java implementation
of LIS problem */

class LIS {
        /* lis() returns the length of the longest
        increasing subsequence in arr[] of size n */
        static int lis(int arr[], int n)
        {
                int lis[] = new int[n];
                int i, j, max = 0;

                /* Initialize LIS values for all indexes */
                for (i = 0; i < n; i++)
                        lis[i] = 1;

                /* Compute optimized LIS values in
                bottom up manner */
                for (i = 1; i < n; i++)
                        for (j = 0; j < i; j++) // res = _lis(arr, i)
                                
                            /*
                         if (arr[i - 1] < arr[n - 1]
                && res + 1 > max_ending_here)
                max_ending_here = res + 1;
                            */
                                if (arr[i] > arr[j] && lis[i] < lis[j] + 1)
                                        lis[i] = lis[j] + 1;

                /* Pick maximum of all LIS values */
                for (i = 0; i < n; i++)
                        if (max < lis[i])
                                max = lis[i];

                return max;
        }

        public static void main(String args[])
        {
                int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 };
                int n = arr.length;
                System.out.println("Length of lis is " + lis(arr, n)
                                                + "\n");
        }
}




class LIS {
        static int max_ref; // stores the LIS
        /* To make use of recursive calls, this function must
        return two things: 1) Length of LIS ending with element
        arr[n-1]. We use max_ending_here for this purpose 2)
        Overall maximum as the LIS may end with an element
        before arr[n-1] max_ref is used this purpose.
        The value of LIS of full array of size n is stored in
        *max_ref which is our final result */
       //           {10,22,9},    3
       //           {10,22,9},    1
       //           {10,22,9},    2

//
/*

res, max_ending_here = 1;1
res = _lis(arr, i);1
arr[i - 1] < arr[n - 1] && res + 1 > max_ending_here10 9 2 1
res, max_ending_here = 1;1
res = _lis(arr, i);1
arr[i - 1] < arr[n - 1] && res + 1 > max_ending_here10 22 2 1
res = _lis(arr, i);2
arr[i - 1] < arr[n - 1] && res + 1 > max_ending_here22 9 3 1
Length of lis is 2

*/

        static int _lis(int arr[], int n)
        {
                // base case
        // 3  ==1 f
        // 2 == 1 f
                if (n == 1)
                        return 1;
                // 'max_ending_here' is length of LIS ending with
                // arr[n-1]
                int res, max_ending_here = 1;
                /* Recursively get all LIS ending with arr[0],
                arr[1] ... arr[n-2]. If arr[i-1] is smaller
                than arr[n-1], and max ending with arr[n-1] needs
                to be updated, then update it */
            // i     1 2

            // i     1
                for (int i = 1; i < n; i++) {
                 //   {10,22,9},    1 = 1
                 //   {10,22,9},  2   = 2
                 //   {10,22,9},    1 = 1
                        res = _lis(arr, i); //1  //1 //2
            //   a1-1 < a3-1 // a0 < a2 // 10 < 9
            //   a1-1 < a2-1   // a0 < a1 // 10 < 22
            //   a1-1 < a2-1   // a0 < a1 // 10 <22
                        if (arr[i - 1] < arr[n - 1]
                                && res + 1 > max_ending_here)
                                max_ending_here = res + 1; // 2
                }
                // Compare max_ending_here with the overall max. And
                // update the overall max if needed
                if (max_ref < max_ending_here)
                        max_ref = max_ending_here;
                // Return length of LIS ending with arr[n-1]
                return max_ending_here;
        }
        // The wrapper function for _lis()
        //lis({10.22.9}, 3)
        static int lis(int arr[], int n)
        {
                // The max variable holds the result
                max_ref = 1;
                // The function _lis() stores its result in max
                _lis(arr, n);
                // returns max
                return max_ref;
        }
        // driver program to test above functions
        public static void main(String args[])
        {
                int arr[] = { 10, 22, 9 };
                int n = arr.length;
                System.out.println("Length of lis is " + lis(arr, n)
                                                + "\n");
        }
}

