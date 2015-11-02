package com.mw.leetcode.p121to130;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class WordLadder127
{
    public static int ladderLength(String beginWord, String endWord, Set<String> wordList)
    {
        // Create a queue to hold current word to iterate from.
        Queue<WordNode> next = new LinkedList<>();
        next.add(new WordNode(beginWord, 1));
        wordList.add(endWord); // need to add the word into the dictionary.

        while (!next.isEmpty()) // we have word to search.
        {
            WordNode wordNode = next.poll();
            char[] array = wordNode.word.toCharArray();

            if (wordNode.word.equals(endWord))
            {
                return wordNode.numSteps;
            }

            for (int i = 0; i < array.length; i++)
            {
                for (char c = 'a'; c <= 'z'; c++)
                {
                    if (array[i] != c)
                    {
                        char temp = array[i];
                        array[i] = c; // swap the char to become new String.
                        String newWord = new String(array);
                        if (wordList.contains(newWord))
                        {
                            next.add(new WordNode(newWord, wordNode.numSteps + 1));
                            wordList.remove(newWord);
                        }

                        array[i] = temp; // revert the c, because we need to keep the word as it was.
                    }
                }
            }
        }

        return 0;
    }

    public static class WordNode
    {
        public String word;
        public int numSteps;

        public WordNode(String word, int numSteps)
        {
            this.word = word;
            this.numSteps = numSteps;
        }
    }

    public static void main(String[] args)
    {
        Set<String> wordList = new HashSet<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");


        System.out.println(ladderLength("hit", "cog", wordList));
    }
}
