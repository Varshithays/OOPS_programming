import java.util.HashSet;
import java.util.Scanner;

public class UniqueCharString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        HashSet<Character> uniqueChars = new HashSet<>();

        System.out.print("Unique characters in the string: ");
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            // Check if this character is already in the set
            if (!uniqueChars.contains(ch)) {
                // If not, print it and add to the set
                System.out.print(ch);
                uniqueChars.add(ch);
            }
        }
    }
}
