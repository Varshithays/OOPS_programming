import java.util.Arrays;
import java.util.Scanner;

class Simclass{
    private int simId;
    private String customerName;
    private double balance;
    private double ratePerSecond;
    private String circle;

    public Simclass(int simId,String customerName,double balance,double ratePerSecond,String circle){
        this.simId=simId;
        this.customerName= customerName;
        this.balance = balance;
        this.ratePerSecond = ratePerSecond;
        this.circle = circle;
    }

    public int getSimId(){
        return simId;
    }
    public String getCustomerName(){
        return customerName;
    }
    public double getBalance(){
        return balance;
    }
    public double getRatePerSecond(){
        return ratePerSecond;
    }
    public String getCircle(){
        return circle;
    }
}
public class Sim {
    public static void main(String[] args) {
        Simclass[] cards = new Simclass[5];
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            int a = in.nextInt();
            in.nextLine();
            String b = in.nextLine();
            Double c = in.nextDouble();
            in.nextLine();
            Double d = in.nextDouble();
            in.nextLine();
            String e = in.nextLine();

            cards[i] = new Simclass(a, b, c, d, e);

        }
        String c1 = in.nextLine();
        String c2 = in.nextLine();
        Simclass[] s = transferCustomerCircle(cards, c1, c2);


    }

    public static Simclass[] transferCustomerCircle(Simclass[] cards, String c1, String c2) {
        Simclass[] res = new Simclass[0];
        for (int i = 0; i < cards.length; i++) {
            if (cards[i].getCircle().equalsIgnoreCase(c1)) {
                res = Arrays.copyOf(res, res.length + 1);
                res[res.length - 1] = cards[i];
            }
        }
        return null;
    }
}

