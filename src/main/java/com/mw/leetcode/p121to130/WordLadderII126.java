package com.mw.leetcode.p121to130;

import java.util.*;

public class WordLadderII126
{
    public static List<List<String>> ladderLength(String beginWord, String endWord, Set<String> wordList)
    {
        // Create a queue to hold current word to iterate from.
        Queue<WordNode> next = new LinkedList<>();
        List<String> initList = new ArrayList<>();
        initList.add(beginWord);
        next.add(new WordNode(beginWord, null, 1));
        wordList.add(endWord); // need to add the word into the dictionary.

        List<List<String>> result = new ArrayList<>();
        int minStep = 0;

        HashSet<String> visited = new HashSet<>(); // ******** THE ONLY REASON IT WORKS IS even dot and lot both visited in two different thread,
                                                        // you can't visit dot again from the thread visited lot.
                                                        // because if you go dot again from lot. you are actually not doing the minimum step.
        HashSet<String> unvisited = new HashSet<>();
        unvisited.addAll(wordList);

        int preNumSteps = 0;
        while (!next.isEmpty()) // we have word to search.
        {
            WordNode wordNode = next.poll();
            int currNumSteps = wordNode.numSteps;
            char[] array = wordNode.word.toCharArray();

            if (wordNode.word.equals(endWord))
            {
                if(minStep == 0)
                {
                    minStep = wordNode.numSteps;
                }
                else
                {
                    if (wordNode.numSteps < minStep)
                    {
                        result.clear();
                    }
                }

                //recursively add result.
                ArrayList<String> t = new ArrayList<>();
                t.add(wordNode.word);
                while (wordNode.pre != null)
                {
                    t.add(0, wordNode.pre.word);
                    wordNode = wordNode.pre;
                }
                result.add(t);

                continue;
            }

            if(preNumSteps < currNumSteps)
            {
                unvisited.removeAll(visited);
            }
            preNumSteps = currNumSteps;

            for (int i = 0; i < array.length; i++)
            {
                for (char c = 'a'; c <= 'z'; c++)
                {
                    if (array[i] != c)
                    {
                        char temp = array[i];
                        array[i] = c; // swap the char to become new String.
                        String newWord = new String(array);
                        if (unvisited.contains(newWord))
                        {
                            next.add(new WordNode(newWord, wordNode, wordNode.numSteps + 1));
                            visited.add(newWord);
                        }

                        array[i] = temp; // revert the c, because we need to keep the word as it was.
                    }
                }
            }
        }

        return result;
    }

    public static class WordNode
    {
        public String word;
        public WordNode pre;
        public int numSteps;

        public WordNode(String word, WordNode pre, int numSteps)
        {
            this.word = word;
            this.pre = pre;
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


        for (List<String> result : ladderLength("hit", "cog", wordList))
        {
            for (String s : result)
            {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }
}
