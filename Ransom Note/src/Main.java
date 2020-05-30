import java.util.HashMap;

/**
 * Given an arbitrary ransom note string and another string containing letters from all the magazines,
 * write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.
 * Each letter in the magazine string can only be used once in your ransom note.
 * canConstruct("a", "b") -> false
 * canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 */
public class Main {
    public static boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character,Integer> hashMap = new HashMap<>();

        for (int i = 0; i < magazine.length(); i++){
            if(hashMap.containsKey(magazine.charAt(i))) {
                int count = hashMap.get(magazine.charAt(i));
                count++;
                hashMap.put(magazine.charAt(i), count);
            }
            else hashMap.put(magazine.charAt(i),1);
        }

        for (int i = 0; i < ransomNote.length(); i++){
            if(hashMap.containsKey(ransomNote.charAt(i)) && hashMap.get((ransomNote.charAt(i))) != 0) {
                int decrement =  hashMap.get(ransomNote.charAt(i));
                if(decrement == 1) {decrement = 0;}
                else decrement--;
                hashMap.put(ransomNote.charAt(i), decrement);
                continue;
            }
            else return false;
        }
        return true;
    }


    public static void main(String[] args){
        String ransomNote = "a";
        String magazine   = "b";

        System.out.println(canConstruct(ransomNote,magazine));
    }
}
