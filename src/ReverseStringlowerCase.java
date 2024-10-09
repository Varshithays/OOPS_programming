import java.util.Scanner;

public class ReverseStringlowerCase {
    // reverse string and print in lowercase in output
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        String str = in.nextLine();
        String st = str.toLowerCase();
        for(int i=st.length()-1;i>=0;i--){
            System.out.print(st.charAt(i));

        }
    }
}
