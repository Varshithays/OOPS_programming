import java.util.Scanner;

public class Simp {
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