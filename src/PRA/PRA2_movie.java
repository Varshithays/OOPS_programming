package PRA;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Movie{
    int mid;
    String mname;
    String genre;
    public Movie(int mid,String mname,String genre){
        this.mid=mid;
        this.mname=mname;
        this.genre=genre;
    }
}
class Theater{
    int id;
    String name;
    String location;
    HashMap<Integer,Double> movieMap;
    public Theater(int id,String name,String location,HashMap<Integer,Double> movieMap){
        this.id=id;
        this.name=name;
        this.location=location;
        this.movieMap=movieMap;
    }
}
class MovieTheaterService{
    public void TicketDis(ArrayList<Theater> tl,int theaterid,int movie_id,int noOftickets,double discountrate){
      /*  double ans=-1;
        for(Theater i: tl){
            if(i.id==theaterid){
                    if(i.movieMap.containsKey(movie_id)){
                        double total= i.movieMap.get(movie_id)* noOftickets;
                        ans=total-(total*discountrate/100);
                    }
            }
        }
        if(ans!=-1){
            System.out.println("Amount:"+ans);
        }else{
            System.out.println("No shows found");
        }*/
        double ans=-1;
        for(Theater i:tl){
            if(i.id==theaterid){
                for(Map.Entry<Integer,Double> e : i.movieMap.entrySet()){
                    int m=e.getKey();
                    double p=e.getValue();

                    if(m==movie_id){
                        double total= p*noOftickets;
                        ans= total-(total*discountrate/100);
                    }
                }

            }
        }
        if(ans!=-1){
            System.out.println("Amount:"+ans);
        }else{
            System.out.println("No shows found");
        }
    }
    public void getTheaterRunning(ArrayList<Theater> tl,int movie_idn,String moviename){
        ArrayList<Theater> match = new ArrayList<>();
        for(Theater i:tl){
            if(i.movieMap.containsKey(movie_idn)){
                match.add(i);
            }

       /* for(int e: i.movieMap.keySet()){

                    if(e==movie_idn){
                match.add(i);
            }
        }*/
        }
        if(match.isEmpty()){
            System.out.println("No theater found");
        }else{
            System.out.println(moviename +" movie is running in the following theaters");
            for(Theater m:match){
                System.out.println("Theater ID: "+m.id);
                System.out.println("Theater name: "+m.name);
                System.out.println("Location: "+m.location);

            }
        }
    }
}
public class PRA2_movie {
    public static void main(String args[]) throws Exception {
        Scanner in = new Scanner(System.in);
        int nom= Integer.parseInt(in.nextLine());
        ArrayList<Movie> ml = new ArrayList<>();
        ArrayList<Theater> tl= new ArrayList<>();

        for(int i=0;i<nom;i++){
            int mid=Integer.parseInt(in.nextLine());
            String mname= in.nextLine();
            String genre= in.nextLine();

            ml.add(new Movie(mid, mname, genre));
        }
        int not= Integer.parseInt(in.nextLine());

        for(int i=0;i<not;i++){
            int id=Integer.parseInt(in.nextLine());
            String name=in.nextLine();
            String location=in.nextLine();

            int noOfmovies=Integer.parseInt(in.nextLine());
            HashMap<Integer,Double> map = new HashMap<>();
            for(int j=0;j<noOfmovies;j++){
                int movieId=Integer.parseInt(in.nextLine());
                double price=Double.parseDouble(in.nextLine());

                map.put(movieId,price);
            }
            tl.add(new Theater(id, name, location, map));
        }
        int theaterid=Integer.parseInt(in.nextLine());
        int movie_id=Integer.parseInt(in.nextLine());
        int noOftickets=Integer.parseInt(in.nextLine());

        double discountrate=Double.parseDouble(in.nextLine());
        int movie_idn=Integer.parseInt(in.nextLine());
        String moviename=in.nextLine();

        MovieTheaterService ms= new MovieTheaterService();
        ms.TicketDis(tl, theaterid, movie_id, noOftickets, discountrate);
        ms.getTheaterRunning(tl, movie_idn, moviename);
    }
}