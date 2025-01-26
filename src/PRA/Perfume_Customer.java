package PRA;

import java.util.ArrayList;
import java.util.Scanner;

class Perfume{
    private  int perfumeId;
    private String brand;
    private Double price;
    private String fragrance;
    public Perfume(int perfumeId,String brand,Double price,String fragrance){
        this.perfumeId=perfumeId;
        this.brand=brand;
        this.price=price;
        this.fragrance=fragrance;
    }
    public int getPerfumeId(){
        return perfumeId;
    }
    public  String getBrand() {
        return brand;
    }
    public Double getPrice(){
        return price;
    }
    public String getFragrance(){
        return fragrance;
    }
}
class Customer{
    int customerId;
    String name;
    int age;
    String gender;
    ArrayList<Perfume> perfumes;
    public Customer(int customerId,String name,int age,String gender,ArrayList<Perfume> perfumes){
        this.customerId=customerId;
        this.name=name;
        this.age=age;
        this.gender=gender;
        this.perfumes=perfumes;
    }

}
public class Perfume_Customer {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Customer> c = new ArrayList<>();
        int nc=in.nextInt();in.nextLine();
        for(int i=0;i<nc;i++){
            int customerid=in.nextInt();
            in.nextLine();
            String name=in.nextLine();
            int age=in.nextInt();
            in.nextLine();
            String gender=in.nextLine();
            int numPerfumes = in.nextInt();
            in.nextLine();
            ArrayList<Perfume> perfumes = new ArrayList<>();
            for(int j=0;j<numPerfumes;j++){
                int perfumeid=in.nextInt();in.nextLine();
                String brand=in.nextLine();
                double price=in.nextDouble();in.nextLine();
                String fragrance=in.nextLine();

                perfumes.add(new Perfume(perfumeid,brand,price,fragrance));
            }
            c.add(new Customer(customerid,name,age,gender,perfumes));
        }
        String inputbr=in.nextLine();
        ArrayList<Customer> ans= findCustomersWithPerfumeBrand(c,inputbr);
        for(Customer a:ans){
            System.out.println(a.name);
        }
        double ans2=calculateTotalExpenditure(c);
        System.out.printf("$%.2f%n",ans2);
    }

    public static ArrayList<Customer> findCustomersWithPerfumeBrand(ArrayList<Customer> c,String inputbr){
       ArrayList<Customer> match= new ArrayList<>();
        for(Customer i:c){
            for(Perfume p:i.perfumes){
                if(p.getBrand().equalsIgnoreCase(inputbr)){
                    match.add(i);
                    break;
                }
            }
        }
        if(match.isEmpty()){
            System.out.println("NO match customers found");
        }
        return match;
    }
    public static double calculateTotalExpenditure(ArrayList<Customer> c) {
        double sum=0.0;
        for (Customer i : c) {
        for(Perfume p:i.perfumes){
            sum+=p.getPrice();
        }
        }
        return sum;
    }
}
