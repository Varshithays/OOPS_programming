import java.util.Arrays;
import java.util.Scanner;

class OOPS3{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Employee[] E = new Employee[n];
        for(int i=0;i<n;i++){
            int a = in.nextInt();in.nextLine();
            String b = in.nextLine();
            int c = in.nextInt();
            in.nextLine();
            char d =in.next().charAt(0);
            double e = in.nextDouble();

            E[i]= new Employee(a,b,c,d,e);
            
        }
        in.nextLine();
        int inputage = in.nextInt();

        Employee ans1= getEmployeeWithSecondLowestSalary(E);
        {
            if(ans1 != null){
                System.out.println( ans1.getEmployeeId()+ "#" +ans1.getEmployeeName());
            }else{
                System.out.println("Null");
            }
        }

        int ans2 = countEmployeesBasedOnAge(E,inputage);
        if(ans2!=0){
            System.out.println(ans2);
        }else{
            System.out.println("No employee found for the given age");
        }

        
    }
    public static Employee getEmployeeWithSecondLowestSalary(Employee[] E){
        if(E.length<2){
            return null;
        }

        Arrays.sort(E,(e1,e2) -> Double.compare(e1.getSalary(),e2.getSalary()));
        return E[1];
    }
    public static int countEmployeesBasedOnAge(Employee[] E,int inputage){
        int count =0;
        for(int i=0;i<E.length;i++){
            if(E[i].getAge()==inputage){
                count++;

            }
        }
        return count;
    }
}
class Employee{
    private int employeeId;
    private String employeeName;
    private int age;
    private char gender;
    private double salary;
    
    public Employee(int employeeId, String employeeName,int age,char gender,double salary){
        this.employeeId=employeeId;
        this.employeeName=employeeName;
        this.age=age;
        this.gender= gender;
        this.salary=salary;
        
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public char getGender() {
        return gender;
    }

    public double getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    
}
