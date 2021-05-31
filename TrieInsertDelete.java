// Java implementation of search and insert operations
// on Trie
public class Trie {
      
    // Alphabet size (# of symbols)
    static final int ALPHABET_SIZE = 26;
      
    // trie node
    static class TrieNode
    {
        TrieNode[] children = new TrieNode[ALPHABET_SIZE]; // TrieNode [] children = new TrieNode[26]
       
        // isEndOfWord is true if the node represents
        // end of a word
        boolean isEndOfWord; // isEndOfWord
          
        TrieNode(){
            isEndOfWord = false; // f
            for (int i = 0; i < ALPHABET_SIZE; i++)
                children[i] = null; children[0] = false
        }
    };
       
    static TrieNode root;


        // If not present, inserts key into trie
    // If the key is prefix of trie node,
    // just marks leaf node

    //                       // the
                             // their
    static void insert(String key)
    {
        int level;
        int length = key.length(); // 3
        int index;

        TrieNode pCrawl = root;
             // level 0 1 2
        for (level = 0; level < length; level++)
        {

            index = key.charAt(level) - 'a'; // 't' - 'a'
            if (pCrawl.children[index] == null)         // root
                pCrawl.children[index] = new TrieNode(); // t
                                                         // h
                                                         // e isEndOfWord t
            pCrawl = pCrawl.children[index];             // i
        }                                                // r  isEndOfWord t

        // mark last node as leaf
        pCrawl.isEndOfWord = true;
    }

    // Returns true if key presents in trie, else false
                            // the
    static boolean search(String key)
    {
        int level;
        int length = key.length();
        int index;
        TrieNode pCrawl = root;
            // level 0 1 2
        for (level = 0; level < length; level++)
        {
            index = key.charAt(level) - 'a';   // 't' - 'a'

            if (pCrawl.children[index] == null)
                return false; // not found

            pCrawl = pCrawl.children[index];
        }

        return (pCrawl != null && pCrawl.isEndOfWord); // e != null t &&  e.isEndOfWord t
    }

    public static void main(String args[])
    {
        // Input keys (use only 'a' through 'z' and lower case)
        String keys[] = {"the", "a"} ;//"there", "answer", "any",
                        // "by", "bye", "their"};

        String output[] = {"Not present in trie", "Present in trie"};


        root = new TrieNode();

        // Construct trie
        int i;
        for (i = 0; i < keys.length ; i++)
            insert(keys[i]);

        // Search for different keys
        if(search("the") == true)
            System.out.println("the --- " + output[1]);
        else System.out.println("the --- " + output[0]);

        if(search("these") == true)
            System.out.println("these --- " + output[1]);
        else System.out.println("these --- " + output[0]);

        if(search("their") == true)
            System.out.println("their --- " + output[1]);
        else System.out.println("their --- " + output[0]);

        if(search("thaw") == true)
            System.out.println("thaw --- " + output[1]);
        else System.out.println("thaw --- " + output[0]);

    }
}
