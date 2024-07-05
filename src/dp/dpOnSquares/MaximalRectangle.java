package dp.dpOnSquares;

import java.util.Stack;

public class MaximalRectangle {
    public static void main(String[] args) {
        //its not exaclty a partition dp
        //required largest rectangle area in a histogram problem as pre req
        //then we can solve this problem
        char[][] matrix = {{'1','0','1','0','0'},{'1','0','1','1','1'},
                {'1','1','1','1','1'},{'1','0','0','1','0'}};
        System.out.println(maximalRectangle(matrix));
    }
    public static int maximalRectangle(char[][] matrix) {
        int n = matrix.length , m = matrix[0].length;
        int[] height = new int[m];
        int max = 0;
        for(int i = 0; i < n ;i++){
            for(int j = 0 ; j < m ;j++){
                if(matrix[i][j] == '0')height[j] = 0;
                else height[j] += 1;
            }
            max = Math.max(max,findArea(height));
        }
        return max;
    }
    public static int findArea(int[] arr){
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int max = 0;
        for(int i = 0 ; i <= n ;i++){
            while(!st.isEmpty() && (i == n || arr[st.peek()] >= arr[i])){
                int height = arr[st.pop()];
                int width;
                if(st.isEmpty())width = i;
                else width = i - st.peek() - 1;
                max = Math.max(max,height * width);
            }
            st.push(i);
        }
        return max;
    }
}
