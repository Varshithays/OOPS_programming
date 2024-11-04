import java.util.Scanner;

public class CountWords {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String st = in.nextLine();
        int count=0;
       String[] str=  st.split("\\s+");
       /* for(int i=0;i<st.length();i++){

        }*/
        count=str.length;
        System.out.println(count);
    }
}
//second method
/*import java.util.*;

public class Count_Word {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in); // Create Scanner object to read input
        String s = sc.nextLine(); // Read the entire input line as a string

        // Split the string by spaces, creating an array where each element is a word
        // or an empty string if there are multiple spaces
        String[] arr = s.split(" ");

        int count = 0; // Initialize counter for words

        // Loop through each element in the array
        for (int i = 0; i < arr.length; i++) {
            // Check if the element is not an empty string
            if (!arr[i].equals("")) {
                count++; // Increment count if arr[i] is a word
            }
        }

        System.out.println("Number of word : " + count); // Print the word count
    }
}
*/