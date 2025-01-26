

import java.util.*;
public class FirstLetterOfEachWord {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String s = "";
        String[] words=str.split("\\s+");
        for (int i=0;i<words.length;i++) {
            //s+=words[i].charAt(words[i].length()-1);// lats char word
            s+=words[i].charAt(0);
        }
        System.out.println(s);
    }
}
/*
/* Find first letter of each word in a string
    Input : Kalyani Govt. Eng. College
    Output : KGEC

//OTHER WAYS
import java.util.*;

public class FirstLetterOfEachWord {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine(); // Read input
        StringBuilder s = new StringBuilder(); // Using StringBuilder for efficiency
        String[] words = str.split("\\s+"); // Split the input string into words

        // Loop through each word
        for (int i = 0; i < words.length; i++) {
            // Append the first character of each word to the StringBuilder
            s.append(words[i].charAt(0));
        }

        // Output the result
        System.out.println(s.toString()); // Convert StringBuilder to String and print
    }
}
// using for loop woth string
import java.util.*;
public class FirstLetterOfEachWord {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String s = "";
        s = s+str.charAt(0);
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i)==' ')
            {
                s = s + str.charAt(i+1);
            }
        }
        System.out.println(s);
    }
}*/