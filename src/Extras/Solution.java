package Extras;

import java.util.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Solution {

    /*
     * Complete the 'vanity' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts following parameters:
     *  1. STRING_ARRAY codes
     *  2. STRING_ARRAY numbers
     */

    public static List<String> vanity(List<String> codes, List<String> numbers) {
        Map<String, String> map = createMap();
        Set<String> matchedNumbers = new HashSet<>();

        for (String code : codes) {
            StringBuilder decodedCode = new StringBuilder();
            for (char c : code.toCharArray()) {
                decodedCode.append(map.get(Character.toString(c)));
            }

            String numericCode = decodedCode.toString();

            for (String number : numbers) {
                if (number.contains(numericCode)) {
                    matchedNumbers.add(number);
                }
            }
        }

        List<String> result = new ArrayList<>(matchedNumbers);
        Collections.sort(result);
        return result;
    }

    public static Map<String, String> createMap() {
        Map<String, String> map = new HashMap<>();
        map.put("A", "2");
        map.put("B", "2");
        map.put("C", "2");
        map.put("D", "3");
        map.put("E", "3");
        map.put("F", "3");
        map.put("G", "4");
        map.put("H", "4");
        map.put("I", "4");
        map.put("J", "5");
        map.put("K", "5");
        map.put("L", "5");
        map.put("M", "6");
        map.put("N", "6");
        map.put("O", "6");
        map.put("P", "7");
        map.put("Q", "7");
        map.put("R", "7");
        map.put("S", "7");
        map.put("T", "8");
        map.put("U", "8");
        map.put("V", "8");
        map.put("W", "9");
        map.put("X", "9");
        map.put("Y", "9");
        map.put("Z", "9");
        return map;
    }

    public static void main(String[] args) {
        List<String> codes = Arrays.asList("TWLO", "CODE");
        List<String> numbers = Arrays.asList("+14157088956",
                "+15108926333",
                "+17474824380",
                "+1415123456",
                "+919810155555");

        List<String> result = vanity(codes, numbers);

        System.out.println(result.stream().collect(joining("\n")));
    }
}