import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 *
 * You may assume that the array is non-empty and the majority element always exist in the array.
 */
public class Main {
    public static int majorityElement(int[] nums) {
        int size = nums.length;
        int number = 0;
        int key = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < size; i++) {
            if (hashMap.containsKey(nums[i])) {
                int count = hashMap.get(nums[i]);
                count++;
                hashMap.put(nums[i], count);
            } else hashMap.put(nums[i], 1);
        }
        for (Map.Entry me : hashMap.entrySet()) {
            number = (int) me.getValue();
            if(number > (size / 2)){
                key = (int) me.getKey();
                break;}
        }
        return key;
    }

    public static void main(String[] args){
        int [] nums = {3,2,3};


        System.out.println(majorityElement(nums));
    }
}
