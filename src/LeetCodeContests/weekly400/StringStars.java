package LeetCodeContests.weekly400;

import java.util.ArrayList;
import java.util.List;

public class StringStars {
    public static void main(String[] args) {
        System.out.println(clearStars("a*b*c"));
    }
    public static String clearStars(String s) {
        int n = s.length();
        List<List<Integer>> buckets = new ArrayList<>();

        for(int i = 0 ; i < 26; i++){
            buckets.add(new ArrayList<>());
        }

        boolean[] removed = new boolean[n];

        for(int i = 0 ; i < n ; i++){
            if(s.charAt(i) == '*'){
                removed[i] = true;
                removeIndex(buckets,removed);
            }else buckets.get(s.charAt(i) - 'a').add(i);
        }

        StringBuilder ans = new StringBuilder();
        for(int i = 0 ; i < n ; i++){
            if(!removed[i]) ans.append(s.charAt(i));
        }
        return ans.toString();
    }
    public static void removeIndex(List<List<Integer>> buckets, boolean[] removed){
        for(int i = 0; i < 26 ; i++){
            if(!buckets.get(i).isEmpty()){
                int lastIndex = buckets.get(i).size() -1;//lastIndex is the position (index) of the last element in the current bucket list.
                int indexToRemove = buckets.get(i).get(lastIndex);//indexToRemove is the actual value stored at that position in the bucket list, which corresponds to
                removed[indexToRemove] = true;
                buckets.get(i).remove(lastIndex);
                return;
            }
        }
    }
}
