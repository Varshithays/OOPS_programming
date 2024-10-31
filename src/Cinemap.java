import java.util.Scanner;

public class Cinemap {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Cinema[] cn= new Cinema[4];
        for(int i=0;i<4;i++){
            int a =in.nextInt();
            in.nextLine();
            String b = in.nextLine();
            int c = in.nextInt();
            in.nextLine();
            int d =in.nextInt();
            in.nextLine();

            cn[i]= new Cinema(a,b,c,d);

        }
        String inputdir=in.nextLine();
        int ans = findAverageByDirector(cn,inputdir);
        if(ans!=0){
            System.out.println(ans);
        }else{
            System.out.println("Sorry -The given director has not yet directed any movie");
        }
    }

    public static int findAverageByDirector(Cinema[] cn,String inputdir){
        {
            int sum=0;
            int count=0;
            for(int i=0;i<cn.length;i++){
                if(cn[i].director.equalsIgnoreCase(inputdir)){
                    sum+=cn[i].budget;
                    count++;
                }
            }
            int avg;
            avg=sum/count;

            if(avg>0){
                return avg;
            }else{
                return 0;
            }

        }
    }

    public static Cinema getMovieByRatingBudget(Cinema[] cn ,int inputrat,int budget){

        return null;
    }
}
class Cinema{
    int movieId;
    String director;
    int rating;
    int budget;

    public Cinema(int movieId,String director,int rating,int budget){
        this.movieId=movieId;
        this.director=director;
        this.rating=rating;
        this.budget=budget;
    }


}
