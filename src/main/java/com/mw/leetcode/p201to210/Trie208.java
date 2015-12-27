package com.mw.leetcode.p201to210;

import com.mw.leetcode.TrieNode;

public class Trie208
{
    private TrieNode root;

    public Trie208()
    {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word)
    {
        TrieNode node = root;
        for (char c : word.toCharArray())
        {
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode();
            }
            node = node.children[c - 'a'];
        }
        node.terminates = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word)
    {
        TrieNode node = getLastNode(word);
        return node != null && node.terminates;
    }

    private TrieNode getLastNode(String word)
    {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null) return null;
            node = node.children[c - 'a'];
        }
        return node;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix)
    {
        TrieNode node = getLastNode(prefix);
        return node != null;
    }

    public static void main(String[] args)
    {
        Trie208 trie = new Trie208();
        trie.insert("one");
        trie.insert("two");
        trie.insert("tweet");
        trie.insert("three");

        System.out.println(trie.startsWith("tw"));
        System.out.println(trie.startsWith("twa"));
        System.out.println(trie.search("one"));
        System.out.println(trie.search("tw"));
        System.out.println(trie.search("tweete"));
    }
}


