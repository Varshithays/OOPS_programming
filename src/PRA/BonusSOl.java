package PRA;

import java.util.ArrayList;
import java.util.Scanner;

class Department {
    int deptId;
    String deptName;
    String location;

    public Department(int deptId, String deptName, String location) {
        this.deptId = deptId;
        this.deptName = deptName;
        this.location = location;
    }
}

class Employeeb {
    String empName;
    int empId;
    double experience;
    int deptID;
    double salary;

    public Employeeb(String empName, int empId, double experience, int deptID, double salary) {
        this.empName = empName;
        this.empId = empId;
        this.experience = experience;
        this.deptID = deptID;
        this.salary = salary;
    }
}

class ES {
    public void findEmp(ArrayList<Employeeb> el, int id) {
        ArrayList<Employeeb> match = new ArrayList<>();
        int count = 0;
        for (Employeeb i : el) {
            if (i.deptID == id) {
                match.add(i);
                count++;
            }
        }
        if (match.isEmpty()) {
            System.out.println("No Employees Found.");
        } else {
            System.out.println("Number of Employees in department " + id + " is: " + count);
            System.out.println("Details of Employees are:");
            for (Employeeb j : match) {
                System.out.println("Employee ID: " + j.empId);
                System.out.println("Employee Name: " + j.empName);
            }
        }
    }

    public void calbonus(ArrayList<Employeeb> el) {
        if (el.isEmpty()) {
            System.out.println("No Employees Found.");
        } else {
            System.out.println("Bonus incentives for all employees are:");
            for (Employeeb emp : el) {
                double bonus = emp.salary * 0.1 * emp.experience;
                System.out.println("Employee ID: " + emp.empId + ", Employee Name: " + emp.empName + ", Bonus: " + bonus);
            }
        }
    }
}

public class BonusSOl {
    public static void main(String args[]) throws Exception {
        Scanner in = new Scanner(System.in);
        int nod = Integer.parseInt(in.nextLine());
        ArrayList<Department> dl = new ArrayList<>();
        for (int i = 0; i < nod; i++) {
            int a = Integer.parseInt(in.nextLine());
            String b = in.nextLine();
            String c = in.nextLine();

            dl.add(new Department(a, b, c));
        }
        int noe = Integer.parseInt(in.nextLine());
        ArrayList<Employeeb> el = new ArrayList<>();
        for (int i = 0; i < noe; i++) {
            String a = in.nextLine();
            int b = Integer.parseInt(in.nextLine());
            double c = Double.parseDouble(in.nextLine());
            int d = Integer.parseInt(in.nextLine());
            double e = Double.parseDouble(in.nextLine());

            el.add(new Employeeb(a, b, c, d, e));
        }
        int id = Integer.parseInt(in.nextLine());

        ES a = new ES();
        a.findEmp(el, id);
        a.calbonus(el);
    }
}
