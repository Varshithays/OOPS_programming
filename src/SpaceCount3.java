import java.util.Scanner;

public class SpaceCount3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str=in.nextLine();
        int count=0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)==' '){
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
