import java.util.Arrays;
import java.util.Scanner;

public class AntennaP
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        Antenna[] ar= new Antenna[4];
        for(int i=0;i<4;i++){
            int a=in.nextInt();in.nextLine();
            String b= in.nextLine();
            String c = in.nextLine();
            double d= in.nextDouble();
            in.nextLine();

            ar[i]= new Antenna(a,b,c,d);
        }
        String inputname = in.nextLine();
        int ans = searchAntennaByName(ar,inputname);
        if(ans==0){
            System.out.println("there i sno");
        }else{
            System.out.println(ans);
        }
        double  VSWR=in.nextDouble();

    }
    public static int searchAntennaByName(Antenna[] ar,String inputname ){
        for(int i=0;i<ar.length;i++){
            if(ar[i].getAntennaName().equalsIgnoreCase(inputname)){
                return ar[i].getAntennaId();
            }
        }
        return 0;
    }

    public static Antenna[] sortAntennaByVSWR(Antenna[] ar,double VSWR){
        Antenna[] arr= new Antenna[0];
        for(int i =0;i<ar.length;i++)
        {
            if(ar[i].getAntennaVSWR()<VSWR)
            {
            arr= Arrays.copyOf(arr,arr.length+1);
            arr[arr.length-1]=ar[i];
            }
        }
        for(int i=0;i<ar.length;i++){
            for(int j=0;j<ar.length-i-1;j++){
                if(arr[i].getAntennaVSWR()>arr[i+1].getAntennaVSWR()){
                    Antenna temp= arr[i];
                    arr[i]=arr[i+1];
                    arr[i+1]=temp;
                }
            }
        }
        if(arr.length>0)
        {
            return arr;
        }else{
            return null;
        }

    }
}
class Antenna
{
    private int antennaId;
    private String antennaName;
    private String projectLead;
    private double antennaVSWR;

    public Antenna(int antennaId,String antennaName,String projectLead,double antennaVSWR){
        this.antennaId=antennaId;
        this.antennaName=antennaName;
        this.projectLead=projectLead;
        this.antennaVSWR=antennaVSWR;
    }

    public int getAntennaId(){
        return antennaId;
    }
    public String getAntennaName(){
        return antennaName;
    }
    public String getProjectLead(){
        return projectLead;
    }

    public double getAntennaVSWR() {
        return antennaVSWR;
    }

}
