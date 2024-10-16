import java.util.Scanner;

class Resort{
    int resortID;
    String resortName;
    String category;
    double rating;
    double price;

    public Resort(int resortID,String resortName,String category,double rating,double price){
        this.resortID=resortID;
        this.resortName=resortName;
        this.category=category;
        this.rating=rating;
        this.price=price;
    }

}
public class Resortp {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        Resort[] rs = new Resort[3];
        for(int i=0;i<rs.length;i++){
            int a= in.nextInt();
            in.nextLine();
            String b = in.nextLine();
            String c =in.nextLine();
            double d=in.nextDouble();
            in.nextLine();
            double e = in.nextDouble();
            in.nextLine();

            rs[i]= new Resort(a,b,c,d,e);

        }
        String inputob= in.nextLine();
        double ans = avgPriceOfGiven(rs,inputob);
        if(ans==0){
            System.out.println("nooo");
        }else{
            System.out.println(ans);
        }



    }
    public static double avgPriceOfGiven(Resort[] rs,String inputob){
        double avg=0;
        double sum =0;
        int count=0;

        for(int i=0;i<3;i++){
            if(rs[i].category.equalsIgnoreCase(inputob)&& rs[i].rating>4){
                sum=sum+rs[i].price;
                count++;
            }
        }
            if(count==0){
                return 0;
            }else{
                return sum/count;
            }
    }
}
