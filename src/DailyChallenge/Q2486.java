package DailyChallenge;

public class Q2486 {
    public static void main(String[] args) {
        System.out.println(appendCharacters("coaching","coached"));
    }
    public static int appendCharacters(String s, String t) {
        int sIndex = 0, tIndex = 0;
        int sLength = s.length(), tLength = t.length();

        while (sIndex < sLength && tIndex < tLength) {
            if (s.charAt(sIndex) == t.charAt(tIndex)) {
                tIndex++;
            }
            sIndex++;
        }

        return tLength - tIndex;
    }
}
