package DSAworkshop14sep;

public class SlidingWindow {
    public static void main(String[] args) {
        // Longest Substring Without Repeating Characters
        String s = "aabbccdddddeeeeefghijkleeee";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        int i = 0, j = 0;
        int n = s.length();
        int[] freq = new int[26];
        int max = 0;  // Start max with 0

        while (j < n) {
            freq[s.charAt(j) - 'a']++;

            // Shrink the window until there are no repeating characters
            while (i < n && freq[s.charAt(i) - 'a'] > 1) {
                freq[s.charAt(i) - 'a']--;
                i++;
            }

            // Update max length if needed
            max = Math.max(j - i + 1, max);
            j++;
        }

        return max;
    }
}
