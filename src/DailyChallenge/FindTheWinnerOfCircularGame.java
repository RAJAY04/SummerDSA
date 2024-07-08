package DailyChallenge;

import java.util.ArrayDeque;
import java.util.Queue;

public class FindTheWinnerOfCircularGame {
    public static void main(String[] args) {
        int n = 6;
        int k = 4   ;
        System.out.println(findTheWinner(n,k));
        System.out.println(findTheWinnerOptimized(n,k));
        System.out.println(findTheWinnerOptimized2(n,k));
        System.out.println(findTheWinnerOptimized3(n,k));
    }

    public static int findTheWinner(int n, int k) {//this is a bad complexity brute force solution
        int[] arr = new int[n];
        for(int i = 0 ; i < n ;i++){
            arr[i] = i + 1;
        }

        int lostCount = 0;
        int i = 0;
        while(lostCount < n - 1){
            int j = 0;
            while(j < k - 1){
                if(arr[i%n] != -1)j++;
                i++;
            }
            while(arr[i%n] == -1)i++;
            arr[i%n] = -1;
            lostCount++;
            while(arr[i%n] == -1)i++;
        }
        for(int num : arr){
            if(num != -1)return num;
        }
        return -1;

    }

    public static int findTheWinnerOptimized(int n, int k) {//this is a good complexity optimized solution
        Queue<Integer> q = new ArrayDeque<>();
        for(int i = 1; i <= n ;i++){
            q.add(i);
        }

        while(q.size() > 1){
            for(int i = 1; i < k ;i++){//until i get kth element take out from front and put to back
                q.add(q.peek());
                q.poll();
            }
            q.poll();//i have the element to be removed in first position so remove it
        }
        return q.peek();
    }

    public static int findTheWinnerOptimized3(int n , int k){
        return helper(n,k) + 1;
    }

    public static int helper(int n , int k){
        if(n == 1)return 0;
        return (helper(n - 1,k) + k ) % n;
    }

    public static int findTheWinnerOptimized2(int n, int k) {//this is a good complexity optimized solution
        int res = 0;
        for(int i = 1; i <= n ;i++){
            res = (res + k) % i;
        }
        return res + 1;
    }


}
