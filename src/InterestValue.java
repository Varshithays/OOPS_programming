import java.util.Scanner;

public class InterestValue {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */

        Scanner in =new Scanner(System.in);
        int x;
        double y,z;
        x=in.nextInt();
        y=in.nextDouble();
        z=in.nextDouble();

        Account ac =new Account(x,y,z);
        int ny;
        ny=in.nextInt();

        double ans=calculateInterest(ac,ny);
        System.out.format("%.3f",ans);


    }

    public static double calculateInterest(Account a, int noOfYears)
    {
        double temp= noOfYears*a.getinterestRate()/100;
        return (a.getbalance()*(a.getinterestRate()+temp)/100);
    }
}


class Account
{
    private int id;
    private double balance;
    private double interestRate;

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
    }
    public double getbalance(){
        return balance;
    }
    public void setbalance(double balance){
        this.balance=balance;
    }
    public double getinterestRate(){
        return interestRate;
    }
    public void setinterestRate(double interestRate){
        this.interestRate=interestRate;
    }
    Account(int id, double balance,double interestRate){
        this.id=id;
        this.balance=balance;
        this.interestRate=interestRate;
    }

}
/* Sample input and output
1
1000
5
3
51.500
 */