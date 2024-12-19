import java.util.Scanner;

class Pen {
    int id;
    String name;
    int rating;
    Double price;
    Pen(int id,String name,int rating,Double price){
        this.id=id;
        this.name=name;
        this.rating=rating;
        this.price=price;
    }
}
public class Pra_Pen{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Pen arr[] = new Pen[4];
        for(int i=0;i<arr.length;i++){
            int a=in.nextInt();
            in.nextLine();
            String b = in.nextLine();
            int c=in.nextInt();
            double d=in.nextDouble();
            in.nextLine();

            arr[i]= new Pen(a,b,c,d);
        }
        String str=in.nextLine();
        Pen obj1=findDetailsWithMax(arr);
       Pen obj2= findDetailsWithName(arr,str);
       if(obj1==null){
           System.out.println("no match");
       }else{
           System.out.println(obj1.id);
           System.out.println(obj1.name);
           System.out.println(obj1.rating);
           System.out.println(obj1.price);
       }
        if(obj2==null){
            System.out.println("no match");
        }else{
            System.out.println(obj2.id);
            System.out.println(obj2.name);
            System.out.println(obj2.rating);
            System.out.println(obj2.price);
        }
    }

    public static Pen findDetailsWithMax(Pen[] arr){
        double max=0.0;
        for(Pen p:arr){
            if(p.price>max){
                max=p.price;
            }
        }for(Pen p:arr){
            if(p.price==max){
                return p;
            }
        }
        return null;
    }
    public static Pen findDetailsWithName(Pen arr[], String str){
        for(Pen p:arr){
            if(p.name.equalsIgnoreCase(str)){
                return p;
            }
        }
        return null;
    }
}