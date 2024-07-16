package Graphs.BFSandDFS;

import java.util.*;

public class WordLadderII {
    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = List.of("hot","dot","dog","lot","log","cog");
        System.out.println(findLadders(beginWord, endWord, wordList));
    }
    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>();
        for(String s : wordList)dict.add(s);
        List<List<String>> res = new ArrayList<>();
        List<String> list = new ArrayList<>();
        list.add(beginWord);
        dfs(dict,beginWord.toCharArray(),endWord.toCharArray(),list,res);
        return res;
    }

    public static void dfs(Set<String> dict , char[] word ,char[] end,List<String> list,List<List<String>> res){
        if (Arrays.equals(word, end)) {
            list.add(new String(word));
            res.add(new ArrayList<>(list));
            list.remove(list.size() - 1); // Backtrack: remove the added word
            return;
        }
        for(int i = 0  ; i < word.length; i++){
            char originalChar = word[i];
            for(char c = 'a' ; c <= 'z'; c++){
                if (c == originalChar) continue;
                word[i] = c;
                String newS = new String(word);
                if(dict.contains(newS)){
                    list.add(newS);
                    dict.remove(newS);
                    dfs(dict,newS.toCharArray(),end,list,res);
                    list.remove(list.size() - 1);
                }
                word[i] = originalChar;
            }
        }

    }
}
