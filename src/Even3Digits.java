import java.util.Scanner;

public class Even3Digits
{
    public static void main(String[] args)
    {
        Scanner in  = new Scanner(System.in);
        int n= in.nextInt();
        int count =0;
        while(n>0){
            int d = n%10;
            if(d%2==0)
            {
                count++;
            }
            n=n/10;
        }
        if(count >=3)
        {
            System.out.println("TRUE");
        }else
        {
            System.out.println("FALSE");
        }

    }
}
