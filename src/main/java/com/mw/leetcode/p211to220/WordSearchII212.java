package com.mw.leetcode.p211to220;

import com.mw.leetcode.TrieNode;

import java.util.ArrayList;
import java.util.List;

public class WordSearchII212
{
    private TrieNode root = new TrieNode();
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

    public List<String> findWords(char[][] board, String[] words)
    {
        List<String> result = new ArrayList<>();

        if (board == null || board.length == 0)
            return result;

        for (String word : words)
            insert(word);

        int maxRow = board.length;
        int maxCol = board[0].length;

        boolean[][] visited = new boolean[maxRow][maxCol];
        // dfs
        for (int i = 0; i < maxRow; i++)
        {
            for (int j = 0; j < maxCol; j++)
            {
                search(board, visited, i, j, result, "");
            }
        }
        return result;
    }

    private void search(char[][] board, boolean[][] visited, int i, int j, List<String> result, String str)
    {
        int maxRow = board.length;
        int maxCol = board[0].length;

        if (i == -1 || j == -1 || i == maxRow || j == maxCol)
            return;

        visited[i][j] = true;
        str += board[i][j];

        TrieNode node = getLastNode(str);
        if (node != null) // then search.
        {
            if (node.terminates)
            {
                result.add(str);
            }
            else
            {
                search(board, visited, i - 1, j, result, str);
                search(board, visited, i, j + 1, result, str);
                search(board, visited, i + 1, j, result, str);
                search(board, visited, i, j - 1, result, str);
            }
        }
        visited[i][j] = false;
    }

    public static void main(String[] args)
    {
        String[] words = {"oath","pea","eat","rain"};
        char[][] board = {
                {'o','a','a','n'},
                {'e','t','a','e'},
                {'i','h','k','r'},
                {'i','f','l','v'}
        };

        for (String s : new WordSearchII212().findWords(board, words))
        {
            System.out.println(s);
        }
    }
}
