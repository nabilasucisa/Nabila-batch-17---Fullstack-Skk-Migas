import java.util.*;
import java.util.stream.Collectors;

public class SortByFrequency {
    public static void main(String[] args) {
        // Test Case sesuai soal
        String[] input = {"Abc", "bCd"};
        String[] input2 = {"Oke", "One"};
        String[] input3 = {"Pendanaan", "Terproteksi", "Untuk", "Dampak", "Berarti"};
        System.out.println(sortingByFreq(input));
        System.out.println(sortingByFreq(input2));
        System.out.println(sortingByFreq(input3));
    }

    public static String sortingByFreq(String[] input) {
        // Grouping all the characters from parameter input into one string
        StringBuilder merge = new StringBuilder();
        for (int i = 0; i < input.length; i++) {
            merge.append(input[i]);
        }
//        System.out.println(merge);

        // Change string to be array of characters that will be used in hashmap later
        char[] chars = merge.toString().toCharArray();
        // Make a hashmap that input character as key and it's frequency as value
        Map<Character, Integer> map = new HashMap<>();
        for (Character c : chars) {
            if (c!=null){
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
        }

        // Sort the hashmap using stream and lambda
        // If the value/frequency is bigger then put it first
        // If the value/frequency is equal then sort it by uppercase and alphabetical order (A-Za-z)
        List<Map.Entry<Character, Integer>> sortedList = map.entrySet().stream()
                .sorted(Comparator.comparing((Map.Entry<Character, Integer> t) -> t.getValue()).reversed()
                        .thenComparing(Map.Entry::getKey)) //default order of comparing string in java is A-Za-z
                .collect(Collectors.toList());
//        System.out.println("sorted list : " + sortedList);

        // Collect the sorted key/character into one string
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < sortedList.size(); i++) {
            result.append(sortedList.get(i).getKey());
        }
        // Return the result
        return result.toString();
    }
}

