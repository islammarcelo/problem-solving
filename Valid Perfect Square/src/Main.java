/**
 * Given a positive integer num, write a function which returns True if num is a perfect square else False.
 * Note: Do not use any built-in library function such as sqrt.
 */
public class Main {

    public static boolean isPerfectSquare(int num) {
        if (num == 1)
            return true;
        int sum;
        for (int i = 1; i < num; i++) {
            sum = i * i;
            if (sum == num)
                return true;
        }
        return false;
    }
    public static void main(String[] args){
        System.out.println(isPerfectSquare(12));
    }
}
