import java.util.List;

class Student1{
    int sid;
    String sname;
    int age;
    List<Integer> marks;
    public Student1(int sid,String sname,int age,List<Integer> marks){
        this.sid=sid;
        this.sname=sname;
        this.age=age;
        this.marks=marks;
    }
}
class MarksNotAvailableException extends Exception {
    public MarksNotAvailableException(String message) {
        super(message);
    }
}
class ServiceStudent {
    public void calculateAverage(List<Student1> sl, String stuname) throws MarksNotAvailableException {
        int sum=0, count = 0;
        int avg = 0;
        for (Student1 i : sl) {
            if (i.sname.equalsIgnoreCase(stuname)) {
                if(i.marks==null || i.marks.isEmpty()){
                    throw new MarksNotAvailableException("Marks not availble");
                }
                for(int m: i.marks)
                sum =sum+ m;
                count++;
            }
            avg = sum / count;
            if (avg > 0) {
                System.out.println(avg);
            } else {
                System.out.println("no");
            }
        }
    }

    public void TopperOfEachSub(List<Student1> sl,int noSub){
        for(int i=-0;i<noSub;i++){
            int max= Integer.MIN_VALUE;
            String topper = null;

            for(Student1 s: sl){
                if(s.marks.get(i) >max){
                    max=s.marks.get(i);
                    topper=s.sname;
                }
            }
            System.out.println("subject topper: "+topper);
        }
        System.out.println("Not found");
    }
}
public class q1Studentmange {

}

