//Following activities are selected : n0 1 3 4

// Prints a maximum set of activities that can be done by a single
        // person, one at a time.
        // n --> Total number of activities
        // s[] --> An array that contains start time of all activities
        // f[] --> An array that contains finish time of all activities
        //int s[] =  {1, 3, 0, 5, 8, 5};
    //int f[] =  {2, 4, 6, 7, 9, 9};
    //n 6
        public static void printMaxActivities(int s[], int f[], int n)
        {
        int i, j;

        System.out.print("Following activities are selected : n");

        // The first activity always gets selected
        i = 0;
        // n 0
        System.out.print(i+" ");

        // Consider rest of the activities
        // j 1 2 3 4 5
        //int s[] =  {1, 3, 0, 5, 8, 5};
    //int f[] =  {2, 4, 6, 7, 9, 9};
        for (j = 1; j < n; j++)
        {
                // If this activity has start time greater than or
                // equal to the finish time of previously selected
                // activity, then select it
                // s1 >= f0. 3 >= 2 s2 >= f1 0 >= 4
                if (s[j] >= f[i])
                {
                    // 1 3 4
                        System.out.print(j+" ");
                        // i 1
                        i = j;
                }
        }
        }


//How does Greedy Choice work for Activities sorted according to finish time?
