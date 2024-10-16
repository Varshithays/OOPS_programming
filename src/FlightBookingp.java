import java.util.Scanner;

class FlightBooking{
    int FlightBookingId;
    String FlightName;
    String Departure;
    String Arrival;
    int price;
    boolean airLineMeal;
    public FlightBooking(int FlightBookingId,String FlightName,String Departure,String Arrival,int price,boolean airLineMeal){
        this.FlightBookingId=FlightBookingId;
        this.FlightName=FlightName;
        this.Departure=Departure;
        this.Arrival=Arrival;
        this.price=price;
        this.airLineMeal=airLineMeal;
    }
}
public class FlightBookingp {
    public static void main(String[] args ){
        Scanner in = new Scanner(System.in);
        FlightBooking[] fl = new FlightBooking[4];

        for(int i=0;i<4;i++){
            int a=in.nextInt();
            in.nextInt();
            String b = in.nextLine();
            String c = in.nextLine();
            String d = in.nextLine();
            int e = in.nextInt();
            in.nextLine();
            boolean f=in.nextBoolean();

            fl[i]=new FlightBooking(a,b,c,d,e,f);
        }
        String inputar=in.nextLine();
        String inputdp=in.nextLine();

        Double res=findPrice(fl,inputar,inputdp);
        if(res!=0){
            System.out.println(res);
        }else{
            System.out.println("No such flights");
        }

    }

    public static double findPrice(FlightBooking[] fl,String inputar,String inputdp){
        double sum=0.0;
        for(int i=0;i<4;i++){
            if(fl[i].Arrival.equalsIgnoreCase(inputar) &&fl[i].Departure.equalsIgnoreCase(inputdp)){
                if(fl[i].airLineMeal==true){
                    sum+=fl[i].price;
                }
            }
        }
        return sum;
    }



}
