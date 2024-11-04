import java.util.Scanner;

public class CountPrimeDigit {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int  num = in.nextInt();
        int count=0;
        while(num>0){
            int last = num%10;
            if(last==2||last==3||last==5||last==7){
                count++;
            }
            num/=10;
        }
        System.out.println(count);
    }
}
