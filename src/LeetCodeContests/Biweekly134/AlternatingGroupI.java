package LeetCodeContests.Biweekly134;

public class AlternatingGroupI {
    public static void main(String[] args) {
        int[] colors = {1,1,2,1,2,1,2};
        System.out.println(numberOfAlternatingGroups(colors));
    }
    public static int numberOfAlternatingGroups(int[] colors) {
        int ans = 0;
        int n = colors.length;
        for(int i = 2 ; i < colors.length; i++){
            if(colors[i] == colors[i - 2] && colors[i] != colors[i - 1])ans++;
        }
        if(colors[n - 2] == colors[0] && colors[n - 2] != colors[n - 1])ans++;
        if(colors[n - 1] == colors[1] && colors[n - 1] != colors[0])ans++;
        return ans;
    }
}
