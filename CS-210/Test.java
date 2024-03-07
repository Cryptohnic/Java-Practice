
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Test {

    private static Map<String, Set<String>> anagrams = new HashMap<>();

    public static void run(String[] arr) {
        for (String s : arr) {
            add(s);
        }
        for (String key : anagrams.keySet()) {
            System.out.println(key + " = " + anagrams.get(key).toString());
        }
    }

    public static void add(String word) {
        String key = alphabetized(word);
        if (!anagrams.containsKey(key)) {
            Set<String> s = new HashSet<>();
            s.add(word);
            anagrams.put(key, s);
        } else {
            anagrams.get(key).add(word);
        }
    }

    public static String alphabetized(String word) {
        char[] a = word.toCharArray();
        Arrays.sort(a);
        return new String(a);
    }
    public static void main(String[] args){
        run(new String[]{"red","der","pizza"});
    }
}
