

// Function
                           //"ABDC"; "ABC"
static String Minimum_Window(char []s, char []t)
{

	int m[] = new int[256];

	// Answer
	int ans = Integer.MAX_VALUE; // length of ans
	int start = 0; // starting index of ans
	int count = 0;
	// creating map
	for (int i = 0; i < t.length; i++) {
	     System.out.println("D1");
	     /*
	     D1
         0
         1
         D1
         0
         1
         D1
         0
         1
	     */
	    System.out.println(m[t[i]]);
		if (m[t[i]] == 0)
			count++;
		m[t[i]]++;
		System.out.println(m[t[i]]);
	}
	

	// References of Window
	int i = 0;
	int j = 0;

	// Traversing the window
	while (j < s.length)
	{
	     /*
	    D2
        j0
        m[s[j]] :1
        m[s[j]]--:0
        
        D2
        j1
        m[s[j]] :1
        m[s[j]]--:0
        
        D2  
        j2
        m[s[j]] :0
        m[s[j]]--:-1
        
        D2
        j3
        m[s[j]] :1
        m[s[j]]--:0
	     */
	     System.out.println("D2");
	     System.out.println("j" + j);
	     System.out.println("m[s[j]] :"+m[s[j]]);
		// Calculations
		m[s[j]]--;
        System.out.println("m[s[j]]--:"+m[s[j]]);


		if (m[s[j]] == 0){
		    
			count--;
			// D3 count--:2
			// D3 count--:1
			// D3 count--:0
			System.out.println("D3 count--:"+count);
		}

		// Condition matching
		if (count == 0)
		{
		    System.out.println(" D4 count :"+count);
		    // D4 count :0
			while (count == 0)
			{
			
				// Soring ans
				// D5 ans &gt; j - i + 1 :2147483647 : 4
		        System.out.println("D5 ans > j - i + 1 :"+ans+" : "+(j - i + 1));

				if (ans > j - i + 1)
				{
					ans = Math.min(ans, j - i + 1);
                    // D6 start  :0
					System.out.println("D6 start  :"+start);
					start = i;
				}
			
				// Sliding I
				// Calculation for removing I
				m[s[i]]++;
                // D7 m[s[i]]++ : 1
				System.out.println("D7 m[s[i]]++ : "+m[s[i]]);
				if (m[s[i]] > 0){
					count++;
                    System.out.println("p1 :"+count);
                }
                
				i++;
                // D8 i++ :1
				System.out.println("D8 i++ :"+i);
			}
		}
		j++;
		System.out.println("j++ :"+j);
	}

	if (ans != Integer.MAX_VALUE)
		return String.valueOf(s).substring(start, ans+start);
	else
		return "-1";
}

public static void main(String[] args)
{
	String s = "ABDC";
	String t = "ABC";
	
	System.out.print("-->Smallest window that contain all character : ");
	System.out.print(Minimum_Window(s.toCharArray(), t.toCharArray()));

}
}