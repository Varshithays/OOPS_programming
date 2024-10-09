import java.util.Scanner;

public class ReverseNo {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        while(n!=0){
            int d = n%10;//12345 %10 = 5
            System.out.print(d);//5
            n=n/10;//12345= 12345/10= 1234
        }
    }
}
