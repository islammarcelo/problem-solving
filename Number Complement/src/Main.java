/**
 * Given a positive integer, output its complement number.
 * The complement strategy is to flip the bits of its binary representation.
 * Example
 * Input: 5
 * Output: 2
 * Explanation: The binary representation of 5 is 101 (no leading zero bits), and its complement is 010. So you need to output 2.
 */

public class Main {
    public static int findComplement(int num) {
        String binary = Integer.toBinaryString(num);
        String result = "";
        for(int i = 0; i < binary.length(); i++){
            if(binary.charAt(i) == '0') { result+= "1"; }
            else result+= "0";
        }
        int decimal=Integer.parseInt(result,2);
        return decimal;
    }

    public static void main(String []args){

        System.out.println(findComplement(10));

    }
}
