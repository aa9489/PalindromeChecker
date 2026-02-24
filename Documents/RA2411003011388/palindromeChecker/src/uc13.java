import java.util.*;

interface PalindromeStrategy {
    boolean checkPalindrome(String str);
    String getName();
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
    public String getName() { return "Stack Strategy"; }
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
    public String getName() { return "Deque Strategy"; }
}

class RecursiveStrategy implements PalindromeStrategy {
    public boolean checkPalindrome(String str) {
        str = str.toLowerCase().replaceAll("[^a-z0-9]", "");
        return isPalindrome(str, 0, str.length() - 1);
    }
    private boolean isPalindrome(String str, int start, int end) {
        if (start >= end) return true;
        if (str.charAt(start) != str.charAt(end)) return false;
        return isPalindrome(str, start + 1, end - 1);
    }
    public String getName() { return "Recursive Strategy"; }
}

public class uc13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        List<PalindromeStrategy> strategies = Arrays.asList(
                new StackStrategy(),
                new DequeStrategy(),
                new RecursiveStrategy()
        );

        for (PalindromeStrategy strategy : strategies) {
            long start = System.nanoTime();
            boolean result = strategy.checkPalindrome(input);
            long end = System.nanoTime();
            System.out.println(strategy.getName() + ": " +
                    (result ? "Palindrome" : "Not Palindrome") +
                    " | Time: " + (end - start) + " ns");
        }
        sc.close();
    }
}