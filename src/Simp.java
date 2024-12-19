import java.util.Arrays;
import java.util.Scanner;
public class Simp{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Sim[] sim = new Sim[4];
        for (int i = 0; i < sim.length; i++) {
            int simId = sc.nextInt();
            sc.nextLine();
            String name = sc.nextLine();
            double balance = sc.nextDouble();
            sc.nextLine();
            double ratePersecond = sc.nextDouble();
            sc.nextLine();
            String circle = sc.nextLine();
            sim[i] = new Sim(simId, name, balance, ratePersecond,

                    circle);
        }

        String circle1 = sc.nextLine();
        double ratePerSecond1 = sc.nextDouble();
        Sim[] result = find(sim, circle1, ratePerSecond1);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i].getSimId());
        }
        sc.close();
    }
    public static Sim[] find(Sim[] sim, String circle1, double
            ratePerSecond1) {
        Sim[] temp= new Sim[0];
        int j = 0;
        for (int i = 0; i < sim.length; i++) {
            if (sim[i].getCircle().equals(circle1) &&

                    sim[i].getRatePersecond() < ratePerSecond1) {
                temp= Arrays.copyOf(temp,temp.length+1);
                temp[temp.length-1]=sim[i];
            }
        }

        for (int i = 0; i < temp.length-1; i++) {
            for (int k = 0; k < temp.length - 1; k++) {
                if (temp[k].getBalance() < temp[k +

                        1].getBalance()) {

                    Sim a = temp[k];
                    temp[k] = temp[k + 1];
                    temp[k + 1] = a;
                }
            }
        }
        return temp;
    }
}
class Sim {
    private int simId;
    private String name;
    private double balance;
    private double ratePersecond;
    private String circle;
    public Sim(int simId, String name, double balance, double
            ratePersecond, String circle) {
        this.simId = simId;
        this.name = name;

        this.balance = balance;
        this.ratePersecond = ratePersecond;
        this.circle = circle;
    }
    public int getSimId() {
        return simId;
    }
    public void setSimId(int simId) {
        this.simId = simId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    public double getRatePersecond() {
        return ratePersecond;
    }
    public void setRatePersecond(double ratePersecond) {
        this.ratePersecond = ratePersecond;
    }
    public String getCircle() {
        return circle;
    }
    public void setCircle(String circle) {
        this.circle = circle;
    }
}