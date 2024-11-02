import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Beachp {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        Beach[] bc= new Beach[4];
        for(int i=0;i<4;i++){
            int a= in.nextInt();
            in.nextLine();
            String b =in.nextLine();
            int c =in.nextInt();
            in.nextLine();
            int d = in.nextInt();
            in.nextLine();
            bc[i]= new Beach(a,b,c,d);
        }
        String inname= in.nextLine();
        int incost= in.nextInt();

        Beach ans = findLeastRatingWithName(bc,inname,incost);
        if (ans!=null) {
            System.out.println(ans.getRating());
        }else{
            System.out.println("noo");
        }
    }
    public static Beach findLeastRatingWithName(Beach[] bc,String inname,int incost){
        /*for(Beach m:bc){
            if(m.getName().equalsIgnoreCase(inname) && m.getCost()>incost){
                match = Arrays.copyOf(bc,bc.length+1);
                bc[bc.length-1]=m;
            }
        }*/
        List<Beach>  match = new ArrayList<>();
        for(Beach m :bc){
            if(m.getName().equalsIgnoreCase(inname) && m.getCost()>incost){
                match.add(m);
            }
        }

        match.sort(Comparator.comparingInt(Beach::getRating));
        if(match!=null){
            return match.get(0);
        }else{
            return null;
        }
    }

}
class Beach{
    private int id;
    private String name;
    private int rating;
    private int cost;
    public Beach(int id,String name,int rating,int cost){
        this.id=id;
        this.name=name;
        this.rating=rating;
        this.cost=cost;
    }
    public int getId(){return id;}
    public String getName(){return name;}
    public int getRating(){return rating;}
    public int getCost(){return cost;}
    public void setId(int id){this.id=id;}
    public void setName(String name){this.name=name;}
    public void setRating(int rating){this.rating=rating;}
    public void setCost(int cost){this.cost=cost;}

}
