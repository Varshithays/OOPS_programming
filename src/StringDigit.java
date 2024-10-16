import java.util.Scanner;

public class StringDigit {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String str =in.nextLine();
        int sum =0;
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(Character.isDigit(ch)){
                sum+=Character.getNumericValue(ch);
            }
        }
        System.out.println(sum);
    }
}
