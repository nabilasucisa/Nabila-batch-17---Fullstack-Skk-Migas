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
        // Kelompokkan semua karakter dari masing-masing elemen pada array of string dalam satu string
        StringBuilder merge = new StringBuilder();
        for (int i = 0; i < input.length; i++) {
            merge.append(input[i]);
        }
//        System.out.println(merge);

        // Ubah string menjadi array of character, lalu buat hashmap untuk memasukan key berupa characternya dan value berupa frekuensinya
        char[] chars = merge.toString().toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (Character c : chars) {
            if (c!=null){
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
        }

        // Sort hasil hashmap menggunakan stream
        // jika frekuensi/value lebih besar lebih awal ditulis, jika value sama maka diurutkan sesuai default java (A-Za-z)
        List<Map.Entry<Character, Integer>> sortedList = map.entrySet().stream()
                .sorted(Comparator.comparing((Map.Entry<Character, Integer> t) -> t.getValue()).reversed()
                        .thenComparing(Map.Entry::getKey))
                .collect(Collectors.toList());
//        System.out.println("sorted list : " + sortedList);

        // Gabungkan key map yang sudah diurutkan menjadi string
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < sortedList.size(); i++) {
            result.append(sortedList.get(i).getKey());
        }
        return result.toString();
    }
}

