package LeetCodeContests.Weekly406;

public class LexiographicallySmallestStringAfteraSwap {
    public static void main(String[] args) {
        String s = "45320";
        System.out.println(getSmallestString(s));
    }
    public static String getSmallestString(String s) {
        int swap = 1;
        int n = s.length();
        char[] arr = s.toCharArray();
        for(int i = 0 ; i< n - 1; i++){
            if(arr[i] > arr[i + 1] && arr[i] % 2 == arr[i + 1] % 2) {
                if (swap == 1) {
                    char temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    swap--;
                }
            }
        }
        return new String(arr);
    }
}
