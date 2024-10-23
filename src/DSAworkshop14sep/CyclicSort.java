package DSAworkshop14sep;

public class CyclicSort {
    public static void main(String[] args) {
        int[] arr = {3, 5, 2, 1, 4};
        int[] res = cyclicSort(arr);
        for(int i : res){
            System.out.print(i + " ");
        }
    }

    public static int[] cyclicSort(int[] arr){
        int i = 0;
        while(i < arr.length){
            int correctIndex = arr[i] - 1;
            if(arr[i] == arr[correctIndex]){
                i++;
            }else{
                swap(arr,i,correctIndex);
            }
        }
        return arr;
    }

    public static void swap(int[] arr, int i , int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
