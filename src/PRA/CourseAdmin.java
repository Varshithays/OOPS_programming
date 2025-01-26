package PRA;

import java.util.ArrayList;
import java.util.*;
import java.util.Scanner;

class Course{
    int cid;
    String cname;
    String cadmin;
    int quiz;
   private int handson ;
    public Course(int cid,String cname,String cadmin, int quiz,int handson){
        this.cid=cid;
        this.cname=cname;
        this.cadmin=cadmin;
        this.quiz=quiz;
        this.handson=handson;
    }
    public int getHandson(){
        return handson;
    }
}
public class CourseAdmin {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Course> ls = new ArrayList<>(4);
        for (int i = 0; i < 4; i++) {
            int a = in.nextInt();
            in.nextLine();
            String b = in.nextLine();
            String c = in.nextLine();
            int d = in.nextInt();
            in.nextLine();
            int e = in.nextInt();
            in.nextLine();

            ls.add(new Course(a, b, c, d, e));

        }
        int hand = in.nextInt();
        ArrayList<Course> match = sortCourse(ls, hand);
        for (Course i : match) {
            System.out.println(i.cname);
        }


}

        public static ArrayList<Course> sortCourse(ArrayList<Course> ls,int hand){
            ArrayList<Course> list = new ArrayList<>();
            for(Course c: ls){
                if(c.getHandson()<hand){
                    list.add(c);
                }
            }
            if(list.isEmpty()){
                return null;
            }
            list.sort(Comparator.comparingInt(Course::getHandson));
            return list;
        }

    }
