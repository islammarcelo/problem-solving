import java.util.HashMap;

/**
 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
 * s = "leetcode"
 * return 0.
 *
 * s = "loveleetcode",
 * return 2.
 */
public class Main {
    public static int firstUniqChar(String s) {
        HashMap<Character, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (hashMap.containsKey(s.charAt(i))) {
                int count = hashMap.get(s.charAt(i));
                count++;
                hashMap.put(s.charAt(i), count);
            } else hashMap.put(s.charAt(i), 1);
        }

        for(int i = 0; i < s.length(); i++){
            if (hashMap.get(s.charAt(i)) == 1){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        String ransomNote = "loveleetcode";


        System.out.println(firstUniqChar(ransomNote));
    }
}
