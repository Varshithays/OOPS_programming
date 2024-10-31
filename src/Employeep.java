import java.util.Scanner;

public class Employeep {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
       // EmployeeN[] em= new EmployeeN[4];

            String a = in.nextLine();
            int b = in.nextInt();
            in.nextLine();
            double c= in.nextDouble();
            in.nextLine();

            EmployeeN em = new EmployeeN(a,b,c);

        // Calculate yearly salary and tax
        double yearlySalary = calculateYearlySalary(em);
        double tax = calculateTax(em);

        // Print results
        System.out.printf("Yearly salary of %s: %.2f\n", em.name, yearlySalary);
        System.out.printf("Tax to be paid by %s: %.2f\n", em.name, tax);

    }

    public static double calculateYearlySalary(EmployeeN em){
       // double yearSal=0;
        return em.salary*12;


    }
    public static double calculateTax(EmployeeN em){
       double yearlySalary= calculateYearlySalary(em);
        double tax;

        if (yearlySalary <= 50000) {
            tax = 0.1 * yearlySalary;
        } else if (yearlySalary <= 100000) {
            tax = 0.1 * 50000 + 0.2 * (yearlySalary - 50000);
        } else {
            tax = 0.1 * 50000 + 0.2 * 50000 + 0.3 * (yearlySalary - 100000);
        }
    return tax;
    }
    }


class EmployeeN{
    String name;
    int age;
    double salary;
    public EmployeeN(String name,int age,double salary){
        this.name= name;
        this.age= age;
        this.salary=salary;
    }
}
