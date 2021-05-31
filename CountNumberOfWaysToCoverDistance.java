// Function returns count of ways to cover 'dist'
    static int printCountRec(int dist)
    {
        // Base cases
        if (dist<0)   
            return 0;
        if (dist==0)   
            return 1;
  
        // Recur for all previous 3 and add the results
        return printCountRec(dist-1) +
               printCountRec(dist-2) +
               printCountRec(dist-3);
    }
     
    // driver program
    public static void main (String[] args)
    {
        int dist = 4;
        System.out.println(printCountRec(dist));
    }


function printCountDP(dist)
{
    let count = new Array(dist + 1);

    // Initialize base values. There is one
    // way to cover 0 and 1 distances
    // and two ways to cover 2 distance
    count[0] = 1;
    if (dist >= 1)
        count[1] = 1;
    if (dist >= 2)
        count[2] = 2;

    // Fill the count array
    // in bottom up manner
    for(let i = 3; i <= dist; i++)
        count[i] = count[i - 1] +
                   count[i - 2] +
                   count[i - 3];

    return count[dist];
}



int printCountDP(int dist)
{
        //Create the array of size 3.
        int  ways[3] , n = dist;

        //Initialize the bases cases
        ways[0] = 1;
        ways[1] = 1;
        ways[2] = 2;

        //Run a loop from 3 to n
        //Bottom up approach to fill the array
        for(int i=3 ;i<=n ;i++)
            ways[i%3] = ways[(i-1)%3] + ways[(i-2)%3] + ways[(i-3)%3];

        return ways[n%3];
}



