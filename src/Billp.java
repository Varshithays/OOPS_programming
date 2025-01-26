import java.util.*;
/*
Create a class Bill with below attributes:

billNo- int
name - String
typeOfConnection - String
billAmount - double
status – boolean

where billNo is the bill number, name is the name of the customer, typeOfConnection is the type of the connection
(prepaid, postpaid), billAmount is the bill amount and status is whether the bill is paid or not (if paid then value is TRUE
else value is FALSE).

The above attributes should be private, write getters, setters and parameterized constructor as required.

Create class Solution with main method.
Implement two static methods - findBillWithMaxBillAmountBasedOnStatus and getCountWithTypeOfConnection in Solution class.

findBillWithMaxBillAmountBasedOnStatus method:
-----------------------------------------------------
This method will take an array of Bill objects and a boolean parameter as parameters.
The method will return bill object array in ascending order of their bill number from the array of Bill objects whose bill
amount is maximum in the array with the status attribute that matches with the input parameter.

If no Bill with the given status is present in the array of Bill objects, then the method should return null.

getCountWithTypeOfConnection method:
-----------------------------------------------------
This method will take two input parameters - array of Bill objects and string parameter ( for type of connection).
The method will return the count of bills from array of bill objects for the given type of connection.
If no bill with the given type of connection is present in the array of bill objects, then the method should return 0.


Note :

Two bill object can have the same bill amount.
All the searches should be case insensitive.

The above mentioned static methods should be called from the main method.

For findBillWithMaxBillAmountBasedOnStatus method - The main method should print the billNo followed by # and name from the
returned Bill object array if the returned value is not null.

If the returned value is null then it should print "There are no bill with the given status".

For getCountWithTypeOfConnection method - The main method should print the count of bills as it is, if the returned value is
greater than 0,  otherwise it should print "There are no bills with given type of connection".

Before calling these static methods in main, use Scanner to read the number of object and objects to read the values of Bill
objects referring attributes in the above mentioned attribute sequence.

Next, read the value for status and typeOfConnection.


Consider below sample input and output:
Input:

4
111
Aman Mittal
Prepaid
914.25
true
222
Rekha Kumar
Prepaid
1425.75
false
333
Samyra Gupta
Prepaid
1305.00
true
444
Mohit Saxena
Postpaid
1300.50
false
false
Prepaid

Output:

222#Rekha Kumar
3

4
111
Aman Mittal
Prepaid
914.25
true
222
Rekha Kumar
Prepaid
1425.75
false
333
Samyra Gupta
Prepaid
1305.00
true
444
Mohit Saxena
Postpaid
1425.75
false
false
Prepaid
-------------------------------------------------
        Note on using Scanner object:
        Sometimes scanner does not read the new line character while invoking methods like nextInt(), nextDouble() etc.
        Usually, this is not an issue, but this may be visible while calling nextLine() immediately after those methods.


        Consider below input values:

        1234
        Merin Bakers

        Referring below code:

        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        String str = sc.nextLine(); -> here we expect str to have value Bakers name. Instead it may be "".

        If above issue is observed, then it is suggested to add one more explicit call to nextLine() after reading numeric value.
*/
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
            if (bill.getStatus() == status && bill.getBillAmount()>maxAmount) {
                maxAmount=bill.getBillAmount();
                maxBillList.add(bill);
            }else if(bill.getBillAmount()==maxAmount){
                maxBillList.add(bill);
            }
        }
        if (maxBillList.isEmpty()) {
            return null;
        }

        // Sort list by billNo in ascending order
      maxBillList.sort(Comparator.comparingDouble(Bill::getBillNo));
       //maxAmount=maxBillList.get(0).getBillAmount();
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
