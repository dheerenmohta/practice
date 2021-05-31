/*
 *
 * 
input: arr[] = {9:00, 9:40, 9:50, 11:00, 15:00, 18:00}
dep[] = {9:10, 12:00, 11:20, 11:30, 19:00, 20:00}
Output: 3
Explantion: There are at-most three trains at a time (time between 11:00 to 11:20)

Input: arr[] = {9:00, 9:40}
dep[] = {9:10, 12:00}
Output: 1
Explantion: Only one platform is needed.
*/


Approach: The idea is to take every interval one by one and find the number of intervals that overlap with it. Keep track of the maximum number of intervals that overlap with an interval. Finally, return the maximum value.


// Returns minimum number of platforms reqquired
    public static int findPlatform(int arr[], int dep[],
                                   int n)
    {

        // plat_needed indicates number of platforms
        // needed at a time
        int plat_needed = 1, result = 1;
        int i = 1, j = 0;

        // run a nested  loop to find overlap
        for (i = 0; i < n; i++) {
            // minimum platform
            plat_needed = 1;

            for (j = i + 1; j < n; j++) {
                // check for overlap
                if ((arr[i] >= arr[j] && arr[i] <= dep[j])
                    || (arr[j] >= arr[i]
                        && arr[j] <= dep[i]))
                    plat_needed++;
            }

            // update result
            result = Math.max(result, plat_needed);
        }

        return result;
    }
