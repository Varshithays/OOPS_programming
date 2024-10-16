import java.util.Scanner;

public class CountSpace {
    //String as input and count number of spaces in it and if spaces is
    // greater than 3 then print it
    public static void main(String[] args){
        Scanner in  = new Scanner(System.in);
        String str = in.nextLine();
        int count =0;
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(ch ==' '){
                count++;
            }
        }
        if(count>=3){
            System.out.println(count);
        }else{
            System.out.println("NA");
        }

    }
}
