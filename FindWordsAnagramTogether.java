
        // class for each word of duplicate array
        static class Word {
                String str; // to store word itself
                int index; // index of the word in the
                // original array

                // constructor
                Word(String str, int index)
                {
                        this.str = str;
                        this.index = index;
                }
        }

        // class to represent duplicate array.
    // { "cat", "dog", "tac", "god", "act" };
        static class DupArray {
                Word[] array; // Array of words
                int size; // Size of array

                // constructor
        //          { "cat", "dog", "tac", "god", "act" }   5
                public DupArray(String str[], int size)
                {

                        this.size = size; // 5
                        array = new Word[size]; // [5]

                        // One by one copy words from the
                        // given wordArray to dupArray
                        int i;
            // 0 1 2 3 4
                        for (i = 0; i < size; ++i) {
                                // create a word Object with the
                                // str[i] as str and index as i
                // a[0] 
                // cat
                // 0
                                array[i] = new Word(str[i], i);
                        }
                }
        }

        // Compare two words. Used in Arrays.sort() for
        // sorting an array of words
        static class compStr implements Comparator<Word> {
                public int compare(Word a, Word b)
                {
                        return a.str.compareTo(b.str);
                }
        }

        // Given a list of words in wordArr[],
    //                              { "cat", "dog", "tac", "god", "act" };
        static void printAnagramsTogether(String wordArr[],
                                                                        int size)
        {
                // Step 1: Create a copy of all words present
                // in given wordArr. The copy will also have
                // original indexes of words
        // 
                DupArray dupArray = new DupArray(wordArr, size);// { "cat" 0, "dog" 1, "tac" 2, "god" 3, "act" 4 };

                // Step 2: Iterate through all words in
                // dupArray and sort individual words.
                int i;
                for (i = 0; i < size; ++i) {
            //  "cat"               
                        char[] char_arr = dupArray.array[i].str.toCharArray();
                        Arrays.sort(char_arr); // act
                        dupArray.array[i].str = new String(char_arr);// act
                }

                // Step 3: Now sort the array of words in
                // dupArray
                Arrays.sort(dupArray.array, new compStr());// 

                // Step 4: Now all words in dupArray are together,
                // but these words are changed. Use the index
                // member of word struct to get the corresponding
                // original word
                for (i = 0; i < size; ++i)
                        System.out.print(wordArr[dupArray.array[i].index] + " ");
        }

        // Driver program to test above functions
        public static void main(String args[])
        {
                String wordArr[] = { "cat", "dog", "tac", "god", "act" };
                int size = wordArr.length;
                printAnagramsTogether(wordArr, size);
        }
}
// This code is contributed by Sumit Ghosh

