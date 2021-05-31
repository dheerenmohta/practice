find triplet equal to sum	


static boolean find3Numbers(int A[], // { 1, 3, 2, 8};
                                     // { 1, 1, 1};
                                     // { 1, 1, 0, 1};
                                // 4            6
                                // 3            3
                                // 4            3
                                int arr_size, int sum)
	{
		// Fix the first element as A[i]
        // i 0 1 
        // i 0 
        // i 0 1
		for (int i = 0; i < arr_size - 2; i++) {

			// Find pair in subarray A[i+1..n-1]
			// with sum equal to sum - A[i]
            //              s
			HashSet<Integer> s = new HashSet<Integer>();
            //      
			int curr_sum = sum - A[i]; // 6 -1 = 5 // 6 -3 
                                       // 2 
            // j 1 2 3 
            // j 1 2
            // j 1 2 3 
			for (int j = i + 1; j < arr_size; j++)
			{       // s(5 - 3) // s(2) // s(3) // s(-3)
                    // s.(2-1) // s(1) f
                    // s.(2-1) // s(1) t

                    // s.(2-1) // s(1) f
                    // s(2-0) // s(2) f
                    // // s(2-1) // s(1) t
				if (s.contains(curr_sum - A[j]))
				{
					System.out.printf(""Triplet is %d,
										%d, %d"", A[i],
									A[j], curr_sum - A[j]);// 1 3 2
                                                           // a[0] a[2] 1
                                                           // 1     1   1 
                                                           // a[0] a[3] 1
                                                           // 1     1   1 
					return true;
				}
                // s.add(a1) // [3,2]
                // s.add(a1) // s.add(1) // [1,]

                // [1]
				s.add(A[j]);
			}
		}

		// If we reach here, then no triplet was found
		return false
	}
