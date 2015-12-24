package com.mw.leetcode;

import java.util.ArrayList;
import java.util.List;

public class TrieNode
{
    public Character val;
    public boolean terminates;
    public List<TrieNode> children = new ArrayList<>();

    public TrieNode()
    {
    }

    public TrieNode(Character val)
    {
        this.val = val;
    }

    public TrieNode getChild(char c)
    {
        for (TrieNode node : children)
        {
            if (node.val == c)
            {
                return node;
            }
        }
        return null;
    }

    public void addChild(TrieNode trieNode)
    {
        children.add(trieNode);
    }
}
