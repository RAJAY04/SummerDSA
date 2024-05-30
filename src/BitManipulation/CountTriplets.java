package BitManipulation;

public class CountTriplets {
    public static void main(String[] args) {
        int[] arr = {2,3,1,6,7};
        System.out.println(countTriplets1(arr));
        System.out.println(countTriplets2(arr));
        System.out.println(countTriplets3(arr));
    }
    //there is one more O(n) approach which is crack head approach

    public static int countTriplets2(int[] arr) {// O(n^    3) approach
        int a = 0 , b = 0;
        int res = 0;
        for(int i = 0 ; i < arr.length -1 ; i++){
            a = 0;
            for(int j = i + 1 ; j < arr.length ; j++){
                b = 0;
                a ^= arr[j - 1];
                for(int k = j ; k < arr.length ; k++){
                    b ^= arr[k];
                    if(a == b)res++;
                }

            }
        }
        return res;
    }
    // O(n^4) approach
    public static int countTriplets1(int[] arr) {
        int res = 0;
        for(int i = 0 ; i < arr.length - 1 ; i++){
            for(int j = i + 1 ; j < arr.length ; j++){
                for(int k = j ; k < arr.length ; k++){
                    int a = 0 , b = 0;
                    for(int l = i ; l < j ; l++){
                        a ^= arr[l];
                    }
                    for(int l = j ; l <= k ; l++){
                        b ^= arr[l];
                    }
                    if(a == b)res++;
                }
            }
        }
        return res;
    }
    public static int countTriplets3(int[] arr) {
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            int val = arr[i];

            for (int k = i + 1; k < arr.length; k++) {
                val = val ^ arr[k];

                if (val == 0) {
                    count += (k - i);
                }
            }
        }

        return count;
    }
}
