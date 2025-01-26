package PRA;

import java.util.Scanner;

public class CharOddpos {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        for(int i=0;i<str.length();i++){
            if(i%2!=0){
                System.out.print(str.charAt(i));
            }
        }
    }
}
