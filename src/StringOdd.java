import java.util.Scanner;

public class StringOdd {
    public static void main(String[] args) {
        // Scanner object to take input from the user
        Scanner scanner = new Scanner(System.in);

        // Taking input string from the user
        System.out.println("Enter a string:");
        String input = scanner.nextLine();

        // Loop through each character in the string
        System.out.println("Characters at odd positions:");
        for (int i = 0; i < input.length(); i++) {
            // Check if the position is odd (index starts from 0, so i+1 represents the position)
            if ((i) % 2 != 0) {
                // Print the character at an odd position
                System.out.print(input.charAt(i));
            }
        }
    }
}
