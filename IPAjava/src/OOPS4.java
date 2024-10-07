import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OOPS4 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String cn = in.nextLine();
        int num = in.nextInt();
        in.nextLine();

        Employee1[] Em = new Employee1[num];
        for(int i=0;i<num;i++){
            int a = in.nextInt();
            in.nextLine();
            String b = in.nextLine();
            String c = in.nextLine();
            double d = in.nextDouble();in.nextLine();

            Em[i]= new Employee1(a,b,c,d);
        }

        Company cp = new Company(cn,Em,num);
        System.out.println(cp.getAverageSalary(Em));
        System.out.println(cp.getMaxSalary(Em));
        String desi = in.nextLine();
        Employee1[] ans = cp.getEmployeesByDesgnation(desi);
        if(ans!=null){
            for(int i=0;i<ans.length;i++){
                System.out.println(ans[i].getId()+" "+ans[i].getName()+" "+ans[i].getDesignation()+" "+ans[i].getSalary());
            }
        }
    }
}
class Company{
    private String companyName;
    private static Employee1[] employees;
    private int numEmployees;

    public Company(String companyName,Employee1[] employees,int numEmployees){
        this.companyName=companyName;
        this.employees=employees;
        this.numEmployees=numEmployees;
    }

    public int getNumEmployees() {
        return numEmployees;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Employee1[] getEmployees() {
        return employees;
    }

    public void setEmployees(Employee1[] employees) {
        this.employees = employees;
    }

    public void setNumEmployees(int numEmployees) {
        this.numEmployees = numEmployees;
    }

    public static double getAverageSalary(Employee1[] Em){

        double sum =0;
        for(int i=0;i<Em.length;i++){
            sum+= Em[i].getSalary();
        }
        if(sum >0){
            double avg = sum/Em.length;
            return avg;
        }
        return 0;
    }
    public static double getMaxSalary(Employee1[] Em){
        double Max = Em[0].getSalary();
        for(int i=0;i<Em.length;i++){
            if(Max< Em[i].getSalary()){
                Max=Em[i].getSalary();
            }
        }
        return Max;
    }
    public static Employee1[] getEmployeesByDesgnation(String d){
        List<Employee1> matchemp = new ArrayList<>();
        for(Employee1 emp : employees){
            if(emp.getDesignation().equalsIgnoreCase(d)){
                matchemp.add(emp);
            }
        }

        return matchemp.toArray(new Employee1[0]);

    }
}
class Employee1{
    private  int id;
    private String name;
    private String designation;
    private double salary;

    public Employee1(int id,String name,String designation,double salary){
        this.id=id;
        this.name=name;
        this.designation=designation;
        this.salary=salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getDesignation() {
        return designation;
    }

    public String getName() {
        return name;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

}