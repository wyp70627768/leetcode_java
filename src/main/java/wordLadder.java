import java.util.*;

/*
127. Word Ladder
Medium

2094

947

Favorite

Share
Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

Only one letter can be changed at a time.
Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
Note:

Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
You may assume no duplicates in the word list.
You may assume beginWord and endWord are non-empty and are not the same.
Example 1:

Input:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

Output: 5

Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.
Example 2:

Input:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]

Output: 0

Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 */
public class wordLadder {
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord.equals(endWord)) {
            return 1;
        }
        HashSet<String> word_set = new HashSet<String>();
        for (String word: wordList) {
            word_set.add(word);
        }
        HashSet<String> seen = new HashSet<String>();
        Queue<String> queue = new LinkedList<String>();
        seen.add(beginWord);
        queue.offer(beginWord);

        int count = 1;
        while (!queue.isEmpty()) {
            count++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                for (String nextWord: getNextWords(word, word_set)) {
                    if (nextWord.equals(endWord)) {
                        return count;
                    }
                    if (seen.contains(nextWord)) {
                        continue;
                    }
                    queue.offer(nextWord);
                    seen.add(nextWord);
                }
            }
        }
        return 0;
    }
    private static ArrayList<String> getNextWords(String word, HashSet<String> word_set) {
        ArrayList<String> nextWords = new ArrayList<String>();
        for (int i = 0; i < word.length(); i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                if (word.charAt(i) == c)
                    continue;
                char[] char_list = word.toCharArray();
                char_list[i] = c;
                String nextWord = new String(char_list);
                if (word_set.contains(nextWord)) {
                    nextWords.add(nextWord);
                }
            }
        }
        return nextWords;
    }
    public static void main(String[] args) {
        String beginWord1 = "hit";

        String endWord1 = "cog";

        List<String> wordList1 = new ArrayList<String>();
        List<String> wordList2 = new ArrayList<String>();

        wordList1.add("hot");
        wordList1.add("dot");
        wordList1.add("dog");
        wordList1.add("lot");
        wordList1.add("log");
        wordList1.add("cog");

        wordList2.add("hot");
        wordList2.add("dot");
        wordList2.add("dog");
        wordList2.add("lot");
        wordList2.add("log");
        System.out.println(ladderLength(beginWord1, endWord1, wordList1));
        System.out.println(ladderLength(beginWord1, endWord1, wordList2));

    }
}
