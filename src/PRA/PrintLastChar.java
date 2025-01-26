package PRA;

import java.util.Scanner;

public class PrintLastChar {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String sentence= in.nextLine();

        String words[] = sentence.split("\\s+");
        for(int i=0;i<words.length;i++){
            String str=words[i];
            if(!str.isEmpty()){
            char lastchar= str.charAt(str.length()-1);
                System.out.print(lastchar);
            }
        }
    }
}
