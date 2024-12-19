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
/*import java.util.*;

public class TwoClasses {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Student> students = new ArrayList<>();

        // Input Students
        System.out.println("Enter details for 2 students:");
        for (int i = 0; i < 2; i++) {
            System.out.println("Enter first name:");
            String firstName = in.nextLine();
            System.out.println("Enter last name:");
            String lastName = in.nextLine();
            System.out.println("Enter age:");
            int age = in.nextInt();
            in.nextLine(); // Consume newline
            System.out.println("Enter gender (M/F):");
            char gender = in.next().charAt(0);
            in.nextLine(); // Consume newline
            System.out.println("Enter roll number:");
            String rollNo = in.nextLine();
            System.out.println("Enter course:");
            String course = in.nextLine();
            System.out.println("Enter semester:");
            int semester = in.nextInt();
            System.out.println("Enter GPA:");
            double GPA = in.nextDouble();
            in.nextLine(); // Consume newline

            students.add(new Student(firstName, lastName, age, gender, rollNo, course, semester, GPA));
        }

        // Calculate Average GPA
        double averageGPA = calculateAverageGPA(students);
        System.out.println("Average GPA: " + averageGPA);

        // Find Students by Course
        System.out.println("Enter a course to find students:");
        String inputCourse = in.nextLine();
        List<Student> studentsInCourse = getStudentsByCourse(students, inputCourse);

        if (!studentsInCourse.isEmpty()) {
            System.out.println("Students in course " + inputCourse + ":");
            for (Student s : studentsInCourse) {
                System.out.println("Roll No: " + s.rollNo + ", GPA: " + s.GPA);
            }
        } else {
            System.out.println("No students found for the course " + inputCourse);
        }
    }

    // Calculate average GPA
    public static double calculateAverageGPA(List<Student> students) {
        double totalGPA = 0;
        for (Student student : students) {
            totalGPA += student.GPA;
        }
        return students.isEmpty() ? 0 : totalGPA / students.size();
    }

    // Get students by course
    public static List<Student> getStudentsByCourse(List<Student> students, String course) {
        List<Student> result = new ArrayList<>();
        for (Student student : students) {
            if (student.course.equalsIgnoreCase(course)) {
                result.add(student);
            }
        }
        return result;
    }
}

// Person class
class Person {
    String firstName;
    String lastName;
    int age;
    char gender;

    public Person(String firstName, String lastName, int age, char gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
    }
}

// Student class
class Student extends Person {
    String rollNo;
    String course;
    int semester;
    double GPA;

    public Student(String firstName, String lastName, int age, char gender, String rollNo, String course, int semester, double GPA) {
        super(firstName, lastName, age, gender);
        this.rollNo = rollNo;
        this.course = course;
        this.semester = semester;
        this.GPA = GPA;
    }
}
*/