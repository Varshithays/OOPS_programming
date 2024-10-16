import java.util.Scanner;

class Universities{
    int UniversitiesID;
    String UniversitiesName;
    String Location;
    double rating;
    boolean InnovativeLab;
    public Universities(int UniversitiesID,String UniversitiesName,String Location,double rating,boolean InnovativeLab){
        this.UniversitiesID=UniversitiesID;
        this.UniversitiesName=UniversitiesName;
        this.Location=Location;
        this.rating=rating;
        this.InnovativeLab=InnovativeLab;
    }

}
public class Universitiespr {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        Universities[] un = new Universities[4];
        for(int i=0;i<4;i++){
            int a = in.nextInt();
            in.nextLine();
            String b = in.nextLine();
            String c = in.nextLine();
            double d = in.nextDouble();
            in.nextLine();
            boolean e = in.nextBoolean();


            un[i]=new Universities(a,b,c,d,e);
        }
        String inputs=in.nextLine();
        double inputd=in.nextDouble();
        in.nextLine();

        int ans = countNumberOfInnovativeLabs(un,inputs,inputd);
        if(ans !=0){
            System.out.println(ans);
        }else{
            System.out.println("NO any labs");
        }

    }

    public static int countNumberOfInnovativeLabs(Universities[] un,String inputs,double inputd){
        int labcount=0;
        for(int i=0;i<4;i++){
            if(un[i].Location.equalsIgnoreCase(inputs) && un[i].rating>inputd){
                if(un[i].InnovativeLab==true){
                    labcount++;
                }
            }
        }
        return labcount;
    }
}
