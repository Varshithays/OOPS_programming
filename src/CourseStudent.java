import java.util.Scanner;
class Course{
    String courseName;
    String instructor;
    int studentAttend;
    boolean present;
    String city;

    public Course(String courseName,String instructor,int studentAttend,boolean present,String city){
        this.courseName=courseName;
        this.instructor=instructor;
        this.studentAttend=studentAttend;
        this.present=present;
        this.city=city;
    }
}
public class CourseStudent {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        Course[] cs= new Course[4];
        for(int i=0;i<4;i++){
            String a=in.nextLine();
            String b = in.nextLine();
            int c = in.nextInt();in.nextLine();
            boolean d =in.nextBoolean();
            String e = in.nextLine();

            cs[i]= new Course(a,b,c,d,e);
        }
        String inputcn=in.nextLine();

        String ans = findCategory(cs,inputcn);
        if(ans==null){
            System.out.println("No match found");
        }else{
            System.out.println(ans);
        }

    }
    public static String findCategory(Course[] cn,String inputcn){
        String category= " ";

        for(int i=0;i<4;i++) {
            if (cn[i].courseName.equalsIgnoreCase(inputcn)) {
                if (cn[i].present && cn[i].studentAttend < 1500 && cn[i].studentAttend >= 100) {
                    category += "Diamond";
                    return category;
                } else if (cn[i].present && cn[i].studentAttend < 1000 && cn[i].studentAttend >= 500) {
                    category += "Golden";
                    return category;
                } else if (cn[i].present && cn[i].studentAttend < 500) {
                    category += "Silver";
                    return category;
                }
            }

        }
        return null;

    }
}
