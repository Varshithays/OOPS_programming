import java.util.Arrays;
import java.util.Scanner;

public class Data_Transmission {
    static int primeCount; // This will count the number of prime numbers.

    public static void main(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine(); // Take the input line
        sc.close();

        input = input.replace(";", ""); // Remove the semicolon at the end
        String[] inputArray = input.split(" "); // Split the input string into numbers based on spaces.

        int[] resultArray = new int[0]; // An array to store prime numbers

        // Loop through each number in the inputArray
        for(int i=0;i<inputArray.length;i++){
            int num = Integer.parseInt(inputArray[i]); // Convert the string to an integer

            // Check if the number is prime
            boolean result = isPrimeNumber(num);
            if(result == true){
                // If it's prime, increase the size of the resultArray and add the prime number
                resultArray = Arrays.copyOf(resultArray, resultArray.length+1);
                resultArray[resultArray.length-1] = num;
                primeCount++; // Increment the count of prime numbers
            }
        }

        // Sort the prime numbers in ascending order
        Arrays.sort(resultArray);

        // Output the second largest prime + total number of primes
        System.out.println(resultArray[resultArray.length-2]+primeCount);
    }

    // Function to check if a number is prime
    public static boolean isPrimeNumber(int number){
        if(number <= 1){
            return false; // Numbers <= 1 are not prime
        }

        // Check divisibility up to the square root of the number
        for(int i=2;i<=Math.sqrt(number);i++){
            if(number % i == 0){ // If divisible by any number other than 1 and itself, it's not prime
                return false;
            }
        }
        return true; // It's prime if no divisors were found
    }
}
