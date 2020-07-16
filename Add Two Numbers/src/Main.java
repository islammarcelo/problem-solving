import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/***
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example:
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */



public class Main {
    public static LinkedList<Integer> addTwoNumbers (LinkedList<Integer> linkedList1, LinkedList<Integer> linkedList2){
        LinkedList<Integer> add = new LinkedList<>();
        LinkedList<Integer> longList, shortList;

        if(linkedList1.size() > linkedList1.size()) {
            longList = linkedList1;
            shortList = linkedList2;
        }
        else {
            longList  = linkedList2;
            shortList = linkedList1;
        }

        Stack<Integer> STACK = new Stack<Integer>();

        for (int i = 0; i < longList.size(); i++){
           STACK.push(longList.get(i));
        }
        int carry = 0 ;
        for (int i = shortList.size()-1; i >= 0; i--){

            int result = shortList.get(i) + STACK.peek() + carry;
            STACK.pop();

            if (result == 10){ carry = 1; add.add(0); }
            else if (result < 10){ add.add(result); carry = 0; }
            else { add.add(result - 10); carry = 1; }
        }

        if(carry != 0){ add.add(STACK.peek() + carry); STACK.pop(); }

        while (!STACK.empty()){ add.add(STACK.peek()); STACK.pop(); }
        return reverse(add);
    }

    public static LinkedList<Integer> reverse(LinkedList<Integer> linkedList){
        LinkedList<Integer> reverseList = new LinkedList<>();
        Stack<Integer> STACK = new Stack<Integer>();

        for (int i = 0; i < linkedList.size(); i++){
            STACK.push(linkedList.get(i));
        }
        while (!STACK.empty()){ reverseList.add(STACK.peek()); STACK.pop(); }
        return reverseList;
    }

    public static void main (String []args){
        LinkedList<Integer> linkedList1 = new LinkedList<>();
        LinkedList<Integer> linkedList2 = new LinkedList<>();
        linkedList1.add(1);
        linkedList1.add(0);
        linkedList1.add(3);
        linkedList1.add(4);
        linkedList1.add(3);
        linkedList2.add(7);
        linkedList2.add(6);
        linkedList2.add(6);
        linkedList2.add(8);
        linkedList2.add(1);
        linkedList2.add(6);
        System.out.print(addTwoNumbers(linkedList1,linkedList2));


    }
}
