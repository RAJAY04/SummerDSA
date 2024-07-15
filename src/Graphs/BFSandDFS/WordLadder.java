package Graphs.BFSandDFS;

import java.util.*;

public class WordLadder {
    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = List.of("hot","dot","dog","lot","log","cog");
        System.out.println(ladderLength(beginWord, endWord, wordList));
    }
    static class Pair{
        String s;
        int level;
        Pair(String s, int level){
            this.s = s;
            this.level = level;
        }
    }
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>();
        for(String s : wordList){
            dict.add(s);
        }
        Queue<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(beginWord,1));
        while(!queue.isEmpty()){
            String s = queue.peek().s;
            int level = queue.peek().level;
            if(s.equals(endWord))return level;
            for(int i = 0 ; i < s.length(); i++){
                String beg = s.substring(0,i);
                String end = s.substring(i + 1);
                for(char c = 'a'; c <= 'z' ; c++){
                    String newS = beg + c + end;
                    if(dict.contains(beg + c + end)){
                        queue.add(new Pair(newS,level + 1));
                        dict.remove(newS);
                    }
                }
            }
            queue.poll();
        }
        return 0;
    }

//most optimal
    public static int ladderLength1(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) return 0;

        Queue<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(beginWord, 1));

        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            String s = current.s;
            int level = current.level;

            if (s.equals(endWord)) return level;

            char[] sArr = s.toCharArray();
            for (int i = 0; i < sArr.length; i++) {
                char originalChar = sArr[i];
                for (char c = 'a'; c <= 'z'; c++) {
                    if (c == originalChar) continue;
                    sArr[i] = c;
                    String newS = new String(sArr);
                    if (dict.contains(newS)) {
                        queue.add(new Pair(newS, level + 1));
                        dict.remove(newS);
                    }
                }
                sArr[i] = originalChar;
            }
        }

        return 0;
    }
}
