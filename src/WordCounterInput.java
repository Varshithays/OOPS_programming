import java.util.Scanner;

public class WordCounterInput {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read the input sentence
        System.out.print("Enter a sentence: ");
        String sentence = sc.nextLine();

        // Read the word to count
        System.out.print("Enter the word to count: ");
        String targetWord = sc.nextLine();

        // Normalize to lowercase
        sentence = sentence.toLowerCase();
        targetWord = targetWord.toLowerCase();

        // Split the sentence into words
        String[] words = sentence.split("\\s+"); // Splits on one or more spaces

        int count = 0;

        // Loop through the words
        for (String word : words) {
            // Clean the word by removing punctuation
            String cleanedWord = word.replaceAll("[^a-zA-Z]", ""); // Remove non-letters
            // Check if the cleaned word matches the target word
            if (cleanedWord.equals(targetWord)) {
                count++; // Increment count
            }
        }

        // Output the result
        System.out.println("Number of that word present in the Sentence: " + count);
    }
}
/*
 Input : Home, Sweet Home

           Home
 * Output : Number of that word present in the sentence : 2
 *
 * Process
 * ----------
 * The word Home present in the sentence 2 times


import java.util.*;
public class Find_CountWord
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] arr = str.split(" ");
        String s = sc.nextLine();
        String ch = "";
        int count = 0;

        for (int i = 0; i < arr.length; i++)
        {
            for (int j = 0; j < arr[i].length(); j++)
            {
                if(Character.isLetter(arr[i].charAt(j)))
                {
                    ch = ch + arr[i].charAt(j);
                }
            }

            if(ch.equals(s))
            {
                count++;
            }
            ch = "";
        }
        System.out.println("Number of that word present in the Sentence : "+count);
    }
}
*/