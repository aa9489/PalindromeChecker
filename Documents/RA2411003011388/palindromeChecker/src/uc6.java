import java.util.Scanner;
import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;

public class uc6 {
    public static void main(String[] args){
        Scanner sc = new Scanner (System.in);
        System.out.println("enter string: ma");
        String input = sc.nextLine();
        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();
        for(int i=0; i < input.length(); i++){
            char ch = input.charAt(i);
            queue.add(ch);
            stack.push(ch);
        }
        boolean isPalindrome = true;
        while(!queue.isEmpty()) {
            if(queue.remove() != stack.pop()){
                isPalindrome = false;
                break;
            }
        }
        System.out.println(isPalindrome);
    }
}
