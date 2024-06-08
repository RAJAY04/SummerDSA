package Contests.Biweekly132;

public class PlayerAndGame {
    public static void main(String[] args) {
        int[] skills = {1,2,3,4,5,6,7,8,9,10};
        int k = 1;
        System.out.println(findWinningPlayer(skills,k));
    }
    public static int findWinningPlayer(int[] skills, int k) {
        int n = skills.length;
        int i = 0 , j = 1;
        int largest = 0;
        int wins = 0;
        while(i < n && j < n){
            if(skills[j] < skills[i]){
                wins++;
                j++;
            }else{
                if(skills[largest] < skills[j])largest = j;
                wins = 1;
                i++;
                j = i + 1;
            }
            if(wins >= k)return largest;

        }
        return largest;
    }
}
