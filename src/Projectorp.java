import java.util.Scanner;
class Projector{
    private int id;
    private String name;
    private int price;
    private int rating;
    private String available;
    public Projector(int id,String name,int price,int rating,String available){
        this.id=id;
        this.name=name;
        this.price=price;
        this.rating=rating;
        this.available=available;
    }
    public int getID(){
        return id;
    }
    public String getName(){
        return name;
    }
    public int getPrice(){
        return price;
    }
    public int getRating(){
        return rating;
    }
    public String getAvailable(){
        return available;
    }
}
public class Projectorp {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        Projector[] p= new Projector[4];
        for(int i=0;i<4;i++){
            int a=in.nextInt();
            in.nextLine();
            String b= in.nextLine();
            int c =in.nextInt();in.nextLine();
            int d=in.nextInt();in.nextLine();
            String e=in.nextLine();
            p[i]= new Projector(a,b,c,d,e);
        }
        int input=in.nextInt();
        Projector ans= findMaxByRating(p,input);
        if(ans!=null){
            System.out.println(ans.getID());
        }else{
            System.out.println("no match");
        }
    }
    public static Projector findMaxByRating(Projector[] p, int input){
        Projector pr= null;
        int Max= Integer.MIN_VALUE;
        for(int i=0;i<p.length;i++){
            if(p[i].getRating()>input && p[i].getAvailable().equalsIgnoreCase("TataCliq")){
                if(p[i].getPrice()>Max){
                    Max=p[i].getPrice();
                    pr=p[i];
                }
            }
        }
        return pr;
    }
}
