package BitManipulation;




public class XORcalculator {
    public static void main(String[] args) {
        int[] arr = {2,1,2,3,4,1};
        System.out.println(XOR(arr));

    }
    public static int XOR(int[] arr) {
        int ans = 0;
        for(int i = 0 ; i < arr.length; i++){
            ans ^= arr[i];
        }
        return ans;
    }
}
