import java.util.Scanner;

public class String4 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        char st = in.next().charAt(0);
        String string =str.toLowerCase();
        int flag =0;
        for(int i=0;i<string.length();i++){
            if(string.charAt(i)==st){
                flag=1;
                System.out.println(i);
                break;
            }
        }
        if(flag ==0) {
            System.out.println("NA");
        }
    }
}
