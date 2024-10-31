import java.util.*;

public class TwoClasses {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //Person[] p= new Person[2];
        Student[] st= new Student[2];
        Faculty[] fc= new Faculty[2];
        for(int i=0;i<st.length;i++){
            String firstname= in.nextLine();
            String lastname= in.nextLine();
            int age=in.nextInt();
            in.nextLine();
            char gender= in.next().charAt(0);
            in.nextLine();
            String a= in.nextLine();
            String b= in.nextLine();
            int c= in.nextInt();
            in.nextLine();
            double d = in.nextDouble();
            in.nextLine();
            st[i]= new Student(firstname,lastname,age,gender,a,b,c,d);
        }

        /*for(int j=0;j<fc.length;j++){
            String firstname= in.nextLine();
            String lastname= in.nextLine();
            int age=in.nextInt();in.nextLine();
            char gender= in.next().charAt(0);
            in.nextLine();
            String a= in.nextLine();
            String b = in.nextLine();
            String c= in.nextLine();
            double d= in.nextDouble();
            in.nextLine();
            fc[j]= new Faculty(firstname,lastname,age,gender,a,b,c,d);
        }

       /* Student ans1= findHighestGPAStudent(st);
        if(ans1!=null){
            System.out.println(ans1.rollNo);
            System.out.println(ans1.course);
            System.out.println(ans1.GPA);
        }else{
            System.out.println("NO");
        }
        Faculty ans2= findHighestPaidFaculty(fc);
        if(ans2!=null){
            System.out.println(ans2.employeeId);
            System.out.println(ans2.department);
            System.out.println(ans2.salary);
        }*/
        String inputcourse= in.nextLine();
        double avg= calculateAverageGPA(st);
        if(avg>0){
            System.out.println(avg);
        }else{
            System.out.println("NOO");
        }
        Student[] ans=getStudentByCourse(st,inputcourse);
        if(ans!=null){
            for(int i=0;i<ans.length;i++){
                System.out.println(ans[i].rollNo);
                System.out.println(ans[i].course);
                System.out.println(ans[i].GPA);
            }

        }else{
            System.out.println("NOO");
        }
    }
    public static double calculateAverageGPA(Student[] st){
        double sum =0,count=0;
        for(int i=0;i<st.length;i++){
            sum+=st[i].GPA;
            count++;
        }

        double avg= sum/count;
        return avg;
    }
    public static Student[] getStudentByCourse(Student[] st,String inputcourse){
        Student[] stu= new Student[0];
        for(int i=0;i<st.length;i++){
            if(st[i].course.equalsIgnoreCase(inputcourse)){
                stu=Arrays.copyOf(stu,stu.length+1);
                stu[stu.length-1]=st[i];
            }
        }
        if(stu.length>0){
            return stu;
        }else{
            return null;
        }
    }
    public  static Student findHighestGPAStudent(Student[] st){
        List<Double> match= new ArrayList<>();
        for(int i=0;i<st.length;i++){
            match.add(st[i].GPA);

        }
        match.sort(Comparator.comparingDouble(Double::doubleValue).reversed());
        double high = match.get(0);
        for(Student stu:st){
            if(stu.GPA==high){
                return stu;
            }
        }
        return null;
    }

    public static Faculty findHighestPaidFaculty(Faculty[] fc)
    {
    Faculty paid= fc[0];
    for(int i=1;i<fc.length;i++){
        if(fc[i].salary>paid.salary){
            paid =fc[i];
        }
    }
    return paid;
    }
}
class Person{
    String firstName;
    String lastName;
    int age;
    char gender;
    public Person(String firstName,String lastName,int age,char gender){
        this.firstName=firstName;
        this.lastName=lastName;
        this.age=age;
        this.gender=gender;
    }
}
class Student extends Person{
    String rollNo;
    String course;
    int semester;
    double GPA;
    public Student(String fn,String ln,int age,char gen,String rollNo,String course,int semester,double GPA){
        super(fn,ln,age,gen);
        this.rollNo=rollNo;
        this.course=course;
        this.semester=semester;
        this.GPA=GPA;
    }

}
class Faculty extends Person{
    String employeeId;
    String department;
    String designation;
    double salary;

    public Faculty(String fn,String ln,int age,char gen,String employeeId,String department,String designation,double salary){
        super(fn,ln,age,gen);
        this.employeeId=employeeId;
        this.department=department;
        this.designation = designation;
        this.salary=salary;
    }
}