package DailyChallenge;

import java.util.Arrays;

public class HeightChecker {
    public static void main(String[] args) {
        int[] heights = {1,1,4,2,1,3};
        System.out.println(heightChecker(heights));
    }
    public static int heightChecker(int[] heights) {
        int n = heights.length;
        int[] expected = new int[n];
        for(int i = 0 ; i < n ; i++){
            expected[i] = heights[i];
        }
        int start = 0 , end = heights.length;
//        mergeSort(heights,0,n);
        quickSort(heights,0,n -1);
        System.out.println(Arrays.toString(heights));
        int count = 0;
        for(int i = 0 ; i < n ; i++){
            if(heights[i] != expected[i])count++;
        }
        return count;
    }
    public static void mergeSort(int[] arr,int start, int end){
        if(start < end - 1) {
            int mid = start + (end - start) / 2;
            mergeSort(arr, start, mid);
            mergeSort(arr, mid, end);
            merge(arr, start, mid, end);
        }
    }
    public static void merge(int[] arr, int s , int m, int e) {
        int[] temp = new int[e - s];
        int i = s, j = m, k = 0;
        while (i < m && j < e) {
            if (arr[i] < arr[j]) {
                temp[k++] = arr[i++];
            } else temp[k++] = arr[j++];
        }
        while(i < m){
            temp[k ++] = arr[i++];
        }
        while(j < e){
            temp[k++] = arr[j++];
        }
        for(i = 0 ; i < temp.length; i++){
            arr[i + s] = temp[i];
        }
    }
    public static void quickSort(int[] arr, int s, int e) {
        if (s < e) {
            int p = partition(arr, s, e);
            quickSort(arr, s, p - 1);
            quickSort(arr, p + 1, e);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int partition(int[] arr, int s, int e) {
        int pivot = arr[s];
        int i = s + 1;
        int j = e;

        while (i <= j) {
            while (i <= j && arr[i] <= pivot) {
                i++;
            }
            while (i <= j && arr[j] > pivot) {
                j--;
            }
            if (i < j) {
                swap(arr, i, j);
            }
        }
        swap(arr, s, j);
        return j;
    }

}
