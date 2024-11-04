// Integer input
import java.util.Scanner;

public class ArmstrongCheck {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input number: ");
        int number = scanner.nextInt();
        scanner.close();

        int originalNumber = number;
        int sum = 0;

        // Calculate the sum of cubes of each digit
        while (number > 0) {
            int digit = number % 10;
            sum += digit * digit * digit;
            number /= 10;
        }

        // Check if the sum of cubes is equal to the original number
        if (sum == originalNumber) {
            System.out.println("Yes, the number is an Armstrong number.");
        } else {
            System.out.println("No, the number is not an Armstrong number.");
        }
    }
}
//String input
import java.util.Scanner;
public class ArmstrongCheck {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input number: ");
        String input = scanner.nextLine();
        scanner.close();

        int sum = 0;
        int length = input.length(); // Number of digits

        // Calculate the sum of each digit raised to the power of 'length'
        for (int i = 0; i < length; i++) {
            int digit = input.charAt(i) - '0'; // Convert char to int
            sum += Math.pow(digit, length);
        }

        // Convert input string to a long to handle very large numbers
        long originalNumber = Long.parseLong(input);

        // Check if the sum is equal to the original number
        if (sum == originalNumber) {
            System.out.println("Yes, the number is an Armstrong number.");
        } else {
            System.out.println("No, the number is not an Armstrong number.");
        }
    }
}
//second  way 
import java.util.Scanner;

public class Armstrong
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        String num = in.nextLine();
        int sum =0;
        for(int i=0;i<num.length();i++){

            sum+=Math.pow(Integer.parseInt(String.valueOf(num.charAt(i))),num.length());

            sum+=Math.pow(Integer.parseInt(String.valueOf(num.charAt(i))),num.length);

        }
        if(sum == Integer.parseInt(num))
        {
            System.out.println("Armstrong no");
        }
        else
        {
            System.out.println("Not a Armstrong");
        }
    }
}
