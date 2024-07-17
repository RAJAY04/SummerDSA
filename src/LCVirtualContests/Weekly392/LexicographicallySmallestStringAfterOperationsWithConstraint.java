package LCVirtualContests.Weekly392;

public class LexicographicallySmallestStringAfterOperationsWithConstraint {
    public static void main(String[] args) {
        String s = "zbbz";
        int k = 3;
        System.out.println(getSmallestString(s, k));
    }
    public static String getSmallestString(String s, int k) {
        if(k == 0)return s;
        char[] arr = s.toCharArray();
        for(int i = 0 ; i < s.length(); i++){
            char ch = arr[i];
            if(ch == 'a')continue;
            int diff = Math.min('z' - ch + 1,ch - 'a');
            if(diff <= k){
                arr[i] = 'a';
                k -= diff;
            }else{
                arr[i] = (char)(ch - k);
                k = 0;
                break;
            }

        }

        return new String(arr);

    }


}
