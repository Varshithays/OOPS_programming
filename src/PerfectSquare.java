import java.util.Scanner;

public class PerfectSquare {
    //Check whether given no is perfect square or not
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int number = in.nextInt();

        for(int i=0;i<number;i++){
            int sqr = i*i;

            if(sqr == number){
                System.out.println("True");
            }
        }
    }
}
