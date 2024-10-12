import java.util.Scanner;

public class EvenDigit {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int number = in.nextInt();
        int count =0;
        while(number!=0){
            int d = number % 10;//12345 %10 = 5
            if(d%2==0){
                count++;
            }
            number = number/10;
        }
        System.out.println(count);

    }
}
