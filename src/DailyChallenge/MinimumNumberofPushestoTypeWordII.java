package DailyChallenge;

import java.util.Arrays;

public class MinimumNumberofPushestoTypeWordII {
    public static void main(String[] args) {
        String word = "aabbccddeeffgghhiiiiii";
        System.out.println(minimumPushes(word));
    }

    public static int minimumPushes(String word) {
        int[] freq = new int[26];
        for(char c : word.toCharArray())freq[c - 'a']++;

        Arrays.sort(freq);
        int cost = 0;
        int alphabetCount = 0;
        for(int i = 25; i >= 0; i--){
            cost += freq[i] * ((alphabetCount / 8) + 1);
            alphabetCount++;
        }
        return cost;
    }
}
