import java.util.Scanner;

public class BankTrans {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Bank_Account[] ba= new Bank_Account[2];
        for(int i=0;i<ba.length;i++){
            String a= in.nextLine();
            String b  =in.nextLine();
            double c = in.nextDouble();
            in.nextLine();

            ba[i]= new Bank_Account(a,b,c);

        }

    }
    public static  Transaction transferFunds(BankUtils b){
        if(b.fromAccount.balance>b.amount){
            double amount1= b.fromAccount.balance-b.amount;
            double amount2 =b.toAccount.balance+b.amount;
            double[] amount={amount1,amount2};
        }
    }

}
class Bank_Account{
    String accountNumber;
    String accountHolderName;
    double balance;
    public Bank_Account(String accountNumber,String accountHolderName,double balance){
        this.accountNumber=accountNumber;
        this.accountHolderName=accountHolderName;
        this.balance=balance;
    }

}
class BankUtils{
    Bank_Account fromAccount;
    Bank_Account toAccount;
    double amount;
    String transactionCode;
    public BankUtils(Bank_Account fromAccount,Bank_Account toAccount,double amount,String transactionCode){
        this.fromAccount=fromAccount;
        this.toAccount=toAccount;
        this.amount=amount;
        this.transactionCode=transactionCode;
    }
}
class Transaction{
    String transactionCode;
    double amount;
    String timestamp;
    public Transaction(String transactionCode,double amount,String timestamp){
        this.transactionCode=transactionCode;
        this.amount=amount;
        this.timestamp=timestamp;
    }
}
class InsufficientBalanceException extends Exception {

    // Constructor that takes a message as a parameter
    public InsufficientBalanceException(String message) {
        super(message); // Pass the message to the Exception superclass
    }
}
