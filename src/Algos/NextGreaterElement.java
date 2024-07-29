package Algos;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

public class NextGreaterElement {
    public static void main(String[] args) {
        int[] nums1 = {4,1,2};
        int[] nums2 = {1,3,4,2};
        int[] ans = nextGreaterElement(nums1, nums2);
        for(int i : ans){
            System.out.print(i + " ");
        }
    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for(int num : nums2){
            while(!stack.isEmpty() && stack.peek() < num){
                map.put(num,stack.pop());
            }
            stack.push(num);
        }
        int[] res = new int[nums1.length];
        for(int i = 0 ; i < nums1.length; i++){
            res[i] = map.getOrDefault(nums1[i],-1);
        }
        return res;
    }
}
