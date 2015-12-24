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

    // Returns if the word is in the trie.
    public boolean search(String word)
    {
        if (root.children.isEmpty() && (word == null || word.length() == 0))
            return true;
        else
        {
            TrieNode node = getLastNode(word);
            return node != null && node.terminates;
        }
    }

    private TrieNode getLastNode(String word)
    {
        if (word != null && word.length() > 0)
        {
            TrieNode cur = root;
            for (int i = 0; i < word.length(); i++)
            {
                TrieNode child = cur.getChild(word.charAt(i));
                if (child != null)
                {
                    cur = child;
                }
                else
                {
                    return null;
                }
            }
            return cur;
        }
        return null;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix)
    {
        if (root.children.isEmpty() && (prefix == null || prefix.length() == 0))
            return true;
        else
        {
            TrieNode node = getLastNode(prefix);
            return node != null;
        }
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


