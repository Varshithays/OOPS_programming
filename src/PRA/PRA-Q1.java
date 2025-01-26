package  PRA;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

class Employee1{
    int eid;
    String ename;
    int age;
    char gender;
    double salary;
    public Employee1(int eid,String ename,int age,char gender,double salary){
        this.eid=eid;
        this.ename=ename;
        this.age=age;
        this.gender=gender;
        this.salary=salary;
    }
    public double getSalary(){
        return salary;
    }
}
class PRA_Q1{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        ArrayList<Employee1> ll = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(in.nextLine());
            String b = in.nextLine();
            int c = Integer.parseInt(in.nextLine());
            char d = in.next().charAt(0);in.nextLine();
            double e = Double.parseDouble(in.nextLine());

            ll.add(new Employee1(a, b, c, d, e));
        }
        int reqage=Integer.parseInt(in.nextLine());
        Employee1 ans= getEmployeeWithSecondLowestSalary(ll);
        int count= countEmployeesBasedOnAge(ll,reqage);
        if(ans!=null){
            System.out.println(ans.eid+"#"+ans.ename);
        }else{
            System.out.println("null");
        }
        if(count>0){
            System.out.println(count);
        }else{
            System.out.println("Not found");
        }
    }
    public static Employee1 getEmployeeWithSecondLowestSalary(ArrayList<Employee1> ll){
        ll.sort(Comparator.comparingDouble(Employee1::getSalary));
        double second=ll.get(1).getSalary();
        for(Employee1 e:ll){
            if(e.getSalary()==second){
                return e;
            }
        }
        return null;
    }
    public static int countEmployeesBasedOnAge(ArrayList<Employee1> ll, int reqage)
    {
        int count=0;
        for(Employee1 e:ll)
        {
            if(e.age==reqage)
            {
                count++;
            }
        }
        return count;
    }
}
