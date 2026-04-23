class WordDictionary {

    class TrieNode {

        TrieNode[] children;
        boolean isWord;

        public TrieNode() {
            this.children = new TrieNode[26];
            this.isWord = false;
        }
    }

    TrieNode root;

    public WordDictionary() {
        this.root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode node = root;

        for (char c: word.toCharArray()) {
            if (node.children[c-'a']==null) {
                node.children[c-'a'] = new TrieNode();
            }
            node = node.children[c-'a'];
        }

        node.isWord = true;
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    public boolean dfs(String word, int j, TrieNode n) {
        TrieNode curr = n;

        for (int i = j; i < word.length(); i++) {
            char c = word.charAt(i);

            if (c=='.') {
                for (TrieNode no: curr.children) {
                    if (no!=null && dfs(word, i+1, no)) {
                        return true;
                    }
                }
                return false;
            } else {
                if (curr.children[c-'a']==null) {
                    return false;
                }
                curr = curr.children[c-'a'];
            }
        }

        return curr.isWord;
    }
}
