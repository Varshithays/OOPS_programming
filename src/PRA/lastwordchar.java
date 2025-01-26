package PRA;

import java.util.Scanner;

public class lastwordchar {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();

        String[] words= str.split(" ");
        for(int i=0;i<words.length;i++)
        {
          //  String word=words[i];
            char ch = words[i].charAt(words[i].length()-1);
            if(Character.isLetter(ch))
            {
            System.out.print(ch);
            }
        }
    }
}
