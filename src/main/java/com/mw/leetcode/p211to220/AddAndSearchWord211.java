package com.mw.leetcode.p211to220;

import com.mw.leetcode.TrieNode;

public class AddAndSearchWord211
{
    private TrieNode root = new TrieNode();
    // Adds a word into the data structure.
    public void addWord(String word) {
        if (word != null && word.length() > 0)
        {
            TrieNode cur = root;
            for (int i = 0; i < word.length(); i++)
            {
                TrieNode child = cur.getChild(word.charAt(i));
                if (child == null)
                {
                    child = new TrieNode(word.charAt(i));
                    cur.addChild(child);
                }
                cur = child;
            }
            cur.terminates = true;
        }
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word)
    {
        return search(root, word, 0);
    }

    private boolean search(TrieNode cur, String word, int start)
    {
        if (start == word.length())
            return cur.terminates;

        char c = word.charAt(start);
        if (c == '.')
        {
            // for each '.' we need to do dfs search.
            for (TrieNode node : cur.children)
            {
                boolean found = search(node, word, start + 1);
                if (found)
                {
                    return true;
                }
            }
            // it is not find in any of its children.
            return false;
        }
        else
        {
            TrieNode child = cur.getChild(c);
            if (child == null)
                return false;
            return search(child, word, ++start);
        }
    }

    public static void main(String[] args)
    {
        AddAndSearchWord211 trie = new AddAndSearchWord211();
        trie.addWord("ab");
        trie.addWord("bad");
        trie.addWord("dad");
        trie.addWord("mad");
        trie.addWord("pourparler");
        System.out.println(trie.search("pad"));
        System.out.println(trie.search("bad"));
        System.out.println(trie.search(".ad"));
        System.out.println(trie.search("..e"));
        System.out.println(trie.search("b.."));
        System.out.println(trie.search("p...p....."));
    }
}