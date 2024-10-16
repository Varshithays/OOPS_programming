import java.util.Scanner;

public class StringCHN {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        str.toUpperCase();
        if(str.substring(0,3).equals("CHN")){
            String st = str.substring(3);
           StringBuilder sb = new StringBuilder(st);
            //sb.append(st);
            sb.reverse();
            System.out.println(sb);
        }else{
            System.out.println("NA");
        }

    }
}
