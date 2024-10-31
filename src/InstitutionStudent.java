import java.util.*;
class Institution{
    int insId;
    String insName;
    String noOfstudentPlaced;
    int noOfstudentCleared;
    String location;
    String grade;

   Institution(int insId,String insName,String noOfstudentPlaced,int noOfstudentCleared,String location){
        this.insId=insId;
        this.insName=insName;
        this.noOfstudentPlaced=noOfstudentPlaced;
        this.noOfstudentCleared=noOfstudentCleared;
        this.location=location;

    }



}
public class InstitutionStudent{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        Institution[] arr = new Institution[4];
        for(int i=0;i<arr.length;i++){
            int a = in.nextInt();
            in.nextLine();
            String b = in.nextLine();
            String c = in.nextLine();
            int d = in.nextInt();
            in.nextLine();
            String e = in.nextLine();
            arr[i] = new Institution(a,b,c,d,e);
        }
        String inputloc = in.nextLine();
        String inputName= in.nextLine();
        int ans1 = findNumClear(arr,inputloc);
        if(ans1>0){
            System.out.println(ans1);
        }else{
            System.out.println("There are no cleared students in this particular locaton");
        }

        Institution ans2= updateGrade(arr,inputName);
        if(ans2!=null){
            System.out.println(ans2.insName+"::"+ans2.grade);

        }else{
            System.out.println("No intitute is available with the specified name");
        }

    }

    public static int findNumClear(Institution arr[] ,String inputloc){
        int sum =0;
        for(int i=0;i<arr.length;i++){
            if(arr[i].location.equalsIgnoreCase(inputloc)){
                sum += arr[i].noOfstudentCleared;
            }
        }

        return sum;
    }

    public static Institution updateGrade(Institution[] arr ,String inputName){

        for(int i=0;i<arr.length;i++){
            if(arr[i].insName.equalsIgnoreCase(inputName)){
                int rating = (Integer.parseInt((arr[i].noOfstudentPlaced))*100/arr[i].noOfstudentCleared);
                if(rating>=80){
                    arr[i].grade= "A";
                }else{
                    arr[i].grade = "B";
                }
                return arr[i];
            }
        }
        return null;
    }


}
