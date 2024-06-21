package LeetCodeContests.weekly400;

import java.util.*;

public class StringStars {
    public static void main(String[] args) {
//        System.out.println(clearStars("a*b*c"));
        System.out.println(clearStars1("aaba*"));
    }

    //did this shit myself while revising
    //just the key point is storing every single characters occurence indexes
    public static String clearStars1(String s) {
        Stack<Integer>[] arr = new Stack[26];
        for(int i = 0 ; i < 26 ;i++){
            arr[i] = new Stack();
        }
        Set<Integer> ans = new HashSet<>();

        for(int i = 0 ;i < s.length() ; i++){
            if(s.charAt(i) != '*'){
                arr[s.charAt(i) - 'a'].push(i);
            }else{
                for(int j = 0 ; j < 26; j++){
                    if(!arr[j].isEmpty()){
                        int index = arr[j].pop();
                        ans.add(i);
                        ans.add(index);
                        break;
                    }
                }
            }
        }
        StringBuilder res = new StringBuilder();
        for(int i = 0 ; i < s.length(); i++){
            if(!ans.contains(i)){
                res.append(s.charAt(i));
            }
        }
        return res.toString();
    }
//    public static String clearStars(String s) {
//        int n = s.length();
//        List<List<Integer>> buckets = new ArrayList<>();
//
//        for(int i = 0 ; i < 26; i++){
//            buckets.add(new ArrayList<>());
//        }
//
//        boolean[] removed = new boolean[n];
//
//        for(int i = 0 ; i < n ; i++){
//            if(s.charAt(i) == '*'){
//                removed[i] = true;
//                removeIndex(buckets,removed);
//            }else buckets.get(s.charAt(i) - 'a').add(i);
//        }
//
//        StringBuilder ans = new StringBuilder();
//        for(int i = 0 ; i < n ; i++){
//            if(!removed[i]) ans.append(s.charAt(i));
//        }
//        return ans.toString();
//    }
//    public static void removeIndex(List<List<Integer>> buckets, boolean[] removed){
//        for(int i = 0; i < 26 ; i++){
//            if(!buckets.get(i).isEmpty()){
//                int lastIndex = buckets.get(i).size() -1;//lastIndex is the position (index) of the last element in the current bucket list.
//                int indexToRemove = buckets.get(i).get(lastIndex);//indexToRemove is the actual value stored at that position in the bucket list, which corresponds to
//                removed[indexToRemove] = true;
//                buckets.get(i).remove(lastIndex);
//                return;
//            }
//        }
//    }
}
