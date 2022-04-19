
    class TrieNode{

        TrieNode[] children;
        boolean hasWord ;

        TrieNode(){
            children = new TrieNode[26];
            hasWord = false;
        }

        public void insert(String word, int index){
            if(index == word.length()){
                this.hasWord = true;
                return;
            }

            int pos = word.charAt(index)-'a';
            if(children[pos] == null){
                children[pos] = new TrieNode();
            }

            children[pos].insert(word, index+1);

        }

        public TrieNode find(String word, int index){
            if(index == word.length()){
                return this;
            }

            int pos = word.charAt(index)-'a';
            if(children[pos] == null){
                return null;
            }

            return children[pos].find(word, index+1);

        }
    }


    class TrieNodeSolution {

        TrieNode root;

        public TrieNodeSolution() {
            // do intialization if necessary
            root = new TrieNode();
        }


        /*
         * @param word: a word
         * @return: nothing
         */
        public void insert(String word) {
            // write your code here
            root.insert(word, 0);

        }

        /*
         * @param word: A string
         * @return: if the word is in the trie.
         */
        public boolean search(String word) {
            // write your code here
            TrieNode node = root.find(word, 0);

            if (node != null && node.hasWord) {
                return true;
            } else {
                return false;
            }
        }

        /*
         * @param prefix: A string
         * @return: if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            // write your code here
            TrieNode node = root.find(prefix, 0);

            if (node != null) {
                return true;
            } else {
                return false;
            }
        }
    }
}
