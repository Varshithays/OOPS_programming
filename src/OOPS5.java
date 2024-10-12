import java.util.Scanner;
class TravelAgency {
    private int regNo;
    private String agencyName;
   private  String packageType;
   private int price;
    private boolean flightFacility;

    public TravelAgency(int regNo,String agencyName,String packageType,int price,boolean flightFacility){
        this.regNo= regNo;
        this.agencyName=agencyName;
        this.packageType=packageType;
        this.price=price;
        this.flightFacility=flightFacility;
    }
    int getRegNo(){
        return regNo;
    }
    String getAgencyName(){
        return agencyName;
    }
    String getPackageType(){
        return packageType;
    }
    int getPrice(){
        return price;
    }
    boolean getFlightFacility(){
        return flightFacility;
    }


}
public class OOPS5{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        TravelAgency[] arr = new TravelAgency[4];

        for(int i=0;i<4;i++){
            int a = in.nextInt();
            in.nextLine();
            String b = in.nextLine();
            String c = in.nextLine();
            int d = in.nextInt();
            in.nextLine();
            boolean e = in.nextBoolean();

            arr[i]= new TravelAgency(a,b,c,d,e);
        }

        int maxPrice=  findAgencyWithHighestPackagePrice(arr);
        int inputRegNo= in.nextInt();
        in.nextLine();
        String inputPackageType=in.nextLine();

        TravelAgency obj= agencyDetailsForGivenAndType(arr,inputRegNo,inputPackageType);
        System.out.println(maxPrice);

       if(obj == null){
           System.out.println("not found");
       }else{
           System.out.println(obj.getAgencyName()+"and"+obj.getPackageType()+"="+obj.getPrice());
       }
    }

    public static int findAgencyWithHighestPackagePrice(TravelAgency[] arr){
        int maxx = arr[0].getPrice();
        for(int i=0;i<4;i++){
            if(arr[i].getPrice()>maxx){
                maxx=arr[i].getPrice();
            }
        }
        return maxx;
    }
    public static TravelAgency agencyDetailsForGivenAndType(TravelAgency[] arr,int inputRegNo,String inputPackageType){
        for(int i=0;i<arr.length;i++){
            if(arr[i].getFlightFacility() == true){
                if(arr[i].getRegNo() == inputRegNo && inputPackageType.equalsIgnoreCase(arr[i].getPackageType())){
                    return arr[i];
                }
            }
        }
        return null;
    }
}
