package com.mw.leetcode;

public class TrieNode
{
    public Character val;
    public boolean terminates;
    public TrieNode[] children = new TrieNode[26]; // c - 'a' as index.

    public TrieNode()
    {
    }

    public TrieNode(Character val)
    {
        this.val = val;
    }

    public TrieNode getChild(char c)
    {
        return children[c - 'a'];
    }

    public void addChild(TrieNode trieNode)
    {
        children[trieNode.val - 'a'] = trieNode;
    }
}
