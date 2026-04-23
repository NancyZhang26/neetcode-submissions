class WordDictionary {

    class TrieNode {
        TrieNode[] children;
        boolean isWord;

        public TrieNode() {
            this.children = new TrieNode[26];
            this.isWord = false;
        }
    }

    TrieNode node;

    public WordDictionary() {
        this.node = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode cur = this.node;

        for (char c: word.toCharArray()) {
            if (cur.children[c - 'a'] == null) {
                cur.children[c - 'a'] = new TrieNode();
            }
            cur = cur.children[c-'a'];
        }
        cur.isWord = true;
    }

    public boolean search(String word) {
        return dfs(word, 0, node);
    }

    public boolean dfs(String word, int j, TrieNode n) {
        TrieNode cur = n;

        for (int i = j; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c=='.') {
                for (TrieNode d: cur.children) {
                    if (d!=null && dfs(word, i+1, d)) {
                        return true;
                    }
                }
                return false;
            } else {
                if (cur.children[c-'a']==null) {
                    return false;
                }
                cur = cur.children[c-'a'];
            }
        }

        return cur.isWord;
    }
}
