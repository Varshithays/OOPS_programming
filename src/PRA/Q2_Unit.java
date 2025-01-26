package PRA;

import java.util.ArrayList;
import java.util.Scanner;

class Unit{
    private int unitId;
    private String unitName;
    private int budget;
    private ArrayList<Employee> employees;
    public Unit(int unitId,String unitName,int budget,ArrayList<Employee> employees){
    this.unitId=unitId;
    this.unitName=unitName;
    this.budget=budget;
    this.employees=employees;
    }
    public int getUnitId(){
        return  unitId;
    }
    public String getUnitName(){
        return  unitName;
    }
    public  int getBudget(){
        return budget;
    }
    public ArrayList<Employee> getEmployees(){
        return employees;
    }

}
class Employee{
    private int employeeId;
    private String employeeName;
    private int salary;
    public Employee(int employeeId,String employeeName,int salary){
        this.employeeId=employeeId;
        this.employeeName=employeeName;
        this.salary=salary;
    }
    public int getEmployeeId(){
        return employeeId;
    }
    public  String getEmployeeName(){
        return employeeName;
    }
    public int getSalary(){
        return salary;
    }
}
class SalaryNegativeException extends Exception{
    public SalaryNegativeException(String message){
        super(message);
    }
}
class Service{
    public static int totalSalaryByEmpName(ArrayList<Unit> u,String inputname)throws SalaryNegativeException{
        int total=0;
        for(Unit i:u){
            for(Employee j:i.getEmployees()){
                if(j.getEmployeeName().equalsIgnoreCase(inputname)){
                    if(j.getSalary()<0){
                        throw new SalaryNegativeException("Invalid Salary: Salary cant be negative");
                    }
                    total+=j.getSalary();

                }
            }
        }

        return total;
    }
    public static ArrayList<String> findUnitNamesOfEmployeeBySalary(ArrayList<Unit> u,int inputsal){
        ArrayList<String> temp= new ArrayList<>();
        for(Unit i:u){
            for(Employee j:i.getEmployees()){
                if(j.getSalary()>inputsal){
                    temp.add(i.getUnitName());
                    break;
                }
            }
        }

        return temp;
    }

}
public class Q2_Unit {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        try {
            int nu = in.nextInt();
            ArrayList<Unit> u = new ArrayList<>();
            for (int i = 0; i < nu; i++) {
                int unitid = in.nextInt();
                in.nextLine();
                String unitName = in.nextLine();
                int budget = in.nextInt();
                in.nextLine();

                int ne = in.nextInt();
                in.nextLine();
                ArrayList<Employee> e = new ArrayList<>();
                for (int j = 0; j < ne; j++) {
                    int employeeid = in.nextInt();
                    in.nextLine();
                    String employeename = in.nextLine();
                    int salary = in.nextInt();
                    in.nextLine();
                    e.add(new Employee(employeeid, employeename, salary));
                }
                u.add(new Unit(unitid, unitName, budget, e));

            }
            String inputname = in.nextLine();
            int inputsal = in.nextInt();
            in.nextLine();
            Service ser = new Service();
            try {
                int ans1 = ser.totalSalaryByEmpName(u, inputname);
                if (ans1 > 0) {
                    System.out.println(ans1);
                }
            } catch (SalaryNegativeException e) {
                System.out.println(e.getMessage());
            }


            ArrayList<String> ans2 = ser.findUnitNamesOfEmployeeBySalary(u, inputsal);
            if (ans2.isEmpty()) {
                System.out.println("no match");
            } else {
                for (String sol : ans2) {
                    System.out.println(sol);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            in.close();
        }
    }
}