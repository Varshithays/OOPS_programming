package PRA;

import java.util.ArrayList;
import java.util.Scanner;

class Student{
    int sid;
    String sname;
    ArrayList<Coursem> courselist;
    public Student(int sid, String sname, ArrayList<Coursem> courselist) {
        this.sid = sid;
        this.sname = sname;
        this.courselist = courselist;
    }
}
class Coursem{
    int id;
    String name;
    int hours;

    public Coursem(int id, String name, int hours) {
        this.id = id;
        this.name = name;
        this.hours = hours;
    }
}
class Services {
    public ArrayList<Student> getbasedoncourse(ArrayList<Student> sl, String coursename) {
        ArrayList<Student> match = new ArrayList<>();
        for (Student s : sl) {
            for (Coursem c : s.courselist) {
                if (c.name.equalsIgnoreCase(coursename)) {
                    match.add(s);
                    break;
                }
            }
        }
        return match.isEmpty() ? null :match;
    }
    public int noOfhours(ArrayList<Student> sl, int stuid,String stuname){
        int sum=0;
        for(Student i: sl){
            if(i.sid==stuid && i.sname.equalsIgnoreCase(stuname)){
                for(Coursem c:i.courselist){
                    sum+=c.hours;
                }
            }
        }
        return sum;
}
public class PRA3_sol {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nos=Integer.parseInt(sc.nextLine());
        ArrayList<Student> sl = new ArrayList<>();

        for(int i=0;i<nos;i++){
            int sid=Integer.parseInt(sc.nextLine());

            String sname=sc.nextLine();
            int m=Integer.parseInt(sc.nextLine());
         ArrayList<Coursem>  Cl=new ArrayList<>();
            for(int j=0;j<m;j++){
                int cid=Integer.parseInt(sc.nextLine());

                String cname=sc.nextLine();
                int hours=Integer.parseInt(sc.nextLine());
                Cl.add(new Coursem(cid,cname,hours));
            }
            sl.add(new Student(sid,sname,Cl));
        }
        int sId=Integer.parseInt(sc.nextLine());
      //  sc.nextLine();
        String sName=sc.nextLine();
        String cName=sc.nextLine();
        Services a= new Services();

        ArrayList<Student> ans= a.getbasedoncourse(sl,cName);
        int ans2= a.noOfhours(sl,sId,sName);
        if(ans!=null){
            for (Student s: ans ) {
                System.out.println(s.sname);
            }
        }else{

                System.out.println("not found");

        }
        if(ans2>0){
            System.out.println(ans2);
        }else{
            System.out.println("not");
        }

        }
    }
}
