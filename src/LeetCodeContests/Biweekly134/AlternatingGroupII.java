package LeetCodeContests.Biweekly134;

public class AlternatingGroupII {
    public static void main(String[] args) {
        int[] colors = {0,0,1,0,1};
        System.out.println(numberOfAlternatingGroups(colors,5));
    }
    public static int numberOfAlternatingGroups(int[] colors, int k) {
        int n = colors.length;
        int ans = 0;
        int curLen = 0;
        for(int i = 2 ; i < n + k - 1 ;i++){
            if(colors[(i)%n] == colors[(i - 2)%n] && colors[(i)%n] != colors[(i - 1)%n]){
                if(curLen == 0)curLen = 3;
                else curLen++;
            }else{
                if(curLen >= k){
                    ans += curLen - k + 1;
                }
                curLen = 0;
            }
        }
        if(curLen >= k)ans += curLen - k + 1;
        return ans;
    }
}
