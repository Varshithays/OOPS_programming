package PRA;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Staff{
    int staffId;
    String staffName;
    String deptName;
    float yearsofexpr;
    double currentSalary;
    public Staff(int staffId,String staffName,String deptName,float yearsofexpr,double currentSalary){
        this.staffId=staffId;
        this.staffName=staffName;
        this.deptName=deptName;
        this.yearsofexpr=yearsofexpr;
        this.currentSalary=currentSalary;
    }
}
public class StaffSol {
    public static void main(String args[]) throws Exception {
        Scanner in = new Scanner(System.in);
        List<Staff> ls= new ArrayList<>(4);
        for(int i=0;i<4;i++)
        {
            int a=in.nextInt();in.nextLine();
            String b= in.nextLine();
            String c=in.nextLine();
            float d=in.nextFloat(); in.nextLine();
            double e=in.nextDouble();
            in.nextLine();

            ls.add(new Staff(a,b,c,d,e));
        }
        String deptname=in.nextLine();
        double ans= findAverageSalaryForDepratment(ls, deptname);
        Staff ans2= findStaffDetailsByMinSalary(ls);
        if(ans!=0){
            System.out.println(ans);
        }else{
            System.out.println("Departement doesn't exist");
        }
        if(ans2!=null){
            System.out.println(ans2.staffId);
            System.out.println(ans2.staffName);
        }else{
            System.out.println("No such staf availabale");
        }
    }
    public static double findAverageSalaryForDepratment(List<Staff> ls,String deptname){
        double avg=0.0;
        double sum=0.0;
        double count=0.0;
        for(Staff s:ls){
            if(s.deptName.equalsIgnoreCase(deptname)){
                sum+=s.currentSalary;
                count++;
            }
        }
        return sum/count;
    }
    public static Staff findStaffDetailsByMinSalary(List<Staff> ls)
    {
        double min=0.0;
        for(Staff s: ls){
            if(s.currentSalary< min && s.yearsofexpr >5){
                min =s.currentSalary;
            }

        }
        for(Staff i : ls){
            if(i.currentSalary==min){
                return i;
            }
        }
        return null;
    }
}