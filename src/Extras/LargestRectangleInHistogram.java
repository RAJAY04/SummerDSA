package Extras;

import java.util.Stack;

public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        int[] heights = {2,1,5,6,2,3,1};
        System.out.println(largestRectangleArea(heights));
        System.out.println(largestRectangleArea1(heights));
        System.out.println(largestRectangleArea2(heights));
    }
    //for every index find left smaller ele and right smaller ele that give us width , width * arr[i] is our area.
    public static int largestRectangleArea(int[] heights) {//brute force
        int max = 0;
        for(int i = 0  ; i < heights.length; i++){
            int LSE = lse(heights,i);
            int RSE = rse(heights,i);
            int area = (RSE - LSE + 1) * heights[i];
            max = Math.max(area,max);
        }
        return max;
//this code results in a TLE
    }
    public static int lse(int[] arr, int i){
        if(i == 0) return i;
        int j = i - 1;
        while(j >= 0){
            if(arr[j] < arr[i])break;
            j--;
        }
        return j + 1;//returning index next to the last smaller element
    }
    public static int rse(int[] arr, int i){
        if(i == arr.length - 1)return i;
        int j = i + 1;
        while( j < arr.length){
            if(arr[j] < arr[i])break;
            j++;
        }
        return j - 1;//returning index previous to the last smaller element
    }

    //now we follow the same approach but with a stack to find the left smaller element and right smaller element

    public static int largestRectangleArea1(int[] heights) {
        int[] ls = findLS(heights);
        int[] rs = findRs(heights);
        int max = 0;
        for(int i = 0 ; i < heights.length; i++){
            int area = (rs[i] - ls[i] + 1) * heights[i];
            max = Math.max(area,max);
        }
        return max;
    }
    public static int[] findLS(int[] arr){
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int[] ls = new int[n];
        for(int i = 0 ; i < n ;i++){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                ls[i] = 0;
            }else ls[i] = st.peek() + 1;
            st.push(i);
        }
        return ls;
    }
    public static int[] findRs(int[] arr){
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int[] rs = new int[n];
        for(int i =  n - 1; i >= 0 ;i--){
            int num = arr[i];
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                rs[i] = n - 1;
            }else rs[i] = st.peek() - 1;
            st.push(i);
        }
        return rs;
    }
//most optimal single pass
    public static int largestRectangleArea2(int[] heights) {
        int n = heights.length;
        int max = 0 ;
        Stack<Integer> st = new Stack<>();
        for(int i = 0 ; i <= n ;i++){
            while(!st.isEmpty() && (i == n || heights[st.peek()] >= heights[i])){
                int h = heights[st.peek()];
                st.pop();
                int w ;
                if(st.isEmpty())w = i;
                else w = i - st.peek() - 1 ;
                max = Math.max(max,w * h);
            }
            st.push(i);
        }
        return max;
    }
}
