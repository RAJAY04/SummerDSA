package Graphs.BFSandDFS;

import java.util.*;

public class WordLadderII {
    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = List.of("hot", "dot", "dog", "lot", "log", "cog");
        System.out.println(findLadders(beginWord, endWord, wordList));
    }


    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
return new ArrayList<>();

    }

    //Set<String> set = new HashSet<>();
    //        for (String s : wordList) set.add(s);
    //
    //        Queue<ArrayList<String>> queue = new ArrayDeque<>();
    //        ArrayList<String> list = new ArrayList<>();
    //        list.add(beginWord);
    //
    //        queue.add(list);
    //
    //        ArrayList<String> usedOnLevel = new ArrayList<>();
    //        usedOnLevel.add(beginWord);
    //
    //        int level = 1;
    //
    //        List<List<String>> res = new ArrayList<>();
    //
    //        while (!queue.isEmpty()) {
    //            ArrayList<String> vec = queue.poll();
    //            if (vec.size() > level) {
    //                level++;
    //                for (String it : usedOnLevel) {
    //                    set.remove(it);
    //                }
    //                usedOnLevel.clear();
    //            }
    //
    //            String word = vec.get(vec.size() - 1);
    //            if (word.equals(endWord)) {
    //                if (res.size() == 0) res.add(new ArrayList<>(vec));
    //                else if (res.get(0).size() == vec.size()) res.add(new ArrayList<>(vec));
    //            }
    //
    //            for (int i = 0; i < word.length(); i++) {
    //                char[] wordArray = word.toCharArray();
    //                char original = wordArray[i];
    //                for (char c = 'a'; c <= 'z'; c++) {
    //                    if (c == original) continue;
    //                    wordArray[i] = c;
    //                    String s = new String(wordArray);
    //                    if (set.contains(s)) {
    //                        ArrayList<String> temp = new ArrayList<>(vec);
    //                        temp.add(s);
    //                        queue.add(temp);
    //                        usedOnLevel.add(s);
    //                    }
    //                }
    //                wordArray[i] = original;
    //            }
    //        }
    //
    //        return res;
}

