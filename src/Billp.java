import java.util.*;

public class Billp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        Bill[] bills = new Bill[n];
        for (int i = 0; i < n; i++) {
            int billNo = sc.nextInt(); sc.nextLine();
            String name = sc.nextLine();
            String typeOfConnection = sc.nextLine();
            double billAmount = sc.nextDouble();
            boolean status = sc.nextBoolean(); sc.nextLine();

            bills[i] = new Bill(billNo, name, typeOfConnection, billAmount, status);
        }

        boolean statusFilter = sc.nextBoolean(); sc.nextLine();
        String connectionType = sc.nextLine();

        // Calling the required methods
        Bill[] maxBills = findBillWithMaxBillAmountBasedOnStatus(bills, statusFilter);
        int countByType = getCountWithTypeOfConnection(bills, connectionType);

        // Display results for max bill based on status
        if (maxBills != null) {
            for (Bill b : maxBills) {
                System.out.println(b.getBillNo() + "#" + b.getName());
            }
        } else {
            System.out.println("There are no bills with the given status");
        }

        // Display results for count by type of connection
        if (countByType > 0) {
            System.out.println(countByType);
        } else {
            System.out.println("There are no bills with given type of connection");
        }

        sc.close();
    }

    public static Bill[] findBillWithMaxBillAmountBasedOnStatus(Bill[] bills, boolean status) {
        double maxAmount = -1;
        List<Bill> maxBillList = new ArrayList<>();

        for (Bill bill : bills) {
            if (bill.getStatus() == status && bill.getBillAmount() > maxAmount) {
                maxAmount = bill.getBillAmount();
            }
        }
        System.out.println("MAx bill amount: "+maxAmount);
        for (Bill bill : bills) {
            if (bill.getStatus() == status && bill.getBillAmount() == maxAmount) {
                maxBillList.add(bill);
            }
        }

        if (maxBillList.isEmpty()) {
            return null;
        }

        // Sort list by billNo in ascending order
       // maxBillList.sort(Comparator.comparingInt(Bill::getBillNo));

        return maxBillList.toArray(new Bill[0]);
    }

    public static int getCountWithTypeOfConnection(Bill[] bills, String typeOfConnection) {
        int count = 0;
        for (Bill bill : bills) {
            if (bill.getTypeOfConnection().equalsIgnoreCase(typeOfConnection)) {
                count++;
            }
        }
        return count;
    }
}

class Bill {
    private int billNo;
    private String name;
    private String typeOfConnection;
    private double billAmount;
    private boolean status;

    public Bill(int billNo, String name, String typeOfConnection, double billAmount, boolean status) {
        this.billNo = billNo;
        this.name = name;
        this.typeOfConnection = typeOfConnection;
        this.billAmount = billAmount;
        this.status = status;
    }

    public int getBillNo() { return billNo; }
    public void setBillNo(int billNo) { this.billNo = billNo; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getTypeOfConnection() { return typeOfConnection; }
    public void setTypeOfConnection(String typeOfConnection) { this.typeOfConnection = typeOfConnection; }

    public double getBillAmount() { return billAmount; }
    public void setBillAmount(double billAmount) { this.billAmount = billAmount; }

    public boolean getStatus() { return status; }
    public void setStatus(boolean status) { this.status = status; }
}
