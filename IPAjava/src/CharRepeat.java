import java.util.*;

public class CharRepeat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();  // Input string
        int count = 1;  // Start counting the first character

        // Loop through the string starting from the second character
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                // If the current character is the same as the previous one, increase the count
                count++;
            } else {
                // If the character changes, print the previous character and its count
                System.out.print(s.charAt(i - 1) + "" + count);
                // Reset count for the new character
                count = 1;
            }
        }
        // Print the last character and its count after the loop ends
        System.out.print(s.charAt(s.length() - 1) + "" + count);
    }
}
// 2nd method
