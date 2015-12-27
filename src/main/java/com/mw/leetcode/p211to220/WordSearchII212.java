package com.mw.leetcode.p211to220;

import com.mw.leetcode.TrieNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordSearchII212
{
    private TrieNode root = new TrieNode();
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

    private TrieNode getLastNode(String word)
    {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null) return null;
            node = node.children[c - 'a'];
        }
        return node;
    }

    public List<String> findWords(char[][] board, String[] words)
    {
        Set<String> result = new HashSet<>();

        if (board == null || board.length == 0)
            return new ArrayList<>(result);

        Set<String> allWords = new HashSet<>();
        for (String word : words)
        {
            allWords.add(word);
            insert(word);
        }

        int maxRow = board.length;
        int maxCol = board[0].length;

        boolean[][] visited = new boolean[maxRow][maxCol];
        // dfs
        for (int i = 0; i < maxRow; i++)
        {
            for (int j = 0; j < maxCol; j++)
            {
                search(board, visited, i, j, result, "", allWords.size());
            }
        }
        return new ArrayList<>(result);
    }

    private void search(char[][] board, boolean[][] visited, int i, int j, Set<String> result, String str, int maxWord)
    {
        int maxRow = board.length;
        int maxCol = board[0].length;

        if (result.size() == maxWord || i == -1 || j == -1 || i == maxRow || j == maxCol)
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
                search(board, visited, i - 1, j, result, str, maxWord);
                search(board, visited, i, j + 1, result, str, maxWord);
                search(board, visited, i + 1, j, result, str, maxWord);
                search(board, visited, i, j - 1, result, str, maxWord);
            }
        }
        visited[i][j] = false;
    }

    public static void main(String[] args)
    {
//        String[] words = {"oath","pea","eat","rain"};
//
//        char[][] board = {
//                {'o','a','a','n'},
//                {'e','t','a','e'},
//                {'i','h','k','r'},
//                {'i','f','l','v'}
//        };
        String[] words = {"aaaa","aaaa","aaaa"};
        char[][] board = {"aaaaaaaaaaaa".toCharArray(),"aaaaaaaaaaaaa".toCharArray(),"aaaaaaaaaaab".toCharArray()};
        for (String s : new WordSearchII212().findWords(board, words))
        {
            System.out.println(s);
        }
    }
}
