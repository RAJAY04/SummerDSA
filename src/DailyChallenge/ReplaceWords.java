package DailyChallenge;

import java.util.List;

public class ReplaceWords {
    public static void main(String[] args) {
        List<String> dictionary = List.of("cat", "bat", "rat");
        String sentence = "the cattle was rattled by the battery";
        System.out.println(replaceWords(dictionary, sentence));
    }
    public static String replaceWords(List<String> dictionary, String sentence) {
        String[] words = sentence.split(" ");
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            sb.append(convert(words[i], dictionary));
            if (i != words.length - 1) {
                sb.append(" ");
            }
        }

        return sb.toString();
    }

    public static String convert(String sentence, List<String> dictionary) {
        String shortestPrefix = sentence;

        for (String root : dictionary) {
            if (sentence.startsWith(root)) {
                if (root.length() < shortestPrefix.length()) {
                    shortestPrefix = root;
                }
            }
        }

        return shortestPrefix;
    }
}
