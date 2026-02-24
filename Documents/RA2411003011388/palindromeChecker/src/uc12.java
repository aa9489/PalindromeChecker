import java.util.*;

interface PalindromeStrategy {
    boolean checkPalindrome(String str);
}

class StackStrategy implements PalindromeStrategy {
    public boolean checkPalindrome(String str) {
        str = str.toLowerCase().replaceAll("[^a-z0-9]", "");
        Stack<Character> stack = new Stack<>();
        for (char c : str.toCharArray()) stack.push(c);
        for (char c : str.toCharArray()) {
            if (c != stack.pop()) return false;
        }
        return true;
    }
}

class DequeStrategy implements PalindromeStrategy {
    public boolean checkPalindrome(String str) {
        str = str.toLowerCase().replaceAll("[^a-z0-9]", "");
        Deque<Character> deque = new LinkedList<>();
        for (char c : str.toCharArray()) deque.add(c);
        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) return false;
        }
        return true;
    }
}

class PalindromeService {
    private PalindromeStrategy strategy;
    public PalindromeService(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }
    public boolean validate(String str) {
        return strategy.checkPalindrome(str);
    }
}

public class uc12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.println("Choose strategy: 1.Stack  2.Deque");
        int choice = sc.nextInt();
        PalindromeStrategy strategy = (choice == 1) ? new StackStrategy() : new DequeStrategy();
        PalindromeService service = new PalindromeService(strategy);
        if (service.validate(input)) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not Palindrome");
        }
        sc.close();
    }
}