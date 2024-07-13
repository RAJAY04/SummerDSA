package LCVirtualContests.Weekly394;

public class CountNumOFSpecialCharsII {
    public static void main(String[] args) {
        String word = "cCceDC";
        System.out.println(numberOfSpecialChars(word));
    }
    public static int numberOfSpecialChars(String word) {
        int[] lower = new int[26];
        int[] totalLower = new int[26];
        for(char c : word.toCharArray()){
            if(Character.isLowerCase(c))
                totalLower[c - 'a']++;
        }
        int count = 0;

        for(char c : word.toCharArray()){
            if(Character.isLowerCase(c)){
                lower[c - 'a']++;
            }else{
                char low = Character.toLowerCase(c);
                if(lower[low - 'a'] != -1 && lower[low - 'a'] == totalLower[low - 'a'] && lower[low - 'a'] > 0){
                    count++;
                    lower[low - 'a'] = -1;
                }else if(lower[low - 'a'] < totalLower[low - 'a'])lower[low - 'a'] = -1;
            }

        }
        return count;
    }
}
