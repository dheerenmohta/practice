

Set<String> res;
    public List<String> generateParenthesis(int n) {
        res = new HashSet();
        //    2  2 ""
        recur(n, n, "");
        return new ArrayList(res);
    }
                         // 2        2         ""
                         //  1        0    (
                         //  0        0    ((

                         //  0     1        (()
                         //  1     1        ()
                         //  0     1     ()(
    public void recur(int left, int right, String curr) {
             // 0 == 0 && 0 == 0
             //
        if (left == 0 && right == 0) {
            res.add(curr); // (()) ()()
            return;
        }
                // Add left parentheses only when remaining left > 0
        // 2 > 0 t
        // 1 > 0 t

        //  1 > 0
        if (left > 0){
            //     1        2    (
            //     0        2    ((

            //     0       1     ()(
            recur(left-1, right, curr + '(');

        }
        // If right < left, it means you will end up with an imbalanced  string. Add right parentheses, when you new that the resultant string will be balanced
        // 0 < 2 t
        // 0 < 1 t

        // 1  < 2 t
        // 0 < 1 t
        if (left < right)
                //  0     1        (()
                //  0     0        res = (())
                //  1     1        ()
                //  0     0     ()()
            recur(left, right-1, curr + ')');
    }
}



4
{}{}
{{}}



// open store the count of opening parenthesis
        // close store the count of closing parenthesis
                                       // str[4]      0,     2,        0,       0
                                       // [{].        1      2.        1.       0
                                       // [{ }].      2      2.        1.       1
                                       // [{ } {].    3      2.        2.       1
                                       //[{ } { }].   4.     2.        2.       2
        static void _printParenthesis(char str[], int pos, int n, int open, int close)
        {
            // 0 == 2 f
            // 0 == 2 f
            // 1 == 2 f
            // 1 == 2 f
            // 2 == 2 t
                if(close == n)
                {
                        // print the possible combinations
                        //  i 0 1 2 3 
                        for(int i=0;i<str.length;i++)
                            // [{ } { }]
                                System.out.print(str[i]);
                        System.out.println();
                        return;
                }
                else
                {       // 0 > 0 f
                        // 1 > 0 t
                        // 1 > 1 f
                        // 2 > 1 t
                        if(open > close) {
                            // str[1] = } // [{ }]
                            // str[3] = } // [{ } { }]
                                str[pos] = '}';
                                //                [{ }].  2   2.  1.      1
                                            //[{ } { }].  4.  2.  2.      2
                                _printParenthesis(str, pos+1, n, open, close+1);
                        }
                        // 0 < 2 t
                        // 1 < 2 t
                        if(open < n) {
                            // str[0] = { // [{]
                            // str2 = { // [{ } {]
                                str[pos] = '{';
                                //                [{].  1     2.  1.      0
                                            //[{ } {].  3.    2.  2.      1
                                _printParenthesis(str, pos+1, n, open+1, close);
                        }
                }
        }
        
        // Wrapper over _printParenthesis()
        //                             char str[4], 2
        static void printParenthesis(char str[], int n)
        {       
            // 2 > 0                   str[4] 0, 2, 0, 0
                if(n > 0). _printParenthesis(str, 0, n, 0, 0);
                return;
        }
        
        // driver program
        public static void main (String[] args)
        {
                int n = 2;
                System.out.println(2*n);
                char[] str = new char[2 * n];// char [] str = new char[2*2]= new char[4]
                printParenthesis(str, 2);
        }
}
