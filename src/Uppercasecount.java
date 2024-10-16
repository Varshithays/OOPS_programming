import java.util.Scanner;

public class Uppercasecount {
    public static void main(String[] args){
        Scanner in = new Scanner (System.in);
        String str = in.nextLine();
        int count =0;
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(ch>='A'&& ch<='Z'){
                count++;

            }
        }
        if(count==0){
            System.out.println("NO capital letters");
        }else{
            System.out.println(count);
        }

    }
}
