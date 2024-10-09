import java.util.Scanner;

class AutonomousCar{
    int carId;
    String brand;
    int noOfTestConducted;
    int  noOfTestPassed;
    String environment;


    String grade;

    public AutonomousCar(int carId,String brand,int noOfTestConducted,int noOfTestPassed,String environment){
        this.carId= carId;
        this.brand=brand;
        this.noOfTestConducted= noOfTestConducted;
        this.noOfTestPassed=noOfTestPassed;
        this.environment = environment;
    }

}
public class OOPS6 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        AutonomousCar[] arr = new AutonomousCar[4];
        for(int i=0;i<4;i++){
            int a = in.nextInt();
            in.nextLine();
            String b = in.nextLine();
            int c = in.nextInt();
            in.nextLine();
            int d = in.nextInt();
            in.nextLine();
            String e =in.nextLine();


            arr[i] = new AutonomousCar(a,b,c,d,e);
        }
        String inputenv= in.nextLine();
        String inputbrand= in.nextLine();
        int result = findTestPassedByEnv(arr,inputenv);
        if (result==0){
            System.out.println("there are no tests passed in this particular environment");
        }else{
            System.out.println(result);
        }
        AutonomousCar obj = updateCarGrade(arr,inputbrand);
        if(obj== null) {
            System.out.println("No Car is available");
        }else{
            System.out.println(obj.brand+"::"+obj.grade);
        }
    }

    public static int findTestPassedByEnv(AutonomousCar[] arr,String inputenv){
        int sum =0;
        for(int i=0;i<arr.length;i++){
            if(arr[i].environment.equalsIgnoreCase(inputenv)){
                sum+=arr[i].noOfTestPassed;
            }
        }
        return sum;
    }

    public static AutonomousCar updateCarGrade(AutonomousCar[] arr,String inputbrand){
        int rating;
        for(int i=0;i<arr.length;i++){
            if(arr[i].brand.equalsIgnoreCase(inputbrand)){
                 rating =((arr[i].noOfTestPassed* 100)/arr[i].noOfTestConducted);
                if(rating>=80){
                    arr[i].grade= "A1";
                }else {
                    arr[i].grade ="B2";
                }
                return arr[i];
            }
        }
        return null;
    }

}
