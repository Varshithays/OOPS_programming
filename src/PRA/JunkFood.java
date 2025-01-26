package PRA;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

class Junk_Food{
    String item;
    double price;
    String cuisine;
    ArrayList<Review> reviews;
    public Junk_Food(String item, double price, String cuisine, ArrayList<Review> reviews){
        this.item=item;
        this.price=price;
        this.cuisine=cuisine;
        this.reviews=reviews;
    }
}
class Review{
    String reviewer;
    double rating;
    public Review(String reviewer,double rating){
        this.reviewer=reviewer;
        this.rating=rating;
    }

}
public class JunkFood {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int nf = in.nextInt();in.nextLine();

        ArrayList<Junk_Food> arr = new ArrayList<>();
        for(int i=0;i<nf;i++){
            String item= in.nextLine();
            double price = in.nextDouble();in.nextLine();

            String cuisine = in.nextLine();

            //No of reviews for each item
            int nr= in.nextInt();
            in.nextLine();
            ArrayList<Review> rev= new ArrayList<>();
            for(int j=0;j<nr;j++){
                String reviewer = in.nextLine();
                double rating =in.nextDouble();
              in.nextLine();
                rev.add( new Review(reviewer,rating));
            }
            arr.add(new Junk_Food(item,price,cuisine,rev));
        }
        String name= in.nextLine();
        removeReviewsByName(arr,name);
        HashMap<String,double[]> ans= findMinMaxRating(arr);
        for(String key:ans.keySet()){
            System.out.println("Item: "+key);
            double[] values= ans.get(key);
            System.out.println("Min ratong :"+values[0]);
            System.out.println("Max rating: "+values[1]);
        }


    }
    public static void removeReviewsByName(ArrayList<Junk_Food> arr,String name){
        List<Review> temp  = new ArrayList<>();
        int c=0;
        for(Junk_Food j:arr){
            for(Review rs : j.reviews){
                if(rs.reviewer.equalsIgnoreCase(name)){
                    temp.add(rs);
                    c=1;
                    System.out.println(rs.reviewer+ " is removed");
                }
            }
            j.reviews.removeAll(temp);
        }
        if(c==0){
            System.out.println("NO reviewer found for name");

        }
    }
    static HashMap<String,double[]> findMinMaxRating(ArrayList<Junk_Food> arr) {
        HashMap<String, double[]> m = new HashMap<>();
        for (Junk_Food j1 : arr) {
            double[] d = new double[2];
            double min = 5;
            double max = 0;
            String item = j1.item;
            for (Review rs : j1.reviews) {
                if (rs.rating < min) {
                    min=rs.rating;
                }
                if (rs.rating > max) {
                    max = rs.rating;
                }
            }
            d[0] = min;
            d[1] = max;
            m.put(item, d);
        }
        return m;
    }

}
